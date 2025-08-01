public class Administrador extends Usuario{
	public Administrador(String nome, String email, String senha){
		super(nome, email, senha);
	}

	@Override
	public boolean autenticar(String senha){
		return senha.equals(getSenha());
	}

	public void redefinirSenha(String novaSenha){
		setSenha(novaSenha);
	}
}