import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
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

	public void start() {
		try {
			// To connect to mongodb server
			MongoClient mongoClient = new MongoClient();

			// Now connect to your databases
			DB db = mongoClient.getDB("medicao");
			System.out.println("Connect to database successfully");
			DBCollection colltemp = db.getCollection("Temp");
			DBCollection collection = db.getCollection("Perm");

			List<DBObject> medicoes = colltemp.find().toArray();
//			colltemp.drop();
			for (int i = 0; i < medicoes.size(); i++) {
				collection.save(medicoes.get(i));
				Medicao a = new Medicao(medicoes.get(i));
				String dbUrl;
				dbUrl = "jdbc:sqlanywhere:Tds:localhost:2638?eng=Grupo33";
				Connection conn = DriverManager.getConnection(dbUrl, "dba", "sql");
				String query = "SELECT * FROM HumidadeTemperatura";
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(query);
				int max = 0;
				while (rs.next()) {
					if (max < Integer.valueOf(rs.getString(1))) {
						max = Integer.valueOf(rs.getString(1));
					}
					;
				}
				int id = max + 1;
				PreparedStatement ps = conn.prepareStatement("INSERT INTO  HumidadeTemperatura values (?,?,?,?,?)");
				ps.setInt(1, id);
				ps.setObject(2, a.getDdata());
				ps.setObject(3, a.getTHora());
				ps.setDouble(4, Double.valueOf(a.getTemperatura().split("'")[1]));
				ps.setDouble(5, Double.valueOf(a.getHumidade().split("'")[1]));
				ps.executeUpdate();
			}

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
	}
}
