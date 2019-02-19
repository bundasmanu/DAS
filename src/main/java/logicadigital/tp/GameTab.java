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
    ArrayList<String> in = new ArrayList<String>();
    ArrayList<String> and = new ArrayList<String>();
    ArrayList<String> or = new ArrayList<String>();
    ArrayList<String> out = new ArrayList<String>();
    ArrayList<String> inAux = new ArrayList<String>();
    ArrayList<String> inAux2 = new ArrayList<String>();
    ArrayList<String> OperadoresAndOr = new ArrayList<String>();
    ArrayList<String> OperadoresAndOrAux = new ArrayList<String>();
    ArrayList<String> OperadoresAndOrAux2 = new ArrayList<String>();
    ArrayList<String> outAux = new ArrayList<String>();
    ArrayList<String> Bin = new ArrayList<String>();
    //referencia para o adaptador para escrita no ficheiro
    AdaptadorBLIF adaptadorBLIF;
    static ComandoFicheiros comando= new ComandoFicheiros();
    static int id_mod = 0;
    static int contador = 0;
    static int contador2 = 0;
    static int contador3 = 0;

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
        //f.getJogo().insereInputModulo(id_modulo, bin);
        Comando c = new CriaInput(id_modulo, bin);
        f.getJogo().getDadosJogo().getCom().apply(c);
    }

    public static void criaOperadoresAnd(int id_modulo) {
        //f.getJogo().insereOperadorModulo(id_modulo, AND);
        Comando c = new CriaOperador(id_modulo, AND);
        f.getJogo().getDadosJogo().getCom().apply(c);
    }

    public static void criaOperadoresOr(int id_modulo) {
        //f.getJogo().insereOperadorModulo(id_modulo, OR);
        Comando c = new CriaOperador(id_modulo, OR);
        f.getJogo().getDadosJogo().getCom().apply(c);
    }

    public static void criaSaidas(int id_modulo) {
        //Comando c = new CriaOutput(id_modulo, id_mod);
    }

    public static void invocaModulo() throws IOException {
         String comando_modulo= comando.executaComandoModulo();
         System.out.println(""+comando_modulo);
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
        jToggleButton1 = new javax.swing.JToggleButton();
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

        jLabel5.setText("  Simulacao");

        jLabel6.setText("Especificar dados iniciais");

        jLabel7.setText("Desenhar esquema");

        jLabel8.setText("Ligue a Entrada:");

        jLabel10.setText("And");

        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });

        jToggleButton1.setText("OK");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
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

        jButton6.setText("OK");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(jLabel6))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(155, 155, 155))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3))))
                        .addGap(160, 160, 160))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton4)
                        .addGap(66, 66, 66)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jTextField11, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel9))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jToggleButton1))
                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextField7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel13))
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel18))
                            .addComponent(jTextField9)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton3)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14))
                    .addComponent(jTextField5, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton5, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(218, 218, 218)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton6))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel16)))))
                .addContainerGap(377, Short.MAX_VALUE))
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
                            .addComponent(jToggleButton1)
                            .addComponent(jButton2)))
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
                            .addComponent(jLabel4))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel14)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel18))
                        .addGap(4, 4, 4)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3))
                        .addGap(147, 147, 147))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton4)
                            .addComponent(jButton5))
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
        jButton2.setEnabled(false);
        String input = jTextField1.getText();
        String operadorAnd = jTextField2.getText();
        String operadoOr = jTextField3.getText();
        String output = jTextField4.getText();
        int Input = Integer.parseInt(input);
        int AND = Integer.parseInt(operadorAnd);
        int OR = Integer.parseInt(operadoOr);
        int Output = Integer.parseInt(output);
        jTextArea1.setEditable(false);
        
        
        if (input.equals("")) {
            JOptionPane.showMessageDialog(null, "Adicione um input");
        } else if (operadorAnd.equals("") || operadoOr.equals("")) {
            JOptionPane.showMessageDialog(null, "Adicione pelo menos um operador AND ou OR");
        } else if (output.equals("")) {
            JOptionPane.showMessageDialog(null, "Adicione um output");
        } else if (input.equals("") && operadorAnd.equals("") && operadoOr.equals("") && output.equals("")) {
            JOptionPane.showMessageDialog(null, "Tem de adicionar dados");
        }
         
        for (int i = 1; i <= Input; i++) {
            String aux = "E";
            aux = aux + i ;
            in.add(aux);
            try {
                comando.executaComandoInput(in);
            } catch (IOException ex) {
                System.out.println(""+ex.getMessage());
            }
           
        }

        for (int i = 1;
                i <= AND;
                i++) {
            String aux = "AND";
            aux = aux + i;
            and.add(aux);
        }
        for (int i = 1;
                i <= OR;
                i++) {
            String aux = "OR";
            aux = aux + i;
            or.add(aux);
        }
        for (int i = 1;
                i <= Output;
                i++) {
            String aux = "O";
            aux = aux + i;
             try {
                comando.executaComandoOutput(aux);
            } catch (IOException ex) {
                System.out.println(""+ex.getMessage());
            }
            out.add(aux);
        }

        jTextArea1.append(
                "Entradas do sistema");
        jTextArea1.append(
                "\n");
        jTextArea1.append(in.toString());
        jTextArea1.append(
                "\n");
        jTextArea1.append(
                "\n");
        jTextArea1.append(
                "Operadores AND");
        jTextArea1.append(
                "\n");
        jTextArea1.append(and.toString());
        jTextArea1.append(
                "\n");
        jTextArea1.append(
                "\n");
        jTextArea1.append(
                "Operadores OR");
        jTextArea1.append(
                "\n");
        jTextArea1.append(or.toString());
        jTextArea1.append(
                "\n");
        jTextArea1.append(
                "\n");
        jTextArea1.append(
                "Outputs do sistema");
        jTextArea1.append(
                "\n");
        jTextArea1.append(out.toString());

        inAux.add(in.get(0));

        if (and.size() != 0) {
            OperadoresAndOr.add(and.get(0));
        } else if (or.size() != 0) {
            OperadoresAndOr.add(or.get(0));
        } else if (and.size() == 0 && or.size() == 0) {
            System.out.println("Sem operadores!!!!");
        }
        int total = and.size();
        int total2 = or.size();

        for (int i = 0; i < total; i++) {
            OperadoresAndOrAux.add(and.get(i));
            OperadoresAndOrAux2.add(and.get(i));
        }
        for (int i = 0; i < total2; i++) {
            OperadoresAndOrAux.add(or.get(i));
            OperadoresAndOrAux2.add(or.get(i));
        }

        outAux.add(out.get(0));

        DesenhaEsquema();
        DesenhaEsquema1();
        DesenhaEsquema2();

        //int numInput = Integer.parseInt(input);
        int numOperadorAnd = Integer.parseInt(operadorAnd);
        int numOperadorOr = Integer.parseInt(operadoOr);
        int numOutput = Integer.parseInt(output);
        int bin = 0;
        try {
            //cria modulo
            id_mod = criaModulo();
        } catch (IOException ex) {
            Logger.getLogger(GameTab.class.getName()).log(Level.SEVERE, null, ex);
        }
        //insere Entradas/Operadores/Saidas
//        for (int i = 0; i < numInput; i++) {
//            criaEntradas(id_mod, bin);
//        }
        for (int i = 0; i < numOperadorAnd; i++) {
            criaOperadoresAnd(id_mod);
        }
        for (int i = 0; i < numOperadorOr; i++) {
            criaOperadoresOr(id_mod);
        }
//        for (int i = 0; i < numOutput; i++) {
//            criaSaidas(id_mod);
//        }
        //cria ligacoes

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        //atualizar vetor inAUx 
        int tam = in.size();
        contador++;
        if (contador < tam) {
            inAux.add(in.get(contador));
            DesenhaEsquema();
        }

    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // escrita da operacao
        String op = jTextField6.getText();
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int tam = OperadoresAndOrAux2.size();
        contador2++;
        if (contador2 < tam) {
            OperadoresAndOr.add(OperadoresAndOrAux2.get(contador2));
            DesenhaEsquema2();
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
        if (bin == 0 || bin == 1) {

            int tam = in.size();
            contador3++;
            if (contador3 < tam) {
                inAux2.add(in.get(contador3));
                DesenhaEsquema1();
            }
            criaEntradas(id_mod, bin);
        } else {
            JOptionPane.showMessageDialog(null, "Input 0 ou 1");
        }
// chamar metodo inserir entrada!!!!
    }//GEN-LAST:event_jButton6ActionPerformed

    public void DesenhaEsquema() {
        jTextField5.setEditable(false);
        jTextField7.setEditable(false);
        jTextField11.setEditable(false);
        jTextField9.setEditable(false);

        jTextField5.setText(and.toString());
        jTextField9.setText(out.toString());
        jTextField11.setText(or.toString());

        for (int i = 0; i < inAux.size(); i++) {
            jLabel9.setText(inAux.get(i));
        }

    }

    public void DesenhaEsquema1() {

        for (int i = 0; i < inAux2.size(); i++) {
            jLabel16.setText(inAux2.get(i));
        }

    }

    public void DesenhaEsquema2() {

        String aux = "";

        for (int i = 0; i < inAux.size(); i++) {
            jLabel16.setText(inAux.get(i));
        }
        for (int i = 0; i < OperadoresAndOr.size(); i++) {
            jLabel18.setText(OperadoresAndOr.get(i));
            aux = OperadoresAndOr.get(i);
        }
        for (int y = 0; y < OperadoresAndOrAux.size(); y++) {
            if (OperadoresAndOrAux.get(y).equals(aux)) {
                OperadoresAndOrAux.remove(y);
            }
        }
        jTextField7.setText(OperadoresAndOrAux.toString());
        OperadoresAndOrAux.add(aux);
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
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables
}
