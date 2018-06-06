import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class MongoConnect {
	private Medicao m;
	private BasicDBObject obj;
	public MongoConnect(Medicao m) {
		this.m = m;
		start();
	}
	public void start(){
		try{
			// To connect to mongodb server
			MongoClient mongoClient = new MongoClient();

			// Now connect to your databases
			DB db = mongoClient.getDB( "medicao" );
			System.out.println("Connect to database successfully");
			DBCollection colltemp = db.getCollection("Temp");
			createDocument();
			colltemp.save(obj);
			mongoClient.close();

			

		}catch(Exception e){
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		}

	}
	private  void createDocument() {
		obj = new BasicDBObject()
				.append("temperatura", m.getTemperatura())
                .append("humidade", m.getHumidade())
                .append("data", m.getData())
                .append("hora", m.getHora());
		System.out.println(obj.toString());
	}
}