import java.util.Date;

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

    // Getter for agentId
    public String getAgentId() {
        return agentId;
    }

    // Setter for agentId
    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }
}
