import java.util.HashMap;
import java.util.Map;

public class GerenciadorContas {
    private final Map<Integer, Conta> contas = new HashMap<>();
    private int contador = 0;

    public GerenciadorContas(){}

    public Conta criarConta(String titular, double saldo){
        if (saldo >=0) {
            Conta conta = new Conta(titular, contador, saldo);
            contas.put(contador, conta);
            contador++;
            return conta;
        }
        return null;
    }

    private Conta buscaPorNumero(int numero){
        return contas.get(numero);
    }

    public Conta acessarConta(int numero, String senha){
        Conta conta = buscaPorNumero(numero);
        if (conta == null){
            System.out.println("número de conta inválido");
            return null;
        }
        if (conta.acessaConta(senha)){
            System.out.println("Conta acessada com sucesso");
            return conta;
        }
        System.out.println("senha inválida");
        return null;
    }

    public void depositar(Conta conta, double valor){
        if (conta.depositar(valor)){
            System.out.println("Deposito realizado com sucesso");
        }
        else{
            System.out.println("Valor insuficiente para depósito");
        }
    }

    public void sacar(Conta conta, double valor){
        if (conta.depositar(-valor)){
            System.out.println("Saque realizado com sucesso");
        }
        else{
            System.out.println("Saldo insuficiente para saque");
        }
    }

    public void transferir(Conta conta, int numero, double valor){
        Conta contaDestino = buscaPorNumero(numero);
        if (contaDestino == null){
            System.out.println("número de conta inválido");
        }
        else {
            if (conta.depositar(-valor)) {
                contaDestino.depositar(valor);
                System.out.println("Transferência realizada com sucesso");
            } else {
                System.out.println("saldo insuficiente para realizar transferencia");
            }
        }
    }

    public void pagar(Conta conta, double valor){
        if (conta.depositar(-valor)){
            System.out.println("Pagamento realizado com sucesso");
        }
        else{
            System.out.println("Saldo insuficiente para pagamento");
        }
    }

    public boolean atualizarConta(Conta conta, String novaSenha){
        if (conta.trocaSenha(novaSenha)){
            System.out.println("Senha atualizada com sucesso");
            conta.setTemporario();
            return true;
        }
        else{
            System.out.println("Senha inválida. A senha deve conter exatamente 6 dígitos numéricos");
            return false;
        }
    }
}
