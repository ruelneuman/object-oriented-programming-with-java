/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movingfigure;

import java.awt.Graphics;
import java.util.ArrayList;

public class CompoundFigure extends Figure {

    private ArrayList<Figure> figures = new ArrayList<Figure>();
    
    public CompoundFigure() {
        super(0, 0);
    }

    public void add(Figure f) {
        figures.add(f);
    }
    
    @Override
    public void move(int dx, int dy) {
        for (Figure f : figures) {
            f.move(dx, dy);
        }
    }
    
    @Override
    public void draw(Graphics graphics) {
        for (Figure f : figures) {
            f.draw(graphics);
        }
    }
    
}
