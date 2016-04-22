package game;

import object.*;

import java.io.*;
import java.util.*;

/**
 * Created by jzl on 16/4/4.
 */
public class Map {
    public static final int MAP_LENGTH = 60, MAP_HEIGHT = 10, MAP_WIDTH = 22;
//    public static final String INITIAL_MAP =
//            "◎◎◎◎◎◎◎新◎◎◎◎银◎◎◎◎◎券券◎◎\n"+
//            "彩　　　　　　　　　　　　　　　　　　　　◎\n"+
//            "◎　　　　　　　　　　　　　　　　　　　　◎\n"+
//            "◎　　　　　　　　　　　　　　　　　　　　◎\n"+
//            "◎　　　　　　　　　　　　　　　　　　　　道\n"+
//            "◎　　　　　　　　　　　　　　　　　　　　◎\n"+
//            "空　　　　　　　　　　　　　　　　　　　　◎\n"+
//            "卡　　　　　　　　　　　　　　　　　　　　◎\n"+
//            "券　　　　　　　　　　　　　　　　　　　　◎\n"+
//            "券券券券券券券券券券券券券券券券券券券券券券\n";
    public static final char[][] INITIAL_MAP = {
        {'◎', '◎', '◎', '◎', '◎', '◎', '◎', '新', '◎', '◎', '◎', '◎', '银', '◎', '◎', '◎', '◎', '◎', '券', '券', '◎', '◎'},
        {'彩', '　', '　',  '　',  '　',  '　',  '　',  '　',  '　',  '　',  '　',  '　',  '　',  '　',  '　',  '　',  '　',  '　',  '　',  '　',  '　', '◎'},
        {'◎', '　', '　',  '　',  '　',  '　',  '　',  '　',  '　',  '　',  '　',  '　',  '　',  '　',  '　',  '　',  '　',  '　',  '　',  '　',  '　', '◎'},
        {'◎', '　', '　',  '　',  '　',  '　',  '　',  '　',  '　',  '　',  '　',  '　',  '　',  '　',  '　',  '　',  '　',  '　',  '　',  '　',  '　', '◎'},
        {'◎', '　', '　',  '　',  '　',  '　',  '　',  '　',  '　',  '　',  '　',  '　',  '　',  '　',  '　',  '　',  '　',  '　',  '　',  '　',  '　', '道'},
        {'◎', '　', '　',  '　',  '　',  '　',  '　',  '　',  '　',  '　',  '　',  '　',  '　',  '　',  '　',  '　',  '　',  '　',  '　',  '　',  '　', '◎'},
        {'空', '　', '　',  '　',  '　',  '　',  '　',  '　',  '　',  '　',  '　',  '　',  '　',  '　',  '　',  '　',  '　',  '　',  '　',  '　',  '　', '◎'},
        {'卡', '　', '　',  '　',  '　',  '　',  '　',  '　',  '　',  '　',  '　',  '　',  '　',  '　',  '　',  '　',  '　',  '　',  '　',  '　',  '　', '◎'},
        {'券', '　', '　',  '　',  '　',  '　',  '　',  '　',  '　',  '　',  '　',  '　',  '　',  '　',  '　',  '　',  '　',  '　',  '　',  '　',  '　', '◎'},
        {'券', '券', '券',  '券',  '券',  '券',  '券',  '券',  '券',  '券',  '券',  '券',  '券',  '券',  '券',  '券',  '券',  '券',  '券',  '券',  '券',  '券'}
    };
    public static final int[][] COORDINATE = {
            {0, 0}, {1, 0}, {2, 0}, {3, 0}, {4, 0}, {5, 0}, {6, 0}, {7, 0}, {8, 0}, {9, 0},
            {10, 0}, {11, 0}, {12, 0}, {13, 0}, {14, 0}, {15, 0}, {16, 0}, {17, 0}, {18, 0}, {19, 0},
            {20, 0}, {21, 0}, {21, 1}, {21, 2}, {21, 3}, {21, 4}, {21, 5}, {21, 6}, {21, 7}, {21, 8},
            {21, 9}, {20, 9}, {19, 9}, {18, 9}, {17, 9}, {16, 9}, {15, 9}, {14, 9}, {13, 9}, {12, 9},
            {11, 9}, {10, 9}, {9, 9}, {8, 9}, {7, 9}, {6, 9}, {5, 9}, {4, 9}, {3, 9}, {2, 9},
            {1, 9}, {0, 9}, {0, 8}, {0, 7}, {0, 6}, {0, 5}, {0, 4}, {0, 3}, {0, 2}, {0, 1}
    };

    private Collection<Cell> cells;
    private char[][] curMap;

    public Map() {
        this.cells = new ArrayList<Cell>();
        this.curMap = new char[MAP_HEIGHT][MAP_WIDTH];
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

    public void printInitialMap() {
//        BufferedReader reader = new BufferedReader(new StringReader(INITIAL_MAP));
//        try {
//            for (int y=0;y<MAP_HEIGHT;y++) {
//                char[] chars = reader.readLine().toCharArray();
//                for (int x=0;x<MAP_WIDTH;x++)
//                    System.out.print(chars[x] + "\u3000");
//                System.out.println();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        for (int y=0;y<MAP_HEIGHT;y++) {
            for (int x=0;x<MAP_WIDTH;x++)
                System.out.print(INITIAL_MAP[y][x] + "　");
            System.out.println();
        }
    }
}
