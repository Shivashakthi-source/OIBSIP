public class User {

    private String username;
    private String password;
    private String name;
    private String registerNumber;

    public User(String username, String password,
                String name, String registerNumber) {

        this.username = username;
        this.password = password;
        this.name = name;
        this.registerNumber = registerNumber;
    }

    public boolean validate(String username, String password) {
        return this.username.equals(username)
                && this.password.equals(password);
    }

    public String getName() {
        return name;
    }

    public String getRegisterNumber() {
        return registerNumber;
    }

    public String getUsername() {
        return username;
    }
}