public class FakeDoor {
    private Rectangle door = new Rectangle(700, 825, 50, 75, "DARKCHOCOLATE", 2);

    public Rectangle getRect() {
        return door;
    }

    public void addTo(GameArena gameArena) {
        gameArena.addRectangle(door);
    }
}
