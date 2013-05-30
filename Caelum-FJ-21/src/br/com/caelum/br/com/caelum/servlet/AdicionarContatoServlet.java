package br.com.caelum.br.com.caelum.servlet;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created with IntelliJ IDEA.
 * User: Thiago
 * Date: 5/26/13
 * Time: 4:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class AdicionarContatoServlet extends HttpServlet{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String nome = req.getParameter("nome");
        String email = req.getParameter("email");
        String endereco = req.getParameter("endereco");
        String dataNascimento = req.getParameter("dataNascimento");
        String id = req.getParameter("id");

        try {
            Contato contato = new Contato();
            contato.setNome(nome);
            contato.setEmail(email);
            contato.setEndereco(endereco);
            Calendar data = Calendar.getInstance();
            data.setTime(new SimpleDateFormat("dd/MM/yyyy").parse(dataNascimento));
            contato.setDataNascimento(data);
            new ContatoDao().adiciona(contato);
            resp.sendRedirect("listar-contatos.jsp");
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
