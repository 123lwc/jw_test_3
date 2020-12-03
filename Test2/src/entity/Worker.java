package entity;

public class Worker {
	private String id;
	private String name;
	private String sex;
	private String club;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getClub() {
		return club;
	}
	public void setClub(String club) {
		this.club = club;
	}
	@Override
	public String toString() {
		return "Worker [id=" + id + ", name=" + name + ", sex=" + sex + ", club=" + club + "]";
	}
	

}
