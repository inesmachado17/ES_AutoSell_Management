package Model;

public class Veiculo {
    private Matricula matricula;
    private String modelo;
    private String marca;
    private int donoAnterior;
    private String caracteristicas;

    public Veiculo(Matricula matricula, String modelo, String marca, int donoAnterior, String caracteristicas) {
        this.matricula = matricula;
        this.modelo = modelo;
        this.marca = marca;
        this.donoAnterior = donoAnterior;
        this.caracteristicas = caracteristicas;
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getDonoAnterior() {
        return donoAnterior;
    }

    public void setDonoAnterior(int donoAnterior) {
        this.donoAnterior = donoAnterior;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }
}
