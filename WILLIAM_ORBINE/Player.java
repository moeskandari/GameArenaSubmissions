public class Player {
    
    private int x;
    private int y;
    private Rectangle body;
    private boolean supported = false ;
    private boolean direction = true; //true = right , fasle  = left
    private int lives;

    public Player(int inX ,int inY,int lives){
        x = inX;
        y = inY;
        body = new Rectangle(x,y,20,35,"blue");
        this.lives = lives;
    }
    
    public Rectangle getBody(){
        return body;
    }
    public void addTo(GameArena arena ){
        arena.addRectangle(body);
    }

    public void gravityAffect(int gravity){
        if(supported == false){// ching to see if on girders 
            // Checking to see if the player is at the bottom of the map 
        if (y - gravity > 1000){
            y = 1000;
        }else{
            y = y + gravity;
        }
        //moving the player to the new gravitylocation 
        body.move(0,y - body.getYPosition());
        }
        
        

    }
    public int getLives(){
        return(lives);
    }

    public void changeLives(int value){
        // Allows or the incrementing and decrementing of the player
        // Pass negative numbers and positive
        this.lives = this.lives + value;
    }

    public void setDir(boolean dir){
        //updating the player direction 
        direction = dir;

    }

    public boolean getDir(){
        return direction;
    }

    public void jump(Level l1, GameArena arena){
        supported = false;
        int xJumpValue;

        
        if(direction == true ){
            xJumpValue = 5;
        }else{
            xJumpValue = -5;
            
        }
        
        for(int loop = 0; loop < 250;loop ++){
            //x = x + xJumpValue;
            y = y - 1;
            //Checking to see if the player hits the bottom of a girder during a jump
            if(l1.collisionDetection(body) && loop > 20){
                y = y + 20;
                body.move(0, y - body.getYPosition());
                break;
            }
            
        //     body.move(x - body.getXPosition(),y - body.getYPosition());
            body.move(0,y - body.getYPosition());
            //arena.pause(1);
            
            
            
         }
        //supported = false;
        
        
     
        
    }
   

    public void setSupported(boolean value){
        // Setting if the player is standing on somthing
        supported = value;
    }

    public boolean getSupported(){
        return supported;
    }

    public void move(boolean dir){
        // moving the player horizontaly
        if(dir){
            x = x + 10;

        }else{
            x = x - 10;
        }
        body.move(x-body.getXPosition(), 0);
    }
    public int getX(){
        return(this.x);
    }
    public int getY(){
        return(this.y);
    }

    public void setX(int x){
        this.x = x;
    }

    public void sety(int y){
        this.y = y;
    }
}

