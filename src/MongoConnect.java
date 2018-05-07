
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
		System.out.println("0");
		this.m = m;
		start();
	}
	public void start(){
		try{
			System.out.println(1);
			// To connect to mongodb server
			MongoClient mongoClient = new MongoClient();

			// Now connect to your databases
			DB db = mongoClient.getDB( "medicao" );
			System.out.println("Connect to database successfully");
			DBCollection colltemp = db.getCollection("Temp");
//			DBCollection collection = db.getCollection("Perm");
		//	System.out.println("Collection mycol created successfully");
			createDocument();
			colltemp.save(obj);
//			collection.insert(obj);
			
			DBCursor cursor = colltemp.find();
			while (cursor.hasNext()) {
			DBObject obj = cursor.next();
				System.out.println(obj);				
			}
//			colltemp.drop();
			System.out.println(2);
			//boolean auth = db.authenticate(myUserName, myPassword);
			//	System.out.println("Authentication: "+auth);

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
