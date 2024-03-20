

public class Bout 
{

    private Text[] starting = new Text[4];
    private int numWords = 4;

    private Text[] ending = new Text[3]; 

    private Rectangle backDrop = new Rectangle(500, 150, 800,150, "#141414");
    private Rectangle backDropDepth = new Rectangle(510, 160, 780,130, "#3b3b3b");
    
    private Rectangle backDrop2 = new Rectangle(500, 150, 300,10, "#141414");
    private Rectangle backDropDepth2 = new Rectangle(510, 160, 300,100, "#3b3b3b");

    public Bout(GameArena arena)

    {
        
        starting[0] = new Text(" En Guarde..",100,520,250,"BLACK");
        starting[1] = new Text("Both Ready..",100,520,250,"BLACK");
        starting[2] = new Text("FENCE!",100,710,250,"BLACK");
        starting[3] = new Text("HALT!",100,730,250,"BLACK");

        ending[0] = new Text("Player 1 Wins!",80,520,250,"BLACK");
        ending[1] = new Text("Player 2 Wins!",80,520,250,"BLACK");
        ending[2] = new Text("DRAW!",100,730,250,"BLACK");



        //start oob and are brought down each point
        for(int i = 0; i < numWords; i++)
        {
            starting[i].setYPosition(starting[i].getYPosition()+800);
        }

        backDropDepth.setYPosition(backDropDepth.getYPosition()+800);
        backDrop.setYPosition(backDrop.getYPosition()+800);
        backDropDepth2.setYPosition(backDropDepth2.getYPosition()+800);
        backDrop2.setYPosition(backDrop2.getYPosition()+800);

        ending[0].setYPosition(ending[0].getYPosition()+800);
        ending[1].setYPosition(ending[1].getYPosition()+800);
        ending[2].setYPosition(ending[2].getYPosition()+800);


        //puts it in the game
        arena.addRectangle(backDrop);
        arena.addRectangle(backDropDepth);
        arena.addRectangle(backDrop2);
        arena.addRectangle(backDropDepth2);

        arena.addText(ending[0]);
        arena.addText(ending[1]);
        arena.addText(ending[2]);

        for(int i = 0; i < numWords; i++)
        {
            arena.addText(starting[i]);
        }

        
    }

    public void showText(int word,int time)//Enguarde... Both Ready... Fence!
    {
        starting[word].setYPosition(starting[word].getYPosition()-800);        
        try 
        {
            Thread.sleep(time);
            //System.out.println("Slept for 1 second.");
        }
        catch (InterruptedException e)
        {e.printStackTrace();}
        starting[word].setYPosition(starting[word].getYPosition()+800);  
    }

    public void EBR()
    {
        backDrop.setYPosition(backDrop.getYPosition()-800);
        backDropDepth.setYPosition(backDropDepth.getYPosition()-800);
        showText(0,1300);
        showText(1,1000);
        showText(2,800);
        backDrop.setYPosition(backDrop.getYPosition()+800);
        backDropDepth.setYPosition(backDropDepth.getYPosition()+800);
    }


    public void stop()
    {
        backDrop.setYPosition(backDrop.getYPosition()-800);
        backDropDepth.setYPosition(backDropDepth.getYPosition()-800);
        showText(3,1000);
        backDrop.setYPosition(backDrop.getYPosition()+800);
        backDropDepth.setYPosition(backDropDepth.getYPosition()+800);
    }

    public void decideWinner(Box box)
    {
        if(box.getScores()[0]>box.getScores()[1])
        {
            backDrop.setYPosition(backDrop.getYPosition()-800);
            backDropDepth.setYPosition(backDropDepth.getYPosition()-800);       
            ending[0].setYPosition(ending[0].getYPosition()-800);
        }
        else if(box.getScores()[1]>box.getScores()[0])
        {
            backDrop.setYPosition(backDrop.getYPosition()-800);
            backDropDepth.setYPosition(backDropDepth.getYPosition()-800);       
            ending[1].setYPosition(ending[1].getYPosition()-800);
        }
        else
        {
            backDrop.setYPosition(backDrop.getYPosition()-800);
            backDropDepth.setYPosition(backDropDepth.getYPosition()-800);
            ending[2].setYPosition(ending[2].getYPosition()-800);   
        }
    }
    


    public void play(GameArena arena)
    {

    arena.setBackgroundImage("stadium.png");


    //rf starting coords
    int RFxPos = 1200, RFyPos = 350;

    //lf starting coords
    int LFxPos = 580, LFyPos = 350;

    RightFencer rf = new RightFencer(arena,RFxPos,RFyPos);
    LeftFencer lf = new LeftFencer(arena, LFxPos, LFyPos);
    Box box = new Box(arena, 750, 650);
    

    box.addTo(arena);
    rf.addTo(arena);
    lf.addTo(arena);

    lf.enGuarde();
    rf.enGuarde();


    boolean LFparrying = false;
    boolean LFlunging = false;
    boolean LFtouche = false;

    boolean RFparrying = false;
    boolean RFlunging = false;
    boolean RFtouche = false;

    boolean stopClock = false;
    boolean halt = false;
    boolean gameOver = false;
    //boolean gameBegin = true;


    boolean antiLoopCondition = true;

    int winner = -1;

    long Timers[]= new long[12];
    for(int i = 0; i<12 ;i++)
    {
        Timers[i] = System.currentTimeMillis();
    }
    // 0-1 = lunge +4 for rf
    // 2-3 = parry +4 for rf
    // 8-9 = box clock

    int parryhold = 1000;
    int lungehold = 1500;

    EBR();
    while(true)
    {


        //##### starting and stopping the match #####//
        Timers[11] = System.currentTimeMillis();
        if(Timers[11]-Timers[10] > 2000 && halt == true && gameOver == false)
        {

            rf.resetPosition();
            lf.resetPosition();
            box.reset();
            if((halt && !gameOver))
                {EBR();}
            stopClock = false;
            Timers[10] = System.currentTimeMillis();
            halt = false;
        }

        if(lf.getXPosition()>rf.getXPosition())
        {
            halt = true;  
            stop();  
        }


        //##### win conidtion #####//
        if(gameOver && antiLoopCondition)
            {
            System.out.println("we have a winner");
            if(RFlunging||RFparrying)
                {rf.enGuarde();}
            if(LFlunging||LFparrying)
                {lf.enGuarde();}
            antiLoopCondition = false;
            box.reset();
            decideWinner(box);
            break;
            }

            
        //##### Box result #####//
        Timers[9] = System.currentTimeMillis();
        if(RFtouche)
            {   
                winner = 0;
                box.result(winner);
                RFtouche = false;
                stopClock = true;
                halt = true;
                stop();
                if((box.getScores()[0]==5 ||box.getScores()[1]==5))
                {gameOver = true;}
                Timers[10] = System.currentTimeMillis();
            }
            
        if(LFtouche)
            {
                winner = 1;
                box.result(winner);
                LFtouche = false;
                stopClock = true;
                halt = true;
                stop();
                if((box.getScores()[0]==5 ||box.getScores()[1]==5))
                {gameOver = true;}
                Timers[10] = System.currentTimeMillis();
            }
        

        if(Timers[9]-Timers[8] > 1000)
        {
            if(!stopClock)
            {
            box.clockTick();
            if(box.timeOut())
            {
                halt = true;
                stop();
                gameOver = true;
                
            }
            Timers[8] = System.currentTimeMillis();
            }
        }




        //##### Right Fencer Movment #####//
        Timers[7] = System.currentTimeMillis();
        Timers[5] = System.currentTimeMillis();

        //comes out of parry once time is up
        if(Timers[7] - Timers[6] > parryhold && RFparrying == true)
        {
            rf.parryDown();
            RFparrying = false;
        }


        //comes out of lunge once time is up
        if(Timers[5] - Timers[4] > lungehold && RFlunging== true)
        {
            rf.enGuarde();
            RFlunging = false;
        }


        //retreat
        if(arena.rightPressed() && halt == false)
        {   if(rf.getXPosition()+10 < 1800)
            {
            if(RFlunging == false)
                {rf.retreat();}
            }
        }


        //advance
        if(arena.leftPressed() && halt == false)
        {   if(RFlunging == false)
                {rf.advance();}
        }


        //lunge
        if(arena.upPressed() && halt == false)
        {
            if(RFparrying == false)
            {
                Timers[5] = System.currentTimeMillis();
                if(Timers[5] - Timers[4] > lungehold)
                {
                    RFlunging = true;
                    rf.lunge();
                    if(!LFparrying)
                        {
                            if(rf.detectHit(lf))
                                {RFtouche = true;}
                        }
                    Timers[4] =System.currentTimeMillis();
    
                }
            }
        }


        //parry
        if(arena.downPressed() && halt == false)
        {
            if(RFlunging == false)
            {
                Timers[7] = System.currentTimeMillis();
                if(Timers[7] - Timers[6] > parryhold)
                {
                    RFparrying = true;
                    rf.parryUp();
                    Timers[6] =System.currentTimeMillis();

                }
            }
        }





        //##### Left fencer Movment #####//
        Timers[3] = System.currentTimeMillis();
        Timers[1] = System.currentTimeMillis();

        //comes out of parry once time is up
        if(Timers[3] - Timers[2] > parryhold && LFparrying == true)
        {
            lf.parryDown();
            LFparrying = false;
        }


        //comes out of lunge once time is up
        if(Timers[1] - Timers[0] > lungehold && LFlunging== true)
        {
            lf.enGuarde();
            LFlunging = false;
        }


        //retreat
        if(arena.letterPressed('a') && halt == false)
        {   
            if(lf.getXPosition()-10 > 0)
            {
            if(LFlunging == false)
                {lf.retreat();}
            }
        }


        //advance
        if(arena.letterPressed('d') && halt == false)
        {   if(LFlunging == false)
                {lf.advance();}
        }


        //lunge
        if(arena.letterPressed('w') && halt == false)
        {
            if(LFparrying == false)
            {
                Timers[1] = System.currentTimeMillis();
                if(Timers[1] - Timers[0] > lungehold)
                {
                    LFlunging = true;
                    lf.lunge();
                    if(!RFparrying)
                        {
                            if(lf.detectHit(rf))
                                {LFtouche = true;}
                        }
                    Timers[0] =System.currentTimeMillis();
    
                }
            }
        }


        //parry
        if(arena.letterPressed('s') && halt == false)
        {
            if(LFlunging == false)
            {
                Timers[3] = System.currentTimeMillis();
                if(Timers[3] - Timers[2] > parryhold)
                {
                    LFparrying = true;
                    lf.parryUp();
                    Timers[2] =System.currentTimeMillis();

                }
            }
        }
        arena.pause();
    }
 
    }
}
