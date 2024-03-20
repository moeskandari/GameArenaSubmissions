import java.util.LinkedList;
public class Barrel_Controller implements Runnable {
    private int startX ,startY ,endY;
    private LinkedList<Barrel> barrelList = new LinkedList<Barrel>();
    // This next attribute I'm pretty sure is a goofy thing but eh i can't figure out another implementation 
    private KonkeyDong kD;
    private Thread[] threads = new Thread[100];//I hope i can implement something that prevents an out of bounds error, but if not 100 * 3 seconds of play time should be good enough 
    private GameArena arena;
    private Level level;
    private boolean bDir; 
   
    public Barrel_Controller(int startX , int startY , GameArena arena,Level level,KonkeyDong kD,int endY,boolean bDir){
        this.startX = startX ;
        this.startY = startY;
        this.endY = endY;
        // this.endY = endY;
        this.arena = arena;
        this.level = level;
        this.kD = kD;
        this.bDir = bDir;

        
        

    }

    public void run(){
        int barrelCount = 0;
        while(!level.getGO() || !level.getWon() ){
            if(barrelCount > threads.length-1){
                barrelCount = 0;
            }
            //List that will be used to store the barrels
            barrelList.addLast(new Barrel(startX, startY, endY, this,level,barrelCount,bDir));
            barrelList.getLast().addTo(this.arena);

            
            threads[barrelCount] = new Thread(barrelList.getLast());
    
            threads[barrelCount].start();
            barrelCount++;
            kD.jump();
            
            
            arena.pause(3000);
        }
        
    }

    public void removeBarrel(Barrel barrel){
        barrel.removeBall(arena);
        threads[barrel.getBarrelNo()].stop();

        barrelList.removeFirstOccurrence(barrel);
    }

    public void pauseBarrel(Barrel B){
        try{
            threads[B.getBarrelNo()].sleep(10);

        } catch (InterruptedException e) {

            e.printStackTrace();
            }
        
    }

    public KonkeyDong getDong(){
        return this.kD;
    }

    public LinkedList getBarrelList(){
        return(barrelList);
    }

    public void removeAll(){
        while(!barrelList.isEmpty()){
            
            barrelList.getFirst().removeBall(arena);
            int arrayPos = barrelList.getFirst().getBarrelNo();
            barrelList.removeFirst();
            
            threads[arrayPos].stop();
        }
    }
}



