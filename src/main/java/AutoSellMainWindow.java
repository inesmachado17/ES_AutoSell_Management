import Model.Gestor;
import Model.Transacao;
import Model.Veiculo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;

public class AutoSellMainWindow extends JFrame{

    private JTabbedPane tabbedPane1;
    private JPanel mainPainel;
    private JRadioButton rdVeiculoMatricula;
    private JRadioButton rdVeiculoMarca;
    private JTextField txtVeiculosPesquisa;
    private JButton veiculoPesquisarButton;
    private JTable tabelaVeiculos;
    private JButton veiculoInserirButton;
    private JButton veiculoEditarButton;
    private JButton veiculoEliminarButton;
    private JButton transacaoPesquisarButton;
    private JButton transacaoInserirButton;
    private JButton transacaoEditarButton;
    private JButton transacaoEliminarButton;
    private JTable tabelaTrasacoes;
    private JButton oficinaInserirButton;
    private JButton oficinaEditarButton;
    private JButton oficinaEliminarButton;
    private JTable tabelaOficinas;
    private JButton inserirButton;
    private JButton editarButton;
    private JButton eliminarButton;
    private JTable tabelaPecas;
    private JButton btnPedirPeca;
    private JRadioButton rdTransportesMatricula;
    private JRadioButton rdTransportesLocal;
    private JTextField txtTransportesPesquisa;
    private JButton transportesPesquisaButton;
    private JTable tabelaTransportes;
    private JButton inserirButton1;
    private JButton transportesCancelar;
    private JButton editarButton1;
    private JComboBox cbEstatisticas;
    private JRadioButton rdClientesNome;
    private JRadioButton rdClientesNIF;
    private JTextField txtClientesPesquisa;
    private JButton clientesPesquisaButton;
    private JButton inserirClienteButton;
    private JButton eliminarClienteButton;
    private JButton editarClienteButton;
    private JTable tabelaClientes;
    private JTable tabelaHistorioCliente;
    private JPanel painelClientes;
    private JRadioButton rdEventoNome;
    private JTextField txtEventosPesquisa;
    private JRadioButton rdEventoLocal;
    private JButton eventosPesquisaButton;
    private JButton inserirEventoButton;
    private JButton eliminarEventoButton;
    private JButton editarEventoButton;
    private JTable tabelaEventos;
    private JTable tabelaVeiculosEventos;
    private JRadioButton rdTranscacoesMatricula;
    private JRadioButton rdTransacoesCliente;
    private JRadioButton rdOficinasMatricula;
    private JRadioButton rdOficinasOficina;
    private JRadioButton rdPecasRef;
    private JRadioButton rdPecasDesig;
    private JTextField txtTranscacoesPesquisa;
    private JTextField txtOficinasPesquisa;
    private JButton oficinasPesquisaButton;
    private JButton pecasPesquisaButton;
    private JTextField txtPecasPesquisa;
    private JButton btnAtualizarTabVeiculos;
    private JButton transportesConfirmar;
    private static JFrame autoSellMainFrame;

    public AutoSellMainWindow() {

        /* VEICULOS PAINEL */
        //region veiculos
        ButtonGroup grupoVeiculos = new ButtonGroup();
        grupoVeiculos.add(rdVeiculoMatricula);
        grupoVeiculos.add(rdVeiculoMarca);

        Gestor.getGestor().atualizaTabelaVeiculos(tabelaVeiculos);

        veiculoInserirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AutoSellVeiculosInserir(AutoSellMainWindow.this, tabelaVeiculos);
            }
        });

        veiculoEditarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(tabelaVeiculos.getSelectionModel().isSelectionEmpty()) {
                    //System.out.println("Nenhuma linha selcionada");
                    JOptionPane.showMessageDialog(autoSellMainFrame, "Tem de escolher uma linha");
                    return;
                }
                new AutoSellVeiculosEditar(AutoSellMainWindow.this, tabelaVeiculos);

            }
        });
        veiculoEliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(tabelaVeiculos.getSelectionModel().isSelectionEmpty()){
                    //System.out.println("Nenhuma linha selcionada");
                    JOptionPane.showMessageDialog(autoSellMainFrame, "Tem de escolher uma linha");
                    return;
                }

                int result = JOptionPane.showConfirmDialog(autoSellMainFrame,"Tem a certeza?", "Eliminar Entrada",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
                if(result == JOptionPane.YES_OPTION){
                    Gestor.getGestor().removerVeiculo(tabelaVeiculos.getValueAt(tabelaVeiculos.getSelectedRow(), 0).toString());
                    Gestor.getGestor().atualizaTabelaVeiculos(tabelaVeiculos);
                }
            }
        });

        veiculoPesquisarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (grupoVeiculos.getSelection() == null)
                {
                    JOptionPane.showMessageDialog(autoSellMainFrame, "Por favor escolha um critério de pesquisa.");
                    return;
                }
                if(txtVeiculosPesquisa.getText().equals("")){
                    JOptionPane.showMessageDialog(autoSellMainFrame, "Por favor preencha o campo pesquisa.");
                    return;
                }
            }
        });
        //endregion

        /* TRANSACOES PAINEL */
        //region transacoes
        ButtonGroup grupoTransacoes = new ButtonGroup();
        grupoTransacoes.add(rdTransacoesCliente);
        grupoTransacoes.add(rdTranscacoesMatricula);

        Gestor.getGestor().atualizaTabelaOficinas(tabelaOficinas);

        /*
        String[] colunasTransacoes = {"Matricula","Vendedor", "Comprador", "Valor Compra", "Valor Venda", "Data Trans.","Confirmada", "Colaborador"};
        Object[][] dataTransacoes = {{"04-ER-22", "239223112", "503630330", "1500","","05/05/2022", "X", "1"},
                {"50-35-LI", "503630330", "210322667", "","1750","15/05/2022", "","121"}};

        DefaultTableModel modelTransacoes = new DefaultTableModel(colunasTransacoes, 0);

        for (Object[] item : dataTransacoes) {
            modelTransacoes.addRow(item);
        }
        tabelaTrasacoes.setModel(modelTransacoes);

        */

        transacaoInserirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AutoSellTransacoesInserir inserir = new AutoSellTransacoesInserir();
            }
        });
        transacaoEditarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(tabelaTrasacoes.getSelectionModel().isSelectionEmpty()) {
                    //System.out.println("Nenhuma linha selcionada");
                    JOptionPane.showMessageDialog(autoSellMainFrame, "Tem de escolher uma linha");
                    return;
                }

                AutoSellTransacoesEditar editar = new AutoSellTransacoesEditar(tabelaTrasacoes);
            }
        });
        transacaoEliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(tabelaTrasacoes.getSelectionModel().isSelectionEmpty()) {
                    //System.out.println("Nenhuma linha selcionada");
                    JOptionPane.showMessageDialog(autoSellMainFrame, "Tem de escolher uma linha");
                    return;
                }

                int result = JOptionPane.showConfirmDialog(autoSellMainFrame,"Tem a certeza?", "Eliminar Entrada",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
                if(result == JOptionPane.YES_OPTION){
                    DefaultTableModel model = (DefaultTableModel) tabelaTrasacoes.getModel();
                    model.removeRow(tabelaTrasacoes.getSelectedRow());
                }

            }
        });

        transacaoPesquisarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (grupoTransacoes.getSelection() == null)
                {
                    JOptionPane.showMessageDialog(autoSellMainFrame, "Por favor escolha um critério de pesquisa.");
                    return;
                }
                if(txtTranscacoesPesquisa.getText().equals("")){
                    JOptionPane.showMessageDialog(autoSellMainFrame, "Por favor preencha o campo pesquisa.");
                    return;
                }
            }
        });
        //endregion

        /* OFICINAS PAINEL */
        //region oficinas
        ButtonGroup grupoOficinas = new ButtonGroup();
        grupoOficinas.add(rdOficinasOficina);
        grupoOficinas.add(rdOficinasMatricula);

        Gestor.getGestor().atualizaTabelaOficinas(tabelaOficinas);
        /*
        String[] colunasOficinas = {"Matricula","Oficina", "Tipo de Serviço", "Data Inicio", "Data Fim"};
        Object[][] dataOficinas = {{"04-ER-22", "Lisboa", "Manutenção", "02/05/2022", ""},
                                    {"50-35-LI", "Leiria", "Manutenção", "02/05/2022", ""},
                                    {"65-RD-15", "Lisboa", "Preparação", "03/05/2022","05/05/2022"}};

        DefaultTableModel modelOficinas = new DefaultTableModel(colunasOficinas, 0);

        for (Object[] item : dataOficinas) {
            modelOficinas.addRow(item);
        }
        tabelaOficinas.setModel(modelOficinas);
        */

        oficinaInserirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AutoSellOficinasInserir(AutoSellMainWindow.this, tabelaOficinas);
            }
        });
        oficinaEditarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(tabelaOficinas.getSelectionModel().isSelectionEmpty()) {
                    //System.out.println("Nenhuma linha selcionada");
                    JOptionPane.showMessageDialog(autoSellMainFrame, "Tem de escolher uma linha");
                    return;
                }
                new AutoSellOficinasEditar(AutoSellMainWindow.this, tabelaOficinas);
            }
        });
        oficinaEliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(tabelaOficinas.getSelectionModel().isSelectionEmpty()) {
                    //System.out.println("Nenhuma linha selcionada");
                    JOptionPane.showMessageDialog(autoSellMainFrame, "Tem de escolher uma linha");
                    return;
                }

                int result = JOptionPane.showConfirmDialog(autoSellMainFrame,"Tem a certeza?", "Eliminar Entrada",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
                if(result == JOptionPane.YES_OPTION){
                    Gestor.getGestor().removerTrabalho(tabelaOficinas.getValueAt(tabelaOficinas.getSelectedRow(), 0).toString());
                    Gestor.getGestor().atualizaTabelaOficinas(tabelaOficinas);
                }

            }
        });

        oficinasPesquisaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (grupoOficinas.getSelection() == null)
                {
                    JOptionPane.showMessageDialog(autoSellMainFrame, "Por favor escolha um critério de pesquisa.");
                    return;
                }
                if(txtOficinasPesquisa.getText().equals("")){
                    JOptionPane.showMessageDialog(autoSellMainFrame, "Por favor preencha o campo pesquisa.");
                    return;
                }
            }
        });
        //endregion

        /* PEÇAS PAINEL */
        //region pecas
        ButtonGroup grupoPecas = new ButtonGroup();
        grupoPecas.add(rdPecasDesig);
        grupoPecas.add(rdPecasRef);

        /*
        String[] colunasPecas = {"Referencia","Designação", "Marca", "Local", "Qtd.", "Qtd. Min."};
        Object[][] dataPecas = {{"99321", "Oleo para Motor 1L", "Bosh", "Lisboa", "2", "1"},
                                {"CM900", "Correia para Motor", "Audi", "Leiria", "4","2"}};

        DefaultTableModel modelPecas = new DefaultTableModel(colunasPecas, 0);

        for (Object[] item : dataPecas) {
            modelPecas.addRow(item);
        }
        tabelaPecas.setModel(modelPecas);

        */

        Gestor.getGestor().atualizaTabelaPecas(tabelaPecas);

        inserirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AutoSellPecasInserir(AutoSellMainWindow.this, tabelaPecas);
            }
        });

        editarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(tabelaPecas.getSelectionModel().isSelectionEmpty()) {
                    //System.out.println("Nenhuma linha selcionada");
                    JOptionPane.showMessageDialog(autoSellMainFrame, "Tem de escolher uma linha");
                    return;
                }
                new AutoSellPecasEditar(AutoSellMainWindow.this, tabelaPecas);
            }
        });

        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(tabelaPecas.getSelectionModel().isSelectionEmpty()) {
                    //System.out.println("Nenhuma linha selcionada");
                    JOptionPane.showMessageDialog(autoSellMainFrame, "Tem de escolher uma linha");
                    return;
                }

                int result = JOptionPane.showConfirmDialog(autoSellMainFrame,"Tem a certeza?", "Eliminar Entrada",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
                if(result == JOptionPane.YES_OPTION){
                    Gestor.getGestor().removerPeca(tabelaPecas.getValueAt(tabelaPecas.getSelectedRow(), 0).toString());
                    Gestor.getGestor().atualizaTabelaPecas(tabelaPecas);
                }

            }
        });

        btnPedirPeca.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(tabelaPecas.getSelectionModel().isSelectionEmpty()) {
                    //System.out.println("Nenhuma linha selcionada");
                    JOptionPane.showMessageDialog(autoSellMainFrame, "Tem de escolher uma linha");
                    return;
                }
                new AutoSellPecasPedir(AutoSellMainWindow.this, tabelaPecas);
            }
        });

        pecasPesquisaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (grupoPecas.getSelection() == null)
                {
                    JOptionPane.showMessageDialog(autoSellMainFrame, "Por favor escolha um critério de pesquisa.");
                    return;
                }
                if(txtPecasPesquisa.getText().equals("")){
                    JOptionPane.showMessageDialog(autoSellMainFrame, "Por favor preencha o campo pesquisa.");
                    return;
                }
            }
        });
        //endregion

        /* TRANSPORTES */
        //region transportes
        ButtonGroup grupoTransportes = new ButtonGroup();
        grupoTransportes.add(rdTransportesLocal);
        grupoTransportes.add(rdTransportesMatricula);

        String[] colunasTransportes = {"Matricula","Local Atual", "Local Recolha", "Local Entrega", "Entregue", "Dta. Recolha", "Dta. Entrega"};
        Object[][] dataTransportes = {{"04-ER-22", "Evento", "Leiria", "Lisboa", "", "", ""},
                {"50-35-LI", "Filial", "Lisboa", "Coimbra", "X","05/05/2022", "07/05/2022" }};

        DefaultTableModel modelTransportes = new DefaultTableModel(colunasTransportes, 0);

        for (Object[] item : dataTransportes) {
            modelTransportes.addRow(item);
        }
        tabelaTransportes.setModel(modelTransportes);

        inserirButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AutoSellTransportesInserir inserir = new AutoSellTransportesInserir();
            }
        });
        editarButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(tabelaTransportes.getSelectionModel().isSelectionEmpty()) {
                    //System.out.println("Nenhuma linha selcionada");
                    JOptionPane.showMessageDialog(autoSellMainFrame, "Tem de escolher uma linha");
                    return;
                }
                AutoSellTransportesEditar editar = new AutoSellTransportesEditar(tabelaTransportes);
            }
        });
        transportesCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(tabelaTransportes.getSelectionModel().isSelectionEmpty()) {
                    //System.out.println("Nenhuma linha selcionada");
                    JOptionPane.showMessageDialog(autoSellMainFrame, "Tem de escolher uma linha");
                    return;
                }
                int result = JOptionPane.showConfirmDialog(autoSellMainFrame,"Tem a certeza?", "Eliminar Transporte",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
                if(result == JOptionPane.YES_OPTION){
                    DefaultTableModel model = (DefaultTableModel) tabelaTransportes.getModel();
                    model.removeRow(tabelaTransportes.getSelectedRow());
                }

            }
        });

        transportesPesquisaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (grupoTransportes.getSelection() == null)
                {
                    JOptionPane.showMessageDialog(autoSellMainFrame, "Por favor escolha um critério de pesquisa.");
                    return;
                }
                if(txtTransportesPesquisa.getText().equals("")){
                    JOptionPane.showMessageDialog(autoSellMainFrame, "Por favor preencha o campo pesquisa.");
                    return;
                }
            }
        });
        //endregion

        /* ESTATISTICAs */
        String[] estatisticas = {"Marcas Mais Vendidas","Modelos Mais Vendidos","Melhores Clientes","Melhores Filiais","Investimentos por Marca","Investimentos por Modelo"};
        final DefaultComboBoxModel modelEstatisticas = new DefaultComboBoxModel(estatisticas);
        cbEstatisticas.setModel(modelEstatisticas);

        /* CLIENTES */
        //region clientes
        ButtonGroup grupoClientes = new ButtonGroup();
        grupoClientes.add(rdClientesNIF);
        grupoClientes.add(rdClientesNome);

        Gestor.getGestor().atualizaTabelaClientes(tabelaClientes);

        tabelaClientes.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                String nif =  tabelaClientes.getValueAt(tabelaClientes.getSelectedRow(), 0).toString();

                LinkedList<Transacao> transacoes = Gestor.getGestor().getTransacoes(nif);

                if(transacoes == null)
                    Gestor.getGestor().atualizaTabelaHistoricoClientes(tabelaHistorioCliente, null);
                else
                    Gestor.getGestor().atualizaTabelaHistoricoClientes(tabelaHistorioCliente, nif);
                /*
                if(nif.equals("230123321"))
                    dataHistoricoClientess = new Object[][] {{"50-35-LI", "503630330", "230123321", ""  ,"1750","15/05/2022", "121"}};
                else
                    dataHistoricoClientess = new Object[][] {{"04-ER-22", "123554332", "503630330", "2500"  ,"","01/07/2022", "1"}};

                for (Object[] item : dataHistoricoClientess) {
                    modelHistoricoClientes.getDataVector().removeAllElements();
                    modelHistoricoClientes.fireTableDataChanged();
                    modelHistoricoClientes.addRow(item);
                }
                */

            }
        });

        inserirClienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AutoSellClientesInserir(AutoSellMainWindow.this, tabelaClientes);
            }
        });
        editarClienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(tabelaClientes.getSelectionModel().isSelectionEmpty()) {
                    //System.out.println("Nenhuma linha selcionada");
                    JOptionPane.showMessageDialog(autoSellMainFrame, "Tem de escolher uma linha");
                    return;
                }
                 new AutoSellClientesEditar(AutoSellMainWindow.this, tabelaClientes);
            }
        });
        eliminarClienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(tabelaClientes.getSelectionModel().isSelectionEmpty()) {
                    //System.out.println("Nenhuma linha selcionada");
                    JOptionPane.showMessageDialog(autoSellMainFrame, "Tem de escolher uma linha");
                    return;
                }

                String nif =  tabelaClientes.getValueAt(tabelaClientes.getSelectedRow(), 0).toString();

                LinkedList<Transacao> transacoes = Gestor.getGestor().getTransacoes(nif);

                if(transacoes != null){
                    JOptionPane.showMessageDialog(autoSellMainFrame, "Não é possivel eliminar clientes com historico de transações");
                    return;
                }

                int result = JOptionPane.showConfirmDialog(autoSellMainFrame,"Tem a certeza?", "Eliminar Entrada",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
                if(result == JOptionPane.YES_OPTION){
                    Gestor.getGestor().removerCliente(tabelaClientes.getValueAt(tabelaClientes.getSelectedRow(), 0).toString());
                    Gestor.getGestor().atualizaTabelaClientes(tabelaClientes);
                    Gestor.getGestor().atualizaTabelaHistoricoClientes(tabelaHistorioCliente, null);
                }
            }
        });

        clientesPesquisaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (grupoClientes.getSelection() == null)
                {
                    JOptionPane.showMessageDialog(autoSellMainFrame, "Por favor escolha um critério de pesquisa.");
                    return;
                }
                if(txtClientesPesquisa.getText().equals("")){
                    JOptionPane.showMessageDialog(autoSellMainFrame, "Por favor preencha o campo pesquisa.");
                    return;
                }
            }
        });
        //endregion

        /* EVENTOS */
        //region eventos
        ButtonGroup grupoEventos = new ButtonGroup();
        grupoEventos.add(rdEventoLocal);
        grupoEventos.add(rdEventoNome);

        String[] colunasEventos = {"Nome","Local", "Data Inicio", "Data Fim", "Nº Veiculos"};
        Object[][] dataEventos = {{"Feira de Maio de Leiria", "Leiria", "01/05/2022", "30/05/2022", "2"},
                                  {"Queima das Fitas", "Coimbra", "02/06/2022", "15/06/2022", "3"}};
        DefaultTableModel modelEventos = new DefaultTableModel(colunasEventos, 0);

        for (Object[] item : dataEventos) {
            modelEventos.addRow(item);
        }
        tabelaEventos.setModel(modelEventos);

        String[] colunasEventosVeiculos = {"Matricula","Marca", "Modelo", "Ano", "Dono Anterior", "Donos", "Caracteristicas"};
        DefaultTableModel modelEventosVeiculos = new DefaultTableModel(colunasEventosVeiculos, 0);
        tabelaVeiculosEventos.setModel(modelEventosVeiculos);

        tabelaEventos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                String evento =  tabelaEventos.getValueAt(tabelaEventos.getSelectedRow(), 0).toString();
                Object[][] dataVeiculosEventos = null;

                if(evento.equals("Feira de Maio de Leiria"))
                    dataVeiculosEventos = new Object[][] {{"04-ER-22", "Audi", "A3", "2000", "212543987", "1", "3P Preto"},
                                                           {"50-35-LI", "BMW", "320", "1999", "234765437", "2", "5P Branco"}};
                else
                    dataVeiculosEventos = new Object[][] {{"65-RD-15", "Opel", "Corsa", "1998", "210454772", "1", "Comercial Azul Escuro"},
                                                          {"52-23-FT", "Renault", "Megane", "2007", "218656098", "3", "2P Cinza"},
                                                          {"01-XS-87", "Tesla", "Y", "2019", "119223223", "2", "5P Preto - Bateria Nova"}};
                modelEventosVeiculos.getDataVector().removeAllElements();
                modelEventosVeiculos.fireTableDataChanged();
                for (Object[] item : dataVeiculosEventos) {
                    modelEventosVeiculos.addRow(item);
                }
            }
        });

        inserirEventoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AutoSellEventosInserir inserir = new AutoSellEventosInserir();
            }
        });
        editarEventoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(tabelaEventos.getSelectionModel().isSelectionEmpty()) {
                    //System.out.println("Nenhuma linha selcionada");
                    JOptionPane.showMessageDialog(autoSellMainFrame, "Tem de escolher uma linha");
                    return;
                }
                AutoSellEventosEditar editar = new AutoSellEventosEditar(tabelaEventos);
            }
        });
        eliminarEventoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(tabelaEventos.getSelectionModel().isSelectionEmpty()) {
                    //System.out.println("Nenhuma linha selcionada");
                    JOptionPane.showMessageDialog(autoSellMainFrame, "Tem de escolher uma linha");
                    return;
                }
                int result = JOptionPane.showConfirmDialog(autoSellMainFrame,"Tem a certeza?", "Eliminar Entrada",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
                if(result == JOptionPane.YES_OPTION){
                    DefaultTableModel model = (DefaultTableModel) tabelaEventos.getModel();
                    model.removeRow(tabelaEventos.getSelectedRow());
                    modelEventosVeiculos.getDataVector().removeAllElements();
                    modelEventosVeiculos.fireTableDataChanged();
                }
            }
        });

        eventosPesquisaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (grupoEventos.getSelection() == null)
                {
                    JOptionPane.showMessageDialog(autoSellMainFrame, "Por favor escolha um critério de pesquisa.");
                    return;
                }
                if(txtEventosPesquisa.getText().equals("")){
                    JOptionPane.showMessageDialog(autoSellMainFrame, "Por favor preencha o campo pesquisa.");
                    return;
                }
            }
        });
        //endregion

        setTitle("AutoSell Management");
        setContentPane(mainPainel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

}
