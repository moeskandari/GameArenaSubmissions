
public class Player
{
    private Rectangle[] rectangleParts;
    private Line[] lineParts;
    private Rectangle base;
    
    //shapes to make model
    public Player(double x, double y)
    {
        this.rectangleParts = new Rectangle[]{
            new Rectangle(x-25, y-25, 25, 50, "grey",3),
            new Rectangle(x-20, y-27, 15, 25, "cyan",4),
            new Rectangle(x-42, y+6, 60, 20, "GREY",3),
            new Rectangle(x-22, y+11, 20, 20, "darkgrey",2),
        };

        this.lineParts = new Line[]{
            new Line(x-24, y-24, x-12, y-50, 3, "GREY",0),
            new Line(x-1, y-24, x-12, y-50, 3, "GREY",0),
            new Line(x-21, y-24, x-12, y-50, 4, "GREY",0),
            new Line(x-18, y-24, x-12, y-48, 4, "GREY",0),
            new Line(x-15, y-24, x-12, y-48, 4, "GREY",0),
            new Line(x-12, y-24, x-12, y-48, 4, "GREY",0),
            new Line(x-9, y-24, x-12, y-48, 4, "GREY",0),
            new Line(x-6, y-24, x-12, y-48, 4, "GREY",0),
            new Line(x-3, y-24, x-12, y-48, 4, "GREY",0),
            new Line(x-39, y+6, x-39, y-15, 5, "grey",0),
            new Line(x+15, y+6, x+15, y-15, 5, "grey",0),
            new Line(x-39, y-12, x-39, y-15, 5, "red",1),
            new Line(x+15, y-12, x+15, y-15, 5, "red",1),

            new Line(x-17, y+30, x-12, y+55, 5, "yellow",0),
            new Line(x-6, y+30, x-12, y+55, 5, "yellow",0),
            new Line(x-15, y+30, x-12, y+52, 4, "#e29a16",1),
            new Line(x-8 , y+30, x-12, y+52, 4, "#e29a16",1),
            new Line(x-12 , y+30, x-12, y+47, 3, "red",1),
        };

            base = new Rectangle(x-40, y-25, 55 , 50, "BLACK",0);
    }


    public void addTo(GameArena arena)
    {
        arena.addRectangle(base);
        for (Rectangle part : rectangleParts)
            arena.addRectangle(part);
        
        for (Line part : lineParts)
            arena.addLine(part);
    }
    

    public void move(char key)
    {   
        int travelSpeed = 6;
        switch (key)
        { 
            case 'a':
                //base
                base.setXPosition(base.getXPosition() - travelSpeed);
                if (base.getXPosition() < 10)
                    base.setXPosition(base.getXPosition()+travelSpeed);

                //rectangle parts
                for (Rectangle part: rectangleParts){
                    part.setXPosition(part.getXPosition() - travelSpeed);
                    if (part.getXPosition() < 7)   //check if it hit the edge
                        for (Rectangle partWall : rectangleParts)
                            partWall.setXPosition(partWall.getXPosition()+travelSpeed);
                } 
                
                //line parts
                for (Line part: lineParts){
                    part.setLinePosition(part.getXStart() - travelSpeed, part.getYStart(),part.getXEnd() - travelSpeed, part.getYEnd());
                    if (part.getXStart() < 10)   //check if it hit the edge
                        for (Line partWall : lineParts)
                            partWall.setLinePosition(partWall.getXStart()+travelSpeed, partWall.getYStart(), partWall.getXEnd()+travelSpeed, partWall.getYEnd());
                }
                break;

            case 'd':
                //base
                base.setXPosition(base.getXPosition() + travelSpeed);
                if (base.getXPosition() > 435)
                    base.setXPosition(base.getXPosition()-travelSpeed);

                //rectangle parts
                for (Rectangle part: rectangleParts){
                    part.setXPosition(part.getXPosition() + travelSpeed);
                    if (part.getXPosition() > 455)   //check if it hit the edge
                        for (Rectangle partWall : rectangleParts)
                            partWall.setXPosition(partWall.getXPosition()-travelSpeed);
                    }

                //line parts
                for (Line part: lineParts){
                    part.setLinePosition(part.getXStart()+travelSpeed, part.getYStart(),part.getXEnd()+travelSpeed, part.getYEnd());
                    if (part.getXStart() > 490)   //check if it hit the edge
                        for (Line partWall : lineParts)
                            partWall.setLinePosition(partWall.getXStart()-travelSpeed, partWall.getYStart(), partWall.getXEnd()-travelSpeed, partWall.getYEnd());
                } 
                break; 
        }   
    }

    public boolean checkCollision (Meteor meteor)
    {
        Rectangle meteorHitbox = meteor.hitbox();

        //check conditions
        if (base.collides(meteorHitbox))
            return true;
        else
            return false;

    }

    public void flyIn(int timer)
    {
        if(timer < 75){ 
            base.move(0, -2);
            for (Line part: lineParts)
                part.setLinePosition(part.getXStart(), part.getYStart() - 2, part.getXEnd(), part.getYEnd() -2);
            
            for (Rectangle part: rectangleParts)
                part.move(0, -2);
        }
    }
}
