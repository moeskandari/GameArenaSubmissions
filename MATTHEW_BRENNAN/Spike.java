public class Spike {
    private Rectangle s_1 = new Rectangle(200, 150, 25, 10, "GREY", 7);
    private Rectangle s_2 = new Rectangle(205, 140, 15, 20, "GREY", 7);
    private Rectangle s_3 = new Rectangle(210, 130, 5, 20, "GREY", 7);
    private int x;
    private int y;

    public Spike(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setPos(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void addTo(GameArena gameArena) {
        s_1.setXPosition(x);
        s_1.setYPosition(y);
        s_2.setXPosition(x + 5);
        s_2.setYPosition(y - 10);
        s_3.setXPosition(x + 10);
        s_3.setYPosition(y - 20);
        gameArena.addRectangle(s_1);
        gameArena.addRectangle(s_2);
        gameArena.addRectangle(s_3);
    }
}
