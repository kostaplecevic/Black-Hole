package world;

import grafika.Visual;

public class Jupiter extends Anim {
    
    double rotSpeed = 40.;
    double cenralRotSpeed = 7.7;

    public Jupiter(double xpos, double ypos, double angle, double scale) {
        super(xpos, ypos, angle, scale, new GSprite("./res/jupiter.png"));
    }

    @Override
    public void update(double delta) {
        angle += rotSpeed * delta;
        rotate(cenralRotSpeed * delta);
    }
    
}
