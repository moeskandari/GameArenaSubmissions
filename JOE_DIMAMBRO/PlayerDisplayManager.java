public class PlayerDisplayManager extends StaticObject{

    private Double rayResolution;

    public PlayerDisplayManager(int rayResolution){

        super(0.0,0.0,rayResolution);
        this.rayResolution=(double) rayResolution;
        Double rectWidth = 1800/(this.rayResolution);

        //creates all the rectangles to be used for the players view.
        for (int i=0;i<rayResolution;i++){
            ObjectParts[i]=new Rectangle(Integer.valueOf(i)*rectWidth+60.0, 340.0-(i*3/2),rectWidth,i*3 , "Blue", 5);
        }

    }

    public Rectangle[] getDisplayWalls(){
        return ObjectParts;
    }

}