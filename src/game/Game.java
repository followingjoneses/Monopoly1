package game;

import object.*;

import java.util.*;
import java.text.*;

/**
 * Created by jzl on 16/4/2.
 */
public class Game {
    private static final String NAME_INPUT = "请输入玩家%d的名字:\n",
        GAME_START = "游戏开始\n";
    private static final int MAX_PLAYER = 4;

    private ArrayList<Player> players;
    private int currentPlayer;
    private Calendar calendar;
    private Menu menu;
    private Map map;

    public Game() {
        players = new ArrayList<Player>();
        for (int i=0;i<MAX_PLAYER;i++)
            players.add(new Player(i));

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年M月d日");
        calendar = Calendar.getInstance();
        try {
            Date date = simpleDateFormat.parse("2014年1月1日");
            calendar.setTime(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        menu = new Menu();
        map = new Map();
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
        for (int i=0;i<players.size();i++) {
            System.out.printf(NAME_INPUT, i+1);
            Scanner sc = new Scanner(System.in);
            String name = sc.next();
            players.get(i).setName(name);
        }
    }

    public void startGame() {
        buildMap();
        System.out.print(GAME_START);

        int option = -1;

        while (players.size()!=1) {
            for (int i=0;i<players.size();i++) {
                while (option != 7 && option != 6) {
                    option = menu.printMainMenu(map, calendar, players, currentPlayer);
                }
            }
        }
    }

    private void buildMap() {
        int landNameIndex = 0;

        for (int y=0;y<Map.MAP_HEIGHT;y++) {
            for (int x=0;x<Map.MAP_WIDTH;x++) {
                if (Map.INITIAL_MAP[y][x] == '\u3000')
                    continue;
                Cell curCell = this.map.createCell(x, y);
                switch(Map.INITIAL_MAP[y][x]) {
                    case '◎':
                        Land land = new Land(Map.LAND_NAME[landNameIndex++]);
                        curCell.addView(land);
                        curCell.setServing(land);
                        break;
                    case '新':
                        NewsCentre newsCentre = new NewsCentre();
                        curCell.addView(newsCentre);
                        curCell.setServing(newsCentre);
                        break;
                    case '银':
                        Bank bank = new Bank();
                        curCell.addView(bank);
                        curCell.setServing(bank);
                        break;
                    case '道':
                        ItemShop itemShop = new ItemShop();
                        curCell.addView(itemShop);
                        curCell.setServing(itemShop);
                        break;
                    case '券':
                        PointGetter pointGetter = new PointGetter();
                        curCell.addView(pointGetter);
                        curCell.setServing(pointGetter);
                        break;
                    case '空':
                        Opening opening = new Opening();
                        curCell.addView(opening);
                        curCell.setServing(opening);
                        break;
                    case '卡':
                        ItemGetter itemGetter = new ItemGetter();
                        curCell.addView(itemGetter);
                        curCell.setServing(itemGetter);
                        break;
                    case '彩':
                        LotteryHouse lotteryHouse = new LotteryHouse();
                        curCell.addView(lotteryHouse);
                        curCell.setServing(lotteryHouse);
                        break;

                }
            }
        }
        for (int i=0;i<players.size();i++)
            map.getCell(0, 0).addView(players.get(i));
    }

    private void nextPlayer() {
        currentPlayer = (currentPlayer + 1) % players.size();
    }
}
