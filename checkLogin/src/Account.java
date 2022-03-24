public class Account {
    private long id;
    private String user_name;
    private String pass_word;
    private String email;

    public Account(long id, String user_name, String pass_word, String email) {
        this.id = id;
        this.user_name = user_name;
        this.pass_word = pass_word;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPass_word() {
        return pass_word;
    }

    public void setPass_word(String pass_word) {
        this.pass_word = pass_word;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
