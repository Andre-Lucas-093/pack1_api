package br.projeto.aplicado.dto;

public class ClientDTO {

	private String loginEmail;

	private String password;
	
	public ClientDTO() {
		
	}

	public ClientDTO(String loginEmail, String password) {
		super();
		this.loginEmail = loginEmail;
		this.password = password;
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
