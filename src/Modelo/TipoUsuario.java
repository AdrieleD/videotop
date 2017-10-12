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
    CLIENTE(0),
    FUNCIONARIO(1);
    
    private final int tiposUsuario;

    TipoUsuario(int tipo) {
        this.tiposUsuario = tipo;
    }

    public int getTiposUsuario() {
        return this.tiposUsuario;
    }

}
