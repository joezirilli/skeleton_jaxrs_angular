package aveniros.example.db;

import java.net.UnknownHostException;

import org.jongo.Jongo;

import com.mongodb.DB;
import com.mongodb.MongoClient;

public class DBUtil {
	private static DBUtil instance = null;
	
	private static String dbName = "example_db";

	private DB database = null;
	private MongoClient client = null;
	private Jongo jongo = null;

	public static synchronized DBUtil getInstance() {
		if (instance == null) {
			instance = new DBUtil();
		}
		return instance;
	}
	
	public static void setDBName(String name) {
		dbName = name;
	}

	protected DBUtil() {
		try {
			client = new MongoClient();
		} catch (UnknownHostException ex) {
			// Oh no!
		}
		database = client.getDB(dbName);
		jongo = new Jongo(database);
	}

	public Jongo getJongo() {
		return jongo;
	}

	public static synchronized void destroy() {
		instance = null;
	}

	public void clearDatabase() {
		jongo.getDatabase().dropDatabase();
	}
}
