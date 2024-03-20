public abstract class StaticObject{
//this object is a collection of retangles

    protected int maxAmountofParts=1;
    protected Double x,y;
    protected Rectangle[] ObjectParts;
    protected Double[] partOffSetArrayX;
    protected Double[] partOffSetArrayY;

    public StaticObject(Double xStart, Double yStart, int maxAmountofParts){

        //initiallises the object
        this.maxAmountofParts=maxAmountofParts;
        ObjectParts= new Rectangle[maxAmountofParts];
        partOffSetArrayX= new Double[maxAmountofParts];
        partOffSetArrayY= new Double[maxAmountofParts];

        for(int i=0;i<maxAmountofParts;i++){
            partOffSetArrayX[i]=0.0;//sets the offset array to be initialised to 0.
            partOffSetArrayY[i]=0.0;
        }

        x=xStart;
        y=yStart;
    }
       
        /*
        else if(inputEntityType=="En")//makes a player entity
        {
            Rectangle part = new Rectangle(x,y,100,100,"BLUE",10);
            ObjectParts[0] = part;
            Rectangle part2 = new Rectangle(x+25, y-50,50,50,"GREEN",11);
            ObjectParts[1] = part2;
            Rectangle part3 = new Rectangle(x, y+100,25,100,"RED",9);
            ObjectParts[2] = part3;
            Rectangle part4 = new Rectangle(x+75, y+100,25,100,"RED",9);
            ObjectParts[3] = part4;*/
        

        //adds the thing to the arena 
        public void addTo(GameArena arenaObject){
            for (Rectangle part: ObjectParts) {
                if (part!=null){
                    arenaObject.addRectangle(part);
                }
            }
        }

        //removes object from the game arena
        public void RemoveFrom(GameArena arenaObject){
            for (Rectangle part : ObjectParts) {
                if(part!=null){
                    arenaObject.removeRectangle(part);
                }
            }
        }
}