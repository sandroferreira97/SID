import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
				System.out.println(medicoes.get(i).toString());			
				Medicao a = new Medicao(medicoes.get(i));
				
				
				
				Connection conn = 
						   DriverManager.getConnection("jdbc:sybase:Tds:localhost:5000", 
						     "username", "password");
				
				PreparedStatement ps = conn.prepareStatement("INSERT INTO  Friends values (?,?,?,?)");
				
				//alterar de acordo com a tabela do sybase, ((Como fica o ID??))
				ps.setString(1, "Joan");
				ps.setString(2, "Smith");
				ps.setObject(3, "  ");
				ps.setString(4, "123-456-7890");
				ps.executeUpdate();

			}
		}catch(Exception e){
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		}
	}
}
