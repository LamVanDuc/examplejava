import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class ReadAccount {
    public List<Account> accountList;
        public List<Account> getAccountList(){
            try{
                FileReader accountJson  = new FileReader("checkLogin/src/account.json");
                accountList = new Gson().fromJson(accountJson , new TypeToken<List<Account>>(){}.getType());

            }catch (IOException e){
                e.printStackTrace();
            }
            return accountList;
        }
    }
