public class Reembolso {
    private final String nomeFuncionario;
    private final int diasTrabalhados;

    public Reembolso(Funcionario funcionario) {
        this.nomeFuncionario = funcionario.getNomeFuncionario();
        this.diasTrabalhados = funcionario.getDiasTrabalhados();
    }

    public double calcularReembolso(double alimentacao, double transporte, double hospedagem){
        return alimentacao + transporte + hospedagem;
    }

    public double calcularReembolso(double alimentacao, double transporte) {
        return alimentacao + transporte;
    }

    public boolean recebeBonus(){
        return diasTrabalhados > 7;
    }

    public double calcularBonus(double valorTotal){
        return recebeBonus() ? (valorTotal * 1.1) : valorTotal;
    }

    public void imprimirResumoReembolso(double valorTotal) {
        double v = calcularBonus(valorTotal);
        System.out.printf("Funcionário: %s - Dias Trabalhados: %d - Reembolso Total: %.2f%n",
                this.nomeFuncionario,
                this.diasTrabalhados,
                v);
    }

}
