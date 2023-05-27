import java.util.HashMap;

public class User {

    static HashMap<String,String> loginInfo = new HashMap<String,String>();

    public static HashMap<String,String> getLoginInfo(){
        return loginInfo;
    }

    public static void addUser(String login, String senha) {
        loginInfo.put(login, senha);
    }
}
