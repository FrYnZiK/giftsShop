import testgroup.giftography.instances.Client;
import testgroup.giftography.jdbc.SQLDatabaseConnection;
import testgroup.giftography.repository.ClientRepository;

import java.sql.Connection;
import java.sql.SQLException;

public class Runner {
    public static void main(String[] args) {
        Connection connection = new SQLDatabaseConnection().getConnection();
        ClientRepository clientRepository = new ClientRepository(connection);

        try {
            Client client = getStaticClient();
            clientRepository.updateClient(client);
            Client client1 = clientRepository.getClient(1);
            System.out.println(client1);

            Client client2 = new Client(
                    "Gleb",
                    "Hleb",
                    "Minsk",
                    "901",
                    "GlebHleb@rb.by");

            //clientRepository.addClient(client2);
            clientRepository.deleteClient(4);

        } catch (SQLException throwables) {
            System.err.println("ALERT!!!");
            throwables.printStackTrace();
        }
    }

    private static Client getStaticClient() {
        Client client = new Client(
                4,
                "Vitaliy",
                "Any",
                "addr",
                "103",
                "any@mail.com");
        return client;
    }

}
