import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ProdutosDB {
    private final Map<Integer, Produto> produtos = new HashMap<>();

    public Produto criarProduto(String nome, double preco, int estoque){
        Produto p = new Produto(nome, preco, estoque);
        produtos.put(p.getItemId(), p);
        return p;
    }
    public Produto criarProduto(String nome, double preco){
        Produto p = new Produto(nome, preco);
        produtos.put(p.getItemId(), p);
        return p;
    }

    public Produto buscarPorId(int id) {
        return produtos.get(id);
    }

    public Collection<Produto> listarTodos() {
        return produtos.values();
    }
}
