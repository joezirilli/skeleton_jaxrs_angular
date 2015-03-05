package aveniros.example.db;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

import aveniros.example.pojo.Team;

public class TeamsDAOTest extends BaseDBTest {

	private TeamsDAO dao;

	@Before
	public void setup() {
		dao = new TeamsDAO();
	}
	
	@Test
	public void testAddTeamAddsTheTeamToTheCollection() throws Exception {
		assertEquals(0, dao.getAllTeams().size());
		
		dao.addTeam(new Team("Yankees", 27));
		dao.addTeam(new Team("Red Sox", 8));
		
		Collection<Team> teams = dao.getAllTeams();
		Iterator<Team> teamsIt = teams.iterator();
		
		assertEquals(2, teams.size());
		assertEquals("Yankees", teamsIt.next().getName());
		assertEquals("Red Sox", teamsIt.next().getName());
	}
	
	@Test
	public void testGetTeamByIdReturnsTheTeamWithTheMatchingId() throws Exception {
		Team yankees = new Team("Yankees", 27);
		Team redsox = new Team("Red Sox", 8);
		dao.addTeam(yankees);
		dao.addTeam(redsox);

		assertEquals("Yankees", dao.getTeamById(yankees.get_id()).getName());
		assertEquals("Red Sox", dao.getTeamById(redsox.get_id()).getName());
	}
}
