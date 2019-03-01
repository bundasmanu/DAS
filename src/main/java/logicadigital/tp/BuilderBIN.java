/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicadigital.tp;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author carlo
 */
public class BuilderBIN extends FicheiroBuilder{
    
    List<Modulo> listas_modulos;
    
    public BuilderBIN(){
        listas_modulos=new ArrayList<Modulo>();
    }

    public List<Modulo> getListas_modulos() {
        return listas_modulos;
    }

    public void setListas_modulos(List<Modulo> listas_modulos) {
        this.listas_modulos = listas_modulos;
    }

    @Override
    public FicheiroBuilder setModulo(DadosJogo x, int id_mod) {
        //eEscrever.escreveModulo(x,id_mod);
        
        try{
            
            /*PROCURAR O ID DO MODULO PASSADO POR PARAMETRO*/
            if(x==null){
                return this;
            }
            
            Modulo m=x.getModulo(id_mod);
            if(m==null){
                return this;
            }
            
            this.listas_modulos.add(m);
            
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return this;
        }
        
        return this;
        //return FicheiroBuilder.getFicheiroBuilder("BuilderBLIF");
    }
    
    @Override
    public FicheiroBuilder setInputs(DadosJogo x, int id_mod){
        
        try{
            
            /*PROCURAR O ID DO MODULO PASSADO POR PARAMETRO*/
            if(x==null){
                return this;
            }
            
            Modulo m=x.getModulo(id_mod);
            if(m==null){
                return this;
            }  
            
            /*VERIFICAR SE EXISTEM TODOS OS INPUTS QUE SE PRETENDEM ADICIONAR NO MODULO*/

            for(Input i : m.inputs){
                this.listas_modulos.get(id_mod-1).getInputs().add(i);
            }
            
            return this;
            
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return this;
        }
            
    }
    
    @Override
    public FicheiroBuilder setOutputs(DadosJogo x, int id_mod){
        
        try{
            
            /*PROCURAR O ID DO MODULO PASSADO POR PARAMETRO*/
            if(x==null){
                return this;
            }
            
            Modulo m=x.getModulo(id_mod);
            if(m==null){
                return this;
            }  
            
            /*VERIFICAR SE EXISTEM TODOS OS INPUTS QUE SE PRETENDEM ADICIONAR NO MODULO*/

            for(Output out : m.getOutputs()){
                this.listas_modulos.get(id_mod-1).getOutputs().add(out);
            }
            
            return this;
            
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return this;
        }
            
    }
    
    @Override
    public FicheiroBuilder setOperadores(DadosJogo x, int id_mod){
        
        try{
            
            /*PROCURAR O ID DO MODULO PASSADO POR PARAMETRO*/
            if(x==null){
                return this;
            }
            
            Modulo m=x.getModulo(id_mod);
            if(m==null){
                return this;
            }  
            
            /*VERIFICAR SE EXISTEM TODOS OS INPUTS QUE SE PRETENDEM ADICIONAR NO MODULO*/

                for(Operador op : m.getOperador()){
                this.listas_modulos.get(id_mod-1).getOperador().add(op);
            }
            
            return this;
            
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return this;
        }
        
    }
    
    @Override
    public FicheiroBuilder build() throws Exception{
        
        if(this.listas_modulos.isEmpty()==false){
            /*ESCREVE PARA O FICHEIRO*/
            FileOutputStream fos = new FileOutputStream("historico_" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS") +".bin"); /*FALTA METER O NOME DO UTILIZADOR*/
            ObjectOutputStream ois = new ObjectOutputStream(fos);
            ois.writeObject(this.listas_modulos);
        }
        throw new Exception("Nao pode construir o ficheiro");
    }

    
    
}
