public class Sistema{
	static void testeInstanciaAdmin(){
		try{
			new Administrador("nome", "email", "senha");
			System.out.println("instanciação funcionou");
		}
		catch(Exception e){
			System.out.println("falha ao instanciar");
			System.out.println(e.getMessage());

		}
	}

	static void testeRedefinirSenha(){
		Administrador administrador = new Administrador("nome", "email", "senha");
		try{
			admin.redefinirSenha("novaSenha");
			System.out.println("troca de senha funcionou");
		}
		catch(Exception e){
			System.out.println("falha ao redefinir senha");
			System.out.println(e.getMessage());

		}
	}

	static void testeAutenticar(){
		Administrador administrador = new Administrador("nome", "email", "senha");
		try{
			if (admin.autenticar("senha")){
				System.out.println("autentificação positiva funcionou");
			}
			if (!admin.autenticar("novaSenha")){
				System.out.println("autentificação negativa funcionou");
			}
		}
		catch(Exception e){
			System.out.println("falha ao autenticar senha");
			System.out.println(e.getMessage());

		}
	}

	static void testeValidarSenhaForte(){
		try{
			if (!SegurancaUtils.validarSenhaForte("abc1%")){
				System.out.println("teste senha curta funcionou");
			}
			if (!SegurancaUtils.validarSenhaForte("abc%#def")){
				System.out.println("teste senha sem dígito funcionou");
			}
			if (SegurancaUtils.validarSenhaForte("abc1defg")){
				System.out.println("teste senha adequada funcionou");
			}
		}
		catch(Exception e){
			System.out.println("falha ao redefinir senha");
			System.out.println(e.getMessage());
		}
	}

	static void testeAcessaAtributos(){
		Administrador administrador = new Administrador("nome", "email", "senha");
		System.out.println("nome: " + admin.nome);
		System.out.println("email: " + admin.email);
		System.out.println("senha: " + admin.senha);
	}

}

public static void main(String[] args){
	Sistema.testeInstanciaAdmin();
	Sistema.testeRedefinirSenha();
	Sistema.testeAutenticar();
	Sistema.testeValidarSenhaForte();
	Sistema.testeAcessaAtributos();
}