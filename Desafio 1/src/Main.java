public class Main {
    public static void main(String[] args) {
        // Criando produto com estoque zero
        Produto p1 = new Produto("Caderno", 15.90);
        p1.exibirResumo();

        // Adicionando estoque
        p1.adicionarEstoque(10);
        p1.exibirResumo();

        // Tentando vender mais do que o estoque
        p1.vender(15); // deve falhar
        p1.vender(5);  // deve funcionar
        p1.exibirResumo();

        // Reajustando preço com valor direto
        p1.ajustarPreco(17.50);
        p1.exibirResumo();

        // Reajustando preço com porcentagem
        p1.ajustarPreco("10%");
        p1.exibirResumo();

        // Criando produto com estoque inicial definido
        Produto p2 = new Produto("Caneta", 3.50, 20);
        p2.exibirResumo();
    }
}
