public class StatsBar {
    Rectangle backing = new Rectangle(0, 0, 1450, 75, "LIGHTBLUE", 19);
    Text shellCount = new Text("SHELLS: 6", 50, 20, 55, "CHOCOLATE", 20);
    Text deathCount = new Text("DEATHS: 0", 50, 612, 55, "DARKCHOCOLATE", 20);
    Text levelCount = new Text("FLOOR: 0", 50, 1200, 55, "WHITE", 20);

    public void addTo(GameArena gameArena) {
        gameArena.addRectangle(backing);
        gameArena.addText(shellCount);
        gameArena.addText(deathCount);
        gameArena.addText(levelCount);
    }

    public void updateShells(int count) {
        shellCount.setText("SHELLS: " + (count - 1));
    }

    public void updateDeaths(int count) {
        deathCount.setText("DEATHS: " + count);
    }

    public void updateFloor(int count) {
        levelCount.setText("FLOOR: " + count);
    }

}