/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicadigital.tp;

/**
 *
 * @author Armando
 */
public class Jogo {
    
    private DadosJogo dj;
    /*ESTADOS AQUI TAMBEM*/
    private IEstados estado;
    
    public Jogo(){
        this.dj=new DadosJogo();
        this.estado=new Inicio(dj);/*PASSAGEM DOS DADOS ATUAIS DO JOGO*/
    }
    
    public void setDadosJogo(DadosJogo dj) {
        this.dj = dj;
    }

    public void setEstado(IEstados estado) {
        this.estado = estado;
    }
    
    public DadosJogo getDadosJogo(){
        return dj;
    }

    public IEstados getEstado() {
        return estado;
    }
    
    /*CHAMADA DAS VARIAS FUNCOES DE ESTADO*/
   
    public void aplica_registo(){
        this.setEstado(this.estado.aplica_registo());
    }
    
    public void aplica_login(){
        this.setEstado(this.estado.aplica_login());
    }
    
    public void registo(String n, String p){
        this.setEstado(this.estado.registo(n, p));
    }
    
    public void login(String n, String p){
        this.setEstado(this.estado.login(n, p));
    }
    
    public void voltar(){
        this.setEstado(this.estado.voltar());
    }
    
    public int criaModulo(){
        return this.estado.criaModulo();
    }
    
    public int insereInputModulo(int id, int bin){
        return this.estado.insereInputModulo(id, bin);
    }
    
    public int insereOperadorModulo(int id, Opcao op){
        return this.estado.insereOperadorModulo(id, op);
    }
    
    public boolean colocaInputOperador(int id_input, int id_modulo, int id_operador){
        return this.getEstado().colocaInputOperador(id_input, id_modulo, id_operador);
    }
    
    public void realizaOperacaoModulo(int id){
        this.estado.realizaOperacaoModulo(id);
    }
    
    public String listaModulo(int id){
        return this.estado.listaModulo(id);
    }
    
    public boolean adicionaOutputAoModuloEOperador(int id_modulo, int id_operador){
        return this.getEstado().adicionaOutputAoModuloEOperador(id_modulo, id_operador);
    }
    
    public boolean adicionaOperadorOutroOperador(int id_modulo,int id_Operador_Adicionar,int id_Operador_Receber){
        return this.getEstado().adicionaOperadorOutroOperador(id_modulo, id_Operador_Adicionar, id_Operador_Receber);
    }
    
    @Override
    public String toString(){
        
        String info_jogo="";
        
        info_jogo+=this.getEstado().getClass().getName();/*NOME DA CLASSE*/
        
        return info_jogo;
    }
    
}
