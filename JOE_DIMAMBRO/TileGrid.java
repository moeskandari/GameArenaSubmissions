public class TileGrid//it's actually the world and manages collision and level loading
{
    private Level[] levelArray= {new Level1()};//for now change the object name to change level ATM there is only level 1 and 2. these are for testing
    private Level currentLevel;

    //constructor loads the first level
    public TileGrid(GameArena arena){
        currentLevel=levelArray[0];
        currentLevel.addTo(arena);
    }

    //returns current level object
    public Level getCurrentLevel(){
        return currentLevel;
    }

    public void changeLevel(GameArena arena){
        //clear level
        currentLevel.RemoveFrom(arena);

        //change what current level is equal to

        //add current level to arena
        currentLevel.addTo(arena);
        
    }


}