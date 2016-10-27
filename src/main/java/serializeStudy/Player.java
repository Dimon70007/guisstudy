package serializeStudy;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Created by OTBA}|{HbIu` on 27.10.16.
 */
public class Player implements Serializable{
    private final String name;
    private final String gameTime;
    private  int power;
    private String[] weapons;

    public Player(String name, String gameTime, int power, String[] weapons) {
        this.name = name;
        this.gameTime = gameTime;
        this.power = power;
        this.weapons = weapons;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void setWeapons(String[] weapons) {
        this.weapons = weapons;
    }

    public String getName() {
        return name;
    }

    public String getGameTime() {
        return gameTime;
    }

    public int getPower() {
        return power;
    }

    public String[] getWeapons() {
        return weapons;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", gameTime='" + gameTime + '\'' +
                ", power=" + power +
                ", weapons=" + Arrays.toString(weapons) +
                '}';
    }
}
