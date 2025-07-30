import java.util.Scanner;

public class InterfaceComsole {
    private final Scanner scanner;
    private final ProdutosDB repositorio;

    public InterfaceComsole(){
        scanner = new Scanner(System.in);
        repositorio = new ProdutosDB();
    }

    public void executarInterface(){
        while(true){
            menuInicial();
            int opcao = lerInput();
            switch (opcao){
                case 1 -> cadastrarProduto();
                case 2 -> verProduto();
                case 3 -> venderProduto();
                case 4 -> adicionarEstoque();
//                case 5 -> cadastrarProduto();
                case 0 -> {
                    System.out.println("Encerrando o programa...");
                    return;
                }
                default -> System.out.println("opção inválida");

            }
        }
    }

    public void menuInicial(){
        System.out.println("\n==== MENU ====");
        System.out.println("1. Cadastrar novo produto");
        System.out.println("2. Ver produto");
        System.out.println("3. Vender produto");
        System.out.println("4. Adicionar estoque");
//        System.out.println("5. Ajustar preço");
        System.out.println("0. Sair");

        System.out.print("Escolha uma opção: ");
    }

    private int lerInput() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Opção inválida");
            return -1;
        }
    }

    private void cadastrarProduto() {
        System.out.print("Nome do produto: ");
        String nome = scanner.nextLine();

        System.out.print("Preço: ");
        double preco = Double.parseDouble(scanner.nextLine());

        System.out.print("Itens em estoque: ");
        String estoque = scanner.nextLine();
        Produto p;
        if (estoque.isEmpty())
            p = repositorio.criarProduto(nome, preco);
        else
            p = repositorio.criarProduto(nome, preco, Integer.parseInt(estoque));
        System.out.println("Produto cadastrado com o id " + p.getItemId());
    }

    private void verProduto(){
        System.out.print("Digite o ID do produto: ");
        try {
            int id = Integer.parseInt(scanner.nextLine());
            Produto p = repositorio.buscarPorId(id);
            p.exibirResumo();
        } catch (NumberFormatException e) {
            System.out.println("ID inválido");
        } catch (NullPointerException e) {
            System.out.println("item não encontrado");
        }
    }

    private void venderProduto(){
        System.out.print("Digite o ID do produto: ");
        try {
            int id = Integer.parseInt(scanner.nextLine());
            Produto p = repositorio.buscarPorId(id);
            System.out.print("Digite a quantidade do produto a ser vendida: ");
            int quantidade = Integer.parseInt(scanner.nextLine());
            p.vender(quantidade);
            p.exibirResumo();
        } catch (NumberFormatException e) {
            System.out.println("valor inválido para ID ou quantidade");
        } catch (NullPointerException e) {
            System.out.println("item não encontrado");
        }
    }

    private void adicionarEstoque(){
        System.out.print("Digite o ID do produto: ");
        try {
            int id = Integer.parseInt(scanner.nextLine());
            Produto p = repositorio.buscarPorId(id);
            System.out.print("Digite a quantidade do produto a ser adicionada: ");
            int quantidade = Integer.parseInt(scanner.nextLine());
            p.adicionarEstoque(quantidade);
            p.exibirResumo();
        } catch (NumberFormatException e) {
            System.out.println("valor inválido para ID ou quantidade");
        } catch (NullPointerException e) {
            System.out.println("item não encontrado");
        }
    }
    public static void main(String[] args){
        InterfaceComsole comsole =  new InterfaceComsole();
        comsole.executarInterface();
    }
}