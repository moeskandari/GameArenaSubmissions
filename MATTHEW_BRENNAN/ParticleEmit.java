import java.util.ArrayList;

public class ParticleEmit {
    private ArrayList<Particle> pList = new ArrayList<>();

    public ParticleEmit() {

    }

    public void init(int b_x, int b_y, int dist, double angle, GameArena gameArena) {
        for (int i = 0; i < 5; i++) {
            double n_angle = (angle - 0.25) + (i * 0.125);
            pList.add(new Particle(b_x, b_y, (int) (dist * Math.cos(n_angle)), (int) (dist * Math.sin(n_angle)), 40));
        }
    }

    public void addTo(GameArena gameArena) {
        for (Particle i : pList) {
            i.addTo(gameArena);
        }
    }

    public void physics_process(GameArena gameArena) {
        //for all particles
        for (int i = 0; i < pList.size(); i++) {
            Particle p = pList.get(i);
            if (p != null) {
                p.physics_process();
                //if deathCount at zero we delete the particle.
                if (p.getDeaths() < 0) {
                    gameArena.removeRectangle(p.getRect());
                    pList.remove(p);
                }
            }
        }
    }
}
