package aveniros.example.pojo;

import org.jongo.marshall.jackson.oid.ObjectId;

public class Team {

	@ObjectId
	private String _id;
	private String name;
	private String city;
	private int championships;

	public Team() {
	}

	public Team(String name, String city, int championships) {
		this.name = name;
		this.city = city;
		this.championships = championships;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
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
