package Model;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.LinkedList;

public class Gestor {

    private LinkedList<Trabalho> trabalhos;
    private LinkedList<Peca> pecas;
    private LinkedList<Veiculo> veiculos;

    private static final Gestor instancia = new Gestor();

    public static Gestor getGestor(){
        return instancia;
    }

    private Gestor(){
        this.trabalhos = new LinkedList<>();
        this.pecas = new LinkedList<>();
        this.veiculos = new LinkedList<>();
    }

    public LinkedList<Trabalho> getTrabalhos() {
        return trabalhos;
    }

    public LinkedList<Peca> getPecas() {
        return pecas;
    }

    public LinkedList<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void inserirVeiculo(Veiculo veiculo){
        if(veiculo == null)
            return;

        this.veiculos.add(veiculo);
    }

    public Veiculo getVeiculo(Matricula matricula){
        Veiculo result = null;
        for (Veiculo v: veiculos) {
            if(v.getMatricula().getMatricula().equals(matricula.getMatricula()))
                result = v;
        }
        return result;
    }

    public void atualizarVeiculo(Veiculo veiculo){
        for (Veiculo v: veiculos) {
            if(v.getMatricula().getMatricula().equals(veiculo.getMatricula().getMatricula())){
               veiculos.remove(v);
               veiculos.add(veiculo);
            }
        }
    }

    public void removerVeiculo(String matricula){
        for (Veiculo v: veiculos) {
            if(v.getMatricula().getMatricula().equals(matricula)){
                veiculos.remove(v);
            }
        }
    }

    // UPDATE TABLES
    public void atualizaTabelaVeiculos(JTable tabela){
        String[] colunasVeiculos = {"Matricula","Marca", "Modelo", "Ano", "Dono Ant.", "N.Donos", "Caracteristicas"};

        LinkedList<Veiculo> veiculos = Gestor.getGestor().getVeiculos();

        /*
        Object[][] dataVeiculos = {{"04-ER-22", "Audi", "A3", "2000","212543987","1", "3P Preto"},
                           {"50-35-LI", "BMW", "320", "1999","234765437","2", "5P Branco"},
                           {"65-RD-15", "Opel", "Corsa", "1998","210454772","1", "Comercial Azul Escuro"},
                           {"52-23-FT","Renault", "Megane", "2007","218656098","3", "2P Cinza"},
                           {"01-XS-87","Tesla", "Y", "2019","119223223","2", "5P Preto - Electrico"}};

        */

        DefaultTableModel modelVeiculos = new DefaultTableModel(colunasVeiculos, 0);

        for (Veiculo v : veiculos) {
            modelVeiculos.addRow(new Object[]{v.getMatricula().getMatricula(), v.getMarca(), v.getModelo(), "", v.getDonoAnterior(), "", v.getCaracteristicas()});
        }
        tabela.setModel(modelVeiculos);
    }

    public void inserirTrabalho(Trabalho trabalho){
        if(trabalho == null)
            return;

        this.trabalhos.add(trabalho);
    }

    public void inserirPeca(Peca peca){
        if(peca == null)
            return;

        this.pecas.add(peca);
    }

    public boolean isDonoAnteriorValido(String dono){
        if(dono == null)
            return false;

        if(dono.length() != 9)
            return false;
        try {
            int i = Integer.parseInt(dono);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

}
