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
public class Output {

    int id_input;
    private static int nextInputID = 1;
    private int binario;

    public Output(int bin) {/*CONSTRUTOR CRIADO PARA EFETUAR A VERIFICACAO NOS TESTES*/
        this.binario = bin;
        this.id_input = nextInputID;
        nextInputID++;
    }

    public Output() {
        this.id_input = nextInputID;
        nextInputID++;
    }

    public int getBinario() {
        return binario;
    }

    public void setBinario(int binario) {
        this.binario = binario;
    }

    public int getId_input() {
        return id_input;
    }

    public void setId_input(int id_input) {
        this.id_input = id_input;
    }

    @Override
    public int hashCode() {

        int hash = 17;

        hash += this.id_input;

        return hash;
    }

    @Override
    public boolean equals(Object obj) {

        try {

            if (obj == null) {
                return false;
            }

            if (obj instanceof Output == false) {
                return false;
            }

            if (this == obj) {
                return true;
            }

            Output retorno_output = (Output) obj;

            if (this.id_input != retorno_output.getId_input()) {
                return false;
            }

            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public String toString() {

        return "\nOutput: " + this.binario + "\n";

    }

}
