import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class Repository {
    public List<User> users;
    public List<User> getData(){
        try{
            FileReader fileReader = new FileReader("lab_authentication/user.json");
            Type objectType = new TypeToken<List<User>>(){}.getType();
            users = new Gson().fromJson(fileReader , objectType);

        }catch (IOException e){
            e.printStackTrace();
        }
        return users;
    }
}
