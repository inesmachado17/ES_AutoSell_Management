package Model;

public class Cliente {
    private String nome;
    private int nif;
    private int telefone;
    private String email;
    private String morada;
    private String codPostal;

    public Cliente( int nif, String nome, int telefone, String email, String morada, String codPostal) {
        this.nome = nome;
        this.nif = nif;
        this.telefone = telefone;
        this.email = email;
        this.morada = morada;
        this.codPostal = codPostal;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNif() {
        return nif;
    }

    public void setNif(int nif) {
        this.nif = nif;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public String getCodPostal() {
        return codPostal;
    }

    public void setCodPostal(String codPostal) {
        this.codPostal = codPostal;
    }
}
