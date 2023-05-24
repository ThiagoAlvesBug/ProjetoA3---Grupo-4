import java.util.HashMap;

public class IDeSenha {

    HashMap<String,String> logininfo = new HashMap<String,String>();

    IDeSenha(){

        logininfo.put("Thiago","thiago123");
        logininfo.put("Victor","victor123");
        logininfo.put("Fatima","fatima123");
        logininfo.put("Professor", "professor123");
    }

    public HashMap getLoginInfo(){
        return logininfo;
    }

}
