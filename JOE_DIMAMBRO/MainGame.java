public class MainGame
{

    public static void main(String[]args)
    {
        //change this value to change resolution, resolution should divide by 1800 cleanly or it will look weird
        int rayResolution=300;
        

        GameArena playerDisplay = new GameArena(1920, 1080); 
        GameArena model = new GameArena(1280,720);

        PlayerDisplayManager playerView= new PlayerDisplayManager(rayResolution);
        TileGrid currentAreaManager = new TileGrid(model);
        
        playerView.addTo(playerDisplay);
        Rectangle floor = new Rectangle(60, 400, 1800, 350, "GREEN",1);
        playerDisplay.addRectangle(floor);
        

        Player player=new Player(1130.0, 300.0);//adds player to the screen
        player.addTo(model);

        //Entity enemy=new Entity(400.0, 100.0, "En");//adds enemy to the screen
        //enemy.addTo(model);

        //Ball b = new Ball(250,150,20,"GREEN");//reference that screen is loading correctly
        //model.addBall(b);


        double angleFacing=1.6;
        int speed=2;
        double xVelocity=0,yVelocity=speed;

        Rectangle[] displayWalls = playerView.getDisplayWalls();

        Rectangle[] collisionList = currentAreaManager.getCurrentLevel().getCollision(null, null);
        
        while(true)
        {
            model.pause();

            //changes the angle the player moves forwards in
            if(model.letterPressed('j')==true){
                angleFacing+=0.05;
                xVelocity=speed*Math.cos(angleFacing);
                yVelocity=speed*Math.sin(angleFacing);
                player.changeOrbitalPos(-angleFacing);
                
            }
            if(model.letterPressed('k')==true){
                angleFacing-=0.05;
                xVelocity=speed*Math.cos(angleFacing);
                yVelocity=speed*Math.sin(angleFacing);
                player.changeOrbitalPos(-angleFacing);
            }
            
            //moves the player in whatever direction arrow key is pressed
            player.resetDirection();
            if (model.letterPressed('w')==true){
                player.changeDirection(xVelocity,-yVelocity);
            }
            if (model.letterPressed('s')==true){
                player.changeDirection(-xVelocity,yVelocity);
            }
            if (model.letterPressed('a')==true){
                player.changeDirection(-yVelocity,-xVelocity);
            }
            if (model.letterPressed('d')==true){
                player.changeDirection(yVelocity,xVelocity);
            }
            player.move(collisionList);

            if(model.spacePressed()==true){
                speed=10;
            }

            int i=0;
            Double[] wallheight = player.rayTrace(-angleFacing,rayResolution,collisionList);
            String[] WallColours=player.getColours();
            for (Rectangle r : displayWalls) {
                Double height = wallheight[i];
                r.setHeight(height);
                r.setYPosition(400-height/2);    
                r.setColour(WallColours[i]);
                i++;
            }
                
            
            
        }
    }
}   
