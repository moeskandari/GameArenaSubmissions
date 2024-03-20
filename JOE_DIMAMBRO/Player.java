public class Player extends Entity
{
    public String[] rayColourList;

    public Player(Double xStart,Double yStart){
        super(xStart,yStart,3);
        Rectangle part = new Rectangle(x,y,25,25,"BLUE",10);
        ObjectParts[0] = part;
        Rectangle part2 = new Rectangle(x+10, y-50,5,5,"GREEN",11);
        ObjectParts[1] = part2;
        Rectangle part3 = new Rectangle(x,y,0.1,0.1,"RED");
        ObjectParts[2] = part3;
    }

    //changes movement offsets depending on arrowkeys pressed
    public void changeDirection(double offX,double offY) 
    {
        x+=offX;
        y+=offY;
    }

    public void resetDirection(){//sets x and y to zero before checking player direction
        x=0.0;
        y=0.0;
    }

    //moves the movement pointer which points to where the player is heading when w is pressed.
    public void changeOrbitalPos(Double angle){
        ObjectParts[1].move((50*Math.cos(angle)+ObjectParts[0].getXPosition()+10)-ObjectParts[1].getXPosition(), (50*Math.sin(angle)+ObjectParts[0].getYPosition()+12.5)-ObjectParts[1].getYPosition());
    }

    //performs the raytrace every frame and returns array of wall heights
    public Double[] rayTrace(Double angle,int times,Rectangle[] collsisionList){  // currentAngle+=anglechange;
           
        rayColourList=new String[times];
        String currentColour="null";

        Double currentAngle= angle-Math.PI/4; //this determies how far from centre casting starts
        Double anglechange= Math.PI/2/times; //determines the players field of vision
        Double[] sizes=new Double[times]; 

        //carrays out a ray trace for every rectangle on the player display (displayResolution)
        //returns list of wall heights to then be used in maingame.
        for(int i=0;i<times;i++){

            ObjectParts[2].move(ObjectParts[0].getXPosition()-ObjectParts[2].getXPosition()+12.5,ObjectParts[0].getYPosition()-ObjectParts[2].getYPosition()+12.5);//set ray position to the players
            
            Boolean collided=false;
            Double distanceToWall=0.0;
            currentAngle= angle-Math.PI/4+anglechange*i; //angle-Math.PI/4+(Math.PI/4)-(i*Math.PI/4/times);
            Double xspeed=(1*Math.cos(currentAngle));
            Double yspeed=(1*Math.sin(currentAngle));

            //runs until ray has collided with wall handles x collision and y collision seperately, so walls can be different colours.
            while(collided==false){

                ObjectParts[2].move(xspeed,0);
                distanceToWall++;

                for (Rectangle r : collsisionList) {
                    if(r!=null){
                        if (ObjectParts[2].collides(r)==true){
                            collided=true;
                            currentColour="LIGHTGREY";
                        }
                    }
                }

                ObjectParts[2].move(0,yspeed);
                distanceToWall++;

                for (Rectangle r : collsisionList) {
                    if(r!=null){
                        if (ObjectParts[2].collides(r)==true){
                            collided=true;
                            if(currentColour=="null"){
                                currentColour="WHITE";
                            }
                        }
                    }
                }

            }
            
            //Writes a single height value for a wall to the array
            sizes[i]=700-(distanceToWall*0.28)*Math.cos(currentAngle-angle);
            rayColourList[i]=currentColour;
            currentColour="null";
        }
        return sizes;
    }

    public String[] getColours(){
        return rayColourList;
    }

}