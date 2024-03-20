public class KonkeyDong {
    private Rectangle kD;
    private int x;
    private int y;
    private Thread thread;
    public void addTo(GameArena arena){
        arena.addRectangle(kD);
    }

    public KonkeyDong(int x,int y, GameArena arena){
        
        this.x = x;
        this.y = y-50;
        kD = new Rectangle(x, this.y, 50, 60, "#6E2020");
        addTo(arena);
    }

    public void setThread(Thread thread){
        this.thread = thread;
    }
    public void jump(){
        y = y - 30;
        kD.move(0,y - kD.getYPosition());
        try{
            this.thread.sleep(200);

        } catch (InterruptedException e) {

            e.printStackTrace();
            }
        y = y + 30;
        kD.move(0,y-kD.getYPosition());
        
        
        
    }
    public Rectangle getBody(){
        return(kD);
    }
}
