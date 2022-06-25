package Model;

public class Transacao {
    private String tipo;
    private int nifComprador;
    private int nifVendedor;
    private Matricula matricula;
    private double valor;

    public Transacao(String tipo, int nifComprador, int nifVendedor, Matricula matricula, double valor) {
        this.tipo = tipo;
        this.nifComprador = nifComprador;
        this.nifVendedor = nifVendedor;
        this.matricula = matricula;
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getNifComprador() {
        return nifComprador;
    }

    public void setNifComprador(int nifComprador) {
        this.nifComprador = nifComprador;
    }

    public int getNifVendedor() {
        return nifVendedor;
    }

    public void setNifVendedor(int nifVendedor) {
        this.nifVendedor = nifVendedor;
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
