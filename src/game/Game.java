package game;

import object.*;

import java.io.*;
import java.util.*;
import java.text.*;

/**
 * Created by jzl on 16/4/2.
 */
public class Game {
    private static final String NAME_INPUT = "请输入玩家%d的名字:\n",
        GAME_START = "游戏开始\n";

    private Player[] players;
    private int currentPlayer;
    private Calendar calendar;
    private Menu menu;

    public Game() {
        players = new Player[4];
        for (int i=0;i<players.length;i++)
            players[i] = new Player(i+1);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年M月d日");
        calendar = Calendar.getInstance();
        try {
            Date date = simpleDateFormat.parse("2014年1月1日");
            calendar.setTime(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        menu = new Menu();
    }

    public int getCurrentPlayer() {
        return this.currentPlayer;
    }

    public Calendar getCalendar() {
        return this.calendar;
    }

    public void tomorrow() {
        calendar.add(Calendar.DATE, 1);
    }

    public void setPlayerNames() {
        for (int i=0;i<players.length;i++) {
            System.out.printf(NAME_INPUT, i+1);
            Scanner sc = new Scanner(System.in);
            String name = sc.next();
            players[i].setName(name);
        }
    }

    public void startGame() {
        this.menu.buildMap();
        System.out.print(GAME_START);
        menu.printMainMenu(calendar, players, currentPlayer);
    }

//    private Map buildMap() throws IOException {
//        BufferedReader reader = new BufferedReader(new StringReader(Map.map));
//        Map map = new Map(10, 22);
//        for (int y=0;y<map.getHeight();y++) {
//            char[] chars = reader.readLine().toCharArray();
//            for(int x = 0;x <map.getWidth();x++) {
//                if (chars[x] == ' ')
//                    continue;
//                Cell curCell = map.getCell(x, y);
//                switch(chars[x]) {
//                    case '◎':
//                        curCell.addView(new Land());
//                        break;
//                    case '新':
//                        curCell.addView(new NewsCentre());
//                        break;
//                    case '银':
//                        curCell.addView(new Bank());
//                        break;
//                    case '道':
//                        curCell.addView(new ItemShop());
//                        break;
//                    case '券':
//                        curCell.addView(new PointGetter());
//                        break;
//                    case '空':
//                        curCell.addView(new Opening());
//                        break;
//                    case '卡':
//                        curCell.addView(new ItemGetter());
//                        break;
//                }
//            }
//        }
//        return map;
//    }

}
