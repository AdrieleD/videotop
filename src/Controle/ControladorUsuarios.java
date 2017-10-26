/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.Endereco;
import Modelo.TipoUsuario;
import Modelo.Usuario;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author jw
 */
public class ControladorUsuarios {
    private ArrayList<Usuario> usuariosCadastrados;

    public ArrayList<Usuario> getUsuariosCadastrados() {
        return usuariosCadastrados;
    }
    
    public ControladorUsuarios(){
        usuariosCadastrados = new ArrayList ();
   }
    
    public Usuario buscaUsuario(String cpf){
        if(usuariosCadastrados.isEmpty())
            return null;
        for(Usuario u: usuariosCadastrados){
            if(u.getCpf().equals(cpf))
                return u;
        }
        return null;
    }
    
    public boolean cadastrarUsuario (String nome, String cpf, Date nascimento, String telefone, TipoUsuario tipoUsuario, Endereco endereco, String senha){
        if(nome.equals("")||cpf.equals("")|| telefone.equals("") || endereco.equals("") || senha.equals(""))
        {
            return false;
        }
        
        if(buscaUsuario(cpf) != null){
            System.out.println("Usuário já existe!");
            return false;
        }
        Usuario usuario = new Usuario(nome, cpf, nascimento, telefone, tipoUsuario, endereco, senha);
        usuariosCadastrados.add(usuario);
        System.out.println("Usuario Cadastrado com sucesso");
        System.out.println(usuario.getCpf() +" "+usuario.getSenha());
        return true;
    }
    
    public boolean removeUsuario(String cpf){
        Usuario u=buscaUsuario(cpf);
        if(u != null){
            System.out.println("Usuário existe!");
            usuariosCadastrados.remove(u);
            return true;
        }
        else
        {
            System.out.println("Usuário não existe!");
            return false;
        }     
    }
    
    public Usuario realizarLogin(String cpf, String senha){
        Usuario u = buscaUsuario(cpf);
        if(u!=null){
            if(u.getSenha().equals(senha)){
                System.out.println("Login realizado com sucesso!");
            }
        }
        return u;
    }
        
}
