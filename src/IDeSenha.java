import java.util.HashMap;

public class IDeSenha {

    /*_______________Cadastrar_Usuários_______________*/

    static HashMap<String,String> loginInfo = new HashMap<String,String>();

    IDeSenha(){

        //loginInfo.put("Nome","Senha");

        loginInfo.put("1", "1");
        loginInfo.put("Thiago", "thiago123");
        loginInfo.put("Professor", "professor123");

    }

    public static HashMap getLoginInfo(){
        return loginInfo;
    }

}
