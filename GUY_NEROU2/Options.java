public class Options extends Menu
{

    private int buttonWidth = 300;
    private int buttonHeight = 100;
    Text back = new Text("BACK",60,1460,170,"WHITE");

    private Rectangle[] buttons = new Rectangle[2];
    //private int buttonParts = 2;

    public Options(GameArena arena)
    {

        buttons[0] = new Rectangle(1400, 100, buttonWidth,  buttonHeight,"#141414");
        buttons[1] = new Rectangle(1410, 110, 280,  80,"#3b3b3b");



        arena.addRectangle(buttons[0]);
        arena.addRectangle(buttons[1]);
        arena.addText(back);

    }


    public double getButtonPositionX()
    {
        double value;
        value = buttons[0].getXPosition();
        return value;
    }

    public double getButtonPositionY()
    {
        double value;
        value = buttons[0].getYPosition();
        return value;
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


    public void optionsScreen(GameArena arena)
    {
        arena.setBackgroundImage("controls2.png");
    }


    public void shiftObjectsOut()
    {
        buttons[0].setYPosition(buttons[0].getYPosition()+800);
        buttons[1].setYPosition(buttons[1].getYPosition()+800);
        back.setYPosition(back.getYPosition()+800);
    }

    public void shiftObjectsIn()
    {
        buttons[0].setYPosition(buttons[0].getYPosition()-800);
        buttons[1].setYPosition(buttons[1].getYPosition()-800);
        back.setYPosition(back.getYPosition()-800);
    }
}
