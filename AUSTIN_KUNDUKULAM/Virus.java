import java.util.Random;
public class Virus {
    Ball[] bodyParts;
    double health;
    int damage;
    Rectangle healthBar;
    double xPos;
    double yPos;
    String dropItems[] = { "+ Health", "+ Ammo", "+ Shield" };
    int indexer = 0;
    String startDirection;
    Random random = new Random();

    public Virus(int health, int damage, double xLoc, double yLoc, String startDir) {
        bodyParts = new Ball[5];
        this.health = health;
        this.damage = damage;
        this.startDirection = startDir;

        // 140, 295

        bodyParts[0] = new Ball(xLoc, yLoc, 30, "GREEN");
        bodyParts[1] = new Ball(xLoc + 7, yLoc - 5, 10, "WHITE");
        bodyParts[2] = new Ball(xLoc - 7, yLoc - 5, 10, "WHITE");
        bodyParts[3] = new Ball(xLoc + 10, yLoc - 5, 5, "BLACK");
        bodyParts[4] = new Ball(xLoc - 5, yLoc - 5, 5, "BLACK");

        healthBar = new Rectangle(xLoc - 40, yLoc - 30, 80, 10, "RED");
    }

    public String getStartDirection(){
        return startDirection;
    }

    public void incIndex(){

    }

    public void setHealth(double dmgTaken) {
        double dmgTakenPerc = (dmgTaken * 100) / (healthBar.getWidth());
        this.health = health - dmgTakenPerc;
        healthBar.setWidth(healthBar.getWidth() - dmgTakenPerc);
    }

    public String getPowerup() {
        int randInd = random.nextInt(2);
        String pointer = dropItems[randInd];
        return pointer;

    }

    public String getHealthPowerup(){
        return dropItems[0];
    }

    public double getHealth() {
        return health;
    }

    public Ball[] getBodyParts() {
        return bodyParts;
    }

    public Rectangle getHealthBar() {
        return healthBar;
    }

    public double getXPosition() {
        return bodyParts[0].getXPosition();
    }

    public double getYPosition() {
        return bodyParts[0].getYPosition();
    }

    public void moveRight() {
        for (int i = 0; i < bodyParts.length; i++) {
            double xBPos = bodyParts[i].getXPosition();
            bodyParts[i].setXPosition(xBPos + 3);
        }

        healthBar.setXPosition(healthBar.getXPosition() + 3);
    }
    public void moveLeft() {
        for (int i = 0; i < bodyParts.length; i++) {
            double xBPos = bodyParts[i].getXPosition();
            bodyParts[i].setXPosition(xBPos - 3);
        }

        healthBar.setXPosition(healthBar.getXPosition() - 3);
    }
    public void moveDown() {
        for (int i = 0; i < bodyParts.length; i++) {
            double yBPos = bodyParts[i].getYPosition();
            bodyParts[i].setYPosition(yBPos + 3);
        }

        healthBar.setYPosition(healthBar.getYPosition() + 3);
    }
    public void moveUp() {
        for (int i = 0; i < bodyParts.length; i++) {
            double yBPos = bodyParts[i].getYPosition();
            bodyParts[i].setYPosition(yBPos + 3);
        }

        healthBar.setYPosition(healthBar.getYPosition() - 3);
    }
}
