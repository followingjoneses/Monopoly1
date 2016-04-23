package object;

import function.BuyItem;

/**
 * Created by jzl on 16/4/19.
 */
public class ItemShop implements Visualizable {
    private BuyItem buyItem;

    public ItemShop() {
        buyItem = new BuyItem();
    }

    public void serve(Player player) {
        this.buyItem.serve(player);
    }

    @Override
    public char toTexture() {
        return '道';
    }
}
