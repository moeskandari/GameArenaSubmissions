public class Player 
{
    private int health;
    private double x;
    private double y;
    private Rectangle body;
    private Ball head;
    private double moveSpeed;

    public Player(int iHealth, double iX, double iY, double imoveSpeed)
    {
        x = iX;
        y = iY;
        health = iHealth;
        moveSpeed = imoveSpeed;
        body = new Rectangle(x, y, (double)30, (double)60, "BLUE", 1);
        head = new Ball(x+15, y-15, 30, "YELLOW", 1);
    }

    public void addTo(GameArena arena)
    {
        arena.addBall(head);
        arena.addRectangle(body);
    }

    public void move(double iX, double iY)
    {
        iX *= moveSpeed;
        iY *= moveSpeed;
        if(!(x <= 15 && iX < 0) && !(x >= 985 && iX > 0))
        {
            x += iX;
            body.move(iX, 0);
            head.move(iX, 0);
        }
        if(!(y <= 30 && iY < 0) && !(y >= 670 && iY > 0))
        {
            y += iY;
            body.move(0, iY);
            head.move(0, iY);
        }

    }

    public Boolean checkCollides(Obstacle collider)
    {
        if(head.collides(collider.getBody()))
        {
            health--;
            return true;
        }
        else
        {
            return false;
        }
    }

    public Boolean checkHealthCollides(HealthBoost collider)
    {
        if(head.collides(collider.getBody()))
        {
            health++;
            return true;
        }
        else
        {
            return false;
        }
    }

    public int getHealth()
    {
        return health;
    }

    public void setHealth(int input)
    {
        health = input;
    }

    public double getYPos()
    {
        return y;
    }
}
