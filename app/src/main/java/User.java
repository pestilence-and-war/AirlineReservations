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
}

public class Flyer extends User {
    private Reservation reservation;
    private String notificationPreference;
    private PaymentInfo paymentInfo;
    private String agentId;

    // Constructor
    public Flyer(String userId, String firstName, String lastName, String password, Date birthdate, String email, String address, String phoneNumber, Reservation reservation, String notificationPreference, PaymentInfo paymentInfo, String agentId) {
        super(userId, firstName, lastName, password, birthdate, email, address, phoneNumber);
        this.reservation = reservation;
        this.notificationPreference = notificationPreference;
        this.paymentInfo = paymentInfo;
        this.agentId = agentId;
    }

    // Default constructor
    public Flyer() {
    }

    // Getters and setters
    // ...
}

public class Agent extends User {
    private List<String> currentClientIds;
    private List<String> pastClientIds;

    // Constructor
    public Agent(String userId, String firstName, String lastName, String password, Date birthdate, String email, String address, String phoneNumber, List<String> currentClientIds, List<String> pastClientIds) {
        super(userId, firstName, lastName, password, birthdate, email, address, phoneNumber);
        this.currentClientIds = currentClientIds;
        this.pastClientIds = pastClientIds;
    }

    // Default constructor
    public Agent() {
    }

    // Getters and setters
    // ...

    // Method to add a client to the current clients list
    public void addCurrentClient(Flyer client) {
        if (client.getAgentId() == null || !client.getAgentId().equals(this.getUserId())) {
            client.setAgentId(this.getUserId());
            this.currentClientIds.add(client.getUserId());
        }
    }

    // Method to remove a client from the current clients list and add to the past clients list
    public void removeCurrentClient(Flyer client) {
        if (client.getAgentId() != null && client.getAgentId().equals(this.getUserId())) {
            client.setAgentId(null);
            this.currentClientIds.remove(client.getUserId());
            this.pastClientIds.add(client.getUserId());
        }
    }
}
