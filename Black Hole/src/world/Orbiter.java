/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package world;

import grafika.Visual;

/**
 *
 * @author nebojsa
 */
public class Orbiter extends Anim {
    
    double rotSpeed = 30.;
    double cenralRotSpeed = 5.4;

    public Orbiter(double xpos, double ypos, double angle, double scale, Visual object) {
        super(xpos, ypos, angle, scale, object);
    }

    @Override
    public void update(double delta) {
        angle += rotSpeed * delta;
        rotate(cenralRotSpeed * delta);
    }
    
}
