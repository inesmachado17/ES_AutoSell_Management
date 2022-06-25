package Model;

public class Pedido {
    private String origem;
    private String destino;
    private int quantidade;

    public Pedido(String origem, String destino, int quantidade) {
        this.origem = origem;
        this.destino = destino;
        this.quantidade = quantidade;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "origem='" + origem + '\'' +
                ", destino='" + destino + '\'' +
                ", quantidade=" + quantidade +
                '}';
    }
}
