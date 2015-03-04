package aveniros.example.rest.api;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

import aveniros.example.pojo.Team;

public class TeamsResourceTest {

	private TeamsResource teamsResource;

	@Before
	public void setup() {
		teamsResource = new TeamsResource();
	}

	@Test
	public void testGetTeamsReturnsAllTeams() throws Exception {
		Collection<Team> teams = teamsResource.getTeams();
		Iterator<Team> teamsIt = teams.iterator();
		assertEquals(2, teams.size());
		assertEquals("Yankees", teamsIt.next().getName());
		assertEquals("Red Sox", teamsIt.next().getName());
	}

	@Test
	public void testGetTeamByIdReturnsTheTeamWithTheMatchingId() throws Exception {
		Collection<Team> teams = teamsResource.getTeams();
		Iterator<Team> teamsIt = teams.iterator();
		Team yankees = teamsIt.next();
		
		assertSame(teamsResource.getTeamById(yankees.getId()), yankees);
	}
	
	@Test
	public void testAddTeamAddsTheTeamToTheListOfTeams() throws Exception {
		assertEquals(2, teamsResource.getTeams().size());
		
		teamsResource.addTeam(new Team("Cardinals", "St. Louis", 11));
		
		Collection<Team> teams = teamsResource.getTeams();
		Iterator<Team> teamsIt = teams.iterator();
		assertEquals(3, teams.size());
		
		teamsIt.next();
		teamsIt.next();
		Team cardinals = teamsIt.next();
		assertEquals("Cardinals", cardinals.getName());
		assertNotNull(cardinals.getId());
	}
}
