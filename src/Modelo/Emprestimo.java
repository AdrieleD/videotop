/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author JW
 */
public class Emprestimo {
    private int idFilme;
    private char cpf;
    private Date dataEmprestimo;
    private Date dataDevolucao;
    float valor;

    public Emprestimo(int idFilme, char cpf, Date dataEmprestimo, Date dataDevolucao, float valor) {
        this.idFilme = idFilme;
        this.cpf = cpf;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
        this.valor = valor;
    }
    
}
