public class Particle {
    private Rectangle p = new Rectangle(0, 0, 10, 10, "YELLOW", 10);
    private int x;
    private int y;
    private int m_x;
    private int m_y;
    private int deathCount;
    private int DECAYSPEED = 1;

    public Particle(int x, int y, int m_x, int m_y, int deathCount) {
        this.x = x;
        this.y = y;
        this.m_x = m_x;
        this.m_y = m_y;
        this.deathCount = deathCount;
    }

    //move and shrink.
    //when deathCount gets to zero gets deleted
    public void physics_process() {
        x = x + m_x / 4;
        y = y + m_y / 4;
        p.setXPosition(x);
        p.setYPosition(y);
        p.setHeight((int) p.getHeight() - DECAYSPEED);
        p.setWidth((int) p.getWidth() - DECAYSPEED);

        deathCount--;
    }

    public void addTo(GameArena gameArena) {
        gameArena.addRectangle(p);
    }

    public Rectangle getRect() {
        return p;
    }

    public int getDeaths() {
        return deathCount;
    }
}
