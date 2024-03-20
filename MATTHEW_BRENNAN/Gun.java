public class Gun {
    private int x; // 250
    private int y; // 150
    private int rot;
    private Rectangle g_1 = new Rectangle(250, 150, 5, 7, "DARKGREY", 10);
    private Rectangle g_2 = new Rectangle(250, 150, 5, 7, "DARKGREY", 10);
    private Rectangle g_3 = new Rectangle(250, 150, 5, 7, "DARKGREY", 10);

    private Rectangle r_1 = new Rectangle(250, 150, 5, 7, "ALPHARED", 10);
    private Rectangle r_2 = new Rectangle(250, 150, 5, 7, "ALPHARED", 10);
    private Rectangle r_3 = new Rectangle(250, 150, 5, 7, "ALPHARED", 10);

    private int MAX_SHELLS = 11;
    private int shells = MAX_SHELLS;
    private double power = 0.85;
    private int MAX_RANGE = 30;

    private ParticleEmit particle_e = new ParticleEmit();

    public Gun(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void display(GameArena arena) {
        arena.addRectangle(g_1);
        arena.addRectangle(g_2);
        arena.addRectangle(g_3);

        // arena.addRectangle(r_1);
        // arena.addRectangle(r_2);
        // arena.addRectangle(r_3);

    }

    public void move(int b_x, int b_y, GameArena arena) {
        pivotRect(b_x, b_y, 20, g_1, arena);
        pivotRect(b_x, b_y, 25, g_2, arena);
        pivotRect(b_x, b_y, 30, g_3, arena);

        // pivotRect(b_x, b_y, 80, r_1, arena);
        // pivotRect(b_x, b_y, 130, r_2, arena);
        // pivotRect(b_x, b_y, 180, r_3, arena);
    }

    // moves rect in a circle around the player, relative to mouse postion
    public void pivotRect(int b_x, int b_y, int offset, Rectangle rect, GameArena arena) {
        double rot = getAngle(b_x, b_y, arena);
        double dist = offset;
        rect.setXPosition((int) (b_x + (dist * Math.cos(rot))));
        rect.setYPosition((int) (b_y + (dist * Math.sin(rot))));
    }

    public double getAngle(int b_x, int b_y, GameArena arena) {
        return Math.atan2(arena.getMousePositionY() - b_y, arena.getMousePositionX() - b_x);
    }

    public void fire() {
        if (shells > 0) {
            shells--;
        }
    }

    public double getPower() {
        return this.power;
    }

    public boolean loaded() {
        return (shells > 0);
    }

    public int numShells() {
        return shells;
    }

    public void reset() {
        shells = MAX_SHELLS;
    }

    public int getMaxRange() {
        return MAX_RANGE;
    }

    public void emitParticles(int b_x, int b_y, GameArena gameArena) {
        double rot = getAngle(b_x, b_y, gameArena);
        particle_e.init(b_x, b_y, MAX_RANGE, rot, gameArena);
        particle_e.addTo(gameArena);
    }

    public ParticleEmit getEmitter() {
        return particle_e;
    }

    public Rectangle getBarrel() {
        return g_3;
    }
}