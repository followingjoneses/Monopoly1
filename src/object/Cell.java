package object;

import java.util.*;

/**
 * Created by jzl on 16/4/6.
 */
public class Cell {
    private int x, y;
    private Collection<Visualizable> views = new ArrayList<Visualizable>();

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void addView(Visualizable view) {
        this.views.add(view);
    }
}
