import org.bson.Document;

public class PaymentInfo {
    private String paymentId;
    private String cardHolderName;
    private String cardNumber;
    private String cardExpirationDate;
    private String cardSecurityCode;

    // Constructor
    public PaymentInfo(String paymentId, String cardHolderName, String cardNumber, String cardExpirationDate, String cardSecurityCode) {
        this.paymentId = paymentId;
        this.cardHolderName = cardHolderName;
        this.cardNumber = cardNumber;
        this.cardExpirationDate = cardExpirationDate;
        this.cardSecurityCode = cardSecurityCode;
    }

    // Default constructor
    public PaymentInfo() {
    }

    // Getters and setters
    public String getPaymentId(){
        return paymentId;
    }

    public void setPaymentId(String paymentId){
        this.paymentId = paymentId;
    }

    public String getCardHolderName(){
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName){
        this.cardHolderName = cardHolderName;
    }

    public String getCardNumber(){
        return cardNumber;
    }

    public void setCardNumber(String cardNumber){
        this.cardNumber = cardNumber;
    }

    public String getCardExpirationDate(){
        return cardExpirationDate;
    }

    public void setCardExpirationDate(String cardExpirationDate){
        this.cardExpirationDate = cardExpirationDate;
    }

    public String getCardSecurityCode(){
        return cardSecurityCode;
    }

    public void setCardSecurityCode(String cardSecurityCode){
        this.cardSecurityCode = cardSecurityCode;
    }

    // Converts a PaymentInfo object to a Document for database storage
    public Document toDocument() {
        Document document = new Document()
                .append("paymentId", paymentId)
                .append("cardHolderName", cardHolderName)
                .append("cardNumber", cardNumber)
                .append("cardExpirationDate", cardExpirationDate)
                .append("cardSecurityCode", cardSecurityCode);

        return document;
    }

    // Creates a PaymentInfo object from a Document retrieved from the database
    public static PaymentInfo fromDocument(Document document) {
        PaymentInfo paymentInfo = new PaymentInfo();
        paymentInfo.setPaymentId(document.getString("paymentId"));
        paymentInfo.setCardHolderName(document.getString("cardHolderName"));
        paymentInfo.setCardNumber(document.getString("cardNumber"));
        paymentInfo.setCardExpirationDate(document.getString("cardExpirationDate"));
        paymentInfo.setCardSecurityCode(document.getString("cardSecurityCode"));

        return paymentInfo;
    }
}
