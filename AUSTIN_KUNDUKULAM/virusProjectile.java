public class virusProjectile{
    private Ball virusProjectile;

    public virusProjectile(double vX, double vY) {

        virusProjectile = new Ball(vX, vY, 8, "GREEN");
    }

    public void virusRightMove(){
        virusProjectile.setXPosition(virusProjectile.getXPosition()+7);
    }
    public void virusLeftMove(){
        virusProjectile.setXPosition(virusProjectile.getXPosition()-7);
    }
    public void virusDownMove(){
        virusProjectile.setYPosition(virusProjectile.getYPosition()+7);
    }
    public void virusUpMove(){
        virusProjectile.setYPosition(virusProjectile.getYPosition()-7);
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
}