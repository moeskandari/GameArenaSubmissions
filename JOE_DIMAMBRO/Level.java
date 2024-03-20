public abstract class Level extends StaticObject{
    
    //make collision lists for parts of the screen

    public Level(){
        super(0.0,0.0,20);
    }

    public Rectangle[] getCollision(Double x, Double y){
        return this.ObjectParts;
    }

}