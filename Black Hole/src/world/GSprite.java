/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package world;

import grafika.Visual;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;

/**
 *
 * @author nebojsa
 */
public class GSprite implements Visual {

    Image img;

    public GSprite(String path) {
        img = new Image(path);
    }

    @Override
    public void draw(GraphicsContext gc, double x, double y, double angle, double scale) {
        double offx = img.getWidth() * scale / 2;
        double offy = img.getHeight() * scale / 2;
       
        //transformation is applies once the image is drawn, so transform params need to be chosen accordingly
        gc.save();
        Rotate r = new Rotate( -angle, World.WIDTH / 2 + x, World.HEIGHT / 2 - y);
        gc.setTransform(r.getMxx(), r.getMyx(), r.getMxy(), r.getMyy(), r.getTx(), r.getTy());
        gc.drawImage(img, World.WIDTH / 2 + (x - offx), World.HEIGHT / 2 + (-y - offy), offx * 2, offy * 2);
        gc.restore();
    }

}
