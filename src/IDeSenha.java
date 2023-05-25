import java.util.HashMap;

public class IDeSenha {

    static HashMap<String,String> loginInfo = new HashMap<String,String>();

    IDeSenha(){

        loginInfo.put("Thiago","thiago123");
        loginInfo.put("Victor","victor123");
        loginInfo.put("Fatima","fatima123");
        loginInfo.put("Professor", "professor123");
    }

    public static HashMap getLoginInfo(){
        return loginInfo;
    }

}
