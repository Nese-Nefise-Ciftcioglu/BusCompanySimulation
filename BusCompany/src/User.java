public class User {
    private String name;
    public User(){
        name="Unknown";
    }
    public User(String name){
        this.name=name;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
}
