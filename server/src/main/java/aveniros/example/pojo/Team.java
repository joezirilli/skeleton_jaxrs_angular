package aveniros.example.pojo;

import java.util.UUID;

public class Team {

	private String id;
	private String name;
	private int championships;

	public Team() {
		assignRandomId();
	}

	public Team(String name, int championships) {
		this();
		this.name = name;
		this.championships = championships;
	}
	
	public void assignRandomId() {
		setId(UUID.randomUUID().toString());
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
