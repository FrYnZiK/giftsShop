import testgroup.giftography.instances.Client;
import testgroup.giftography.jdbc.SQLDatabaseConnection;
import testgroup.giftography.repository.ClientRepository;

import java.sql.Connection;
import java.sql.SQLException;

public class Runner {
    public static void main(String[] args) {
        Connection connection = new SQLDatabaseConnection().getConnection();
        ClientRepository clientRepository = new ClientRepository(connection);

        Client client = new Client(
                4,
                "Vitaliy",
                "Any",
                "addr",
                "103",
                "any@mail.com");
        try {
            boolean b = clientRepository.updateClient(client);
            Client client1 = clientRepository.getClient(1);
            System.out.println(client1);
        } catch (SQLException throwables) {
            System.err.println("ALERT!!!");
            throwables.printStackTrace();
        }
    }

}
