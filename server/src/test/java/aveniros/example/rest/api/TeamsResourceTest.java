package aveniros.example.rest.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.WebApplicationException;

import org.junit.Before;
import org.junit.Test;

import aveniros.example.db.TeamsDAO;
import aveniros.example.pojo.Team;

public class TeamsResourceTest {

	private TeamsResource teamsResource;
	private TeamsDAO teamsDao;

	@Before
	public void setup() {
		teamsDao = mock(TeamsDAO.class);
		teamsResource = new TeamsResource(teamsDao);
	}

	@Test
	public void testGetTeamsReturnsAllTeams() throws Exception {
		List<Team> teams = Arrays.asList(
				new Team("Yankees", 27),
				new Team("Red Sox", 8));
		when(teamsDao.getAllTeams()).thenReturn(teams);
		
		assertSame(teams, teamsResource.getTeams());
	}

	@Test
	public void testGetTeamByIdReturnsTheTeamWithTheMatchingId() throws Exception {
		Team yankees = new Team("Yankees", 27);
		Team redsox = new Team("Red Sox", 8);
		yankees.set_id("y123");
		yankees.set_id("rs123");
		when(teamsDao.getTeamById("y123")).thenReturn(yankees);
		when(teamsDao.getTeamById("rs123")).thenReturn(redsox);
		assertSame(yankees, teamsResource.getTeamById("y123"));
		assertSame(redsox, teamsResource.getTeamById("rs123"));
	}
	
	@Test
	public void testGetTeamByIdThrows404ErrorIfNoTeamHasId() throws Exception {
		Team yankees = new Team("Yankees", 27);
		Team redsox = new Team("Red Sox", 8);
		yankees.set_id("y123");
		yankees.set_id("rs123");
		when(teamsDao.getTeamById("y123")).thenReturn(yankees);
		when(teamsDao.getTeamById("rs123")).thenReturn(redsox);
		
		try {
			teamsResource.getTeamById("this is definitely not an id");
			fail("Should have thrown exception");
		} catch (WebApplicationException we) {
			assertEquals(404, we.getResponse().getStatus());
		}
	}
	
	@Test
	public void testAddTeamAddsTheTeamToTheListOfTeams() throws Exception {
		Team team = new Team("Cardinals", 11);
		teamsResource.addTeam(team);
		
		verify(teamsDao).addTeam(team);
	}
}
