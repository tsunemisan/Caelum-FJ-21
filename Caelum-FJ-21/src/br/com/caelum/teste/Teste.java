package br.com.caelum.teste;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

import java.util.Calendar;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Thiago
 * Date: 5/26/13
 * Time: 3:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class Teste {
    public static void main(String[] args) {
        List<Contato> contatos = new ContatoDao().getLista();
        for(Contato contato:contatos){
            new ContatoDao().remove(contato);
        }
    }
}
