public class Girder {
    Rectangle girder;
    int x;
    int y;
    int width;
    int height;

    
    public Girder(int inX ,int inY,int w, int h ){
        x = inX;
        y = inY;
        width = w;
        height = h;
        girder = new Rectangle(x,y,width,height,"Red");

    }

    public Girder(){
        girder = new Rectangle(0,0,300,20,"Red");
    }

    public boolean collisionCheck(Rectangle object){
        if(girder.collides(object)){
            return true;
        }else{
            return false;
        }
    }

    public boolean collisionCheck(Ball object){
        if(girder.collides(object)){
            return true;
        }else{
            return false;
        }
    }

    public void addTo(GameArena arena){
        arena.addRectangle(girder);
    }
}
