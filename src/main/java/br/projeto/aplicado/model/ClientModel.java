package br.projeto.aplicado.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Client")
public class ClientModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "login")
	private String loginEmail;

	@Column(name = "password")
	private String password;

	public ClientModel() {

	}

	public ClientModel(Long id, String loginEmail, String password) {
		super();
		this.id = id;
		this.loginEmail = loginEmail;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public String getLoginEmail() {
		return loginEmail;
	}

	public void setLoginEmail(String loginEmail) {
		this.loginEmail = loginEmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
