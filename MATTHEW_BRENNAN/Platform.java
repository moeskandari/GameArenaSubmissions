public class Platform {
    private Rectangle spritePlatform = new Rectangle(0, 0, 50, 50, "SPYBLUE", 2);
    private int x;
    private int y;

    public Platform(int x, int y) {
        this.x = x;
        this.y = y;
        spritePlatform.setXPosition(x);
        spritePlatform.setYPosition(y);
    }

    public void addToo(GameArena arena) {
        arena.addRectangle(spritePlatform);
    }

    public Rectangle getPlatform() {
        return this.spritePlatform;
    }
}
