import java.util.Random;

public class ThePandemic {

    public static void main(String[] args) {
        GameArena arena1 = new GameArena(1200, 800);
        Virus easyVirus = new Virus(100, 35, 40, 395, "Left");
        Scientist JFinn = new Scientist(100, 10);
        Projectile bullet = new Projectile(JFinn.sendXShotLoc(), JFinn.sendYShotLoc());
        virusProjectile virusPellet = new virusProjectile(easyVirus.getXPosition(), easyVirus.getYPosition());
        int shotDirection = 0;
        double deathXloc;
        double deathYloc;
        double vXLoc = 0;
        double vYLoc = 0;
        boolean virusDestroyed = true;
        boolean shieldOn = false;
        boolean playerAlive = true;
        int ammo = JFinn.getAmmo();
        Text outOfammo = new Text("Out of ammo!", 12, JFinn.getXPos(), JFinn.getYPos(), "BLACK");
        Text cycleChoice = null;
        Text gameTitle = new Text("The Pandemic", 50, 450, 270, "GREEN");
        Text startIns = new Text("Press ENTER to start", 25, 490, 350, "RED");
        Text gameIns1 = new Text("UP, DOWN, LEFT, RIGHT to move\r\n", 20, 450, 390, "RED");
        Text gameIns2 = new Text("Click to shoot, Right click to change shot direction", 20, 390, 420, "RED");
        String[] directions = { "Left", "Right", "Up", "Down" };
        Random random = new Random();
        // stage 1 stuff
        arena1.addKeyListener(arena1);
        arena1.addMouseListener(arena1);

        arena1.addText(gameTitle);
        arena1.addText(startIns);
        arena1.addText(gameIns1);
        arena1.addText(gameIns2);

        while (!arena1.enterPressed()) {
            arena1.pause();
        }

        arena1.clearGameArena();

        arena1.setBackgroundImage("citybackjunc.png");

        // scientist (mc) stuff
        for (int i = 0; i < 7; i++) {
            arena1.addLine(JFinn.getBodyLines()[i]);
        }
        arena1.addBall(JFinn.getFace());
        arena1.addRectangle(JFinn.getHealthBar());

        // virus stuff

        int moveCount = 0;
        int virusCounter = 0;

        // actions
        while (true) {

            moveCount++;

            if (virusDestroyed == true) {
                int indexer = random.nextInt(3);
                String chosen = directions[indexer];
                if (chosen == "Left") {
                    vXLoc = 40;
                    vYLoc = 395;
                } else if (chosen == "Right") {
                    vXLoc = 1040;
                    vYLoc = 395;
                } else if (chosen == "Down") {
                    vXLoc = 600;
                    vYLoc = 395;
                } else if (chosen == "Up") {
                    vXLoc = 540;
                    vYLoc = 30;
                }
                easyVirus = new Virus(100, 35, vXLoc, vYLoc, chosen);
                cycleChoice = new Text(easyVirus.getPowerup(), 15, 0, 0, "BLACK");
                virusCounter++;
                for (int i = 0; i < 5; i++) {
                    arena1.addBall(easyVirus.getBodyParts()[i]);
                }
                arena1.addRectangle(easyVirus.getHealthBar());
                virusDestroyed = false;
            }
            if (easyVirus.getXPosition() >= arena1.getWidth() ||
                    easyVirus.getXPosition() <= 0 ||
                    easyVirus.getYPosition() >= arena1.getHeight() ||
                    easyVirus.getYPosition() <= 0) {
                easyVirus.setHealth(100);
                virusDestroyed = true;
            }

            if (easyVirus.getStartDirection() == "Left") {
                easyVirus.moveRight();
                virusPellet.virusRightMove();
            }
            if (easyVirus.getStartDirection() == "Right") {
                easyVirus.moveLeft();
                virusPellet.virusLeftMove();
            }
            if (easyVirus.getStartDirection() == "Up") {
                easyVirus.moveDown();
                virusPellet.virusDownMove();
            }
            if (easyVirus.getStartDirection() == "Down") {
                easyVirus.moveUp();
                virusPellet.virusUpMove();
            }

            if (playerAlive = true) {
                if (virusDestroyed == false) {
                    if (moveCount % 50 == 0) {
                        virusPellet.setVX(easyVirus.getXPosition(), easyVirus.getYPosition());
                        arena1.addBall(virusPellet.vBall());
                    }
                }
            }
            if (arena1.rightMousePressed()) {
                arena1.removeBall(bullet.getBall());
                shotDirection++;
                if (shotDirection > 3) {
                    shotDirection = 0;
                }
            }

            if (shotDirection == 0) {
                bullet.leftMove();
            }
            if (shotDirection == 1) {
                bullet.upMove();
            }
            if (shotDirection == 2) {
                bullet.rightMove();
            }
            if (shotDirection == 3) {
                bullet.downMove();
            }

            if (playerAlive == true) {
                if (arena1.leftMousePressed()) {
                    arena1.removeBall(bullet.getBall());
                    bullet = new Projectile(JFinn.sendXShotLoc(), JFinn.sendYShotLoc());
                    if (ammo >= 1) {
                        arena1.addBall(bullet.getBall());
                        ammo--;
                    }

                    if (ammo <= 0) {
                        arena1.addText(outOfammo);
                    }
                }
            }

            if (checkBVCollision(bullet, easyVirus)) {
                easyVirus.setHealth(10);
                if (easyVirus.getHealth() <= 0 && !virusDestroyed) {

                    deathXloc = easyVirus.getXPosition();
                    deathYloc = easyVirus.getYPosition();

                    cycleChoice = new Text(easyVirus.getPowerup(), 15, deathXloc, deathYloc, "BLACK");

                    for (int i = 0; i < 5; i++) {
                        arena1.removeBall(easyVirus.getBodyParts()[i]);
                    }
                    arena1.removeRectangle(easyVirus.getHealthBar());

                    arena1.addText(cycleChoice);

                    virusDestroyed = true;

                    if (cycleChoice != null && checkTSCollision(cycleChoice, JFinn)){
                        if (cycleChoice.getText() == "+ Health") {
                            JFinn.incHealth(5);
                        } else if (cycleChoice.getText() == "+ Ammo") {
                            JFinn.incAmmo(15);
                        } else if (cycleChoice.getText() == "+ Shield") {
                            shieldOn = true;
                        }

                        arena1.removeText(cycleChoice);
                        cycleChoice = null;
                    }
                }
            }

            if (checkVSCollision(virusPellet, JFinn)) {
                if (shieldOn == false) {
                    JFinn.setHealth(2);
                }
                shieldOn = false;
                arena1.removeBall(virusPellet.vBall());
                if (JFinn.getHealth() <= 0) {
                    arena1.clearGameArena();
                    arena1.setBackgroundImage(null);
                    Text gameOver = new Text("Game Over!", 50, 20, 210, "RED");
                    arena1.addText(gameOver);
                    playerAlive = false;
                }
            }

            if (virusDestroyed) {
                deathXloc = easyVirus.getXPosition();
                deathYloc = easyVirus.getYPosition();

                for (int i = 0; i < 5; i++) {
                    arena1.removeBall(easyVirus.getBodyParts()[i]);
                }
                arena1.removeRectangle(easyVirus.getHealthBar());

                if (cycleChoice != null && checkTSCollision(cycleChoice, JFinn)) {
                    if (cycleChoice.getText() == "+ Health") {
                        JFinn.incHealth(15);
                    } else if (cycleChoice.getText() == "+ Ammo") {
                        JFinn.incAmmo(15);
                    } else if (cycleChoice.getText() == "+ Shield") {
                        shieldOn = true;
                    }

                    arena1.removeText(cycleChoice);
                    cycleChoice = null;
                }
            }

            if(virusCounter >= 10){
                arena1.clearGameArena();
                arena1.setBackgroundImage(null);
                Text winScreen = new Text("You Win!", 50, 420, 210, "GREEN");
                arena1.addText(winScreen);
            }

            JFinn.move(arena1.upPressed(), arena1.downPressed(), arena1.rightPressed(), arena1.leftPressed());

            arena1.pause();
        }
    }

    private static boolean checkBVCollision(Projectile bullet, Virus easyVirus) {
        double bulletX = bullet.getPX();
        double bulletY = bullet.getPY();
        Ball mainBodyPart = easyVirus.getBodyParts()[0];
        double virusX = mainBodyPart.getXPosition();
        double virusY = mainBodyPart.getYPosition();
        if (Math.abs(bulletX - virusX) < 10 && Math.abs(bulletY - virusY) < 10) {
            return true;
        }
        return false;
    }

    private static boolean checkTSCollision(Text cycleChoice, Scientist JFinn) {
        double textX = cycleChoice.getXPosition();
        double textY = cycleChoice.getYPosition();
        Line mainBodyPart[] = JFinn.getBodyLines();
        double scientistX[] = new double[7];
        double scientistY[] = new double[7];

        for (int i = 0; i < 7; i++) {
            scientistX[i] = mainBodyPart[i].getXStart();
        }
        for (int i = 0; i < 7; i++) {
            scientistY[i] = mainBodyPart[i].getYStart();
        }

        for (int i = 0; i < 7; i++) {
            if (Math.abs(textX - scientistX[i]) < 200 && Math.abs(textY - scientistY[i]) < 200) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkVSCollision(virusProjectile bullet, Scientist JFinn) {
        double bulletX = bullet.getVX();
        double bulletY = bullet.getVY();
        Line mainBodyPart[] = JFinn.getBodyLines();
        double scientistX[] = new double[7];
        double scientistY[] = new double[7];

        for (int i = 0; i < 7; i++) {
            scientistX[i] = mainBodyPart[i].getXStart();
        }
        for (int i = 0; i < 7; i++) {
            scientistY[i] = mainBodyPart[i].getYStart();
        }

        for (int i = 0; i < 7; i++) {
            if (Math.abs(bulletX - scientistX[i]) < 10 && Math.abs(bulletY - scientistY[i]) < 10) {
                return true;
            }
        }
        return false;
    }
}
