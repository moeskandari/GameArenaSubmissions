public class Level2 extends Level{

    public Level2(){

        super();

        //4 exterior walls
        ObjectParts[1]= new Rectangle(0.0,0.0,1280,20,"YELLOW",5);
        ObjectParts[2]= new Rectangle(0.0,700.0,1280,20,"YELLOW",5);
        ObjectParts[3]= new Rectangle(0.0,20.0,20,680,"YELLOW",5);
        ObjectParts[4]= new Rectangle(1260.0,20.0,20,680,"YELLOW",5);

        ObjectParts[5]= new Rectangle(320.0,20.0,20,250,"YELLOW",5);
        ObjectParts[6]= new Rectangle(20.0,320.0,250,20,"YELLOW",5);
        ObjectParts[7]= new Rectangle(100.0,100.0,100,100,"YELLOW",5);

        ObjectParts[8]= new Rectangle(320.0,370.0,20,250,"YELLOW",5);
        ObjectParts[9]= new Rectangle(100.0,495.0,220,20,"YELLOW",5);

        ObjectParts[10]= new Rectangle(500.0,150.0,20,20,"YELLOW",5);
        ObjectParts[11]= new Rectangle(500.0,270.0,20,20,"YELLOW",5);
        ObjectParts[12]= new Rectangle(500.0,390.0,20,20,"YELLOW",5);

        ObjectParts[13]= new Rectangle(440.0,495.0,600,20,"YELLOW",5);
        ObjectParts[14]= new Rectangle(850.0,150.0,200,200,"YELLOW",5);
    }
}