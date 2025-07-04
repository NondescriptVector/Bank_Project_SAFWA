public class Person {
    private String name;
    private String address;
    private String username;
    private String password;
    private String id;

    public Person(String name, String address, String username, String password, String id) {
        this.name = name;
        this.address = address;
        this.username = username;
        this.password = password;
        this.id = id;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getId() {
        return id;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(String id) {
        this.id = id;
    }

    // String representation
    @Override
    public String toString() {
        return "Name: " + name + "\n" +
               "Address: " + address + "\n" +
               "ID: " + id;
    }
}
