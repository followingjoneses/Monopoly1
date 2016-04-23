package object;

/**
 * Created by jzl on 16/4/20.
 */
public class PointGetter implements Visualizable {
    public void serve(Player player) {
        int point = (int)(Math.random()*100);
        player.addPoint(point);
    }

    @Override
    public char toTexture() {
        return '券';
    }
}
