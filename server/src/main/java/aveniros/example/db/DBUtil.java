package aveniros.example.db;

import java.net.UnknownHostException;

import org.jongo.Jongo;

import com.mongodb.DB;
import com.mongodb.MongoClient;

public class DBUtil {
	private static DBUtil instance = null;

	private DB database = null;
	private MongoClient client = null;
	private Jongo jongo = null;

	public static synchronized DBUtil getInstance() {
		if (instance == null) {
			instance = new DBUtil();
		}
		return instance;
	}

	protected DBUtil() {
		try {
			client = new MongoClient();
		} catch (UnknownHostException ex) {
			// Oh no!
		}
		database = client.getDB("example_db");
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
