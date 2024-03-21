public class Projectile {
    Ball projectile;
    Ball virusProjectile;
    int bulletAmount;

    public Projectile(double x, double y) {

        projectile = new Ball(x, y, 8, "ORANGE");
        virusProjectile = new Ball(x, y, 8, "GREEN");
    }

    public void virusMove(){
        virusProjectile.setXPosition(virusProjectile.getXPosition()+15);
    }
    public Ball vBall(){
        return virusProjectile;
    }

    public double getVX(){
        return virusProjectile.getXPosition();
    }

    public double getVY(){
        return virusProjectile.getYPosition();
    }

    public void setVX(double x, double y){
        virusProjectile.setXPosition(x);
        virusProjectile.setYPosition(y);
    }

    public double getPX(){
        return projectile.getXPosition();
    }

    public double getPY(){
        return projectile.getYPosition();
    }

    public Ball getBall(){
        return projectile;
    }

    public void leftMove(){
            projectile.setXPosition(projectile.getXPosition() - 7);
    }

    public void rightMove(){
        projectile.setXPosition(projectile.getXPosition() + 7);
    }

    public void upMove(){
        projectile.setYPosition(projectile.getYPosition() - 7);
    }

    public void downMove(){
        projectile.setYPosition(projectile.getYPosition() + 7);
    }

}
