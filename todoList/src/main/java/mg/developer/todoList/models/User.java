package mg.developer.todoList.models;

import javax.persistence.*;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Entity
@Table(name = "users" )
public class User {
	
	@Id
	@Column(name="username")
	private String username;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "enabled", columnDefinition = "tinyint default true", nullable = false)
	private boolean enabled = true;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		this.password = passwordEncoder.encode(password);
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}


}
