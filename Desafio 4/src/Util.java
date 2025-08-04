import java.util.Random;

public class Util {
    private static Random rnd = new Random();
    private static double custoOperacao = 0.5;

//    cria uma senha aleatória de 6 dígitos
    public static String sixDigitRandom() {
        int number = rnd.nextInt(999999); // Generates a number between 0 and 999999
        String sixDigitNumber = String.format("%06d", number); // Formats to 6 digits, padding with leading zeros
        return sixDigitNumber;
    }

//    verifica se uma senha é composta por seis dígitos numéricos
    public static boolean validaSenha(String senha) {
        if (senha == null) return false;
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
