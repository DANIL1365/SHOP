package shop.JDBC;

public class User {

    private int id;
    private String Name;
    private String Number;
    private String Email;

    public User(){
    }

    public User(String Name, String Number, String Email) {
        this.Name = Name;
        this.Number = Number;
        this.Email = Email;
    }

    public User(int id, String Name, String Number, String Email) {
        this.id = id;
        this.Name = Name;
        this.Number = Number;
        this.Email = Email;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName(){
        return Name;
    }

    public void setName(String Name){
        this.Name = Name;
    }

    public String getNumber(){
        return Number;
    }

    public void setNumber(String Number){
        this.Number = Number;
    }

    public String getEmail(){
        return Email;
    }

    public void setEmail(String Email){
        this.Email = Email;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" + '\n' +
                "id= " + id + '\n' +
                "name= '" + Name + '\n' +
                "number= " + Number + '\n' +
                "email= " + Email +
                '}';
    }

}
