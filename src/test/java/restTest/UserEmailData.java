package restTest;

public class UserEmailData {
    private String email;
    private String password;

    public UserEmailData(String email, String password) {

        this.email = email;
        this.password = password;
    }

    public UserEmailData setEmail(String email) {
        this.email = email;
        return this;
    }

    public UserEmailData setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
