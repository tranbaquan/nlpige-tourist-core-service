import com.google.gson.Gson;
import com.nlpige.tourist.utils.HashingUtils;
import com.nlpige.tourist.utils.ResetPasswordParam;

/**
 * Created by IntelliJ on Wednesday, 12 December, 2018 at 02:01.
 *
 * @author Joseph Maria
 */
public class Test {
    public static void main(String[] args) {
        String hashed = HashingUtils.hashPassword(new char[]{'a', 'b', 'c'});
        System.out.println(HashingUtils.verifyPassword(hashed, new char[]{'a', 'b', 'c'}));

        ResetPasswordParam resetPasswordParam = new ResetPasswordParam("baotruong11a@gmail.com", "390583", "Truongem852963");
        System.out.println(new Gson().toJson(resetPasswordParam, ResetPasswordParam.class));
    }
}
