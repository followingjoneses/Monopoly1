package function;

import object.Player;

/**
 * Created by jzl on 16/4/5.
 */
public class News {
    private static final String[] NEWS;

    static {
        NEWS = new String[5];
        NEWS[0] = "公开表扬第一地主%s奖励%d元\n";
        NEWS[1] = "公开补助土地最少者%s %d元\n";
        NEWS[2] = "银行加发储金红利每个人得到存款10%\n";
        NEWS[3] = "所有人缴纳财产税10%\n";
        NEWS[4] = "每个人得到一张卡片\n";
    }

    public void serve(Player[] players) {
        int option = (int)(Math.random()*5);

        switch (option) {
            case 0:
                int reward = (int)(Math.random()*10000);
                Player richest = this.getRichest(players);
                System.out.printf(NEWS[0], richest.getName(), reward);
                richest.addCash(reward);
                break;

            case 1:
                int grants = (int)(Math.random()*10000);
                Player poorest = this.getPoorest(players);
                System.out.printf(NEWS[1], poorest.getName(), grants);
                poorest.addCash(grants);
                break;

            case 2:
                System.out.print(NEWS[2]);
                for (int i=0;i<players.length;i++)
                    players[i].addDeposit((int)(players[i].getDeposit()*0.1));
                break;

            case 3:
                System.out.print(NEWS[3]);
                for (int i=0;i<players.length;i++)
                    players[i].addDeposit(-(int)(players[i].getDeposit()*0.1));
                break;

            case 4:
                System.out.print(NEWS[4]);
                for (int i=0;i<players.length;i++) {
                    int index = (int)(Math.random()*5);
                    players[i].addItem(index, 1);
                }
                break;
        }
    }

    private Player getRichest(Player[] players) {
        int max = 0, maxHouseProperty = 0;
        for (int i=0;i<players.length;i++) {
            if (players[i].getHouseProperty() > maxHouseProperty) {
                maxHouseProperty = players[i].getHouseProperty();
                max = i;
            }
        }

        return players[max];
    }

    private Player getPoorest(Player[] players) {
        int min = 0, minHouseProperty = Integer.MAX_VALUE;
        for (int i=0;i<players.length;i++) {
            if (players[i].getHouseProperty() < minHouseProperty) {
                minHouseProperty = players[i].getHouseProperty();
                min = i;
            }
        }

        return players[min];
    }
}
