package game;

import java.util.*;

/**
 * Created by jzl on 16/4/4.
 */
public class Map {
    public static final int MAP_LENGTH = 60;
    public static String map =
            "◎◎◎◎◎◎◎新◎◎◎◎银◎◎◎◎◎券券◎◎\n"+
            "彩                     ◎\n"+
            "◎                     ◎\n"+
            "◎                     ◎\n"+
            "◎                     道\n"+
            "◎                     ◎\n"+
            "空                     ◎\n"+
            "卡                     ◎\n"+
            "券                     ◎\n"+
            "券券券券券券券券券券券券券券券券券券券券券券\n";

    private int height;
    private int width;
    private Collection<Cell> cells = new ArrayList<Cell>();

    public Map(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    public Cell getCell(int x, int y) {
        return cells.stream().filter(
            item -> (item.getX() == x && item.getY()==y)).findFirst().orElse(createCell(x, y));
    }

    private Cell createCell(int x, int y) {
        Cell c = new Cell(x,y);
        cells.add(c);
        return c;
    }
}
