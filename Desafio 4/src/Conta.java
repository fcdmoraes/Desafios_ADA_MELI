public class Conta {
    private String titular;
    private int numero;
    private double saldo;
    private String senha;
    private boolean temporario;

    public Conta(String titular, int numero, double saldo) {
        this.numero = numero;
        this.saldo = saldo;
        this.titular = titular;
        this.temporario = true;
        this.senha = Util.sixDigitRandom();

        System.out.println("Conta criada com sucesso!");
        System.out.println("Número da conta: " + this.numero);
        System.out.println("Senha temporária: " + this.senha);
    }

    public boolean acessaConta(String senha){
        return this.senha.equals(senha);
    }

    public boolean trocaSenha(String novaSenha){
        if (Util.validaSenha(novaSenha)){
            senha = novaSenha;
            return true;
        }
        return false;
    }

    public boolean depositar(double valor){
        if (Util.verificaSaldo(saldo, valor)){
            saldo += valor;
            saldo -= Util.getCustoOperacao();
            return true;
        }
        return false;
    }

    public double getSaldo(){
        return saldo;
    }

    public double getNumero(){
        return numero;
    }

    public String getTitular(){
        return titular;
    }

    public boolean getTemporario() {
        return temporario;
    }

    public void setTemporario() {
        this.temporario = false;
    }
}
