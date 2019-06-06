/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafika;

import java.io.Serializable;
import java.util.ArrayList;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import world.World;

/**
 *
 * @author nebojsa
 */
public class Composite implements Visual, Serializable {

    ArrayList<Triangle> triangles;

    public Composite() {
        triangles = new ArrayList<>();
    }

    public Composite(ArrayList<Triangle> tr) {
        triangles = (ArrayList<Triangle>) tr.clone();
    }

    public void addTriangle(Triangle t) {
        triangles.add(t);
    }

    public void draw(GraphicsContext gc, double x, double y, double angle, double scale) {
        gc.setStroke(Color.WHITE);
        gc.setLineWidth(1);
        triangles.stream().forEach((t) -> {
            Triangle c = (Triangle) t.clone();
            c.scale(scale, scale);
            c.rotate(angle);
            c.translate(x, y);
            c.transform(World.WIDTH / 2, World.HEIGHT / 2);
            c.draw(gc);
        });
    }

    public void draw(DrawGrid g) {
        triangles.stream().forEach((t) -> {
            t.draw(g);
        });
    }

    public void translate(double x, double y) {
        triangles.stream().forEach((t) -> {
            t.translate(x, y);
        });
    }

    public void transform(int x, int y) {
        triangles.stream().forEach((t) -> {
            t.transform(x, y);
        });
    }

    public void rotate(double teta) {
        triangles.stream().forEach((t) -> {
            t.rotate(teta);
        });
    }

    public void scale(double sx, double sy) {
        triangles.stream().forEach((t) -> {
            t.scale(sx, sy);
        });
    }

}
