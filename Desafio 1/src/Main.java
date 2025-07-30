public class Main {
    public static void main(String[] args) {
        Produto p1 = new Produto("chocolate",9.80,100);
        p1.exibirResumo();
        p1.vender(98);
        p1.exibirResumo();
        p1.vender(10);
        p1.exibirResumo();
    }
}