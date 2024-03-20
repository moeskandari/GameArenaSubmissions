public class Meteor 
{

    private Ball ball;
    private Rectangle base;

    public Meteor(double x, double y,GameArena arena)
    {
            ball = new Ball(x,y,50,"DARKGREY",3);
            base = new Rectangle(x-19, y-19, 40, 40, "BLACK", 0);
            arena.addBall(ball);
            arena.addRectangle(base);
    }

 

    public Rectangle hitbox(){
        return base;
    }


    public void fall()
    {
        ball.move(0, 5);
        base.move(0, 5);
    }

    public void clearMeteor(){ 
        ball.setXPosition(-150);
        base.setXPosition(-150);
    }
}



