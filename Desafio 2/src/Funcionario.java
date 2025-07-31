public class Funcionario {
    private final String nomeFuncionario;
    private int diasTrabalhados;

    public Funcionario(String nomeFuncionario, int diasTrabalhados) {
        this.nomeFuncionario = nomeFuncionario;
        this.diasTrabalhados = diasTrabalhados;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public int getDiasTrabalhados() {
        return diasTrabalhados;
    }

    public void setDiasTrabalhados(int diasTrabalhados) {
        this.diasTrabalhados = diasTrabalhados;
    }
}
