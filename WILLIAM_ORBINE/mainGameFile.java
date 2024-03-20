public class mainGameFile {
    


    public static void main(String[] args)
    {   
        int lives = 3;
        int noLevels = 0;
        GameArena arena = new GameArena(1000, 1000);
        
        
        
        //Add levels here, the game will move on to  the next level if one is completed
        // must update the lives before moving on the next

        
        int lev1GrPosSize[][] = {{0,200,0,200,0},{975,800,625,450,257},{800,800,800,800,800}};
        Level level1 = new Level(5,arena,lev1GrPosSize,130,100,700,900,50,256,1000,lives,false);
        lives = level1.getPlayer().getLives();
        noLevels++;

        int lev2GrPosSize[][] = {{0,600,0,200,0,350},{975,800,625,450,200,250},{600,400,800,800,200,300}};
        Level level2 = new Level(6,arena,lev2GrPosSize,950,100,300,700,25,200,1000,lives,true);
        lives = level2.getPlayer().getLives();
        noLevels ++;

        //Winner screen basically
        int score = (300 - (lives *10))*noLevels; 
        String vicText = "You Won, Score: " + score +"!";
        Text winTxt = new Text(vicText,75,100,500,"WHITE");
        arena.addText(winTxt);
        String colourArray[] = {"BLUE", "CYAN", "DARKGREY", "GREY", "GREEN", "LIGHTGREY", "MAGENTA", "ORANGE", "PINK", "RED", "WHITE", "YELLOW"};
        int index = 0;
        while(true){
            if(index == 12){
                index =  0;
            }
            winTxt.setColour(colourArray[index]);
            index++;
            arena.pause(50);
            
        }
        
        //arbitrary value that will act as the gravity modifier 
        
           
    }


        
}
