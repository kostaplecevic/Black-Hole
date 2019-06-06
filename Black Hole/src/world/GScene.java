/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package world;

import grafika.SpaceShip;
import grafika.Square;

import java.util.ArrayList;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
/**
 *
 * @author nebojsa
 */
public class GScene {

    Fire fire;
    Image sky;
    ArrayList<Anim> objects;

    public GScene() {
        objects = new ArrayList<>();
    }
    
    public void animateFire(double delta) {
        
    }

    public void init() {
        //fire = new Fire();
        sky = new Image("./res/space.jpg");
        objects.add(new Sun(0, 0, 0, 1.));
        objects.add(new Crnilo(0, 0, 0, 1.));
        objects.add(new Saturn(260, -260, 0, 1.));
        objects.add(new Merkur(0, 100, 0, 1.));
        objects.add(new Venera(95, 95, 0, 1.));
        objects.add(new Mars(-150, -150, 0, 1.));
        objects.add(new Jupiter(-200, 200, 0, 1.));
        objects.add(new Uran(310, 310, 0, 1.));
        objects.add(new Pluton(350, 350, 0, 1.));
        objects.add(new EarthandMoon());
        //objects.add(new Orbiter(150, 0, 0, 2, new Square()));
        objects.add(new Patrol(new SpaceShip()));
    }
    
    public void update(double delta) {
        //fire.update(delta);
        objects.stream().forEach((ob) -> {
            ob.update(delta);
        });
    }

    public void draw(GraphicsContext gc) {
        gc.drawImage(sky, 0, 0);
        //fire.draw(gc);
        objects.stream().forEach((ob) -> {
            ob.draw(gc);
        });
    }
}
