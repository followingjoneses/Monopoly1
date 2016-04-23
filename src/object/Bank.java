package object;

import function.BankService;

/**
 * Created by jzl on 16/4/5.
 */
public class Bank implements Visualizable, Servable{
    private BankService bankService;

    public Bank() {
        bankService = new BankService();
    }

    @Override
    public void serve(Player[] players, int currentPlayer) {
        this.bankService.serve(players, currentPlayer);
    }

    @Override
    public char toTexture() {
        return '银';
    }
}
