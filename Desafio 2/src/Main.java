public class Main {
    public static void main(String[] args) {
        // Criando funcionários
        Funcionario f1 = new Funcionario("Alice", 5);
        Funcionario f2 = new Funcionario("Bruno", 7);
        Funcionario f3 = new Funcionario("Carla", 10);

        // Criando objetos de reembolso
        Reembolso r1 = new Reembolso(f1);
        Reembolso r2 = new Reembolso(f2);
        Reembolso r3 = new Reembolso(f3);

        // Testes
        double total1 = r1.calcularReembolso(100.0, 50.0, 200.0);
        r1.imprimirResumoReembolso(total1);

        double total2 = r2.calcularReembolso(80.0, 40.0);
        r2.imprimirResumoReembolso(total2);

        double total3 = r3.calcularReembolso(120.0, 50.0, 80.0);
        r3.imprimirResumoReembolso(total3);
    }
}