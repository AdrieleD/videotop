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
public class Estudio {
    private String nome;
    private Endereco sede;

    public Estudio(String nome, Endereco sede) {
        this.nome = nome;
        this.sede = sede;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return sede;
    }

    public void setEndereco(Endereco sede) {
        this.sede = sede;
    }
}
