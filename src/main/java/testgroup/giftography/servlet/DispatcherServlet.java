package testgroup.giftography.servlet;

import testgroup.giftography.instances.Client;
import testgroup.giftography.jdbc.SQLDatabaseConnection;
import testgroup.giftography.repository.ClientRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class DispatcherServlet extends HttpServlet {
    Connection connection = new SQLDatabaseConnection().getConnection();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        Client client = new Client(
                req.getParameter("name"),
                req.getParameter("surname"),
                req.getParameter("address"),
                req.getParameter("phone"),
                req.getParameter("email")
        );

        if (client.getEmail() == null) {
            resp.setStatus(403);
            resp.getWriter().println("not ok");
        }

        try {
            new ClientRepository(connection).addClient(client);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        resp.setStatus(200);
        resp.getWriter().println("ok");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
