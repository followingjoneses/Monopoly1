package object;

import function.ItemShopService;

import java.util.ArrayList;

/**
 * Created by jzl on 16/4/19.
 */
public class ItemShop implements Visualizable, Servable {
    private ItemShopService itemShopService;

    public ItemShop() {
        itemShopService = new ItemShopService();
    }

    @Override
    public void serve(ArrayList<Player> players, int currentPlayer) {
        this.itemShopService.serve(players, currentPlayer);
    }

    @Override
    public char toTexture() {
        return '道';
    }
}
