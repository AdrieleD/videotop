/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author adriele
 */
public enum TipoUsuario {
    GERENTE(1),
    ATENDENTE(2),
    CLIENTE(3),
    DEPENDENTE(4);
    
    private final int tiposUsuario;

    TipoUsuario(int tipo) {
        this.tiposUsuario = tipo;
    }

    public int getTiposUsuario() {
        return this.tiposUsuario;
    }
    
    public static TipoUsuario getTipoUsuario (int idTU){
        for (TipoUsuario tu : TipoUsuario.values()){
            if(tu.getTiposUsuario()==idTU){
                System.out.println(tu);
                return tu;
            }
        }
        return null;
    }

}
