package aveniros.example.rest.api;

import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

import aveniros.example.db.TeamsDAO;
import aveniros.example.pojo.Team;

@Path("/teams")
public class TeamsResource {
	
	private TeamsDAO dao;

	public TeamsResource() {
		this(new TeamsDAO());
	}
	
	protected TeamsResource(TeamsDAO dao) {
		this.dao = dao;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Team> getTeams() {
		return dao.getAllTeams();
	}

	@Path("/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Team getTeamById(@PathParam("id") String id) {
		Team team = dao.getTeamById(id);
		if (team == null) {
			throw new WebApplicationException(404);
		}
		return team;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String addTeam(Team team) {
		return dao.addTeam(team);
	}
}
