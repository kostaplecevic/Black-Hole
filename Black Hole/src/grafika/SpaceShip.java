/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafika;

import java.awt.geom.Point2D;

/**
 *
 * @author nebojsa
 */
public class SpaceShip extends Composite {

    public SpaceShip() {
        Triangle t1 = new Triangle(new Point2D.Double(0, -7), new Point2D.Double(0, 7), new Point2D.Double(20, 0));
        Triangle t2 = new Triangle(new Point2D.Double(0, -7), new Point2D.Double(0, 7), new Point2D.Double(-4, 0));
        super.addTriangle(t1);
        super.addTriangle(t2);
    }
    
}
