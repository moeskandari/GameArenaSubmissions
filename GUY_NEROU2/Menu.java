public class Menu 
{
    private Rectangle[] buttons = new Rectangle[4];
    private int buttonParts = 4;

    private Text[] text = new Text[2];
    private int texts = 2;

    private int buttonWidth = 300;
    private int buttonHeight = 100;
    

    public Menu()
    {
        buttons[0] = new Rectangle(950, 480, buttonWidth,  buttonHeight,"#141414");
        buttons[1] = new Rectangle(950, 630, buttonWidth,  buttonHeight,"#141414");
        buttons[2] = new Rectangle(960, 490, 280,  80,"#3b3b3b");
        buttons[3] = new Rectangle(960, 640, 280,  80,"#3b3b3b");

        text[0] = new Text("PLAY", 60, 960, 550, "White");
        text[1] = new Text("CONTROLS", 45, 962, 700, "White");

    }


    public void addTo(GameArena arena)
    {
        for(int i = 0; i<buttonParts;i++)
        {
            arena.addRectangle(buttons[i]);
        }

        for(int i = 0; i<texts;i++)
        {
            arena.addText(text[i]);
        }
    }

    public void setBackGround(GameArena arena)
    {
        arena.setBackgroundImage("MainMenu.png");
    }

    public double getButtonPositionX(String name)
    {
        double value;
        if(name == "PLAY")
        {
            value = buttons[0].getXPosition();
            return value;
        }
        else if(name == "SETTINGS")
        {
            value = buttons[1].getXPosition();
            return value;
        }
        return -1;
    }


    public double getButtonPositionY(String name)
    {
        double value;
        if(name == "PLAY")
        {
            value = buttons[0].getYPosition();
            return value;
        }
        else if(name == "SETTINGS")
        {
            value = buttons[1].getYPosition();
            return value;
        }
        return -1;
    }


    public boolean withinButtonBound(double mousePositionX, double mousePositionY, double ButtonPositionX, double ButtonPositionY)
    {
        if(mousePositionX >= ButtonPositionX && mousePositionX <= (ButtonPositionX+buttonWidth))
        {
            if(mousePositionY >= ButtonPositionY && mousePositionY <= (ButtonPositionY+buttonHeight))
            {
                return true;
            }
        }
        return false;
    }

    public void shiftObjectsOut()
    {
        for(int i=0; i< buttonParts;i++)
        {
            buttons[i].setYPosition(buttons[i].getYPosition()+800);
        }
        text[0].setYPosition(text[0].getYPosition()+800);
        text[1].setYPosition(text[1].getYPosition()+800);
    }

    public void shiftObjectsIn()
    {
        for(int i=0; i< buttonParts;i++)
        {
            buttons[i].setYPosition(buttons[i].getYPosition()-800);
        }
        text[0].setYPosition(text[0].getYPosition()-800);
        text[1].setYPosition(text[1].getYPosition()-800);
    }

}   

