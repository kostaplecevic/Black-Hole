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
public class Patrol extends Anim {

    public static final double pangle = 36.869897646;
    
    double rotSpeed = 50.;
    double speedx = 64;
    double speedy = 48;
    double xrange = 304;
    double yrange = 228;
    int state = 0;

    public Patrol(Visual object) {
        super(0, 0, pangle, 1, object);
    }

    private boolean updateRot(double delta, double desired) {
        if (angle >= desired) {
            angle -= rotSpeed * delta;
            if(angle <= desired) {
                angle = desired;
                return true;
            }
        } else {
            angle += rotSpeed * delta;
            if(angle >= desired) {
                angle = desired;
                return true;
            }
        }
        return false;
    }

    @Override
    public void update(double delta) {
        switch (state) {
            case 0:
                xpos += speedx * delta;
                ypos += speedy * delta;
                if (xpos >= xrange || ypos >= yrange) {
                    xpos = xrange;
                    ypos = yrange;
                    state = 1;
                }
                break;
            case 1:
                if (updateRot(delta, -90)) {
                    state = 2;
                }
                break;
            case 2:
                ypos -= speedy * delta;
                if (ypos <= -yrange) {
                    ypos = -yrange;
                    state = 3;
                }
                break;
            case 3:
                if (updateRot(delta, 180 - pangle)) {
                    state = 4;
                }
                break;
            case 4:
                xpos -= speedx * delta;
                ypos += speedy * delta;
                if (xpos <= -xrange || ypos >= yrange) {
                    xpos = -xrange;
                    ypos = yrange;
                    state = 5;
                }
                break;
            case 5:
                if (updateRot(delta, -90)) {
                    state = 6;
                }
                break;
            case 6:
                ypos -= speedy * delta;
                if (ypos <= -yrange) {
                    state = 7;
                }
                break;
            case 7:
                if (updateRot(delta, pangle)) {
                    state = 0;
                }
                break;
        }
    }

}
