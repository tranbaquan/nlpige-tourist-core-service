import com.nlpige.tourist.utils.Hashing;

import java.util.Random;

/**
 * Created by IntelliJ on Wednesday, 12 December, 2018 at 02:01.
 *
 * @author Joseph Maria
 */
public class Test {
    public static void main(String[] args) {
//        String hashed = Hashing.hashPassword(new char[]{'a', 'b', 'c'});
//        System.out.println(Hashing.verifyPassword(hashed, new char[]{'a', 'b', 'c'}));
        Random r = new Random();
        String personID="";
        for (int i=0;i<9;i++){
            personID+=r.nextInt(9);
        }
        System.out.println(personID+"personID");
        String pp="";
        for (int i=0;i<7;i++){
            pp+=r.nextInt(7);
        }
        System.out.println(pp+"pp");
    }
}
