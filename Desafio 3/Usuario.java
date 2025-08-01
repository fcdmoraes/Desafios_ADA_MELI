public abstract class Usuario {
	private String senha;
	protected String email;
	public String nome;

	public Usuario(String nome, String email, String senha){
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}

	abstract boolean autenticar(String senha);

	final void exibirUsuario(){
		String message = String.format("Nome: %s%nEmail: %s", nome, email);
		System.out.println(message);
	}

	final String getNome(){
		return nome;
	}

	final String getEmail(){
		return email;
	}

	protected final void setSenha(String novaSenha) {
    	this.senha = novaSenha;
	}

	protected final String getSenha() {
    	return senha;
	}

} 