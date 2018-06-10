package testgroovy

class User {
    	Long id
    	String name
	String username
	String password
	String role
	
	User(id,name,username,password,role) {
		this.id = id
		this.name = name
		this.username = username
		this.password = password
		this.role = role
	}
}
