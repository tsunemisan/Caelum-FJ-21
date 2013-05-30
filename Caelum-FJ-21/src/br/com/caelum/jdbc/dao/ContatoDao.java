package br.com.caelum.jdbc.dao;

import br.com.caelum.jdbc.modelo.Contato;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Thiago
 * Date: 5/26/13
 * Time: 2:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class ContatoDao {
    private Connection connection;

    public ContatoDao() {
        try {
            connection = new ConnectionFactory().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public  void adiciona(Contato contato){

        try {
            String sql = "insert into contatos (nome,email,endereco,dataNascimento)" +
                    "values(?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            int i = 1;
            ps.setString(i++,contato.getNome());
            ps.setString(i++,contato.getEmail());
            ps.setString(i++,contato.getEndereco());
            ps.setDate(i++, new Date(contato.getDataNascimento().getTimeInMillis()));
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Contato> getLista(){
        try {
            List<Contato> contatos = new ArrayList<Contato>();
            PreparedStatement ps = connection.prepareStatement("select * from contatos");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Contato contato = new Contato();
                contato.setId(rs.getInt("id"));
                contato.setNome(rs.getString("nome"));
                contato.setEmail(rs.getString("email"));
                contato.setEndereco(rs.getString("endereco"));
                Calendar data = Calendar.getInstance();
                data.setTime(rs.getDate("dataNascimento"));
                contato.setDataNascimento(data);
                contatos.add(contato);
            }
            return contatos;
        } catch (SQLException e) {
          throw new RuntimeException(e);
        }
    }

    public void altera(Contato contato){
        String sql = "udpate contatos set nome=?, email=?, endereco=?,dataNascimento=?" +
                "where id =?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            int i = 1;
            ps.setString(i++,contato.getNome());
            ps.setString(i++,contato.getEmail());
            ps.setString(i++, contato.getEndereco());
            ps.setDate(i++, new Date(contato.getDataNascimento().getTimeInMillis()));
            ps.setInt(i++,contato.getId());
            ps.execute();
            ps.close();
        } catch (SQLException e) {
           throw new RuntimeException(e);
        }
    }

    public void remove(Contato contato){
        try {
            String sql = "delete from contatos where id =?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,contato.getId());
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
