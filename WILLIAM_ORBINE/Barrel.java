public class Barrel implements Runnable {
    private int x;
    private int y;
    private boolean supported = false;
    private Ball barrel;

    private int endY;
    private Barrel_Controller bController;
    private int gravity = 12;
    private boolean direction = false; //true = right , fasle  = left
    private Level level;
    private int barrelNo;
    private boolean changeDir = false;
   


    public Barrel( int inX , int inY,int endY , Barrel_Controller bController,Level level,int barrelNo,Boolean bDir){
        x = inX;
        y = inY;
        this.level = level;
        this.endY = endY;
        this.direction = bDir;
      
        this.bController = bController;
        this.barrelNo = barrelNo;
        barrel = new Ball();
        barrel.setXPosition(x);
        barrel.setYPosition(y);
        barrel.setSize(35);

        
    }


    public void  addTo(GameArena arena){
        arena.addBall(barrel);
    }
    public int getBarrelNo(){
        return(this.barrelNo);
    }

    public void gravityAffect(int gravity){
        if(supported == false){// ching to see if on girders 
            
            // Checking to see if the barrel is at the bottom of the map
            if (y - gravity > 1000){
                y = 1000;
            }else{
                y = y + gravity;
            }
            //moving the player to the new gravitylocation 
            barrel.move(0,y - barrel.getYPosition());
        }
        
        

    }

    public void  move(){
        if(supported){
            if(direction){//moving right
                x = x+ 1;
                barrel.move(x - barrel.getXPosition(),0);
            }else{//left 
                x= x - 1;
                barrel.move(x - barrel.getXPosition(),0);
            }
        }
        

    }
    
    public void run(){
        while(true){

            if(y >= endY){
                bController.removeBarrel(this);
            }
            if(level.collisionDetection(barrel)==true){
                supported = true;
            }else{
                supported = false;
            }
            if(supported == false && changeDir == false){
                changeDir = true;
            }
            if(supported ==true  && changeDir == true){
                changeDir = false;
                // I want the barrel to switch direction when falling
            if(direction == false){
                direction =true;
            }else{
                direction = false;
            }
            }
            
            // if(x > 950){
            //     bController.removeBarrel(this);
            // }

            if(level.getPlayer().getBody().collides(barrel)){
                
                level.levReset(-1);
                
            }
            
            gravityAffect(gravity);
            move();
            bController.pauseBarrel(this);
            

        } 
    }

    public Ball getBall(){
        return(barrel);
    }

    public void removeBall(GameArena arena){
        arena.removeBall(barrel);

    }
        

   

    // public void gravityAffect(int gravity){
    //     if(supported == false){// ching to see if on girders 
    //         // Checking to see if the player is at the bottom of the map 
    //     if (y - gravity > 1000){
    //         y = 1000;
    //     }else{
    //         y = y + gravity;
    //     }
    //     //moving the player to the new gravitylocation 
    //     body.move(0,y - body.getYPosition());
    //     }
        
        

    // }
}
