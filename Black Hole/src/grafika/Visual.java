/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafika;

import javafx.scene.canvas.GraphicsContext;

/**
 *
 * @author nebojsa
 */
public interface Visual {
    public void draw(GraphicsContext gc, double x, double y, double teta, double scale);
}
