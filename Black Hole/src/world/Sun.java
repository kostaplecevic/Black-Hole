package world;

import grafika.Visual;
import javafx.scene.image.Image;

public class Sun extends Anim {
    
    double rotSpeed = - 1.;
    double tm = 0;

    public Sun(double xpos, double ypos, double angle, double scale) {
        super(xpos, ypos, angle, scale, new GSprite("./res/sun.png"));
    }

    @Override
    public void update(double delta) {
        tm += delta;
        coeff = (1920 - 192 * tm) / 1620; 
        angle += rotSpeed * delta;
        if (coeff <= 0.000001){
            System.exit(1);
        }
    }
    
}
