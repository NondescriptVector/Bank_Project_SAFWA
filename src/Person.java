public class Person {
    String name;
    protected  String address,username,password;
    static String id;

    public Person(String name, String address, String username, String password, int id) {
        this.name = name;
        this.address = address;
        this.username = username;
        this.password = password;
        this.id = id;
    }
}
