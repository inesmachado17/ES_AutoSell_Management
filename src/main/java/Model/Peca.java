package Model;

public class Peca {

    private String referencia;
    private String marca;
    private String local;
    private int quantidade;
    private String desingnacao;

    public Peca(String referencia, String marca, String local, int quantidade, String desingnacao) {
        this.referencia = referencia;
        this.marca = marca;
        this.local = local;
        this.quantidade = quantidade;
        this.desingnacao = desingnacao;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getDesingnacao() {
        return desingnacao;
    }

    public void setDesingnacao(String desingnacao) {
        this.desingnacao = desingnacao;
    }

    @Override
    public String toString() {
        return "Peca{" +
                "referencia='" + referencia + '\'' +
                ", marca='" + marca + '\'' +
                ", local='" + local + '\'' +
                ", quantidade=" + quantidade +
                ", desingnacao='" + desingnacao + '\'' +
                '}';
    }
}
