package br.com.caelum.br.com.caelum.servlet;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Thiago
 * Date: 5/26/13
 * Time: 8:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class RemoverContatoServlet extends HttpServlet{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParam = req.getParameter("id");
        Integer id = idParam==null?null:Integer.parseInt(idParam);
        Contato contato = new Contato();
        contato.setId(id);
        new ContatoDao().remove(contato);
        resp.sendRedirect("listar-contatos.jsp");
    }
}
