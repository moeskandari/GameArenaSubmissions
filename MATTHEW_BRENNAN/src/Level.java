import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList; // Import the ArrayList class

//level class
public class Level {
    private ArrayList<Platform> platformsList = new ArrayList<>();
    private ArrayList<Spikes> spikesList = new ArrayList<>();
    private FileReader fileReader = null;
    GameArena gameArena;
    private int levelNo = 0;

    public Level(GameArena gameArena) {
        this.gameArena = gameArena;
    }

    // crude
    public FileReader readTo(FileReader fileReader) {
        // how many levels
        try {
            for (int l = 0; l < levelNo; l++) {
                while (fileReader.read() != 'Z') {
                }
                fileReader.read();
                fileReader.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return fileReader;
    }

    public void addPlatforms(GameArena arena) {
        for (Platform i : platformsList) { // Change Platforms to platformsList
            i.addToo(arena);
        }
    }

    public void addSpikes(GameArena arena) {
        for (Spikes i : spikesList) { // Change Platforms to platformsList
            i.addTo(arena);
        }
    }

    public boolean checkSpikeHit(Bird bird, Level level, GameArena gameArena) {
        for (Spikes i : spikesList) {
            if (i.checkEntry(bird, level, gameArena)) {
                return true;
            }
        }
        return false;
    }

    public void incrementLevel() {
        levelNo++;
    }

    public Platform[] getPlatforms() {
        return platformsList.toArray(new Platform[0]);
    }

    public void next(GameArena gameArena, FakeDoor f_door, Door door) {
        platformsList.clear();
        spikesList.clear();
        gameArena.clearGameArena();
        readLevel(f_door, door);
        addPlatforms(gameArena);
    }

    public void readLevel(FakeDoor f_door, Door door) {
        try {
            fileReader = new FileReader("leveldata.txt");
            fileReader = readTo(fileReader);
            int character;
            int x = 0;
            int y = 0;
            while ((character = fileReader.read()) != -1) {
                char charVariable = (char) character;
                if (charVariable == 'X') {
                    platformsList.add(new Platform(x * 50, y * 50));
                } else if (charVariable == '\n') {
                    y++;
                    x = -1; // Reset x to -1 because it will be incremented to 0 at the end of the loop
                } else if (charVariable == 'D') {
                    door.getRect().setXPosition(x * 50);
                    door.getRect().setYPosition((y * 50) - 25);
                } else if (charVariable == 'F') {
                    f_door.getRect().setXPosition(x * 50);
                    f_door.getRect().setYPosition((y * 50) - 25);
                } else if (charVariable == 'S') {
                    spikesList.add(new Spikes(x * 50, (y * 50) + 40));
                }
                if (charVariable == 'Z') {
                    fileReader.read();
                    return;
                }
                x++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public int getFloor() {
        return levelNo;
    }
}