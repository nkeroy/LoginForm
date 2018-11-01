package Login;

public class User {
	private String first_name;
	private String last_name;
	private String city;
	private String country;
	private String email;
	private String password;
	public User(String first_name, String last_name, String city, String country, String email, String password) {
		this.first_name = first_name;
		this.last_name = last_name;
		this.city = city;
		this.country = country;
		this.email = email;
		this.password = password;
	}
	public String getFirst_name() {
		return first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public String getCity() {
		return city;
	}
	public String getCountry() {
		return country;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	
}
