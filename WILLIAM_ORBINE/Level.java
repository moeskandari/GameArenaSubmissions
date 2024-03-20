import java.util.LinkedList;

public class Level {

    // Level allows for levels to be make quickly by just passing a few values in
    private int numGirders;

    //Girder[] girders = new Girder[20];
    private Girder[] girders;
    private Player Ply;
    private int pStrtX;
    private int pStrtY;
    private Thread barrelCThread;
    private int brlSrtX;
    private int brlSrtY;
    private GameArena arena;
    private KonkeyDong kD;
    private int gravity = 12;
    private Barrel_Controller bControl;
    private boolean gameOver = false;
    // Where the barrels will be killed
    private int bEndY;
    private  LivesDisplay livesTxt;
    private boolean won = false;

    public  Level(int inNumGirders,GameArena arena,int posOfGirders[][], int brlSrtX, int brlSrtY,int pStrtX , int pStrtY,int kX,int kY,int bEndY,int lives,boolean bDir){

        numGirders = inNumGirders;
        girders = new Girder[numGirders];
        Ply = new Player(pStrtX,pStrtY,lives);
        Ply.addTo(arena);
        this.bEndY = bEndY;
        this.arena = arena;
        this.pStrtX = pStrtX;
        this.pStrtY =pStrtY;
        this.kD =new KonkeyDong(kX,kY,arena);
        this.livesTxt = new LivesDisplay(Ply.getLives());
        this.livesTxt.addTo(arena);
        
        //KonkeyDong kD = 
        //placing the girders on the screen in the defined postions creating the level 
        for(int index = 0;index < numGirders; index ++){
            girders[index] = new Girder();
            girders[index].girder.setXPosition(posOfGirders[0][index]);
            girders[index].girder.setYPosition(posOfGirders[1][index]);
            girders[index].girder.setWidth(posOfGirders[2][index]);
            girders[index].addTo(arena);// displaying the  girders 
        }

        //strtBarrelController();
        
        this.bControl = new Barrel_Controller(brlSrtX, brlSrtY, arena,this,kD,bEndY,bDir);
        Thread barrelCThread = new Thread(bControl);
        bControl.getDong().setThread(barrelCThread);
        barrelCThread.start();
        

        while(true && !gameOver && !won)
        {   
    

            if (arena.upPressed() && Ply.getSupported()){
                Ply.jump(this,arena);
            }
            if(arena.leftPressed()){
                Ply.setDir(false);
                Ply.move(false);
            }
            if(arena.rightPressed()){
                Ply.setDir(true);
                Ply.move(true);
            }
            
            if(collisionDetection(Ply.getBody())){
                Ply.setSupported(true);
            }else{
                Ply.setSupported(false);
            }
            if(kD.getBody().collides(Ply.getBody())){
                // Level is won
                won = true;
                
                
            }
            Ply.gravityAffect(gravity);
            arena.pause();
    }
    barrelCThread.stop();
    
    if(gameOver && !won){
        while(true){

        }
    }
    arena.clearGameArena();
    

        

 


        
    }

    public Player getPlayer(){
        return(Ply);
    }

    public boolean getGO(){
        return(gameOver);
    }

    public boolean getWon(){
        return(won);
    }

    
    // public void strtBarrelController(){
    //     Barrel_Controller bControl = new Barrel_Controller(brlSrtX, brlSrtY, arena,this,kD);
    //     Thread barrelCThread = new Thread(bControl);
    //     bControl.getDong().setThread(barrelCThread);
    //     barrelCThread.start();
    // }

    public boolean collisionDetection(Rectangle object){
        // checks each girder to see if the player is on one 
        // if so then the player should not be affected by gravity
        for(int index = 0; index < numGirders;index ++){
            if(girders[index].collisionCheck(object) && girders[index].girder.getYPosition() > object.getYPosition()){
                return true;
            }

        }
        return false;
    }
    public boolean collisionDetection(Ball object){
        // checks each girder to see if the player is on one 
        // if so then the ball should not be affected by gravity
        for(int index = 0; index < numGirders;index ++){
            if(girders[index].collisionCheck(object) && girders[index].girder.getYPosition() > object.getYPosition()+5/*+5 here is to stop the ball getting stuck on the end of some girders  */){
                return true;
            }

        }
        return false;
    }

    public void levReset(int livesLost){
        // called when the player hits a barrel
        Ply.changeLives(livesLost);
        this.livesTxt.updateLives(Ply.getLives());
        Ply.getBody().setXPosition(this.pStrtX);
        Ply.getBody().setYPosition(this.pStrtY);
        Ply.setX(this.pStrtX);
        Ply.sety(this.pStrtY);



        


        
        //Ply.getBody().move(Ply.getX(), Ply.getY());
         
        
        
        
        int DEBUG_CurrentLives =Ply.getLives();
        if(Ply.getLives() == 0){
            livesTxt.gameOver();
            gameOver = true;

        }
        bControl.removeAll();
        barrelCThread.stop();
        //strtBarrelController();


    }

}
