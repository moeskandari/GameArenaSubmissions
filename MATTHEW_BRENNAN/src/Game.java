import java.util.ArrayList;

public class Game{
    static GameArena arena = new GameArena(1450, 1000);
    static Level level = new Level(arena);
    static Bird player = new Bird(700, 850);
    static boolean mouseLocked = false;
    static Door door = new Door();
    static FakeDoor f_door = new FakeDoor();
    static StatsBar s_bar = new StatsBar();
    static ParticleEmit particles;
    static HenchFish hf_1 = new HenchFish(0, 200);

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

            if (door.checkEntry(player, level, arena)) {
                level.incrementLevel();
                reset();
            }

            if (level.checkSpikeHit(player, level, arena) || (player.getCollision().getYPosition() > 1000)) {
                reset();
            }

            if (arena.leftMousePressed()) {
                if (mouseLocked == false) {
                    mouseLocked = true;
                    if (player.getGun().loaded()) {
                        int dist = player.getRaycast().cast((int) player.getCollision().getXPosition(),
                                (int) player.getCollision().getYPosition(), player.getGun(), arena,
                                level.getPlatforms());
                        player.setMomentum((int) (player.getMomentumX(arena) * -(player.getGun().getPower() * dist)),
                                (int) (player.getMomentumY(arena) * -(player.getGun().getPower() * dist)));

                        player.getGun().fire();
                        // System.out.println(player.getMomentumX(arena) + " " +
                        // player.getMomentumY(arena));

                        s_bar.updateShells(player.getGun().numShells());

                        player.getGun().emitParticles((int) player.getGun().getBarrel().getXPosition(),
                                (int) player.getGun().getBarrel().getYPosition(), arena);
                    }
                    if (player.getGun().numShells() == 0) {
                        for (int i = 0; i < 8; i++) {
                            arena.pause();
                        }
                        reset();
                    }
                }
            } else {
                mouseLocked = false;
            }

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