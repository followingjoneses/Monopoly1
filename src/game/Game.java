package game;

import object.*;

import java.io.*;

/**
 * Created by jzl on 16/4/2.
 */
public class Game {
    public static Player[] players;
    public static int currentPlayer;

    public static void initial(int num) {
        players = new Player[num];
        for (int i=0;i<num;i++)
            players[i] = new Player();
    }

    private Map buildMap() throws IOException {
        BufferedReader reader = new BufferedReader(new StringReader(Map.map));
        Map map = new Map(10, 22);
        for (int y=0;y<map.getHeight();y++) {
            char[] chars = reader.readLine().toCharArray();
            for(int x = 0;x <map.getWidth();x++) {
                if (chars[x] == ' ')
                    continue;
                Cell curCell = map.getCell(x, y);
                switch(chars[x]) {
                    case '◎':
                        curCell.addView(new Land());
                        break;
                    case '新':
                        curCell.addView(new NewsCentre());
                        break;
                    case '银':
                        curCell.addView(new Bank());
                        break;
                    case '道':
                        curCell.addView(new ItemShop());
                        break;
                    case '券':
                        curCell.addView(new PointGetter());
                        break;
                    case '空':
                        curCell.addView(new Opening());
                        break;
                }
            }
        }
        return map;
    }

}
