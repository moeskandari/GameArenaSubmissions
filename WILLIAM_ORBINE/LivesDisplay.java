public class LivesDisplay{
    private Text livesTxt;
    public LivesDisplay(int noLives){
        String txtOut = "Lives: " + noLives;
        livesTxt = new Text(txtOut,25,850,100,"WHITE");
        

    
        
    }

    public void updateLives(int lives){
        //updating the number of lives that is displayed
        String txtOut = "Lives: " + lives;
        livesTxt.setText(txtOut);

    }

    public void addTo(GameArena arena){
        arena.addText(livesTxt);
    }

    public void gameOver(){
        livesTxt.setText("Game Over :[");
        livesTxt.setXPosition(400);
        livesTxt.setSize(50);
    }

    
}

