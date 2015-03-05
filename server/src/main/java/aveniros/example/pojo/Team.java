package aveniros.example.pojo;

import org.jongo.marshall.jackson.oid.ObjectId;

public class Team {

	@ObjectId
	private String _id;
	private String name;
	private int championships;

	public Team() {
	}

	public Team(String name, int championships) {
		this.name = name;
		this.championships = championships;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getChampionships() {
		return championships;
	}

	public void setChampionships(int championships) {
		this.championships = championships;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String id) {
		this._id = id;
	}
}
