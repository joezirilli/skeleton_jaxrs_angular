package aveniros.example.db;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.bson.types.ObjectId;
import org.jongo.Jongo;
import org.jongo.MongoCollection;

import aveniros.example.pojo.Team;

public class TeamsDAO {
	private Jongo jongo;
	private MongoCollection collection;

	public TeamsDAO() {
		jongo = DBUtil.getInstance().getJongo();
		collection = jongo.getCollection("teams");
	}
	
	public Collection<Team> getAllTeams() {
		Iterable<Team> teams = collection.find().as(Team.class);
		return convertToList(teams);
	}
	
	public Team getTeamById(String id) {
		return collection.findOne(new ObjectId(id)).as(Team.class);
	}
	
	public String addTeam(Team team) {
		collection.insert(team);
		return team.get_id();
	}

	private static <T> List<T> convertToList(Iterable<T> iterable) {
		List<T> list = new ArrayList<>();
		for (T thing : iterable) {
			list.add(thing);
		}
		return list;
	}
}
