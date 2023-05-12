import java.util.Date;
import java.util.List;

public abstract class User {
    private String userId;
    private String firstName;
    private String lastName;
    private String password;
    private Date birthdate;
    private String email;
    private String address;
    private String phoneNumber;

    // Constructor
    public User(String userId, String firstName, String lastName, String password, Date birthdate, String email, String address, String phoneNumber) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.birthdate = birthdate;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    // Default constructor
    public User() {
    }

    // Getters and setters
    // ...
    public String getUserId() {
        return userId;
    }

    // Setter for agentId
    public void setUserId(String userId) {
        this.userId = userId;
    }
}

