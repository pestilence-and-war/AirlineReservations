import org.bson.Document;

public class Reservation {
    private String reservationId;
    private String flightId;
    private String userId;
    private int numberOfPassengers;

    // Constructor
    public Reservation(String reservationId, String flightId, String userId, int numberOfPassengers) {
        this.reservationId = reservationId;
        this.flightId = flightId;
        this.userId = userId;
        this.numberOfPassengers = numberOfPassengers;
    }

    // Default constructor
    public Reservation() {
    }

    // Getters and setters

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId){
        this.reservationId = reservationId;
    }

    public String getFlightId(){
        return reservationId;
    }

    public void setFlightId(String flightId){
        this.flightId = flightId;
    }

    public String getUserId(){
        return userId;
    }

    public void setUserId(String userId){
        this.userId = userId;
    }

    public int getNumberOfPassengers(){
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(int numberOfPassengers){
        this.numberOfPassengers = numberOfPassengers;
    }

    // Converts a Reservation object to a Document for database storage
    public Document toDocument() {
        Document document = new Document()
                .append("reservationId", reservationId)
                .append("flightId", flightId)
                .append("userId", userId)
                .append("numberOfPassengers", numberOfPassengers);

        return document;
    }

    // Creates a Reservation object from a Document retrieved from the database
    public static Reservation fromDocument(Document document) {
        Reservation reservation = new Reservation();
        reservation.setReservationId(document.getString("reservationId"));
        reservation.setFlightId(document.getString("flightId"));
        reservation.setUserId(document.getString("userId"));
        reservation.setNumberOfPassengers(document.getInteger("numberOfPassengers"));

        return reservation;
    }
}
