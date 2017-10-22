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
public class Funcionario extends Usuario{
    
    private float Salario;
    
    public Funcionario(String nome, String cpf, Date nascimento, String telefone, TipoUsuario tipoUsuario, Endereco endereco, String senha, float salario) {
        super(nome, cpf, nascimento, telefone, TipoUsuario.ATENDENTE, endereco, senha);
        this.Salario = salario;
    }
    
    
}
