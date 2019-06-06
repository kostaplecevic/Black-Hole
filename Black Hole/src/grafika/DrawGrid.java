package grafika;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import static java.lang.Math.abs;
import javax.swing.JFrame;
import javax.swing.JPanel;

class Grid extends JPanel implements MouseMotionListener {
    
    public static int WIDTH = 640;
    public static int HEIGHT = 480;

    private boolean[][] grid;
    int rows, columns;
    int pixw, pixh;
    int xoff, yoff;

    Grid(int r, int c) {
        grid = new boolean[c][r];
        setSize(WIDTH, HEIGHT);
        rows = r;
        columns = c;
        pixw = WIDTH / columns;
        pixh = HEIGHT / rows;
        xoff = columns / 2;
        yoff = rows / 2;
        super.addMouseMotionListener((MouseMotionListener) this);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(WIDTH, HEIGHT);
    }

    @Override
    public Dimension getMinimumSize() {
        return getPreferredSize();
    }

    @Override
    public Dimension getMaximumSize() {
        return getPreferredSize();
    }
    
    private void drawGrid(Graphics g) {
        g.setColor(Color.BLACK);
        int k;
        for (k = 0; k < rows; k++) {
            g.drawLine(0, k * pixh, WIDTH, k * pixh);
        }

        for (k = 0; k < columns; k++) {
            g.drawLine(k * pixw, 0, k * pixw, HEIGHT);
        }
    }
    
    private void drawAxes(Graphics g) {
        g.setColor(Color.GRAY);

        g.drawLine(0, (HEIGHT + pixh) / 2, WIDTH, (HEIGHT + pixh) / 2);
        g.drawLine((WIDTH + pixw) / 2, 0, (WIDTH + pixw) / 2, HEIGHT);
    }

    public void paint(Graphics g) {
        super.paintComponent(g);
        
//        drawGrid(g);
        drawAxes(g);

        g.setColor(Color.BLACK);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j]) {
                    g.fillRect(i * pixw, j * pixh, pixw, pixh);
                }
            }
        }
    }

    private Point mouseToPixel(Point m) {
        Point p = new Point(0, 0);
        p.x = m.x / pixw - xoff;
        p.y = yoff - m.y / pixh;
        return p;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        Point p = mouseToPixel(e.getPoint());
        Component r, c = getParent();
        while( (r = c.getParent()) != null )
        {
            c = r;
        }
               
        ((JFrame)c).setTitle(p.x + ", " + p.y);
    }
    
    public void clear() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                grid[i][j] = false;
            }
        }
    }

    public void setPixel(int x, int y, boolean set) {
        x = xoff + x;
        y = yoff - y;
        if(x >= 0 && x < columns && y >= 0 && y < rows) {
            grid[x][y] = set;
        }
    }

    public void setPixel(Point m, boolean set) {
        setPixel(m.x, m.y, set);
    }
}

public class DrawGrid extends JFrame {

    private Grid grid;

    DrawGrid(int columns, int rows) {
        grid = new Grid(rows, columns);
    }

    public void init() {
        setTitle("edugrid");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(grid);
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
    }
    
    public void clear() {
        grid.clear();
    }

    public void setPixel(int x, int y, boolean set) {
        grid.setPixel(x, y, set);
    }

    public void drawLine(Point p1, Point p2, boolean set) {
        drawLine(p1.x, p1.y, p2.x, p2.y, set);
    }
    
    public void drawLine(int x1, int y1, int x2, int y2, boolean set) {
        int dx = x2 - x1;
        int dy = y2 - y1;
        int step = 1;
        int span = 0;
        boolean useX = true;
        
        if(abs(dx) >= abs(dy)) {
            span = abs(dx);
            step = dx / span;
        } else {
            useX = false;
            span = abs(dy);
            step = dy / span;
        }
        
        double x;
        double y;
        for (int i = 0; i <= span; i++) {
            int s = step * i;
            if (useX) {
                x = x1 + s;
                y = y1 + s * dy / dx;
            } else {
                y = y1 + s;
                x = (double) s * dx / dy + x1 ;
            }
            setPixel((int) x, (int) y, set);
        }
    }
}
