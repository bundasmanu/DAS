/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicadigital.tp;

import java.awt.Font;
import java.awt.TextArea;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static logicadigital.tp.Opcao.AND;
import static logicadigital.tp.Opcao.OR;

/**
 *
 * @author Armando
 */
public class GameTab extends javax.swing.JFrame {

    /**
     * Creates new form GameTab
     */
    static Fachada f;
    ArrayList<Input> in = new ArrayList<Input>();
    ArrayList<Operador> operador = new ArrayList<Operador>();
    ArrayList<Operador> and = new ArrayList<Operador>();
    ArrayList<Operador> or = new ArrayList<Operador>();
    ArrayList<Output> out = new ArrayList<Output>();

    ArrayList<Input> inAux = new ArrayList<Input>();
    ArrayList<Input> inAux2 = new ArrayList<Input>();
    ArrayList<Operador> OperadoresAndOr = new ArrayList<Operador>();
    ArrayList<Operador> OperadoresAndOrAux = new ArrayList<Operador>();
    ArrayList<Operador> OperadoresAndOrAux2 = new ArrayList<Operador>();
    ArrayList<String> outAux = new ArrayList<String>();
    ArrayList<String> Bin = new ArrayList<String>();
    //referencia para o adaptador para escrita no ficheiro
    AdaptadorBLIF adaptadorBLIF;
    static ComandoFicheiros comando = new ComandoFicheiros();
    static int id_mod = 0;
    static int contador = 0;
    static int contador2 = 0;
    static int contador3 = 0;
    static int idinput = 0;
    static int idinput2 = 0;
    static int idinputFornecer = 0;
    static int idinputReceber = 0;

    public GameTab(Fachada ff) {
        initComponents();
        f = ff;
        jLabel5.setFont(new Font("Serif", Font.PLAIN, 30));
    }

    public static Fachada getF() {
        return f;
    }

    public static void setF(Fachada f) {
        GameTab.f = f;
    }

    public static int criaModulo() throws IOException {

        int id_modulo = getF().getJogo().criaModulo();/*QUANDO CRIO UM MODULO, OBTENHO O SEU ID*/


        return id_modulo;

    }

    public static void criaEntradas(int id_modulo, int bin) {

        Comando c = new CriaInput(id_modulo, bin);
        f.getJogo().getDadosJogo().getCom().apply(c);
    }

    public static void defineBinEntradas(int id_modulo, int bin) {

        for (int i = 0; i < getF().getJogo().getDadosJogo().getModulo(id_modulo).getInputs().size(); i++) {
            if (getF().getJogo().getDadosJogo().getModulo(id_modulo).getInputs().get(i).id_input == idinput) {
                getF().getJogo().getDadosJogo().getModulo(id_modulo).getInputs().get(i).setBinario(bin);
            }
        }
    }

    public static void LigaEntradaOperador(int idmodulo, int idoperador, int idinput) {
        Comando c = new ColocaInputOperador(idmodulo, idoperador, idinput);
        f.getJogo().getDadosJogo().getCom().apply(c);
    }

    public static void LigaOperadorSaida(int idmodulo, int idoperador, int idinput) {
        //Comando c = new 
        //f.getJogo().getDadosJogo().getCom().apply(c);
    }

    public static void LigaOperadorOperador(int idModulo, int idFornecer, int idReceber) {
        Comando c = new LigaOperadorOperador(idModulo, idFornecer, idFornecer);
        f.getJogo().getDadosJogo().getCom().apply(c);
    }

    public static void criaOperadoresAnd(int id_modulo) {

        Comando c = new CriaOperador(id_modulo, AND);
        f.getJogo().getDadosJogo().getCom().apply(c);
    }

    public static void criaOperadoresOr(int id_modulo) {

        Comando c = new CriaOperador(id_modulo, OR);
        f.getJogo().getDadosJogo().getCom().apply(c);
    }

    public static void criaSaidas(int id_modulo) {
        Comando c = new CriaOutput(id_modulo);
        f.getJogo().getDadosJogo().getCom().apply(c);
    }

    public static void invocaModulo() throws IOException {

//        String comando_modulo = comando.executaComandoModulo();
//        System.out.println("" + comando_modulo);
        int id_modulo = getF().getJogo().criaModulo();/*QUANDO CRIO UM MODULO, OBTENHO O SEU ID*/
        int id1_input = f.getJogo().insereInputModulo(id_modulo, 1);/*QUANDO CRIO UM INPUT, OBTENHO O SEU ID*/
        int id2_input = f.getJogo().insereInputModulo(id_modulo, 1);/*QUANDO CRIO UM INPUT, OBTENHO O SEU ID*/
        int id3_input = f.getJogo().insereInputModulo(id_modulo, 1);/*QUANDO CRIO UM INPUT, OBTENHO O SEU ID*/
        int id_operador = f.getJogo().insereOperadorModulo(id_modulo, AND);/*INSERE OPERADOR NO MODULO*/
        int id_operador2 = f.getJogo().insereOperadorModulo(id_modulo, AND);/*INSERE OPERADOR NO MODULO*/
        int id_operador3 = f.getJogo().insereOperadorModulo(id_modulo, AND);/*INSERE OPERADOR NO MODULO*/
        boolean conseguiu_colocar_input_no_operador = getF().getJogo().colocaInputOperador(id1_input, id_modulo, id_operador);/*NECESSARIO COLOCAR O INPUT NO OPERADOR, DE MODO A ESTE CONSEGUIR EFETUAR OS CALCULOS*/
        boolean conseguiu_colocar_input2_no_operador = getF().getJogo().colocaInputOperador(id2_input, id_modulo, id_operador);/*NECESSARIO COLOCAR O INPUT NO OPERADOR, DE MODO A ESTE CONSEGUIR EFETUAR OS CALCULOS*/
        boolean conseguiu_colocar_input1_no_operador2 = getF().getJogo().colocaInputOperador(id2_input, id_modulo, id_operador2);/*NECESSARIO COLOCAR O INPUT NO OPERADOR, DE MODO A ESTE CONSEGUIR EFETUAR OS CALCULOS*/
        boolean conseguiu_colocar_input2_no_operador2 = getF().getJogo().colocaInputOperador(id3_input, id_modulo, id_operador2);/*NECESSARIO COLOCAR O INPUT NO OPERADOR, DE MODO A ESTE CONSEGUIR EFETUAR OS CALCULOS*/
        //boolean conseguiu_colocar_output_no_operador2=getF().getJogo().adicionaOutputAoModuloEOperador(id_modulo, id_operador2);

        boolean tr = getF().getJogo().adicionaOperadorOutroOperador(id_modulo, id_operador, id_operador3);
        boolean tr2 = getF().getJogo().adicionaOperadorOutroOperador(id_modulo, id_operador2, id_operador3);

        f.getJogo().realizaOperacaoModulo(id_modulo);/*REALIZA AS OPERACOES QUE ESTAO NO MODULO, PARA JA SÓ ESTÁ DEFINIDA A OPERACAO AND*/
        System.out.println(f.getJogo().listaModulo(id_modulo));/*LISTAGEM DO MODULO, COM OS SEUS DADOS, E VERIFICAR SE O RESULTADO É O ESPERADO*/
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jTextField5 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jTextField12 = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Modulo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Numero de entradas");

        jLabel2.setText("Operadores AND");

        jLabel3.setText("Operadores OR");

        jLabel4.setText("Numero de saidas");

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jButton2.setText("OK");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel5.setText("  Inicio");

        jLabel6.setText("Especificar dados iniciais");

        jLabel7.setText("Desenhar esquema");

        jLabel8.setText("Ligue a Entrada:");

        jLabel10.setText("And");

        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });

        jLabel11.setText("Ligue o operador:");

        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });

        jLabel12.setText("Operadores");

        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });

        jButton3.setText("OK");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(0, 102, 0));
        jButton5.setText("Ligar Modulos");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jTextField11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField11ActionPerformed(evt);
            }
        });

        jLabel17.setText("Or");

        jLabel13.setText("Saidas");

        jButton4.setBackground(new java.awt.Color(255, 102, 0));
        jButton4.setText("Novo Modulo");

        jLabel15.setText("Valor da entrada:");

        jLabel16.setText("jLabel16");

        jTextField10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField10ActionPerformed(evt);
            }
        });

        jButton6.setText("Inserir");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("OK");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("OK");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel16))
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButton2)
                        .addComponent(jLabel4)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 227, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextField7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel18))
                                    .addComponent(jTextField8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel14))
                            .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(74, 74, 74)
                                        .addComponent(jButton3))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton8))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(214, 214, 214)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextField11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel9))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton7))
                            .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField5, javax.swing.GroupLayout.Alignment.LEADING))))
                .addGap(0, 29, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButton1)
                .addGap(238, 238, 238)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(74, 74, 74)
                                .addComponent(jLabel6))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4)
                        .addGap(85, 85, 85)
                        .addComponent(jButton5)
                        .addGap(59, 59, 59)))
                .addGap(155, 155, 155))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jLabel5))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel17)
                        .addGap(15, 15, 15)
                        .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton7))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel14)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel18))
                                .addGap(23, 23, 23)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton3)
                                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton8))
                                .addGap(62, 62, 62)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton4)
                                    .addComponent(jButton5)))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(24, 24, 24))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            // TODO add your handling code here:
            invocaModulo();
        } catch (IOException ex) {
            Logger.getLogger(GameTab.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        String input = jTextField1.getText();
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        String operadorAnd = jTextField2.getText();
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        String operadoOr = jTextField3.getText();
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        String output = jTextField4.getText();
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        String input = jTextField1.getText();
        String operadorAnd = jTextField2.getText();
        String operadoOr = jTextField3.getText();
        String output = jTextField4.getText();
        int numInput = Integer.parseInt(input);
        int numOperadorAnd = Integer.parseInt(operadorAnd);
        int numOperadorOr = Integer.parseInt(operadoOr);
        int numOutput = Integer.parseInt(output);

        jTextArea1.setEditable(false);
        jButton2.setEnabled(false);

        if (input.equals("")) {
            JOptionPane.showMessageDialog(null, "Adicione um input");
        } else if (operadorAnd.equals("") || operadoOr.equals("")) {
            JOptionPane.showMessageDialog(null, "Adicione pelo menos um operador AND ou OR");
        } else if (output.equals("")) {
            JOptionPane.showMessageDialog(null, "Adicione um output");
        } else if (input.equals("") && operadorAnd.equals("") && operadoOr.equals("") && output.equals("")) {
            JOptionPane.showMessageDialog(null, "Tem de adicionar dados");
        }

        try {
            //cria modulo
            id_mod = criaModulo();
        } catch (IOException ex) {
            Logger.getLogger(GameTab.class.getName()).log(Level.SEVERE, null, ex);
        }
        //insere Entradas/Operadores / Saidas
        for (int i = 0; i < numInput; i++) {
            criaEntradas(id_mod, 0);
        }
        for (int i = 0; i < numOperadorAnd; i++) {
            criaOperadoresAnd(id_mod);
        }
        for (int i = 0; i < numOperadorOr; i++) {
            criaOperadoresOr(id_mod);
        }
        for (int i = 0; i < numOutput; i++) {
            criaSaidas(id_mod);
        }

        //clonar a os dados do modulo para ArrayList em memoria
        for (int i = 0; i < getF().getJogo().getDadosJogo().getModulo(id_mod).getInputs().size(); i++) {
            in.add(getF().getJogo().getDadosJogo().getModulo(id_mod).getInputs().get(i));
        }
        for (int i = 0; i < getF().getJogo().getDadosJogo().getModulo(id_mod).getOperador().size(); i++) {
            operador.add(getF().getJogo().getDadosJogo().getModulo(id_mod).getOperador().get(i));
        }
        for (int i = 0; i < operador.size(); i++) {
            if (operador.get(i).getQual() == Opcao.AND) {
                and.add(operador.get(i));
            }
        }
        for (int i = 0; i < operador.size(); i++) {
            if (operador.get(i).getQual() == Opcao.OR) {
                or.add(operador.get(i));
            }
        }
        for (int i = 0; i < getF().getJogo().getDadosJogo().getModulo(id_mod).getOutputs().size(); i++) {
            out.add(getF().getJogo().getDadosJogo().getModulo(id_mod).getOutputs().get(i));
        }

        inAux.add(in.get(0));

        jTextArea1.append("Entradas do sistema");
        jTextArea1.append("\n");
        for (int i = 0; i < in.size(); i++) {
            int id = in.get(i).id_input;
            jTextArea1.append(" " + Integer.toString(id));
        }
        jTextArea1.append("\n");
        jTextArea1.append("Operadores AND");
        jTextArea1.append("\n");
        for (int i = 0; i < and.size(); i++) {
            int id = and.get(i).id_operador;
            jTextArea1.append(" " + Integer.toString(id));
        }
        jTextArea1.append("\n");
        jTextArea1.append("Operadores OR");
        jTextArea1.append("\n");
        for (int i = 0; i < or.size(); i++) {
            int id = or.get(i).id_operador;
            jTextArea1.append(" " + Integer.toString(id));
        }
        jTextArea1.append("\n");
        jTextArea1.append("Outputs do sistema");
        jTextArea1.append("\n");
        for (int i = 0; i < out.size(); i++) {
            int id = out.get(i).id_input;
            jTextArea1.append(" " + Integer.toString(id));
        }

        for (int i = 0; i < and.size(); i++) {
            OperadoresAndOr.add(and.get(i));
            OperadoresAndOrAux.add(and.get(i));
        }
        for (int i = 0; i < or.size(); i++) {
            OperadoresAndOr.add(or.get(i));
            OperadoresAndOrAux.add(or.get(i));
        }

        DesenhaEsquema1();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // escrita da operacao
        String op = jTextField6.getText();
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int tam = OperadoresAndOr.size();
        idinputReceber = Integer.parseInt(jTextField8.getText());
        contador2++;
        if (contador2 < tam) {
            OperadoresAndOrAux2.add(OperadoresAndOr.get(contador2));
            LigaOperadorOperador(id_mod, idinputFornecer, idinputReceber);
            DesenhaEsquema2();
            jTextField8.setText("");
        }
        if (contador2 >= tam) {
            jButton3.setEnabled(false);
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // iniciar simulacao
        JOptionPane.showMessageDialog(null, "Ola Adeus");

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jTextField11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField11ActionPerformed

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
        String op = jTextField8.getText();
    }//GEN-LAST:event_jTextField8ActionPerformed

    private void jTextField10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField10ActionPerformed
        // 0 ou 1
    }//GEN-LAST:event_jTextField10ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        String b = jTextField10.getText();
        int bin = Integer.parseInt(b);
        int tam = in.size();
        if (bin == 0 || bin == 1) {

            contador3++;
            if (contador3 < tam) {
                inAux2.add(in.get(contador3));
                DesenhaEsquema1();
            }
            idinput++;
            defineBinEntradas(id_mod, bin);
            jTextField10.setText("");
        } else {
            JOptionPane.showMessageDialog(null, "Input 0 ou 1");
        }
        if (contador3 == tam) {
            jButton6.setEnabled(false);
            DesenhaEsquema();
            DesenhaEsquema2();
            //DesenhaEsquema3();
        }

    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        //atualizar vetor inAUx 
        int tam = in.size();
        int op = Integer.parseInt(jTextField6.getText());
        contador++;

        if (contador < tam) {
            inAux.add(getF().getJogo().getDadosJogo().getModulo(id_mod).getInputs().get(contador));
            LigaEntradaOperador(id_mod, op, idinput2);
            DesenhaEsquema();
            jTextField6.setText("");
        }
        if (contador >= tam) {
            jButton7.setEnabled(false);
        }

    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        int tam = OperadoresAndOr.size();
        contador2++;
        if (contador2 < tam) {
            OperadoresAndOrAux2.add(OperadoresAndOr.get(contador2));
            //LigaOperadorSaida();
            DesenhaEsquema2();
            jTextField12.setText("");
        }
        if (contador2 >= tam) {
            jButton8.setEnabled(false);
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    public void DesenhaEsquema() {
        jTextField5.setEditable(false);
        jTextField7.setEditable(false);
        jTextField11.setEditable(false);
        jTextField9.setEditable(false);
        String andAux = "";
        String orAux = "";
        idinput2++;

        for (int i = 0; i < and.size(); i++) {
            andAux += " " + Integer.toString(and.get(i).id_operador);
        }
        for (int i = 0; i < or.size(); i++) {
            orAux += " " + Integer.toString(or.get(i).id_operador);
        }

        jTextField5.setText(andAux);
        //jTextField9.setText(out.toString());
        jTextField11.setText(orAux);
        String inp = Integer.toString(inAux.get(0).id_input);
        jLabel9.setText(inp);
        for (int i = 0; i < inAux.size(); i++) {
            String inp2 = Integer.toString(inAux.get(i).id_input);
            jLabel9.setText(inp2);
        }

    }

    public void DesenhaEsquema1() {
        String inp = Integer.toString(inAux.get(0).id_input);
        jLabel16.setText(inp);
        for (int i = 0; i < inAux2.size(); i++) {
            String inp2 = Integer.toString(inAux2.get(i).id_input);
            jLabel16.setText(inp2);
        }

    }

    public void DesenhaEsquema2() {

        Operador op = OperadoresAndOr.get(0);
        String auxOut = "";
        String auxOp = "";

        jLabel18.setText(Integer.toString(OperadoresAndOr.get(0).id_operador));

        op = OperadoresAndOr.get(0);
        idinputFornecer = op.id_operador;
        for (int i = 0; i < OperadoresAndOrAux2.size(); i++) {
            jLabel18.setText(Integer.toString(OperadoresAndOrAux2.get(i).id_operador));
            op = OperadoresAndOrAux2.get(i);
            idinputFornecer = op.id_operador;
        }

        for (int y = 0; y < OperadoresAndOrAux.size(); y++) {
            if (OperadoresAndOrAux.get(y).id_operador == op.id_operador) {
                OperadoresAndOrAux.remove(y);
            }
        }

        for (int i = 0; i < OperadoresAndOrAux.size(); i++) {
            auxOp += " " + OperadoresAndOrAux.get(i).id_operador;
        }

        for (int i = 0; i < out.size(); i++) {
            auxOut += " " + Integer.toString(out.get(i).id_input);
        }

        jTextField7.setText(auxOp);
        jTextField9.setText(auxOut);
        OperadoresAndOrAux.add(op);

    }

    public void DesenhaEsquema3() {

        String auxOperadores = "";

        for (int i = 0; i < and.size(); i++) {
            auxOperadores += " " + and.get(i).id_operador;
        }
        for (int i = 0; i < or.size(); i++) {
            auxOperadores += " " + or.get(i).id_operador;
        }

        jTextField7.setText(auxOperadores);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GameTab.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameTab.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameTab.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameTab.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameTab(f).setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
