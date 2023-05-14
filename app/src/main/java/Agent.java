import java.util.Date;
import java.util.List;

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
    public List<String> getCurrentClientIds(){
        return currentClientIds;
    }

    public void setCurrentClientIds(List<String> currentClientIds){
        this.currentClientIds = currentClientIds;
    }

    public List<String> getPastClientIds(){
        return pastClientIds;
    }

    public void setPastClientIds(List<String> pastClientIds){
        this.pastClientIds = pastClientIds;
    }


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
