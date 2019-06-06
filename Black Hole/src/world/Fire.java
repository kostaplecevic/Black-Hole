/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package world;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 *
 * @author nebojsa
 */
public class Fire {
    Image fire;
    int states = 8;
    int state = 0;
    double dleft = 0;
    double period = 0.08;

    public Fire() {
        fire = new Image("./res/fire.png");
    }
    
    public void update(double delta) {
        int adv = (int) ((delta + dleft) / period);
        dleft = (delta + dleft) % period;
        state += adv;
        state &= 7;
//        if(state >= states) {
//            state -= states;
//        }
    }
    
    public void draw(GraphicsContext gc) {
        gc.drawImage(fire, state * 50, 0, 50, 138, 580, 340, 50, 138);
    }
    
}
