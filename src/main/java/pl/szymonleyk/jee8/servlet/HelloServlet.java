package pl.szymonleyk.jee8.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/students")
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        // jeden student
        if(id != null){
            Integer.valueOf(id);
            resp.getWriter().write();
        } else {
            // daj wszystkich
            resp.getWriter().write();
        }
    }

}
