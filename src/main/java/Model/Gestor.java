package Model;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Gestor {

    private String[] oficinas = {"Lisboa", "Coimbra", "Leiria", "Porto"};
    private String[] tiposServico = {"Manutenção", "Preparação"};
    private String[] marcasAuto = {"Audi", "Toyota", "Mercedes-Benz", "BMW", "Honda", "Ford", "Hyundai", "Nissan", "Volkswagen", "Porsche", "Opel"};
    private String[] marcasPecas = {"Bosh", "Castrol", "Febi", "ABS", "Ridex", "Mapco", "Vaico", "Brembo", "SKF", "Ate", "Stark", "Mann Filter", "Van Wezel", "Monroe", "NKG", "Sachs", "TRW", "Valeu", "Topran", "Das Original", "SWAG", "Metzger"};

    private LinkedList<Trabalho> trabalhos;
    private LinkedList<Peca> pecas;
    private HashMap<String, LinkedList<Pedido>> pedidos;
    private LinkedList<Veiculo> veiculos;
    private LinkedList<Cliente> clientes;
    private HashMap<String, LinkedList<Transacao>> historicoClientes;

    private LinkedList<Transacao> transacoes;

    public static final int NIF_AUTOSELL = 600026027;
    private static final Gestor instancia = new Gestor();

    public static Gestor getGestor() {
        return instancia;
    }

    private Gestor() {
        this.trabalhos = new LinkedList<>();
        this.pecas = new LinkedList<>();
        this.veiculos = new LinkedList<>();
        this.clientes = new LinkedList<>();

        this.pedidos = new HashMap<>();
        this.historicoClientes = new HashMap<>();
        this.transacoes = new LinkedList<>();

        veiculos.add(new Veiculo(new Matricula("04-ER-22"), "A3", "Audi", 343222334, "5P"));
        veiculos.add(new Veiculo(new Matricula("50-20-RP"), "X3", "BMW", 567229456, "2P"));
        veiculos.add(new Veiculo(new Matricula("05-01-LI"), "Clio", "Renault", 134223452, "4P"));

        trabalhos.add(new Trabalho("Preparação", new Matricula("04-ER-22"), "Leiria", new Data(25, 06, 2022), null));

        pecas.add(new Peca("BS01", "Bosh", "Lisboa", 1, "Oleo para motor"));
        pecas.add(new Peca("C901", "Castrol", "Coimbra", 2, "Correia Distribuição"));
        pecas.add(new Peca("JANTE54", "Febi", "Leiria", 8, "Jantes"));

        clientes.add(new Cliente(230123321, "Pedro Martins", 963325432, "p.martins@gmail.com", "Rua de escola S/N", "2400-000"));
        clientes.add(new Cliente(210329983, "Rosa Maria", 916983323, "rosa.maria@sapo.pt", "Travessa de sto Antonio", "3154-431"));

        LinkedList<Transacao> transacao = new LinkedList<>();
        transacao.add(new Transacao("Compra", NIF_AUTOSELL, 210329983, new Matricula("04-ER-22"), 500.00, null));
        transacao.add(new Transacao("Venda", 210329983, NIF_AUTOSELL, new Matricula("50-20-RP"), 2700.00, null));
        historicoClientes.put("210329983", transacao);

        transacoes.add(new Transacao("Compra", NIF_AUTOSELL, 210329983, new Matricula("04-ER-22"), 500.00, null));
        transacoes.add(new Transacao("Venda", 210329983, NIF_AUTOSELL, new Matricula("50-20-RP"), 2700.00, null));
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

    public String[] getMarcasPecas() {
        return marcasPecas;
    }

    public LinkedList<Trabalho> getTrabalhos() {
        return trabalhos;
    }

    public LinkedList<Peca> getPecas() {
        return pecas;
    }


    //region Transacao
    public LinkedList<Transacao> getTransacoes() {
        return transacoes;
    }

    public boolean existsTransacao(Transacao t) {
        return transacoes.contains(t);
    }

    public void adicionarTransacao(Transacao t) {
        if (t == null)
            return;

        transacoes.add(t);

        LinkedList<Transacao> lt;

        lt = historicoClientes.get(Integer.toString(t.getNifComprador()));
        if (lt == null) {
            lt = new LinkedList<>();
            lt.add(t);
            historicoClientes.put(Integer.toString(t.getNifComprador()), lt);
        } else {
            lt.add(t);
        }

        lt = historicoClientes.get(Integer.toString(t.getNifVendedor()));
        if (lt == null) {
            lt = new LinkedList<>();
            lt.add(t);
            historicoClientes.put(Integer.toString(t.getNifVendedor()), lt);
        } else {
            lt.add(t);
        }
    }

    public void atualizarTransacao(Transacao transacao) {
        if (transacao == null)
            return;

        for (Transacao t : transacoes) {
            if (t.getMatricula().getMatricula().equals(transacao.getMatricula().getMatricula())
                    && t.getNifVendedor() == transacao.getNifVendedor() && t.getNifComprador() == t.getNifComprador()) {
                transacoes.set(transacoes.indexOf(t), transacao);
                break;
            }
        }


        LinkedList<Transacao> lt;

        lt = historicoClientes.get(Integer.toString(transacao.getNifVendedor()));

        if (lt == null)
            lt = historicoClientes.get(Integer.toString(transacao.getNifComprador()));

        for (Transacao t : lt) {
            if (t.getMatricula().getMatricula().equals(transacao.getMatricula().getMatricula())
                    && t.getNifVendedor() == transacao.getNifVendedor() && t.getNifComprador() == t.getNifComprador()) {
                lt.set(lt.indexOf(t), transacao);
                break;
            }
        }
    }

    public void removerTransacao(Transacao transacao) {

        for (Transacao t : transacoes) {
            if (t.getMatricula().getMatricula().equals(transacao.getMatricula().getMatricula())
                    && t.getNifVendedor() == transacao.getNifVendedor() && t.getNifComprador() == t.getNifComprador()) {
                transacoes.remove(t);
                break;
            }
        }

        LinkedList<Transacao> lt;
        lt = historicoClientes.get(Integer.toString(transacao.getNifVendedor()));

        if (lt == null)
            lt = historicoClientes.get(Integer.toString(transacao.getNifComprador()));

        for (Transacao t : lt) {
            if (t.getMatricula().getMatricula().equals(transacao.getMatricula().getMatricula())
                    && t.getNifVendedor() == transacao.getNifVendedor() && t.getNifComprador() == t.getNifComprador()) {
                lt.remove(t);
                break;
            }
        }
    }
    // endregion

    //region Veiculos
    public LinkedList<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void inserirVeiculo(Veiculo veiculo) {
        if (veiculo == null)
            return;

        this.veiculos.add(veiculo);
    }

    public Veiculo getVeiculo(Matricula matricula) {
        Veiculo result = null;
        for (Veiculo v : veiculos) {
            if (v.getMatricula().getMatricula().equals(matricula.getMatricula()))
                result = v;
        }
        return result;
    }

    public void atualizarVeiculo(Veiculo veiculo) {

        if (veiculo == null)
            return;

        for (Veiculo v : veiculos) {
            if (v.getMatricula().getMatricula().equals(veiculo.getMatricula().getMatricula())) {
                veiculos.set(veiculos.indexOf(v), veiculo);
            }
        }
    }

    public void removerVeiculo(String matricula) {
        for (Veiculo v : veiculos) {
            if (v.getMatricula().getMatricula().equals(matricula)) {
                veiculos.remove(v);
            }
        }
    }

    // UPDATE TABLE VEICULOS
    public void atualizaTabelaVeiculos(JTable tabela) {
        String[] colunasVeiculos = {"Matricula", "Marca", "Modelo", "Ano", "Dono Ant.", "N.Donos", "Caracteristicas"};

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
    //endregion

    public void inserirTrabalho(Trabalho trabalho) {
        if (trabalho == null)
            return;
        this.trabalhos.add(trabalho);
    }

    public Trabalho getTrabalho(Matricula matricula) {
        Trabalho result = null;
        for (Trabalho t : trabalhos) {
            if (t.getMatricula().getMatricula().equals(matricula.getMatricula()))
                result = t;
        }
        return result;
    }

    public void atualizarTrabalho(Trabalho trabalho) {

        if (trabalho == null)
            return;

        for (Trabalho t : trabalhos) {
            if (t.getMatricula().getMatricula().equals(trabalho.getMatricula().getMatricula())) {
                trabalhos.set(trabalhos.indexOf(t), trabalho);
            }
        }
    }

    public void removerTrabalho(String matricula) {
        for (Trabalho t : trabalhos) {
            if (t.getMatricula().getMatricula().equals(matricula)) {
                trabalhos.remove(t);
            }
        }
    }

    // UPDATE TABLE OFICINAS
    public void atualizaTabelaOficinas(JTable tabela) {

        String[] colunasTrabalhos = {"Matricula", "Oficina", "Tipo de Serviço", "Data Inicio", "Data Fim"};

        LinkedList<Trabalho> trabalhos = Gestor.getGestor().getTrabalhos();

        DefaultTableModel modelTrabalhos = new DefaultTableModel(colunasTrabalhos, 0);

        for (Trabalho t : trabalhos) {
            modelTrabalhos.addRow(new Object[]{t.getMatricula().getMatricula(), t.getOficina(), t.getTipoTrabalho(), t.getDataInicio(), t.getDataFim()});
        }
        tabela.setModel(modelTrabalhos);
    }

    public void inserirPeca(Peca peca) {
        if (peca == null)
            return;

        this.pecas.add(peca);
    }

    public Peca getPeca(String referencia) {
        Peca result = null;
        for (Peca p : pecas) {
            if (p.getReferencia().equals(referencia))
                result = p;
        }
        return result;
    }

    public void atualizarPeca(Peca peca) {

        if (peca == null)
            return;

        for (Peca p : pecas) {
            if (p.getReferencia().equals(peca.getReferencia())) {
                pecas.set(pecas.indexOf(p), peca);
            }
        }
    }

    public void removerPeca(String referencia) {
        for (Peca p : pecas) {
            if (p.getReferencia().equals(referencia)) {
                trabalhos.remove(p);
            }
        }
    }

    // UPDATE TABLE PECAS
    public void atualizaTabelaPecas(JTable tabela) {

        String[] colunasPecas = {"Referencia", "Marca", "Local", "Quantidade", "Designacao"};

        LinkedList<Peca> pecas = Gestor.getGestor().getPecas();

        DefaultTableModel modelPecas = new DefaultTableModel(colunasPecas, 0);

        for (Peca p : pecas) {
            modelPecas.addRow(new Object[]{p.getReferencia(), p.getMarca(), p.getLocal(), p.getQuantidade(), p.getDesingnacao()});
        }
        tabela.setModel(modelPecas);
    }

    public LinkedList<Pedido> getPedido(String ref) {
        return pedidos.get(ref);
    }

    public void adicionarPedido(String ref, Pedido p) {

        if (p == null)
            return;

        LinkedList<Pedido> result = pedidos.get(ref);

        if (result == null) {
            LinkedList<Pedido> pedidosLista = new LinkedList<>();
            pedidosLista.add(p);
            pedidos.put(ref, pedidosLista);
            return;
        }
        result.add(p);
    }

    public LinkedList<Cliente> getClientes() {
        return clientes;
    }

    public Cliente getCliente(int nif) {
        Cliente result = null;
        for (Cliente c : clientes) {
            if (c.getNif() == nif)
                result = c;
        }
        return result;
    }

    public void inserirCliente(Cliente cliente) {
        if (cliente == null)
            return;

        this.clientes.add(cliente);
    }

    public void atualizarCliente(Cliente cliente) {

        if (cliente == null)
            return;

        for (Cliente c : clientes) {
            if (c.getNif() == cliente.getNif()) {
                clientes.set(clientes.indexOf(c), cliente);
            }
        }
    }

    public void removerCliente(String nif) {
        for (Cliente c : clientes) {
            if (c.getNif() == Integer.parseInt(nif)) {
                clientes.remove(c);
            }
        }
    }

    public LinkedList<Transacao> getTransacoes(String nif) {
        LinkedList<Transacao> transacoes = historicoClientes.get(nif);
        if (transacoes == null)
            return null;
        return transacoes;
    }

    //UPDATE TABELA CLIENTES
    public void atualizaTabelaClientes(JTable tabela) {

        String[] colunasClientes = {"NIF", "Nome", "Telefone", "Email", "Morada", "Cod.Postal"};

        LinkedList<Cliente> clientes = Gestor.getGestor().getClientes();
        DefaultTableModel modelClientes = new DefaultTableModel(colunasClientes, 0);

        for (Cliente c : clientes) {
            modelClientes.addRow(new Object[]{c.getNif(), c.getNome(), c.getTelefone(), c.getEmail(), c.getMorada(), c.getCodPostal()});
        }
        tabela.setModel(modelClientes);
    }

    //UPDATE TABELA HISTORICO_CLIENTES
    public void atualizaTabelaHistoricoClientes(JTable tabelaHistorioCliente, String nif) {

        String[] colunasHistoricoClientes = {"Matricula", "Vendedor", "Comprador", "Valor Compra", "Valor Venda", "Data Trans.", "Colaborador"};
        DefaultTableModel modelHistoricoClientes = new DefaultTableModel(colunasHistoricoClientes, 0);
        tabelaHistorioCliente.setModel(modelHistoricoClientes);

        if (nif == null) {
            modelHistoricoClientes.getDataVector().removeAllElements();
            modelHistoricoClientes.fireTableDataChanged();
            tabelaHistorioCliente.setModel(modelHistoricoClientes);
            return;
        }

        for (Transacao t : historicoClientes.get(nif)) {
            modelHistoricoClientes.addRow(new Object[]{t.getTipo(), t.getNifComprador(), t.getNifVendedor(), t.getMatricula().getMatricula(), t.getValor()});
        }
        tabelaHistorioCliente.setModel(modelHistoricoClientes);
    }

    public void atualizaTabelaTransacoes(JTable tabela) {
        String[] colunasTransacoes = {"Matricula", "Vendedor", "Comprador", "Valor Compra", "Valor Venda", "Data Trans.", "Confirmada"};

        DefaultTableModel modelTransacoes = new DefaultTableModel(colunasTransacoes, 0);

        for (Transacao t : transacoes) {
            modelTransacoes.addRow(new Object[]{
                            t.getMatricula().getMatricula(),
                            Integer.toString(t.getNifVendedor()),
                            Integer.toString(t.getNifComprador()),
                            t.getTipo().equals("Compra") ? Double.toString(t.getValor()) : "",
                            t.getTipo().equals("Venda") ? Double.toString(t.getValor()) : "",
                            t.getDataTransacao() == null ? "" : t.getDataTransacao().toString(),
                            t.getConfirmada() ? "X" : ""
                    }
            );
        }

        tabela.setModel(modelTransacoes);
    }

    public boolean isNIFValido(String dono) {
        if (dono == null)
            return false;

        if (dono.length() != 9)
            return false;
        try {
            int i = Integer.parseInt(dono);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public boolean isContactoValido(String contacto) {
        if (contacto == null)
            return false;
        if (contacto.length() != 9)
            return false;
        return true;
    }

    public boolean isEmailValido(String email) {
        /*Regex para validação matricula inclusivé por ano*/
        Pattern pattern = Pattern.compile("^([\\w-]+(?:\\.[\\w-]+)*)@((?:[\\w-]+\\.)*\\w[\\w-]{0,66})\\.([a-z]{2,6}(?:\\.[a-z]{2})?)$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.find();
    }

}
