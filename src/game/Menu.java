package game;

import object.*;

import java.io.*;
import java.util.*;
import java.text.*;

/**
 * Created by jzl on 16/4/21.
 */
public class Menu {
    private static final String CURRENT_PLAYER = "现在是玩家%s的操作时间,你的前进方向是%s\n",
        OPTION = "你现在可以进行如下操作:\n"+
                "0 - 查看地图\n"+
                "1 - 查看原始地图\n"+
                "2 - 使用道具\n"+
                "3 - 前方10步内示警\n"+
                "4 - 查看前后指定步数的具体信息\n"+
                "5 - 查看玩家的资产信息\n"+
                "6 - 扔骰子\n"+
                "7 - 认输\n"+
                "请选择:\n",
        WARNING = "请输入符合要求的字符\n",
        ITEM = "你现在拥有的道具如下:\n",
        CARD_NUMBER = "请输入想使用的卡片编号,按x返回上一层:\n",
        PLAYERS_INFO = "昵称\t现金\t存款\t房产\t\n";

    private Map map;

    public Menu() {
        this.map = new Map();
    }

    public void buildMap() {
//        BufferedReader reader = new BufferedReader(new StringReader(Map.INITIAL_MAP));
//        try {
//            for (int y=0;y<Map.MAP_HEIGHT;y++) {
//                char[] chars = reader.readLine().toCharArray();
//                for(int x = 0;x <Map.MAP_WIDTH;x++) {
//                    if (chars[x] == '　')
//                        continue;
//                    Cell curCell = this.map.getCell(x, y);
//                    switch(chars[x]) {
//                        case '◎':
//                            curCell.addView(new Land());
//                            break;
//                        case '新':
//                            curCell.addView(new NewsCentre());
//                            break;
//                        case '银':
//                            curCell.addView(new Bank());
//                            break;
//                        case '道':
//                            curCell.addView(new ItemShop());
//                            break;
//                        case '券':
//                            curCell.addView(new PointGetter());
//                            break;
//                        case '空':
//                            curCell.addView(new Opening());
//                            break;
//                        case '卡':
//                            curCell.addView(new ItemGetter());
//                            break;
//                    }
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        for (int y=0;y<Map.MAP_HEIGHT;y++) {
            for (int x=0;x<Map.MAP_WIDTH;x++) {
                if (Map.INITIAL_MAP[y][x] == '　')
                    continue;
                Cell curCell = this.map.getCell(x, y);
                switch(Map.INITIAL_MAP[y][x]) {
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
                    case '卡':
                        curCell.addView(new ItemGetter());
                        break;
                }
            }
        }
    }

    public void printMainMenu(Calendar calendar, Player[] players, int currentPlayer) {
        String date = (new SimpleDateFormat("yyyy年M月d日")).format(calendar.getTime());
        System.out.println("今天是"+date);

        String direction = players[currentPlayer].isClockWise() ? "顺时针" : "逆时针";
        System.out.printf(CURRENT_PLAYER, players[currentPlayer].getName(), direction);
        System.out.print(OPTION);

        Scanner sc = new Scanner(System.in);
        try {
            int option = sc.nextInt();
            if (option >= 0 && option <=7) {
                printSubmenu(option, players, currentPlayer);
            } else
                System.out.print(WARNING);
        } catch (InputMismatchException e) {
            System.out.print(WARNING);
        }
    }

    private void printSubmenu(int option, Player[] players, int currentPlayer) {
        Player player = players[currentPlayer];

        switch (option) {
            case 0:
                break;
            case 1:
                map.printInitialMap();
                break;
            case 2:

                break;
            case 5:
                printPlayerProperties(players);
                break;
        }
    }

    private void printUseItem(Player player) {
        System.out.print(ITEM);
    }

    private void printPlayerProperties(Player[] players) {
        System.out.print(PLAYERS_INFO);
        for (int i=0;i<players.length;i++)
            System.out.println(players[i].getName() + "\t" + players[i].getCash() + "\t" +
                players[i].getDeposit() + "\t" + players[i].getHouseProperty());
    }
}
