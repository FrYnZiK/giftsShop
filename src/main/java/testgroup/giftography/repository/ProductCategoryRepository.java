package testgroup.giftography.repository;

import testgroup.giftography.instances.Client;
import testgroup.giftography.instances.OrderStatus;
import testgroup.giftography.instances.ProductCategory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductCategoryRepository {

    Connection connection;

    public ProductCategoryRepository(Connection connection) {
        this.connection = connection;
    }

    public ProductCategory getProductCategory(int id) throws SQLException {

        String sql = "select * from category where categoryid=?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return ProductCategory.valueOf(resultSet.getString("productCategory"));
    }

    public int getProductCategoryId(ProductCategory category) throws SQLException {
        String sql = "select * from category where productCategory=?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, category.name());
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return resultSet.getInt("categoryid");
    }

    public boolean addProductCategory(ProductCategory productCategory) throws SQLException {
        String sql = "insert into category set productCategory=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, productCategory.name().toUpperCase());
        preparedStatement.executeUpdate();
        return true;
    }

    public boolean updateProductCategory(ProductCategory productCategory) throws SQLException {
        String sql = "update category set productCategory=? where productCategory=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, productCategory.name());
        preparedStatement.setString(2, productCategory.name());
        preparedStatement.executeUpdate();
        return true;
    }

    public boolean deleteProductCategory(ProductCategory productCategory) throws SQLException {
        String sql = "delete from category where productid=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, productCategory.name().toUpperCase());
        preparedStatement.executeUpdate();
        return true;
    }

}