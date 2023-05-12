import androidx.appcompat.app.AppCompatActivity;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import java.util.List;
import java.util.ArrayList;

public class FlightSearchActivity extends AppCompatActivity {
    private List<Flight> searchFlights(String origin, String destination, String departureDate) {
        MongoDatabase db = DatabaseConnection.getDatabase();
        MongoCollection<Document> flightsCollection = db.getCollection("flights");

        List<Flight> flights = new ArrayList<>();
        flightsCollection.find(
                Filters.and(
                        Filters.eq("origin", origin),
                        Filters.eq("destination", destination),
                        Filters.eq("departureDate", departureDate)
                )
        ).forEach(document -> flights.add(Flight.fromDocument(document)));

        return flights;
    }
}
