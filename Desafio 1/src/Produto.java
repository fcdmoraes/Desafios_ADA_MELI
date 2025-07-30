public class Produto {
    private int estoque;
    private String nome;
    private double preco;

    public Produto(String nome, double preco, int estoque){
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
    }

    public Produto(String nome, int preco){
        this.nome = nome;
        this.preco = preco;
        this.estoque = 0;
    }

    public void adicionarEstoque(int estoque) {
        this.estoque = estoque;
    }

    public void vender(int quantidade){
        if(this.estoque > quantidade){
            this.estoque -= quantidade;
        }
    }

    public void exibirResumo() {
        System.out.println("Nome: " + this.nome);
        System.out.println("Preço: " + this.preco);
        System.out.println("Estoque : " + this.estoque);
    }
}
