import java.util.Scanner;

public class GUI {
    private final Scanner scanner;
    private final GerenciadorContas repositorio;

    public GUI() {
        this.scanner = new Scanner(System.in);
        this.repositorio = new GerenciadorContas();
    }

    public void executarInterface(){
        while(true){
            menuAcesso();
            int opcao = lerInput();
            switch (opcao) {
                case 1 -> cadastrarConta();
                case 2 -> acessarConta();
                case 0 -> {
                    System.out.println("Encerrando o programa...");
                    return;
                }
                default -> System.out.println("opção inválida");
            }
        }
    }

    private void acessarConta() {
        System.out.println("Digite o numero conta: ");
        int numero = Integer.parseInt(scanner.nextLine());
        System.out.println("Digite a senha da conta: ");
        Conta conta = repositorio.acessarConta(numero,scanner.nextLine());
        if (conta != null) {
            if (conta.getTemporario()){
                atualizarSenha(conta);
            }
            while (true) {
                menuDaConta();
                int opcao = lerInput();
                switch (opcao) {
                    case 1 -> depositar(conta);
                    case 2 -> sacar(conta);
                    case 3 -> transferir(conta);
                    case 4 -> pagar(conta);
                    case 0 -> {
                        System.out.println("Saindo da conta");
                        return;
                    }
                    default -> System.out.println("opção inválida");
                }
            }
        }
    }

    private void cadastrarConta() {
        System.out.println("Digite o nome do titular da conta: ");
        String titular = scanner.nextLine();
        System.out.println("Digite o valor para depositar na conta: ");
        try {
            double saldo = Double.parseDouble(scanner.nextLine());
            Conta conta = repositorio.criarConta(titular, saldo);
        }
        catch (NumberFormatException e) {
            System.out.println("Valor inválido");
        }
    }

    private int lerInput() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Opção inválida");
            return -1;
        }
    }

    public void menuAcesso(){
        System.out.println("\n==== MENU ====");
        System.out.println("1. Cadastrar conta");
        System.out.println("2. Acessar conta");
        System.out.println("0. Sair");
    }

    public void menuDaConta(){
        System.out.println("\n==== MENU ====");
        System.out.println("1. Depositar");
        System.out.println("2. Sacar");
        System.out.println("3. Transferir");
        System.out.println("4. Pagar");
        System.out.println("0. Sair");
    }

    public void depositar(Conta conta){
        System.out.println("Digite o valor para depositar na conta: ");
        try {
            double valor = Double.parseDouble(scanner.nextLine());
            repositorio.depositar(conta, valor);
            System.out.println(conta.getSaldo());
        } catch (NumberFormatException e) {
            System.out.println("Valor inválido");
        }
    }

    public void sacar(Conta conta){
        System.out.println("Digite o valor para sacar na conta: ");
        try {
            double valor = Double.parseDouble(scanner.nextLine());
            repositorio.sacar(conta, valor);
            System.out.println(conta.getSaldo());
        } catch (NumberFormatException e) {
            System.out.println("Valor inválido");
        }
    }

    public void transferir(Conta conta){
        try {
            System.out.println("Digite o número da conta para qual quer transferir: ");
            int numero = Integer.parseInt(scanner.nextLine());
            System.out.println("Digite o valor a ser transferido: ");
            double valor = Double.parseDouble(scanner.nextLine());
            repositorio.transferir(conta, numero, valor);
            System.out.println(conta.getSaldo());
        }
        catch (NumberFormatException e) {
            System.out.println("Entrada inválida");
        }
    }

    public void pagar(Conta conta){
        System.out.println("Digite o valor da conta: ");
        try {
            double valor = Double.parseDouble(scanner.nextLine());
            repositorio.pagar(conta, valor);
            System.out.println(conta.getSaldo());
        } catch (NumberFormatException e) {
            System.out.println("Valor inválido");
        }
    }

    public void atualizarSenha(Conta conta){
        System.out.println("Como é a primeira vez que você acessa essa conta, precisa atualizar sua senha");
        while (true) {
            System.out.println("Digite a nova senha: ");
            String senha = scanner.nextLine();
            if(repositorio.atualizarConta(conta, senha)){
                break;
            };
        }
    }
}
