package org.mvc.security.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
//https://howtoprogramwithjava.com/hibernate-manytomany-unidirectional-bidirectional/
//https://hellokoding.com/registration-and-login-example-with-spring-xml-configuration-maven-jsp-and-mysql/
//http://websystique.com/spring-security/spring-security-4-role-based-login-example/
//https://stackoverflow.com/questions/33205236/spring-security-added-prefix-role-to-all-roles-name
//https://stackoverflow.com/questions/19525380/difference-between-role-and-grantedauthority-in-spring-security
//http://en.tekstenuitleg.net/blog/spring-security-with-roles-and-rights
//http://viralpatel.net/blogs/spring-mvc-multi-row-submit-java-list/

//https://stackoverflow.com/questions/6893061/how-to-dynamically-decide-intercept-url-access-attribute-value-in-spring-secur
//https://github.com/srinivas1918/spring-security-dynamic-authorization-and-authentication
//https://stackoverflow.com/questions/8321696/creating-new-roles-and-permissions-dynamically-in-spring-security-3
//https://stackoverflow.com/questions/6893061/how-to-dynamically-decide-intercept-url-access-attribute-value-in-spring-secur
//https://stackoverflow.com/questions/8321696/creating-new-roles-and-permissions-dynamically-in-spring-security-3
////http://www.c-sharpcorner.com/UploadFile/919746/creating-new-user-login-in-sql-server-2014/
//https://stackoverflow.com/questions/20923015/login-to-microsoft-sql-server-error-18456

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	@Transient
	private String passwordConfirm;

	@ManyToMany(cascade = CascadeType.ALL, fetch =FetchType.EAGER)
	@JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private List<Role> roles;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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
		this.password = password;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

}
