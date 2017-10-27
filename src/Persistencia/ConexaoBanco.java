/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.Endereco;
import Modelo.TipoUsuario;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.util.locale.StringTokenIterator;
/**
 *
 * @author jw
 */
public class ConexaoBanco  {

    String sql;
    PreparedStatement stmt;
    ResultSet rs;
    java.sql.Connection conexao;
    
    public ConexaoBanco() throws SQLException {
        this.sql = null;
        this.stmt = null;
        this.rs = null;
        this.conexao = DriverManager.getConnection("jdbc:mysql://localhost/videotopdb", "root", "foiprotpdetopicos");
    }
    
    public boolean  insertUsuario(String nome, String cpf, Date nascimento, String telefone, TipoUsuario tipoUsuario, Endereco endereco, String senha) throws SQLException{
        DateFormat df= new SimpleDateFormat("yyyy-mm-dd");
        try {
            nascimento=df.parse("1996-02-14");
        } catch (ParseException ex) {
            Logger.getLogger(ConexaoBanco.class.getName()).log(Level.SEVERE, null, ex);
        }
        cpf=cpf.replace(".", "");
        cpf=cpf.replace("-", "");
        sql = "INSERT INTO usuario (cpf,senha,nome,dataNascimento,logradouro,numero,bairro,cep,telefone, idtipoUsuario)VALUES(?,?,?,?,?,?,?,?,?,?)";
                    stmt = conexao.prepareStatement(sql);
                    stmt.setString(1, cpf);
                    stmt.setString(2, senha);
                    stmt.setString(3, nome);
                    stmt.setString(4, "1996-02-14");
                    stmt.setString(5, endereco.getLogradouro());
                    stmt.setString(6, Integer.toString( endereco.getNumero()));
                    stmt.setString(7, endereco.getBairro());
                    stmt.setString(8,endereco.getCep());
                    stmt.setString(9,telefone);
                    stmt.setInt(10, 2);
                    
                    stmt.execute();
                    stmt.close();
                
                return  true;
    }
    
      
}
