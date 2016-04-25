package object;

import function.ItemGetterService;

import java.util.ArrayList;

/**
 * Created by jzl on 16/4/20.
 */
public class ItemGetter implements Visualizable, Servable {
    private ItemGetterService itemGetterService;

    public ItemGetter() {
        this.itemGetterService = new ItemGetterService();
    }

    @Override
    public void serve(ArrayList<Player> players, int currentPlayer) {
        this.itemGetterService.serve(players, currentPlayer);
    }

    @Override
    public char toTexture() {
        return '卡';
    }
}
