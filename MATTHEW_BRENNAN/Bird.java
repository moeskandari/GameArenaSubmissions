public class Bird {
    private int x; // 250
    private int y; // 150
    private int m_x = 0;
    private int m_y = 0;
    private int direction = 1;
    private Ball body_1 = new Ball(250, 150, 20, "BLUE", 5);
    private Rectangle body_2 = new Rectangle(240, 150, 20, 20, "BLUE", 5);
    private Rectangle nose = new Rectangle(253, 150, 10, 5, "ORANGE", 5);
    private Rectangle chest = new Rectangle(250, 160, 10, 10, "WHITE", 5);
    private Rectangle eye = new Rectangle(250, 145, 5, 5, "WHITE", 5);
    private Rectangle collision = new Rectangle(150, 150, 20, 20, "ALPHA", 1);
    private Rectangle floor_collision = new Rectangle(150, 150, 14, 5, "ALPHA", 1);
    private Rectangle left_collision = new Rectangle(150, 150, 5, 14, "ALPHA", 1);
    private Rectangle right_collision = new Rectangle(150, 150, 5, 14, "ALPHA", 1);
    private Rectangle top_collision = new Rectangle(150, 150, 14, 5, "ALPHA", 1);
    private int M_LOSS_V = 10;
    private int M_LOSS_H = 5;
    private double FRICTION = 0.25;
    private int deaths = -1;
    private Raycast r = new Raycast();

    // private Rectangle collision = new Rectangle(150, 150, 20, 20, "YELLOW", 1);
    // private Rectangle floor_collision = new Rectangle(150, 150, 14, 5, "MAGENTA",
    // 100);
    // private Rectangle left_collision = new Rectangle(150, 150, 5, 14, "MAGENTA",
    // 100);
    // private Rectangle right_collision = new Rectangle(150, 150, 5, 14, "MAGENTA",
    // 100);
    // private Rectangle top_collision = new Rectangle(150, 150, 14, 5, "MAGENTA",
    // 100);

    private Gun gun = new Gun(250, 150);

    public Bird(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // flips bird based on mouse position
    public void updateDirection(GameArena arena) {
        if (arena.getMousePositionX() < this.x) {
            this.direction = 1;
        } else {
            this.direction = 0;
        }
    }

    public void move(GameArena arena) {
        body_1.setXPosition(x);
        body_1.setYPosition(y);
        body_2.setXPosition(x - 10);
        body_2.setYPosition(y);
        nose.setXPosition(x + 3 - (this.direction * 15));
        nose.setYPosition(y);
        chest.setXPosition(x - (this.direction * 10));
        chest.setYPosition(y + 10);
        eye.setXPosition(x - 3 + (this.direction * 3));
        eye.setYPosition(y - 5);
        collision.setXPosition(x - 10);
        collision.setYPosition(y);
        floor_collision.setXPosition(x - 7);
        floor_collision.setYPosition(y + 15);
        left_collision.setXPosition(x - 10);
        left_collision.setYPosition(y + 3);
        right_collision.setXPosition(x + 5);
        right_collision.setYPosition(y + 3);
        top_collision.setXPosition(x - 7);
        top_collision.setYPosition(y - 5);
        gun.move(x, y, arena);
    }

    public void setHitboxPositions() {
        collision.setXPosition(x - 10);
        collision.setYPosition(y);
        floor_collision.setXPosition(x - 7);
        floor_collision.setYPosition(y + 15);
        left_collision.setXPosition(x - 10);
        left_collision.setYPosition(y + 3);
        right_collision.setXPosition(x + 5);
        right_collision.setYPosition(y + 3);
        top_collision.setXPosition(x - 7);
        top_collision.setYPosition(y - 5);
    }

    // physics things
    public void physics_process(Platform[] platforms) {
        // if going up
        if (m_y > 0) {
            // for each incremental movement. this stops the bird from getting stuck within
            // the block
            for (int i = 0; i < m_y; i++) {
                // if not colliding, increment position
                if (!isCollidingBelow(platforms)) {
                    y++;
                    setHitboxPositions();
                } else {
                    // if it is colliding
                    if (isCollidingBelow(platforms)) {
                        // update momentum
                        if (m_y - M_LOSS_V < 0) {
                            m_y = 0;
                        } else {
                            m_y = m_y - M_LOSS_V;
                        }
                        m_y = -m_y;
                    }
                }
            }
        }
        // same as previous but for going down.
        else {
            for (int i = 0; i > m_y; i--) {
                if (!isCollidingAbove(platforms)) {
                    y--;
                    setHitboxPositions();
                } else {
                    if (isCollidingAbove(platforms)) {
                        if (m_y + M_LOSS_V > 0) {
                            m_y = 0;
                        } else {
                            m_y = m_y + M_LOSS_V;
                        }
                        m_y = -m_y;
                    }
                }
            }
        }

        // if going right, basicvaly same logic as above, wont write duplicate comments
        if (m_x > 0) {
            for (int i = 0; i < m_x; i++) {
                if (!isCollidingRight(platforms)) {
                    x++;
                    setHitboxPositions();
                } else {
                    if (isCollidingSide(platforms)) {
                        if (m_x - M_LOSS_H < 0) {
                            m_x = 0;
                        } else {
                            m_x = m_x - M_LOSS_H;
                        }
                        m_x = -m_x;
                    }
                }
            }
        } else {
            for (int i = 0; i > m_x; i--) {
                if (!isCollidingLeft(platforms)) {
                    x--;
                    setHitboxPositions();
                } else {
                    if (isCollidingSide(platforms)) {
                        if (m_x + M_LOSS_H > 0) {
                            m_x = 0;
                        } else {
                            m_x = m_x + M_LOSS_H;
                        }
                        m_x = -m_x;
                    }
                }
            }
        }
        if (!isCollidingBelow(platforms)) {
            m_y++;
        }
        if (m_x > 0 && isCollidingBelow(platforms)) {
            m_x -= FRICTION;
        }
        if (m_x < 0 && isCollidingBelow(platforms)) {
            m_x += FRICTION;
        }
    }

    // checks all platforms and returns wether bird is coliding with any (main
    // hitbox).
    public boolean is_colliding(Platform[] platforms) {
        for (Platform i : platforms) {
            if (i.getPlatform().collides(collision)) {
                return true;
            }
        }
        return false;
    }

    // checks collision from the sides
    public boolean isCollidingSide(Platform[] platforms) {
        return isCollidingLeft(platforms) || isCollidingRight(platforms);
    }

    // checks collision from above
    public boolean isCollidingAbove(Platform[] platforms) {
        for (Platform i : platforms) {
            if (i.getPlatform().collides(top_collision)) {
                return true;
            }
        }
        return false;
    }

    // collsion detection (left)
    public boolean isCollidingLeft(Platform[] platforms) {
        for (Platform i : platforms) {
            if (i.getPlatform().collides(left_collision)) {
                return true;
            }
        }
        return false;
    }

    // collsion detection (right)
    public boolean isCollidingRight(Platform[] platforms) {
        for (Platform i : platforms) {
            if (i.getPlatform().collides(right_collision)) {
                return true;
            }
        }
        return false;
    }

    // collsion detection (below)
    public boolean isCollidingBelow(Platform[] platforms) {
        for (Platform i : platforms) {
            if (i.getPlatform().collides(floor_collision)) {
                return true;
            }
        }
        return false;
    }

    public Gun getGun() {
        return this.gun;
    }

    public double getMomentumX(GameArena arena) {
        return Math.cos(getAngle(arena));
    }

    public double getMomentumY(GameArena arena) {
        return Math.sin(getAngle(arena));
    }

    public double getAngle(GameArena arena) {
        return Math.atan2(arena.getMousePositionY() - this.y, arena.getMousePositionX() - this.x);
    }

    public void setMomentum(int m_x, int m_y) {
        this.m_x = this.m_x + m_x;
        this.m_y = this.m_y + m_y;
    }

    public void setMomentumZero() {
        this.m_x = 0;
        this.m_y = 0;
    }

    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Rectangle getCollision() {
        return collision;
    }

    public void die() {
        deaths++;
    }

    public int getDeaths() {
        return deaths;
    }

    public Raycast getRaycast() {
        return r;
    }

    public void addTo(GameArena arena) {
        arena.addBall(body_1);
        arena.addRectangle(body_2);
        arena.addRectangle(nose);
        arena.addRectangle(chest);
        arena.addRectangle(eye);
        arena.addRectangle(collision);
        arena.addRectangle(floor_collision);
        arena.addRectangle(left_collision);
        arena.addRectangle(right_collision);
        arena.addRectangle(top_collision);
        gun.display(arena);
    }
}
