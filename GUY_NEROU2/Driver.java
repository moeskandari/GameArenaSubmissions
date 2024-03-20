public class Driver 
{
    public static void main(String[] args) {
        
    
    GameArena arena = new GameArena(1800, 800);
    Menu mainMenu = new Menu();
    Bout match = new Bout(arena);

    mainMenu.setBackGround(arena);
    mainMenu.addTo(arena);

    Options controlMenu = new Options(arena);
    //mainMenu.shiftObjectsOut();
    controlMenu.shiftObjectsOut();



    //TODO: move menu loop into its own method and do the same to options so that i can just run them until game played



    while (true) 
    {
        if(arena.leftMousePressed())
        {
            //System.out.println("clicked");
            if(mainMenu.withinButtonBound(arena.getMousePositionX(), arena.getMousePositionY(), mainMenu.getButtonPositionX("PLAY"), mainMenu.getButtonPositionY("PLAY")))
            {
                mainMenu.shiftObjectsOut();
                match.play(arena);
                break;
            }

            else if(mainMenu.withinButtonBound(arena.getMousePositionX(), arena.getMousePositionY(), mainMenu.getButtonPositionX("SETTINGS"), mainMenu.getButtonPositionY("SETTINGS")))
            {
                controlMenu.optionsScreen(arena);
                mainMenu.shiftObjectsOut();
                controlMenu.shiftObjectsIn();
            }

            else if(mainMenu.withinButtonBound(arena.getMousePositionX(), arena.getMousePositionY(), controlMenu.getButtonPositionX(), controlMenu.getButtonPositionY()))
            {
                controlMenu.shiftObjectsOut();
                arena.setBackgroundImage("MainMenu.png");
                mainMenu.shiftObjectsIn();
            }

            
            else
            {
                System.out.println("no button found");
            }
        }

        


        arena.pause();
    }
    
    }

}
