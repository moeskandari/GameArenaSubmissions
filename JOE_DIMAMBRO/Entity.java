public abstract class Entity extends StaticObject
{

    //entity constructor
    public Entity(Double xStart,Double yStart,int maxAmountofParts) 
    {
        super(xStart,yStart,maxAmountofParts);        
    }

    //moves entity in direction of offsets and tests collision
    public void move(Rectangle[] miniColisionArray){

        //move by x
        //move entity if collided
        this.move(1,0);
        Boolean collided = false;

        //test collision
        for (Rectangle r : miniColisionArray){
            if(r!=null){

                if(this.ObjectParts[0].collides(r)==true){
                    collided=true;
                }
            }
        }

        //move entity back if collided
        if(collided==true){
            this.move(-1,0);
        }
        collided=false;


        //move by y
        //move entity if collided
        this.move(0,1);
        collided = false;
        
        //test collision
        for (Rectangle r : miniColisionArray){
            if(r!=null){
    
               if(this.ObjectParts[0].collides(r)==true){
                   collided=true;
                }
            }
        }
        
        //move entity back if collided
        if(collided==true){
            this.move(0,-1);
        }

    }

    //moves entity via x,y attributes
    public void move(){
        for (Rectangle part : ObjectParts){
            if(part!=null){
               part.move(x,y); 
            }
        }
    }

    //moves entity by x,y attributes times respective parameters.
    public void move(int mx, int my){

        for (Rectangle part : ObjectParts){
            if(part!=null){
               part.move(x*mx,y*my); 
            }
        }
    }


    //moves the movement pointer which points to where the player is heading when w is pressed.
    public void changeOrbitalPos(Double angle){
        ObjectParts[1].move((75*Math.cos(angle)+ObjectParts[0].getXPosition()+20)-ObjectParts[1].getXPosition(), (75*Math.sin(angle)+ObjectParts[0].getYPosition()+25)-ObjectParts[1].getYPosition());

    }

}

