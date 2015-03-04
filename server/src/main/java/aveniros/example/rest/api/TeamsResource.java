package aveniros.example.rest.api;

import java.util.Arrays;
import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

import aveniros.example.pojo.Team;

@Path("/teams")
public class TeamsResource {

	public static Collection<Team> teams = Arrays.asList(
			new Team("Yankees", "New York", 27),
			new Team("Red Sox", "Boston", 8));

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Team> getTeams() {
		return teams;
	}
	
	@Path("/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Team getTeamById(@PathParam("id") String id) {
		for (Team team : teams) {
			if (team.getId().equals(id)) {
				return team;
			}
		}
		throw new WebApplicationException(404);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String addTeam(Team team) {
		team.assignRandomId();
		teams.add(team);
		return team.getId();
	}
}
