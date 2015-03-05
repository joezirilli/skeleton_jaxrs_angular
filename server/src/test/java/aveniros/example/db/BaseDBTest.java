package aveniros.example.db;

import org.junit.Before;
import org.junit.BeforeClass;

public class BaseDBTest {
	protected static final String TEST_DATABASE_NAME = "test_example_db";
	
	@BeforeClass
	public static void baseDbSetupClass() {
		DBUtil.setDBName(TEST_DATABASE_NAME);
	}

	@Before
	public void baseDbSetup() throws Exception {
		DBUtil.destroy();
		DBUtil.getInstance().clearDatabase();
	}
}
