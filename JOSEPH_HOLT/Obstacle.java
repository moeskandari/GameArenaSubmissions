import java.util.Random;

public class Obstacle
{
    private double speed;
    private int diameter;
    private int startx;
    private Ball body;

    public Obstacle(int score)
    {
        if(score <= 0)
        {
            score = 1;
        }
        Random rnd = new Random();
        speed = rnd.nextDouble(5) + 3 + (score/1000);
        startx = rnd.nextInt(1000);
        diameter = rnd.nextInt(50) + 10;
        body = new Ball(startx, 0, diameter, "RED", 2);
    }

    public void addTo(GameArena arena)
    {
        arena.addBall(body);
    }
    
    public void move()
    {
        body.move(0, speed);
    }

    public double getYPos()
    {
        return body.getYPosition();
    }

    public Ball getBody()
    {
        return body;
    }
}
