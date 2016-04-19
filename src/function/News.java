package function;

/**
 * Created by jzl on 16/4/5.
 */
public class News {
    private static String[] news;

    static {
        news = new String[5];
        news[0] = "公开表扬第一地主%s奖励%d元";
        news[1] = "公开补助土地最少者%s, %d元";
        news[2] = "银行加发储金红利每个人得到存款10%";
        news[3] = "所有人缴纳财产税10%";
        news[4] = "每个人得到一张卡片";
    }

    public static void trigger() {
        int option = (int)(Math.random()*5);

        switch (option) {

        }
    }
}
