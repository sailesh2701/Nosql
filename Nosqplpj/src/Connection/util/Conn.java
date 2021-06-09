package Connection.util;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoDatabase;
public class Conn {
    public static MongoDatabase getConnect(String dbname)
    {
        MongoClient mongo = new MongoClient("localhost",27017);
        
        MongoCredential credential;
        credential = MongoCredential.createCredential("sampleUser","myDb","password".toCharArray());
        System.out.println("Connected to the database Successfully");
        //Accessing the database
        MongoDatabase database=mongo.getDatabase(dbname);
        System.out.println("Credentials :: "+credential);
        return database;
    }
    
}
