public class Level1 extends Level{

    public Level1(){

        super();
        //walls
        ObjectParts[1]= new Rectangle(0.0,0.0,250,250,"YELLOW",5);
        ObjectParts[2]=new Rectangle(1030.0,0.0,250,250,"YELLOW",5);
        ObjectParts[3]=new Rectangle(250.0,0.0,780,50,"YELLOW",5);
        ObjectParts[4]=new Rectangle(0.0,350.0,50,430,"YELLOW",5);
        ObjectParts[5]=new Rectangle(200.0,350.0,50,50,"YELLOW",5);
        ObjectParts[15]=new Rectangle(200.0,550.0,50,50,"YELLOW",5);
        ObjectParts[6]=new Rectangle(50.0,670.0,490,50,"YELLOW",5);
        ObjectParts[7]=new Rectangle(640.0,670.0,590,50,"YELLOW",5);
        ObjectParts[8]=new Rectangle(1030.0,670.0,50,250,"YELLOW",5);
        ObjectParts[9]=new Rectangle(1230.0,350.0,50,430,"YELLOW",5);
        ObjectParts[10]=new Rectangle(150.0,670.0,200,50,"YELLOW",5);
        //doors
        ObjectParts[11]=new Rectangle(0.0,250.0,50,100,"WHITE",5);
        ObjectParts[12]=new Rectangle(1230.0,250.0,50,100,"WHITE",5);
        ObjectParts[13]=new Rectangle(540.0,670.0,100,50,"WHITE",5);
        //morewalls
        ObjectParts[14]=new Rectangle(500.0,250.0,100,250,"YELLoW",5);
        //15 is above
        ObjectParts[16]=new Rectangle(1030.0,250.0,50,230,"YELLOW",5);
        //ObjectParts[16]=new Rectangle(540.0,695.0,100,25,"WHITE",5);

    }
}