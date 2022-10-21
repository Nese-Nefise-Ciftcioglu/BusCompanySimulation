public class Owner extends User{

    private String password = "1234";
    public Owner() {
        super();
        password = "1234";
    }
    public Owner(String name, String password){
        super(name);
        this.setPassword(password);
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}

