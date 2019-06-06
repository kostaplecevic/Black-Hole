package world;

import grafika.Visual;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class EarthandMoon extends Anim {
    
    Visual moon;
    Visual earth;
    
    double crad = 170;
    double prad = 10;
    double cangle = 180;
    double pangle = 0;
    double moonangle = 0;
    double earthangle = 0;
    double crotSpeed = 18.5;
    double protSpeed = 23.;
    double earthRotSpeed = 42.;
    double moonRotSpeed = -55.;
    double tm = 0;
    double coefff = 0.9955;
    

    public EarthandMoon() {
        super(-200, 0, -180, .5, null);
        moon = new GSprite("./res/moon.png");
        earth = new GSprite("./res/earth.png");
        
    }

    @Override
    public void update(double delta) {
        cangle += crotSpeed * delta;
        pangle += protSpeed * delta;
        moonangle += moonRotSpeed * delta;
        earthangle += earthRotSpeed * delta;
        crad -= 0.38;
        coeff = (1920 - 192 * tm) / 1620;
        EarthandMoon.super.scale = scale * coefff;
    }
    
    public void draw(GraphicsContext gc) {
        double clustx = crad * Math.cos(Math.toRadians(cangle));
        double clusty = crad * Math.sin(Math.toRadians(cangle));
        
        double cx = clustx + prad * Math.cos(Math.toRadians(pangle));
        double cy = clusty + prad * Math.sin(Math.toRadians(pangle));
        double lx = clustx + prad * Math.cos(Math.toRadians(pangle + 180));
        double ly = clusty + prad * Math.sin(Math.toRadians(pangle + 180));
        moon.draw(gc, cx, cy, moonangle, scale);
        earth.draw(gc, lx, ly, earthangle, scale);
        
    }
}
