
public class Scientist {
    Ball face;
    Line[] body;
    double health;
    int damage;
    Ball bullet;
    Rectangle healthBar;
    int ammo = 1500;

    public Scientist(int health, int damage) {
        body = new Line[7];
        face = new Ball(600, 265, 20, "BLACK");
        this.health = health;
        this.damage = damage;

        // Main body
        body[0] = new Line(600, 275, 600, 310, 5, "BLACK");
        // Right arm
        body[1] = new Line(600, 285, 610, 295, 5, "BLACK");
        // Left arm
        body[2] = new Line(600, 285, 590, 285, 5, "BLACK");
        // Right leg
        body[3] = new Line(610, 320, 600, 310, 5, "BLACK");
        // Left leg
        body[4] = new Line(590, 320, 600, 310, 5, "BLACK");
        //Gun (grip)
        body[5] = new Line(590, 280, 590, 290, 5, "BLACK");
        //Gun (barrel)
        body[6] = new Line(575, 280, 590, 280, 5, "BLACK");
        //healthBar
        healthBar = new Rectangle(body[0].getXStart() - 40, body[0].getYStart() - 40, 80, 10, "RED");

    }

    public void move(boolean up, boolean down, boolean right, boolean left) {
        double SXPos = 0;
        double SYPos = 0;

        if (up) {
            SYPos -= 4;
        }
        if (down) {
            SYPos += 4;
        }
        if (right) {
            SXPos += 4;
        }
        if (left) {
            SXPos -= 4;
        }

        for (int i = 0; i < body.length; i++) {
            body[i].setLinePosition(
                    body[i].getXStart() + SXPos,
                    body[i].getYStart() + SYPos,
                    body[i].getXEnd() + SXPos,
                    body[i].getYEnd() + SYPos
            );
        }

        face.setXPosition(face.getXPosition() + SXPos);
        face.setYPosition(face.getYPosition() + SYPos);

        healthBar.setXPosition(healthBar.getXPosition() + SXPos);
        healthBar.setYPosition(healthBar.getYPosition() + SYPos);

    }

    public int getAmmo(){
        return ammo;
    }

    public double getXPos(){
        return face.getXPosition();
    }
    public double getYPos(){
        return face.getYPosition();
    }

    public double sendXShotLoc(){
        return body[6].getXStart();
    }

    public double sendYShotLoc(){
        return body[6].getYStart();
    }

    public Line[] getBodyLines() {
        return body;
    }

    public void incAmmo(int incAmt){
        ammo = ammo + incAmt;
    }

    public Ball getFace() {
        return face;
    }

    public Rectangle getHealthBar(){
        return healthBar;
    }

    public double getXBodyLines(){
        for(int i = 0; i < 7;){
            return body[i].getXStart();
        }
        return face.getXPosition();
    }

    public double getYBodyLines(){
        for(int i = 0; i < 7;){
            return body[i].getYStart();
        }
        return face.getYPosition();
    }

    public double getHealth(){
        return health;
    }

    public void setHealth(double damageTaken){
        double dmgTakenPerc = (damageTaken*100)/(healthBar.getWidth());
        this.health = health - dmgTakenPerc;
        healthBar.setWidth(healthBar.getWidth() - dmgTakenPerc);
    }

    public void incHealth(double regen){
        if (healthBar.getWidth() < 80 && health < 100){
        double regenPerc = (regen*100)/(healthBar.getWidth());
        this.health = health + regenPerc;
        healthBar.setWidth(healthBar.getWidth() + regenPerc);
        }
    }

}
