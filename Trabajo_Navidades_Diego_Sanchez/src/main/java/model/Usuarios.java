package model;
// Generated 18 dic 2023 18:29:18 by Hibernate Tools 6.3.1.Final

/**
 * Usuarios generated by hbm2java
 */
public class Usuarios implements java.io.Serializable {

	private Integer id;
	private String username;
	private String contrasena;
	private String email;
	private Juegos juegos;
	private Clientes clientes;

	public Usuarios() {
	}

	public Usuarios(String username, String contrasena, String email, Juegos juegos, Clientes clientes) {
		this.username = username;
		this.contrasena = contrasena;
		this.email = email;
		this.juegos = juegos;
		this.clientes = clientes;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getContrasena() {
		return this.contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Juegos getJuegos() {
		return this.juegos;
	}

	public void setJuegos(Juegos juegos) {
		this.juegos = juegos;
	}

	public Clientes getClientes() {
		return this.clientes;
	}

	public void setClientes(Clientes clientes) {
		this.clientes = clientes;
	}

}
