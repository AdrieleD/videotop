/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author adriele
 */
public class Usuario {

    private String nome;
    private String cpf;
    private Date nascimento;
    private String telefone;
    private TipoUsuario tipoUsuario;
    private Endereco endereco;
    private String senha;
    private String classe;

    public Usuario(String nome, String cpf, Date nascimento, String telefone, TipoUsuario tipoUsuario, Endereco endereco, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.nascimento = nascimento;
        this.telefone = telefone;
        this.tipoUsuario = tipoUsuario;
        this.endereco = endereco;
        this.senha = senha;
        switch(tipoUsuario){
            case GERENTE:
                this.classe="AS";
                break;
           case ATENDENTE:
                this.classe="S";
                break;
           case CLIENTE:
                this.classe="C";
                break;
           default:
               if(this.calculaIdade(nascimento)>=18)
                   this.classe="C";
               else
                   this.classe="U";               
        }
    }

    public String getClasse() {
        return classe;
    }
    
    private int calculaIdade(Date nascimento){
        Calendar dataNasc = new GregorianCalendar();
        dataNasc.setTime(nascimento);
        Calendar hoje = Calendar.getInstance();
        int idade = hoje.get(Calendar.YEAR) - dataNasc.get(Calendar.YEAR);
        return idade;        
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }
    
    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
