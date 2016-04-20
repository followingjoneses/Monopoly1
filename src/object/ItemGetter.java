package object;

/**
 * Created by jzl on 16/4/20.
 */
public class ItemGetter implements Visualizable {
    public void serve(Player player) {
        int index = (int)(Math.random()*5);
        player.addItem(index, 1);
    }

    @Override
    public String toTexture() {
        return "卡";
    }
}
