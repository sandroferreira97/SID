import java.util.ArrayList;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class Sbc {

	private Medicao m;
	private BasicDBObject obj;

	public Sbc() {
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
			DBCollection collection = db.getCollection("Perm");

			List<DBObject> medicoes = colltemp.find().toArray();
			colltemp.drop();
			for(int i = 0;i<medicoes.size();i++) {
				System.out.println("TAMANHO        "+medicoes.size()+"          I        "+i);
				collection.save(medicoes.get(i));
				System.out.println(medicoes.get(i).toString());			}
		}catch(Exception e){
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		}
	}
}
