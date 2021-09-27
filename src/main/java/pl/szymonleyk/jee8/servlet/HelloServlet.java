package pl.szymonleyk.jee8.servlet;

import pl.szymonleyk.jee8.repository.AdresRepository;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addresses")
public class HelloServlet extends HttpServlet {

    @Inject
    private AdresRepository adresRepository;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write(adresRepository.getAll().toString());
    }

}
