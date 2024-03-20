public class Spikes {
    private Spike s_1 = new Spike(0, 0);
    private Spike s_2 = new Spike(0, 0);
    private Spike s_3 = new Spike(0, 0);
    private Rectangle hitbox = new Rectangle(0, 0, 50, 25, "ALPHA", 1);
    public int x;
    public int y;

    public Spikes(int x, int y) {
        this.x = x;
        this.y = y;

        s_1.setPos(x, y);
        s_2.setPos(x + 25, y);
        s_3.setPos(x + 50, y);
        hitbox.setXPosition(x);
        hitbox.setYPosition(y - 10);
    }

    public void addTo(GameArena gameArena) {
        s_1.addTo(gameArena);
        s_2.addTo(gameArena);
        gameArena.addRectangle(hitbox);
        // s_3.addTo(gameArena);
    }

    public boolean checkEntry(Bird bird, Level level, GameArena gameArena) {
        if (bird.getCollision().collides(hitbox)) {
            return true;
        }
        return false;
    }
}
