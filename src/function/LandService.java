package function;

import object.*;

import java.util.*;

/**
 * Created by jzl on 16/4/23.
 */
public class LandService {
    private static final String WELCOME = "欢迎来到%s\n",
        NO_OWNER = "这块土地没有主人\n",
        PURCHASE = "你是否选择购买?\n按y购买,按n取消,请选择:\n",
        PURCHASE_SUCCESSFULLY = "购买成功\n",
        PURCHASE_UNSUCCESSFULLY = "未购买\n",
        NO_CASH = "现金不足\n",
        HAS_OWNER = "这块土地的主人是%s\n",
        MAX_LEVEL = "这块土地已经是最高级了\n",
        UPGRADE = "你是否选择升级?\n按y升级,按n取消,请选择:\n",
        UPGRADE_SUCCESSFULLY = "升级成功\n",
        UPGRADE_UNSUCCESSFULLY = "未升级\n",
        PAY = "你需要缴纳%d的过路费\n",
        PAY_SUCCESSFULLY = "缴纳成功\n",
        PAY_UNSUCCESSFULLY = "缴纳失败,破产\n",
        WARNING = "请输入符合要求的字符\n";;

    public void serve(ArrayList<Player> players, int currentPlayer, Land land) {
        String landName = land.getName();
        int landOwner = land.getOwner();
        Player player = players.get(currentPlayer);
        int price = land.getPrice();

        System.out.printf(WELCOME, landName);
        if (landOwner == -1) {
            System.out.print(NO_OWNER);
            System.out.print(PURCHASE);
            Scanner sc = new Scanner(System.in);
            String option = sc.next();
            if (option.equals("y")) {
                if (player.getCash() >= price) {
                    System.out.print(PURCHASE_SUCCESSFULLY);
                    player.addCash(-price);
                    player.addHouseProperty(price);
                    land.setOwner(player.getNumber());
                    player.addLand(land);
                } else
                    System.out.print(NO_CASH);
            } else if (option.equals("n"))
                System.out.print(PURCHASE_UNSUCCESSFULLY);
            else
                System.out.print(WARNING);
        } else if (landOwner == currentPlayer) {
            System.out.printf(HAS_OWNER, player.getName());
            if (land.getLevel() < Land.MAX_LEVEL) {
                System.out.print(UPGRADE);
                Scanner sc = new Scanner(System.in);
                String option = sc.next();
                if (option.equals("y")) {
                    if (player.getCash() >= price) {
                        System.out.print(UPGRADE_SUCCESSFULLY);
                        player.addCash(-price);
                        player.addHouseProperty(price);
                        land.upgrade();
                    } else
                        System.out.print(NO_CASH);
                } else if (option.equals("n"))
                    System.out.print(UPGRADE_UNSUCCESSFULLY);
                else
                    System.out.print(WARNING);
            } else
                System.out.print(MAX_LEVEL);
        } else {
            System.out.printf(HAS_OWNER, players.get(landOwner).getName());
            System.out.printf(PAY, price);
            if (player.getCash() >= price) {
                System.out.print(PAY_SUCCESSFULLY);
                player.addCash(-price);
                players.get(landOwner).addCash(price);
            } else if (player.getCash() + player.getDeposit() >= price) {
                System.out.print(PAY_SUCCESSFULLY);
                player.addDeposit(player.getCash() - price);
                player.setCash(0);
                players.get(landOwner).addCash(price);
            } else if (player.getCash() + player.getDeposit() + player.getHouseProperty() >= price) {
                System.out.print(PAY_SUCCESSFULLY);
                int delta = price - player.getCash() - player.getHouseProperty();
                for (int i=0;i<player.getLands().size();i++) {
                    Land tmpLand = player.getLands().get(i);
                    if (tmpLand.getLevel()*tmpLand.getPrice()>=delta) {
                        
                    }
                }
            } else
                System.out.print(PAY_UNSUCCESSFULLY);
        }
    }
}
