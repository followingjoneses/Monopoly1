package object;

import function.News;

/**
 * Created by jzl on 16/4/19.
 */
public class NewsCentre implements Visualizable {
    private News news;

    public NewsCentre() {
        news = new News();
    }

    public void serve(Player[] players) {
        this.news.serve(players);
    }

    @Override
    public char toTexture() {
        return '新';
    }
}
