package game;

import object.*;

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

    public void dismissView(Visualizable view) {
        this.views.remove(view);
    }

    public char getView(int currentPlayer) {
//        return views.stream().map(item->item.toTexture()).findFirst().orElse('　');
        Iterator<Visualizable> iterator = views.iterator();
        if (views.size() == 1)
            return iterator.next().toTexture();

        char value = '\u3000';
        for (;iterator.hasNext();) {
            Visualizable view = iterator.next();
            if (view instanceof Player) {
                if (((Player)view).getNumber() == currentPlayer) {
                    //System.out.println(view.toTexture());
                    return ((Player)view).toTexture();
                }
                else
                    value = ((Player)view).toTexture();
            }
        }

        return value;
    }
}
