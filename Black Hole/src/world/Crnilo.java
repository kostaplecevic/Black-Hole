package world;

import grafika.Visual;
import javafx.scene.image.Image;

public class Crnilo extends Anim {
    
    double rotSpeed = - 2.;
    //double coeff = 1.5;
    double tm = 5;

    public Crnilo(double xpos, double ypos, double angle, double scale) {
        super(xpos, ypos, angle, scale, new GSprite("./res/blackhole.png"));
    }

    @Override
    public void update(double delta) {
        //coeff += 0.1;
        tm -= delta;
        coeff = (1920 + 192 * tm) / 6000; 
        scale(coeff);
        System.out.println(coeff);
    }
    
}
