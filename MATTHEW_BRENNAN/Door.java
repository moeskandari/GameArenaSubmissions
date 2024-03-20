public class Door {
    private Rectangle door = new Rectangle(700, 225, 50, 75, "CHOCOLATE", 2);

    public void addTo(GameArena gameArena) {
        gameArena.addRectangle(door);
    }

    public Rectangle getRect() {
        return door;
    }

    // checks wether the bird is inside of the door.
    public boolean checkEntry(Bird bird, Level level, GameArena gameArena) {
        if (bird.getCollision().collides(door)) {
            return true;
        }
        return false;
    }
}
