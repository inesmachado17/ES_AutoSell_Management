package Model;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class Gestor {

    private String[] oficinas = {"Lisboa","Coimbra","Leiria","Porto"};
    private String[] tiposServico = {"Manutenção","Preparação"};
    private String[] marcasAuto = {"Audi","Toyota","Mercedes-Benz","BMW","Honda","Ford","Hyundai","Nissan","Volkswagen","Porsche", "Opel"};
    private String[] marcasPecas = {"Bosh", "Castrol", "Febi","ABS","Ridex","Mapco","Vaico","Brembo","SKF","Ate","Stark","Mann Filter", "Van Wezel", "Monroe","NKG","Sachs","TRW","Valeu","Topran","Das Original","SWAG","Metzger"};
    private LinkedList<Trabalho> trabalhos;
    private LinkedList<Peca> pecas;
    private HashMap<String, LinkedList<Pedido>> pedidos = new HashMap<>();
    private LinkedList<Veiculo> veiculos;

    private static final Gestor instancia = new Gestor();

    public static Gestor getGestor(){
        return instancia;
    }

    private Gestor(){
        this.trabalhos = new LinkedList<>();
        this.pecas = new LinkedList<>();
        this.veiculos = new LinkedList<>();

        veiculos.add(new Veiculo(new Matricula("04-ER-22"), "A3", "Audi", 343222334, "5P"));
        veiculos.add(new Veiculo(new Matricula("50-20-RP"), "X3", "BMW", 567229456, "2P"));
        veiculos.add(new Veiculo(new Matricula("05-01-LI"), "Clio", "Renault", 134223452, "4P"));

        trabalhos.add(new Trabalho("Preparação", new Matricula("04-ER-22"), "Leiria", new Data(25,06,2022), null));

        pecas.add(new Peca("BS01", "Bosh", "Lisboa", 1, "Oleo para motor"));
        pecas.add(new Peca("C901", "Castrol", "Coimbra", 2, "Correia Distribuição"));
        pecas.add(new Peca("JANTE54", "Febi", "Leiria", 8, "Jantes"));
    }

    public String[] getOficinas() {
        return oficinas;
    }

    public String[] getTiposServico() {
        return tiposServico;
    }

    public String[] getMarcasAuto() {
        return marcasAuto;
    }

    public String[] getMarcasPecas(){
        return marcasPecas;
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

        if(veiculo == null)
            return;

        for (Veiculo v: veiculos) {
            if(v.getMatricula().getMatricula().equals(veiculo.getMatricula().getMatricula())){
                veiculos.set(veiculos.indexOf(v), veiculo);
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

    // UPDATE TABLE VEICULOS
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

    public Trabalho getTrabalho(Matricula matricula){
        Trabalho result = null;
        for (Trabalho t: trabalhos) {
            if(t.getMatricula().getMatricula().equals(matricula.getMatricula()))
                result = t;
        }
        return result;
    }

    public void atualizarTrabalho(Trabalho trabalho){

        if(trabalho == null)
            return;

        for (Trabalho t: trabalhos) {
            if(t.getMatricula().getMatricula().equals(trabalho.getMatricula().getMatricula())){
                trabalhos.set(trabalhos.indexOf(t), trabalho);
            }
        }
    }

    public void removerTrabalho(String matricula){
        for (Trabalho t: trabalhos) {
            if(t.getMatricula().getMatricula().equals(matricula)){
                trabalhos.remove(t);
            }
        }
    }

    // UPDATE TABLE OFICINAS
    public void atualizaTabelaOficinas(JTable tabela){

        String[] colunasTrabalhos = {"Matricula","Oficina", "Tipo de Serviço", "Data Inicio", "Data Fim"};

        LinkedList<Trabalho> trabalhos = Gestor.getGestor().getTrabalhos();

        DefaultTableModel modelTrabalhos = new DefaultTableModel(colunasTrabalhos, 0);

        for (Trabalho t : trabalhos) {
            modelTrabalhos.addRow(new Object[]{t.getMatricula().getMatricula(), t.getOficina(), t.getTipoTrabalho(), t.getDataInicio(), t.getDataFim() });
        }
        tabela.setModel(modelTrabalhos);
    }

    public void inserirPeca(Peca peca){
        if(peca == null)
            return;

        this.pecas.add(peca);
    }

    public Peca getPeca(String referencia){
        Peca result = null;
        for (Peca p: pecas) {
            if(p.getReferencia().equals(referencia))
                result = p;
        }
        return result;
    }

    public void atualizarPeca(Peca peca){

        if(peca == null)
            return;

        for (Peca p: pecas) {
            if(p.getReferencia().equals(peca.getReferencia())){
                pecas.set(pecas.indexOf(p), peca);
            }
        }
    }

    public void removerPeca(String referencia){
        for (Peca p: pecas) {
            if(p.getReferencia().equals(referencia)){
                trabalhos.remove(p);
            }
        }
    }

    // UPDATE TABLE PECAS
    public void atualizaTabelaPecas(JTable tabela){

        String[] colunasPecas = {"Referencia","Marca", "Local", "Quantidade", "Designacao"};

        LinkedList<Peca> pecas = Gestor.getGestor().getPecas();

        DefaultTableModel modelPecas = new DefaultTableModel(colunasPecas, 0);

        for (Peca p : pecas) {
            modelPecas.addRow(new Object[]{p.getReferencia(), p.getMarca(), p.getLocal(), p.getQuantidade(), p.getDesingnacao() });
        }
        tabela.setModel(modelPecas);
    }

    public LinkedList<Pedido> getPedido(String ref){
        return pedidos.get(ref);
    }

    public void adicionarPedido(String ref, Pedido p){

        if(p == null)
            return;

        LinkedList<Pedido> result = pedidos.get(ref);

        if(result == null){
            LinkedList<Pedido> pedidosLista = new LinkedList<>();
            pedidosLista.add(p);
            pedidos.put(ref,pedidosLista);
            return;
        }
        result.add(p);
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
