import java.util.ArrayList;

public class Game {
    static GameArena arena = new GameArena(1450, 1000);
    static Level level = new Level(arena);
    static Bird player = new Bird(700, 850);
    static boolean mouseLocked = false;
    static Door door = new Door();
    static FakeDoor f_door = new FakeDoor();
    static StatsBar s_bar = new StatsBar();
    static ParticleEmit particles;

    public static void reset() {
        // arena.setBackgroundImage("bg.png");

        level.next(arena, f_door, door);
        level.addPlatforms(arena);
        level.addSpikes(arena);

        door.addTo(arena);
        f_door.addTo(arena);
        s_bar.addTo(arena);

        player.addTo(arena);
        player.setXY((int) f_door.getRect().getXPosition() + 25, (int) f_door.getRect().getYPosition() + 50);
        player.setMomentumZero();
        player.getGun().reset();
        s_bar.updateShells(player.getGun().numShells());
        player.die();
        s_bar.updateDeaths(player.getDeaths());
        s_bar.updateFloor(level.getFloor() + 1);

        // hf_1.addTo(arena);

        player.getRaycast().addTo(arena);
    }

    public static void main(String[] args) {

        reset();

        while (true) {
            arena.pause();

            // hf_1.physics_process(arena);

            player.updateDirection(arena);
            player.move(arena);
            player.physics_process(level.getPlatforms());

            player.getGun().getEmitter().physics_process(arena);

            // if entered door, next level, reset objects.
            if (door.checkEntry(player, level, arena)) {
                level.incrementLevel();
                reset();
            }

            // if died, reset, but keep same level
            if (level.checkSpikeHit(player, level, arena) || (player.getCollision().getYPosition() > 1000)) {
                reset();
            }

            // when gun is used
            if (arena.leftMousePressed()) {
                if (mouseLocked == false) {
                    // lock mouse
                    mouseLocked = true;

                    // if got shells in gun.
                    if (player.getGun().loaded()) {
                        // raycast to get distance form nearest object
                        int dist = player.getRaycast().cast((int) player.getCollision().getXPosition(),
                                (int) player.getCollision().getYPosition(), player.getGun(), arena,
                                level.getPlatforms());

                        // applies that distance as a modifier to the momentum, relative to the
                        // direction the players gun is pointing.
                        // this means if the player is really close to the floor it will get launced
                        // with a greater momentum, than if it is further away.
                        player.setMomentum((int) (player.getMomentumX(arena) * -(player.getGun().getPower() * dist)),
                                (int) (player.getMomentumY(arena) * -(player.getGun().getPower() * dist)));

                        // updates guns shells
                        player.getGun().fire();

                        // updates status bar to show the less shells
                        s_bar.updateShells(player.getGun().numShells());

                        // emits particles
                        player.getGun().emitParticles((int) player.getGun().getBarrel().getXPosition(),
                                (int) player.getGun().getBarrel().getYPosition(), arena);
                    }
                    // if out of shells reset. Crude solutions to gun firing immediatly after dying
                    // is to wait a second
                    if (player.getGun().numShells() == 0) {
                        for (int i = 0; i < 8; i++) {
                            arena.pause();
                        }
                        reset();
                    }
                }
            }
            // if not pressing mouse
            else {
                // unlock mouse
                mouseLocked = false;
            }

            // cheat to get to next level. used for testing.
            if (arena.letterPressed('n')) {
                level.incrementLevel();
                reset();
                for (int i = 0; i < 10; i++) {
                    arena.pause();
                }
            }
        }
    }
}