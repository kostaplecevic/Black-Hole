package world;

import grafika.Visual;

public class Pluton extends Anim {
    
    double rotSpeed = 40.;
    double cenralRotSpeed = 56;
    double tm = 0;

    public Pluton(double xpos, double ypos, double angle, double scale) {
        super(xpos, ypos, angle, scale, new GSprite("./res/pluto.png"));
    }

    @Override
    public void update(double delta) {
        tm += delta;
        coeff = (1920 - 192 * tm) / 1620; 
        angle += rotSpeed * delta;
        rotate(cenralRotSpeed * delta);
        if (coeff <= 0.000001){
            System.exit(1);
        }
    }
    
}
