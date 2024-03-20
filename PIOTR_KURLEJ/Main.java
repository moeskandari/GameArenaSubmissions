import java.awt.RenderingHints.Key;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        //arena
        GameArena arena = new GameArena(500, 700);

        //=====================================================
        //   title screen
        //=====================================================

        Text title1 = new Text("METEOR", 50, 140, 250,"white",1);
        Text title2 = new Text("MAYHEM", 50, 137, 300,"white",1);
        Text title3 = new Text("Press SPACE To Play", 30, 100, 450,"white",1);
        arena.addText(title1);
        arena.addText(title2);
        arena.addText(title3);

        boolean menu = true; 
        do{ 
            arena.pause();
            if (arena.spacePressed())   
                menu = false;
        }while(menu == true);
        arena.clearGameArena();

        //===================================================================

        int highestScore = 0;
        Player player = new Player(250,750);  //x = 250 , y = >700
        int controlScreen = 0;

        Text aLeft = new Text("A = LEFT", 30, 186, 250,"white",1);
        Text dRight = new Text("D = RIGHT", 30, 182, 300,"white",1);

        while(true)
        { 
            player.addTo(arena);

            while(controlScreen <= 150)
            {

                player.flyIn(controlScreen);
                if(arena.letterPressed('a'))
                player.move('a');
                if(arena.letterPressed('d'))
                    player.move('d');

                arena.addText(aLeft);
                arena.addText(dRight);


                if (controlScreen == 150){
                    aLeft.setYPosition(-100);
                    dRight.setYPosition(-100);
                }
                controlScreen++;
                arena.pause();  
            }

            int timer = 0;
            int hardMode = 0;
            int highScore = 0;
            int textTimer = 0;

            player.addTo(arena);

            Meteor meteor1 = new Meteor(-150, 0, arena);
            Meteor meteor2 = new Meteor(-150, 0, arena);
            Meteor meteor3 = new Meteor(-150, 0, arena);
            Meteor meteor4 = new Meteor(-150, 0, arena);
            Meteor meteor5 = new Meteor(-150, 0, arena);
            Meteor meteor6 = new Meteor(-150, 0, arena);
            Meteor meteor7 = new Meteor(-150, 0, arena);
            Meteor meteor8 = new Meteor(-150, 0, arena);
            Meteor meteor9 = new Meteor(-150, 0, arena);
            Text scoreBoard = new Text("0", 30, 400, 100, "WHITE",9);
            Text hardModeText = new Text("HARD MODE", 70, 35,200,"WHITE",9);
            arena.addText(scoreBoard);

            //=======================================================================
            //        GAME RUNNING
            //=======================================================================
            while(true)
            {   
                // System.out.println(timer);

                if(arena.letterPressed('a'))
                    player.move('a');
                if(arena.letterPressed('d'))
                    player.move('d');
                

                if (timer >= 0){ 
                    if (timer == 0){ 
                        meteor1.clearMeteor();
                        meteor1 = new Meteor((int)((Math.random())*500), -10, arena);
                    }
                meteor1.fall();
                if (player.checkCollision(meteor1) == true)
                    break;
                }


                if (timer > 0){
                    if (timer == 20){
                        meteor2.clearMeteor();
                        meteor2 = new Meteor((int)((Math.random())*500), -10, arena);
                    }
                    meteor2.fall();
                    if (player.checkCollision(meteor2) == true)
                        break;
                    }


                if (timer > 0){
                    if (timer == 40){ 
                        meteor3.clearMeteor();
                        meteor3 = new Meteor(250, -10, arena);
                    }
                    meteor3.fall();
                    if (player.checkCollision(meteor3) == true)
                        break;
                }

                if (timer >= 0){ 
                    if (timer == 60){ 
                        meteor4.clearMeteor();
                        meteor4 = new Meteor((int)((Math.random())*500), -10, arena);
                    }
                meteor4.fall();
                if (player.checkCollision(meteor4) == true)
                    break;
                }

                if (timer >= 0){ 
                    if (timer == 80){ 
                        meteor5.clearMeteor();
                        meteor5 = new Meteor((int)((Math.random())*500), -10, arena);
                    }
                meteor5.fall();
                if (player.checkCollision(meteor5) == true)
                    break;
                }

                if (timer >= 0){ 
                    if (timer == 100){ 
                        meteor6.clearMeteor();
                        meteor6 = new Meteor((int)((Math.random())*500), -10, arena);
                    }
                meteor6.fall();
                if (player.checkCollision(meteor6) == true)
                    break;
                }



                if (hardMode > 600)
                {
                    if (textTimer <= 100)
                    {
                        arena.addText(hardModeText);
                        if (textTimer == 100)
                            hardModeText.setYPosition(-200);
                        textTimer++;
                    }
                    if (timer >= 0){ 
                        if (timer == 120){ 
                            meteor7.clearMeteor();
                            meteor7 = new Meteor((int)((Math.random())*500), -10, arena);
                        }
                    meteor7.fall();
                    if (player.checkCollision(meteor7) == true)
                        break;
                    }

                    if (timer >= 0){ 
                        if (timer == 140){ 
                            meteor8.clearMeteor();
                            meteor8 = new Meteor((int)((Math.random())*500), -10, arena);
                        }
                    meteor8.fall();
                    if (player.checkCollision(meteor8) == true)
                        break;
                    }

                    if (timer >= 0){ 
                        if (timer == 160){ 
                            meteor9.clearMeteor();
                            meteor9 = new Meteor((int)((Math.random())*500), -10, arena);
                        }
                    meteor9.fall();
                    if (player.checkCollision(meteor9) == true)
                        break;
                    }
                }

                timer += 1;
                hardMode += 1;
                highScore +=1;

                if (timer == 160)
                    timer = 0;

                scoreBoard.setText(Integer.toString(highScore));
                
                arena.pause();
            }
            

            //=====================================
            //   LOSE
            //=====================================

            arena.clearGameArena();


            if (highScore >= highestScore)
                highestScore = highScore;
            else
            {
                String lowScore = Integer.toString(highScore);
                Text lowScoreText = new Text(lowScore,40, 220, 295, "RED");
                arena.addText(lowScoreText);
            }


            String highScoreString = Integer.toString(highestScore);

            Text highscore1 = new Text("HIGH SCORE", 45, 110, 150, "white",5);
            Text score = new Text(highScoreString, 60, 200, 235, "WHITE", 5);
            Text reset1 = new Text("Press SPACE To Play Again", 25,80 ,400,"white"); 
            Text orText = new Text("or", 25, 237, 450, "WHITE");
            Text quitText = new Text("Press ESC to Rage Quit", 25, 103, 500, "White");
            arena.addText(highscore1);
            arena.addText(score);
            arena.addText(reset1);
            arena.addText(orText);
            arena.addText(quitText);

            while (true)
            {
                arena.pause();
                if (arena.spacePressed())   
                    break;
                if (arena.escPressed())
                    System.exit(0);
            }
            arena.clearGameArena();
        }
    }
}
    


