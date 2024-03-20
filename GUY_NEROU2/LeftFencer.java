

public class LeftFencer
{
    private Rectangle[] pixels = new Rectangle[151];
    private int numPixels = 151;
    
    //actual + 1
    LeftFencer(GameArena arena,int xPos, int yPos)
    {
        //head
        //nl
        pixels[0] = new Rectangle(250, 150, 10,  10,"BLACK");
        pixels[1] = new Rectangle(240, 150, 10, 10,"BLACK");
        //nl
        pixels[2] = new Rectangle(260, 160, 10, 10,"BLACK");
        pixels[3] = new Rectangle(240, 160, 10, 10,"BLACK");
        pixels[4] = new Rectangle(230, 160, 10, 10,"BLACK");
        //nl
        pixels[5] = new Rectangle(270, 170, 10, 10,"BLACK");
        pixels[6] = new Rectangle(250, 170, 10, 10,"BLACK");
        pixels[7] = new Rectangle(230, 170, 10, 10,"BLACK");
        pixels[8] = new Rectangle(220, 170, 10, 10,"BLACK");
        //nl
        pixels[9] = new Rectangle(270, 180, 10, 10,"BLACK");
        pixels[10] = new Rectangle(260, 180, 10, 10,"BLACK");
        pixels[11] = new Rectangle(240, 180, 10, 10,"BLACK");
        pixels[12] = new Rectangle(230, 180, 10, 10,"BLACK");
        pixels[13] = new Rectangle(220, 180, 10, 10,"BLACK");
        //nl
        pixels[14] = new Rectangle(270, 190, 10, 10,"BLACK");
        pixels[15] = new Rectangle(250, 190, 10, 10,"BLACK");
        pixels[16] = new Rectangle(230, 190, 10, 10,"BLACK");
        pixels[17] = new Rectangle(220, 190, 10, 10,"BLACK");
        //nl
        pixels[18] = new Rectangle(260, 200, 10, 10,"BLACK");
        pixels[19] = new Rectangle(240, 200, 10, 10,"BLACK");
        pixels[20] = new Rectangle(230, 200, 10, 10,"BLACK");
        //nl
        pixels[21] = new Rectangle(250, 210, 10, 10,"BLACK");
        pixels[22] = new Rectangle(240, 210, 10, 10,"BLACK");

        //fill head
        pixels[96] = new Rectangle(250, 160, 10,  10,"GREY");

        pixels[97] = new Rectangle(260, 170, 10,  10,"GREY");
        pixels[98] = new Rectangle(240, 170, 10,  10,"GREY");

        pixels[99] = new Rectangle(250, 180, 10,  10,"GREY");
        
        pixels[100] = new Rectangle(260, 190, 10,  10,"GREY");
        pixels[101] = new Rectangle(240, 190, 10,  10,"GREY");

        pixels[102] = new Rectangle(250, 200, 10,  10,"GREY");



        //torso
        pixels[23] = new Rectangle(270, 220, 10, 10,"BLACK");
        pixels[24] = new Rectangle(260, 220, 10, 10,"BLACK");
        pixels[25] = new Rectangle(230, 220, 10, 10,"BLACK");
        pixels[26] = new Rectangle(220, 220, 10, 10,"BLACK");
        //nl
        pixels[27] = new Rectangle(270, 230, 10, 10,"BLACK");
        pixels[28] = new Rectangle(220, 230, 10, 10,"BLACK");
        //nl
        pixels[29] = new Rectangle(270, 240, 10, 10,"BLACK");
        pixels[30] = new Rectangle(220, 240, 10, 10,"BLACK");
        //nl
        pixels[31] = new Rectangle(270, 250, 10, 10,"BLACK");
        pixels[32] = new Rectangle(220, 250, 10, 10,"BLACK");
        pixels[33] = new Rectangle(260, 250, 10, 10,"BLACK");
        //nl
        pixels[34] = new Rectangle(260, 260, 10, 10,"BLACK");
        pixels[35] = new Rectangle(230, 260, 10, 10,"BLACK");
        pixels[36] = new Rectangle(220, 260, 10, 10,"BLACK");
        //nl
        pixels[37] = new Rectangle(260, 270, 10, 10,"BLACK");
        pixels[38] = new Rectangle(230, 270, 10, 10,"BLACK");
        //nl
        pixels[39] = new Rectangle(260, 280, 10, 10,"BLACK");
        pixels[40] = new Rectangle(250, 280, 10, 10,"BLACK");
        pixels[41] = new Rectangle(240, 280, 10, 10,"BLACK");
        pixels[42] = new Rectangle(230, 280, 10, 10,"BLACK");
        //fill torso
        pixels[79] = new Rectangle(260, 230, 10, 10,"WHITE");
        pixels[80] = new Rectangle(260, 240, 10, 10,"WHITE");
        //nr
        pixels[81] = new Rectangle(250, 220, 10, 10,"WHITE");
        pixels[82] = new Rectangle(250, 230, 10, 10,"WHITE");
        pixels[83] = new Rectangle(250, 240, 10, 10,"WHITE");
        pixels[84] = new Rectangle(250, 250, 10, 10,"WHITE");
        pixels[85] = new Rectangle(250, 260, 10, 10,"WHITE");
        pixels[86] = new Rectangle(250, 270, 10, 10,"WHITE");
        //nr
        pixels[87] = new Rectangle(240, 220, 10, 10,"WHITE");
        pixels[88] = new Rectangle(240, 230, 10, 10,"WHITE");
        pixels[89] = new Rectangle(240, 240, 10, 10,"WHITE");
        pixels[90] = new Rectangle(240, 250, 10, 10,"WHITE");
        pixels[91] = new Rectangle(240, 260, 10, 10,"WHITE");
        pixels[92] = new Rectangle(240, 270, 10, 10,"WHITE");
        //nr
        pixels[93] = new Rectangle(230, 230, 10, 10,"WHITE");
        pixels[94] = new Rectangle(230, 240, 10, 10,"WHITE");
        pixels[95] = new Rectangle(230, 250, 10, 10,"WHITE");
        



        







        //rear arm ()
        pixels[43] = new Rectangle(210, 230, 10, 10,"#570c9e");
        pixels[44] = new Rectangle(200, 240, 10, 10,"BLACK");
        pixels[45] = new Rectangle(190, 250, 10, 10,"BLACK");
        pixels[46] = new Rectangle(180, 260, 10, 10,"BLACK");

        //rear arm attacking
        pixels[137] = new Rectangle(210, 230, 10, 10,"#570c9e");
        pixels[138] = new Rectangle(200, 230, 10, 10,"BLACK");
        pixels[139] = new Rectangle(190, 230, 10, 10,"BLACK");
        pixels[140] = new Rectangle(180, 230, 10, 10,"BLACK");
        pixels[141] = new Rectangle(170, 230, 10, 10,"BLACK");

        

        //sword arm
        pixels[47] = new Rectangle(280, 230, 10, 10,"BLACK");
        pixels[48] = new Rectangle(290, 240, 10, 10,"BLACK");
        pixels[49] = new Rectangle(300, 250, 10, 10,"BLACK");

        // sword arm attacking
        pixels[120] = new Rectangle(280, 230, 10, 10,"BLACK");
        pixels[121] = new Rectangle(290, 240, 10, 10,"BLACK");
        pixels[122] = new Rectangle(300, 240, 10, 10,"BLACK");

        //foil handle
        pixels[50] = new Rectangle(310, 250, 10, 10,"BLACK");
        pixels[51] = new Rectangle(320, 230, 10, 10,"BLACK");
        pixels[52] = new Rectangle(320, 240, 10, 10,"BLACK");
        pixels[53] = new Rectangle(340, 250, 10, 10,"BLACK");

        //foil handle attacking
        pixels[123] = new Rectangle(310, 240, 10, 10,"BLACK");
        pixels[124] = new Rectangle(320, 250, 10, 10,"BLACK");
        pixels[125] = new Rectangle(320, 240, 10, 10,"BLACK");
        pixels[126] = new Rectangle(320, 230, 10, 10,"BLACK");
        
        //foil blade
        pixels[54] = new Rectangle(330, 240, 10, 10,"BLACK");
        pixels[55] = new Rectangle(340, 230, 10, 10,"BLACK");
        pixels[56] = new Rectangle(350, 220, 10, 10,"BLACK");
        pixels[57] = new Rectangle(360, 210, 10, 10,"BLACK");
        pixels[58] = new Rectangle(370, 200, 10, 10,"BLACK");
        pixels[59] = new Rectangle(380, 190, 10, 10,"BLACK");
        pixels[60] = new Rectangle(390, 180, 10, 10,"BLACK");
        pixels[61] = new Rectangle(400, 170, 10, 10,"BLACK");

        //foil blade attacking
        pixels[127] = new Rectangle(330, 240, 10, 10,"BLACK");
        pixels[128] = new Rectangle(340, 240, 10, 10,"BLACK");
        pixels[129] = new Rectangle(350, 240, 10, 10,"BLACK");
        pixels[130] = new Rectangle(360, 240, 10, 10,"BLACK");
        pixels[131] = new Rectangle(370, 240, 10, 10,"BLACK");
        pixels[132] = new Rectangle(380, 240, 10, 10,"BLACK");
        pixels[133] = new Rectangle(390, 240, 10, 10,"BLACK");
        pixels[134] = new Rectangle(400, 240, 10, 10,"BLACK");
        pixels[135] = new Rectangle(410, 240, 10, 10,"BLACK");
        pixels[136] = new Rectangle(420, 240, 10, 10,"PINK");






        //front leg
        pixels[62] = new Rectangle(270, 290, 10, 10,"BLACK");
        pixels[63] = new Rectangle(280, 290, 10, 10,"BLACK");
        pixels[64] = new Rectangle(290, 300, 10, 10,"BLACK");
        pixels[65] = new Rectangle(290, 310, 10, 10,"BLACK");
        //sock (FL)
        pixels[66] = new Rectangle(290, 320, 10, 10,"#570c9e");
        pixels[67] = new Rectangle(290, 330, 10, 10,"#570c9e");
        pixels[68] = new Rectangle(290, 340, 10, 10,"#570c9e");
        //shoe (FL)
        pixels[69] = new Rectangle(290, 350, 10, 10,"BLACK");
        pixels[70] = new Rectangle(300, 350, 10, 10,"BLACK");
        
        //fl lifted
        pixels[111] = new Rectangle(270, 290, 10, 10,"BLACK");
        pixels[112] = new Rectangle(280, 290, 10, 10,"BLACK");
        pixels[113] = new Rectangle(290, 290, 10, 10,"BLACK");
        pixels[114] = new Rectangle(300, 290, 10, 10,"BLACK");
        // sock fl lifted
        pixels[115] = new Rectangle(310, 290, 10, 10,"#570c9e");
        pixels[116] = new Rectangle(320, 290, 10, 10,"#570c9e");
        pixels[117] = new Rectangle(310, 290, 10, 10,"#570c9e");
        //shoe fl lifted
        pixels[118] = new Rectangle(330, 290, 10, 10,"BLACK");
        pixels[119] = new Rectangle(330, 280, 10, 10,"BLACK");
        


        //rear leg en guared
        pixels[71] = new Rectangle(230, 290, 10, 10,"BLACK");
        pixels[72] = new Rectangle(220, 300, 10, 10,"BLACK");
        pixels[73] = new Rectangle(220, 310, 10, 10,"BLACK");
        //sock (RL) en guare
        pixels[74] = new Rectangle(210, 320, 10, 10,"#570c9e");
        pixels[75] = new Rectangle(210, 330, 10, 10,"#570c9e");
        pixels[76] = new Rectangle(200, 340, 10, 10,"#570c9e");
        //shoe (RL) en guare
        pixels[77] = new Rectangle(200, 350, 10, 10,"BLACK");
        pixels[78] = new Rectangle(210, 350, 10, 10,"BLACK");
         
        // rear leg lunge
        pixels[103] = new Rectangle(220, 290, 10, 10,"BLACK");
        pixels[104] = new Rectangle(210, 300, 10, 10,"BLACK");

        pixels[105] = new Rectangle(200, 310, 10, 10,"BLACK");
        // sock RL lunge
        pixels[106] = new Rectangle(190, 320, 10, 10,"#570c9e");
        pixels[107] = new Rectangle(180, 330, 10, 10,"#570c9e");
        pixels[108] = new Rectangle(170, 340, 10, 10,"#570c9e");
        // shoe RL lunge
        pixels[109] = new Rectangle(180, 350, 10, 10,"BLACK");
        pixels[110] = new Rectangle(170, 350, 10, 10,"BLACK");
        
        //pixels that re simulate the legs and the arms for a lunge... pixels 103-130?...
        // on start pixels are located off screen


        // for parry sword
        pixels[142] = new Rectangle(330, 240, 10, 10,"BLACK");
        pixels[143] = new Rectangle(340, 240, 10, 10,"BLACK");
        pixels[144] = new Rectangle(350, 240, 10, 10,"BLACK");
        pixels[145] = new Rectangle(360, 240, 10, 10,"BLACK");
        pixels[146] = new Rectangle(370, 230, 10, 10,"BLACK");
        pixels[147] = new Rectangle(380, 230, 10, 10,"BLACK");
        pixels[148] = new Rectangle(390, 230, 10, 10,"BLACK");
        pixels[149] = new Rectangle(400, 230, 10, 10,"BLACK");
        pixels[150] = new Rectangle(410, 230, 10, 10,"BLACK");




        for(int i = 0; i<numPixels; i++)
        {
            pixels[i].setXPosition(pixels[i].getXPosition()-250+xPos);
            pixels[i].setYPosition(pixels[i].getYPosition()-150+yPos);
        }
        for(int i = 43; i< 79;i++)
        {
            pixels[i].setYPosition(pixels[i].getYPosition()+800);
        }
        for(int i = 142; i< 151;i++)
        {
            pixels[i].setYPosition(pixels[i].getYPosition()+800);
        }
        /// all this shit above puts the fencer into a starting position where certain pixels are off screen

        //should really do fill but i want to do gameplay already lol

        //len(pixels)+1 or wont work
    }

    public void addTo(GameArena arena)
    {
        for(int i = 0; i<numPixels; i++)
        {
            arena.addRectangle(pixels[i]);
        }
    }


    public void enGuarde()
    {
        for(int i = 43; i< 79;i++)
        {
            pixels[i].setYPosition(pixels[i].getYPosition()-800);
        }
        for(int i = 103; i<142; i++)
        {
            pixels[i].setYPosition(pixels[i].getYPosition()+800);
        }
    }


    public void retreat()
    {
        for(int i = 0; i<numPixels; i++)
        {
            pixels[i].move(-10,0);
        }
    }


    public void advance()
    {
        for(int i = 0; i<numPixels; i++)
        {
            pixels[i].move(10,0);
        }

    }


    public void lunge()
    {
        //changes the characters sprite
        //  moves up arms and legs
        for(int i = 43; i< 79; i++)
        {
            pixels[i].setYPosition(pixels[i].getYPosition()+800);
        }

        //  moves down new arms and legs
        for(int i = 103; i< 142; i++)
        {
            pixels[i].setYPosition(pixels[i].getYPosition()-800);
        }

        //moves the character
        for(int i = 0; i<numPixels; i++)
        {
            pixels[i].move(155,0);
        }
    }


    public void parryUp()
    {
        //changes the characters sprite
        //  moves up sword
        for(int i = 54; i< 62; i++)
        {
            pixels[i].setYPosition(pixels[i].getYPosition()+800);
        }

        //  moves down new sword
        for(int i = 142; i< 151; i++)
        {
            pixels[i].setYPosition(pixels[i].getYPosition()-800);
        }
    }

    public void parryDown()
    {
        //changes the characters sprite
        //  moves up sword
        for(int i = 54; i< 62; i++)
        {
            pixels[i].setYPosition(pixels[i].getYPosition()-800);
        }

        //  moves down new sword
        for(int i = 142; i< 151; i++)
        {
            pixels[i].setYPosition(pixels[i].getYPosition()+800);
        }
    }


    public Rectangle[] getTargetArea()
    {
        Rectangle targetArea[] = new Rectangle[36];
        for(int i = 0; i < 20;i++)
        {
            targetArea[i] = pixels[i+23];    
        }
        for(int i = 0; i < 17;i++)
        {
            targetArea[i+19] = pixels[i+79];    
        }
        return targetArea;
    }


    public Boolean detectHit(RightFencer rf)
    {
        for(int i = 0; i<36 ;i++)
        {
            if(pixels[136].collides(rf.getTargetArea()[i]))
            {

                System.out.println("hit Detected");
                return true;
            }     
        }
        System.out.println("no hit detected");
        return false;
    }


    public void resetPosition()
    {
        double currentPosition = pixels[0].getXPosition();
        double desiredPosition = 580;
        double changeNeeded = desiredPosition - currentPosition;

        for(int i = 0; i < numPixels; i++)
        {
            pixels[i].setXPosition(pixels[i].getXPosition()+changeNeeded);
        }

        //desired x position - current x position = change required
        
    }

    public double getXPosition()
    {
        double Xpos = pixels[0].getXPosition();
        return Xpos; 
    }
}