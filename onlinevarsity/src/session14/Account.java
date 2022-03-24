package session14;

public class Account {
    public String userId;
    public String password;
    public Account(){}

    public Account(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public String toString(){
        return "Account{" + "userId : " + userId + ", password="+password+ "}";
    }
}
