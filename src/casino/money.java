package casino;

import java.io.*;

public class money implements Serializable {
    
    public int playerMoney;

    public money(int playerMoney) {
        this.playerMoney = playerMoney;
    }

    public int getPlayerMoney() {
        return playerMoney;
    }

    public void setPlayerMoney(int playerMoney) {
        this.playerMoney = playerMoney;
    }

    @Override
    public String toString() {
        System.out.println(playerMoney);
        return null;
    }

    }
    
    

