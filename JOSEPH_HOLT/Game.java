import java.util.Random;
public class Game
{
    private static Obstacle[] balls = new Obstacle[10];
    public static int score;
    public static Boolean gameOver = false;
    private static GameArena arena;
    private static Player player;
    private static HealthBoost hpBoost;
    private static int ballsCount;
    private static int shownMessage;
    public static void main(String[] args)
    {
        gameOver = false;
        score = 0;
        arena = new GameArena(1000, 700);
        player = new Player(5, 500, 350, 5);
        Text playerHealthTxt = new Text("Health: " + player.getHealth(), 30, 10, 20, "WHITE");
        Text playerScoreTxt = new Text("Score: " + score, 30, 10, 60, "WHITE");
        Text gameOverMessage = new Text("Game over, press enter to restart", 30, 100, 100, "WHITE");
        hpBoost = null;
        shownMessage = 0;
        ballsCount = 0;
        player.addTo(arena);
        arena.addText(playerHealthTxt);
        arena.addText(playerScoreTxt);

        while(true)
        {
            while(gameOver == false)
            {
                //creating balls
                Random rnd = new Random();
                int rand = rnd.nextInt(100000);
                if(score >= 0)
                {
                    if(rand <= (score / 2) && ballsCount < 10)
                    {
                        balls[ballsCount] = new Obstacle(score);
                        balls[ballsCount].addTo(arena);
                        ballsCount++;
                    }
                    else if(rand >= 100000-(score/4) && hpBoost == null)
                    {
                        hpBoost = new HealthBoost(score);
                        hpBoost.addTo(arena);
                    }
                }
                else
                {
                    if(rand <= 1 && ballsCount < 10)
                    {
                        balls[ballsCount] = new Obstacle(score);
                        balls[ballsCount].addTo(arena);
                        ballsCount++;
                    }
                    else if(rand >= 99 && hpBoost == null)
                    {
                        hpBoost = new HealthBoost(score);
                        hpBoost.addTo(arena);
                    }
                }
                //user input
                if(arena.leftPressed()){
                    player.move(-1, 0);
                }
                if(arena.rightPressed()){
                    player.move(1, 0);
                }
                if(arena.upPressed()){
                    player.move(0, -1);
                }
                if(arena.downPressed()){
                    player.move(0, 1);
                }
                //updating the obstacles and checking for collision
                for(int i = 0; i < ballsCount; i++)
                {               
                    if(balls[i].getYPos() >= 750)
                    {
                        arena.removeBall(balls[i].getBody());
                        balls[i] = null;
                        resortList();
                        ballsCount--;
                    }
                    if(balls[i] != null)
                    {
                        balls[i].move();
                        if(player.checkCollides(balls[i]))
                        {
                            arena.removeBall(balls[i].getBody());
                            balls[i] = null;
                            resortList();
                            ballsCount--;
                        }
                    }               
                }
                //health booster logic
                if(hpBoost != null)
                {
                    hpBoost.move();
                    if(hpBoost.getYPos() >= 700)
                    {
                        arena.removeBall(hpBoost.getBody());
                        hpBoost = null;
                    }
                }
                if(hpBoost != null)
                {
                    if(player.checkHealthCollides(hpBoost))
                    {
                        arena.removeBall(hpBoost.getBody());
                        hpBoost = null;
                    }                
                }
                //checks for player death
                if(player.getHealth() <= 0)
                {
                    gameOver = true;
                }
                //changes text displays
                playerHealthTxt.setText("Health: " + player.getHealth());
                playerScoreTxt.setText("Score: " + score);
                //moves time on 1/50 of a second
                arena.pause();
                score += (800 - (int)player.getYPos()) / 100;
            }

            while(gameOver == true)
            {
                if(shownMessage == 0)
                {
                    arena.addText(gameOverMessage);
                    shownMessage = 1;
                }
                
                if(arena.enterPressed())
                {
                    arena.removeText(gameOverMessage);
                    resetGame();
                }
                arena.pause();
            }
        }
    }

    public static void resortList()
    {
        for(int i = 0; i < 10; i++)
        {
            if(balls[i] == null)
            {
                for(int j = i; j < 9; j++)
                {
                    balls[j] = balls[j + 1];
                }
            }
        }
    }

    public static void resetGame()
    {
        score = 0;
        ballsCount = 0;
        for(int i = 0; i < 10; i++)
        {
            if(balls[i] != null)
            {
                arena.removeBall(balls[i].getBody());
            }
            balls[i] = null;
        }
        if(hpBoost != null)
        {
            arena.removeBall(hpBoost.getBody());
            hpBoost = null;
        }
        player.setHealth(5);
        gameOver = false;
        shownMessage = 0;
    }
}