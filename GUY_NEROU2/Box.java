public class Box 
{
    private Rectangle[] components = new Rectangle[7];
    private int numComponents = 7;

    private Text[] clock = new Text[3];
    private int numClockParts = 3;

    private Text[] scores = new Text[2];

    
    public Box(GameArena arena,int xPos, int yPos)
    {
        //'box'
        components[0] = new Rectangle(240, 140, 320, 120,"#3b3b3b");
        components[1] = new Rectangle(250, 150, 150, 100,"#141414");
        components[2] = new Rectangle(400, 150, 150, 100,"#141414");

        //left player no point
        components[3] = new Rectangle(260, 160, 75, 75,"#3b3b3b");
        //right player no point
        components[4] = new Rectangle(465, 160, 75, 75,"#3b3b3b");

        // right player point
        components[5] = new Rectangle(465, 160, 75, 75,"#199564");
        // left player point
        components[6] = new Rectangle(260, 160, 75, 75,"#B22222");

        //clock obvs lol
        clock[0] = new Text("1",30,360,195,"WHITE");
        clock[1] = new Text(":",30,380,195,"WHITE");
        clock[2] = new Text("30",30,395,195,"WHITE");

        //player scores
        scores[0] = new Text("00",30,342,230,"WHITE");
        scores[1] = new Text("00",30,416,230,"WHITE");


        


        


    for(int i = 0; i<numComponents; i++)
    {
        components[i].setXPosition(components[i].getXPosition()-250+xPos);
        components[i].setYPosition(components[i].getYPosition()-150+yPos);
    }

        //puts scores oob
        components[5].setYPosition(components[5].getYPosition()+800);
        components[6].setYPosition(components[6].getYPosition()+800);

    for(int i = 0; i<numClockParts;i++)
    {
        clock[i].setXPosition(clock[i].getXPosition()-250+xPos);
        clock[i].setYPosition(clock[i].getYPosition()-150+yPos);
    }

    for(int i = 0; i<2;i++)
    {
        scores[i].setXPosition(scores[i].getXPosition()-250+xPos);
        scores[i].setYPosition(scores[i].getYPosition()-150+yPos);
    }


    }


    public void addTo(GameArena arena)
    {
        for(int i = 0; i<numComponents; i++)
        {
            arena.addRectangle(components[i]);
        }

        for(int i = 0; i<numClockParts; i++)
        {
            arena.addText(clock[i]);
        }

        for(int i = 0; i<2; i++)
        {
            arena.addText(scores[i]);
        }

    }


    public void clockTick()
    {
        if(Integer.parseInt(clock[2].getText()) != 0 || Integer.parseInt(clock[0].getText()) != 0)
            if(Integer.parseInt(clock[2].getText()) > 0)
            {
                if(Integer.parseInt(clock[2].getText()) < 11)
                {
                    clock[2].setText("0"+Integer.toString(Integer.parseInt(clock[2].getText())-1));
                }
                else
                {
                    clock[2].setText(Integer.toString(Integer.parseInt(clock[2].getText())-1));
                }
            }
            else
            {  
                clock[2].setText(Integer.toString(Integer.parseInt(clock[2].getText())+59));
                clock[0].setText(Integer.toString(Integer.parseInt(clock[0].getText())-1));
            }  
    }

    public boolean timeOut()
    {
        if(Integer.parseInt(clock[2].getText()) ==0 && Integer.parseInt(clock[0].getText()) ==0 )
        {
            return true;
        }
        return false;
    }



    
    public void result(int winner)
    {
        //1 for left point - 0 for right point - 2 for double point
        if(winner == 0)
        {
            components[5].setYPosition(components[5].getYPosition()-800);
            scores[1].setText("0"+Integer.toString(Integer.parseInt(scores[1].getText())+1));
        }

        else if(winner == 1)
        {
            components[6].setYPosition(components[6].getYPosition()-800);
            scores[0].setText("0"+Integer.toString(Integer.parseInt(scores[0].getText())+1));
        }

        else if(winner == 2)
        {
            components[5].setYPosition(components[5].getYPosition()-800);
            components[6].setYPosition(components[6].getYPosition()-800);
        }

    }

    public void reset()
    {
        if(components[5].getYPosition() < 800)
            {components[5].setYPosition(components[5].getYPosition()+800);}
        
        if(components[6].getYPosition() < 800)
            {components[6].setYPosition(components[6].getYPosition()+800);}
    }

    public int[] getScores()
    {   int[] points = new int[2];
        points[0] = Integer.parseInt(scores[0].getText());
        points[1] = Integer.parseInt(scores[1].getText());

        return points;

    }
}

