/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicadigital.tp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.SQLException;

/**
 *
 * @author Armando
 */
public class Login extends EstadoAdapter {

    public Login(DadosJogo d) {
        super(d);
    }

    @Override
    public IEstados login(String n, String p) {

        /*IR À BD, VERIFICAR SE EXISTE, SE EXISTIR PASSA PARA O ESTADO MODOGAME*/
 /*SENAO EXISTIR VOLTA AO INICIO*/
        try {

            boolean retorno=Session.getUtilizdorOperacaoCRUD().VerificaLogin(n, p);
            
            if(retorno==true){ /*Apenas se estiver tudo bem*/
                Utilizador utilizador= new Utilizador(n, p);
                super.getDadosJogo().setUtilizador(utilizador);
                AdaptadorBIN adaptadorBIN= new AdaptadorBIN();
                super.getDadosJogo().setAdaptadorBIN(adaptadorBIN);

                boolean status=adaptadorBIN.getFicheiroBIN().WriteNameOfUserBinaryFile(utilizador);
//                System.out.println(""+status);
//                boolean status_leitura_file= fich_bin.ReadBinaryFile(utilizador);
//                System.out.println(""+status_leitura_file);
                boolean status_leitura= adaptadorBIN.LerFicheiro(utilizador);
                System.out.println(""+status);
              
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return new ModoGame(super.getDadosJogo());
    }

    @Override
    public IEstados voltar() {
        return new Inicio(new DadosJogo());/*NOVA INSTANCIA DE JOGO*/
    }

    //se o user autenticar-se na aplicação com sucesso, então o nome desse mesmo utilizador e guardado num ficheiro

 }
//}
