public class carGame {

    public static void main(String[] args)
    {
        GameArena arena = new GameArena(500, 300);
        Ball b = new Ball(250, 150, 50, "BLUE");

        arena.addBall(b);

        while (true) {
            arena.pause();
        }
    }
    
}
