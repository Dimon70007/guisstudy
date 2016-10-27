package mail.fly.dimon;

import serializeStudy.Player;
import serializeStudy.PlayerState;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
        String pName="UASJA";
        String pTime="007";
        int pPower= 20;
        String[] pWeapon= new String[]{"fist", "sword"};
        ArrayList<Player> ps=new ArrayList<>();
        for (int i=0;i<10;i++){
            ps.add(new Player(pName+i,pTime+i,pPower+i,pWeapon));
        }
        PlayerState.savePlayers(ps);
        List<? super Player> ps1=PlayerState.loadPlayers();
        System.out.println(ps1);
    }
}
