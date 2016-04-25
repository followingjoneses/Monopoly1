package object;

import function.BankService;

import java.util.ArrayList;

/**
 * Created by jzl on 16/4/5.
 */
public class Bank extends Serving implements Visualizable {
    private BankService bankService;

    public Bank() {
        bankService = new BankService();
        this.name = "银行";
    }

    @Override
    public void serve(ArrayList<Player> players, int currentPlayer) {
        this.bankService.serve(players, currentPlayer);
    }

    @Override
    public void printCellInfo(ArrayList<Player> players) {
        System.out.println(this.name);
    }

    @Override
    public char toTexture() {
        return '银';
    }
}
