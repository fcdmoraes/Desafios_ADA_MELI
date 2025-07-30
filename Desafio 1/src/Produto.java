public class Produto {
    private static int produtos = 0;

    private final int itemId;
    private int estoque;
    private final String nome;
    private double preco;

    public Produto(String nome, double preco, int estoque){
        this.itemId = produtos++;
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
    }

    public Produto(String nome, double preco){
        this.itemId = produtos++;
        this.nome = nome;
        this.preco = preco;
        this.estoque = 0;
    }

    public void adicionarEstoque(int estoque) {
        this.estoque = estoque;
    }

    public void vender(int quantidade){
        if(estoque > quantidade){
            estoque -= quantidade;
        }
        else{
            System.out.println("Estoque insuficiente");
        }
    }

    public void exibirResumo() {
        System.out.println("Id: " + itemId);
        System.out.println("Nome: " + nome);
        System.out.println("Preço: R$ " + preco);
        System.out.println("Estoque: " + estoque);
    }

    public int getEstoque() {
        return estoque;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getItemId() {
        return itemId;
    }

    public void ajustarPreco(double novoPreco) {
        preco = novoPreco;
    }

    public void ajustarPreco(String reajuste) {
        try {
            String percentual = reajuste.trim()
                    .replace("%", "")
                    .replace(",", ".");
            preco = preco * (1 + Double.parseDouble(percentual) / 100);
        }
        catch (NumberFormatException e) {
            System.out.println("Formato inválido");
        }
    }
}
