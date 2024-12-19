package controller;

public class UsuarioController {

	private String loguin;
	private char[] senha;

	public String getLoguin() {
		return loguin;
	}

	public void setLoguin(String loguin) {
		this.loguin = loguin;
	}

	public char[] getSenha() {
		return senha;
	}

	public void setSenha(char[] senha) {
		this.senha = senha;
	}

	public boolean validarLogin() {

		if (loguin == null || loguin.isEmpty()) {
			return false;
		}

		if (!loguin.endsWith("@gmail.com")) {
			return false;
		}

		if (senha.length < 8) {
			return false;
		}

		return true;
	}

}
