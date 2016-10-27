package serializeStudy;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by OTBA}|{HbIu` on 27.10.16.
 */
public class PlayerState {
    private static Path PATH;
    private final static File DIR;
    private final static String FILE_NAME ="players.ser";
    private static ObjectOutputStream os;
    private static ObjectInputStream ois;

    static {
//        PATH =PlayerState.class.getResourceAsStream(FILE_NAME);
        DIR=new File(".");
        PATH=Paths.get(DIR.getPath(), FILE_NAME);
    }

    public static void savePlayers(ArrayList<? extends Player> players){
        try {
            FileOutputStream fos=new FileOutputStream(PATH.toString());
            os=new ObjectOutputStream(fos);
//            for (Player player:players){
                os.writeObject(players);


        } catch (FileNotFoundException e) {

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static List<? super Player> loadPlayers() {
        List<Player> players=new ArrayList<>();
        try {
            FileInputStream fis=new FileInputStream(PATH.toString());
            ois=new ObjectInputStream(fis);
//            while(true) {
                Object obj = ois.readObject();
                players=(ArrayList<Player>) obj;
//            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
//            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return players;
    }
}
