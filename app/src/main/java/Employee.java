import java.util.Date;

public class Employee extends User {
    private int accessLevel;

    // Constructor
    public Employee(String userId, String firstName, String lastName, String password, Date birthdate, String email, String address, String phoneNumber, int accessLevel) {
        super(userId, firstName, lastName, password, birthdate, email, address, phoneNumber);
        this.accessLevel = accessLevel;
    }

    // Default constructor
    public Employee() {
    }

    // Getters and setters
    public int getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(int accessLevel) {
        this.accessLevel = accessLevel;
    }
}
