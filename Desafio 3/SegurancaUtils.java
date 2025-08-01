public class SegurancaUtils{
	public static boolean validarSenhaForte(String senha){
		if (senha == null) return false;
        return senha.length() > 8 && senha.matches(".*\\d.*");
	}
}