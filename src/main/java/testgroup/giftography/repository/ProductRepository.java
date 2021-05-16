package testgroup.giftography.repository;

import testgroup.giftography.instances.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRepository {

    Connection connection;

    public ProductRepository(Connection connection) {
        this.connection = connection;
    }


    public Product getProduct(int id) throws SQLException {

        String sql = "select * from product where productid=?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return new Product(
                id,
                resultSet.getString("name"),
                resultSet.getString("description"),
                resultSet.getInt("price"),
                ProductCategory.valueOf(resultSet.getString("productCategory"))
        );
    }

    public Product getProduct(String name) throws SQLException {

        String sql = "select * from product where name = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, name);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();


        return new Product(
                name,
                resultSet.getString("description"),
                resultSet.getInt("price"),
                ProductCategory.valueOf(resultSet.getString("productCategory"))
        );
    }

    public boolean addProduct(Product product) throws SQLException {
        String sql = "insert into product set name=?, discription=?, price=?, productCategory=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, product.getName());
        preparedStatement.setString(2, product.getDescription());
        preparedStatement.setInt(3, product.getPrice());
        preparedStatement.setString(4, product.getCategory().name().toUpperCase());

        preparedStatement.executeUpdate();

        return true;
    }

    public boolean updateProduct(Product product) throws SQLException {
        String sql = "update product set name=?, discription=?, price=?, productCategory=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, product.getName());
        preparedStatement.setString(2, product.getDescription());
        preparedStatement.setInt(3, product.getPrice());
        preparedStatement.setString(4, product.getCategory().name().toUpperCase());
        preparedStatement.executeUpdate();

        return true;
    }

    public boolean deleteProduct(int id) throws SQLException {

        String sql = "delete from product where productid=?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);

        preparedStatement.executeUpdate();

        return true;
    }
}
