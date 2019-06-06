package grafika;

import java.awt.Point;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Grafika {

    public static void main(String[] args) throws InterruptedException, IOException, ClassNotFoundException {
       
        DrawGrid grid = new DrawGrid(80, 60);
        grid.init();
        grid.setVisible(true);

//        Triangle t1 = new Triangle(new Point(-10, 10), new Point(-10, -10), new Point(10, 10));
//        t1.draw(grid);

        //drawing code here...
//        Triangle t1 = new Triangle(new Point(-10, 10), new Point(-10, -10), new Point(10, 10));
//        Triangle t2 = new Triangle(new Point(10, -10), new Point(-10, -10), new Point(10, 10));
//        Composite c = new Composite();
//        c.addTriangle(t1);
//        c.addTriangle(t2);
//        c.draw(grid);

//        Square s = new Square();
//        Square s1 = new Square();
//        Square s2 = new Square();
//        s2.scale(0.5, 2);
//        s2.rotate(30);
//        
//        
//        
//        s.translate(-20, -20);
//        s1.translate(20, -20);
//        s2.translate(0, 20);
        
        
//        s.translate(15, 15);
//        s.rotate(30);
//        s.draw(grid);
//        s1.draw(grid);
//        s2.draw(grid);
//        
//        
//        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("objekat.ser"));
//        out.writeObject(s);
        
//        ObjectInputStream in = new ObjectInputStream(new FileInputStream("objekat.ser"));
//        s = (Square) in.readObject();
//        s.translate(10, 10);
//        s.scale(0.5, 0.5);
//        s.draw(grid);
  
//        TestTriangle t = new TestTriangle();
//        t.draw(grid);
        
        SpaceShip sh = new SpaceShip();
        sh.scale(2, 2);
        sh.rotate(45);
        sh.translate(-5, -5);
        sh.draw(grid);

//        for(int i = 0; i < 100; i++) {
//            Thread.sleep(3000);
//            grid.clear();
//
//            s.translate(-i, -i);
//            s.draw(grid);
//            grid.repaint();
//        }
    }

}
