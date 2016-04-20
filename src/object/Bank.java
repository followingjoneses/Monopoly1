package object;

import function.BankService;

/**
 * Created by jzl on 16/4/5.
 */
public class Bank implements Visualizable{
    private BankService bankService;

    public Bank() {
        bankService = new BankService();
    }

    public void serve(Player player) {
        this.bankService.serve(player);
    }

    @Override
    public String toTexture() {
        return "银";
    }
}
