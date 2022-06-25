package Model;

public class Trabalho {
    private String tipoTrabalho;
    private Matricula matricula;
    private String oficina;
    private Data dataInicio;
    private Data dataFim;

    public Trabalho(String tipoTrabalho, Matricula matricula, String oficina, Data dataInicio, Data dataFim) {
        this.tipoTrabalho = tipoTrabalho;
        this.matricula = matricula;
        this.oficina = oficina;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public String getTipoTrabalho() {
        return tipoTrabalho;
    }

    public void setTipoTrabalho(String tipoTrabalho) {
        this.tipoTrabalho = tipoTrabalho;
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

    public String getOficina() {
        return oficina;
    }

    public void setOficina(String oficina) {
        this.oficina = oficina;
    }

    public Data getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Data dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Data getDataFim() {
        return dataFim;
    }

    public void setDataFim(Data dataFim) {
        this.dataFim = dataFim;
    }
}
