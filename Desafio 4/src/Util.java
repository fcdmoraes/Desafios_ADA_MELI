import java.util.Random;

public class Util {
    private final static Random rnd = new Random();
    private final static double custoOperacao = 0.5;

//    cria uma senha aleatória de 6 dígitos
    public static String sixDigitRandom() {
        int numero = rnd.nextInt(999999);
        return String.format("%06d", numero);
    }

//    verifica se uma senha é composta por seis dígitos numéricos
    public static boolean validaSenha(String senha) {
        return senha != null && senha.matches("\\d{6}");
    }

//    confere se saldo é maior que 0.5
    public static boolean verificaSaldo(double saldo) {
        return saldo >= custoOperacao;
    }

    public static boolean verificaSaldo(double saldo, double valor) {
        return saldo+valor >= custoOperacao;
    }

    public static double getCustoOperacao() {
        return custoOperacao;
    }
}
