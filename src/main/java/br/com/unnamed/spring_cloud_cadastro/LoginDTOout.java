package br.com.unnamed.spring_cloud_cadastro;

public class LoginDTOout {
	private String acess_token;
	private String token_type;
	private int expires_in;
	private String scope;
	public String getAcess_token() {
		return acess_token;
	}
	public void setAcess_token(String acess_token) {
		this.acess_token = acess_token;
	}
	public String getToken_type() {
		return token_type;
	}
	public void setToken_type(String token_type) {
		this.token_type = token_type;
	}
	public int getExpires_in() {
		return expires_in;
	}
	public void setExpires_in(int expires_in) {
		this.expires_in = expires_in;
	}
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}
}
