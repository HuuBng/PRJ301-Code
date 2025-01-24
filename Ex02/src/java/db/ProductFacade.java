package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ProductFacade {

    public List<Product> select() throws SQLException {
        List<Product> list = null;
        Connection con = DBContext.getConnection();
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery("SELECT * FROM product");
        list = new ArrayList<>();
        while (rs.next()) {
            Product product = new Product();
            product.setId(rs.getString("id"));
            product.setName(rs.getString("name"));
            product.setPrice(rs.getDouble("price"));
            product.setExpDate(rs.getDate("expDate"));
            list.add(product);
        }

        con.close();
        return list;
    }
    
    public void create(Product product) throws SQLException {
        //Tao connection
        Connection con = DBContext.getConnection();
        // Tao doi tuong stm va chuan bi cau lenh SQL
        PreparedStatement stm = con.prepareStatement("INSERT INTO product VALUES(?, ?, ?)");
        // Cung cap gia tri cho cac tham so
        
        // Vi co identity auto +1 id nen getId ko can
        //stm.setString(1, product.getId());
        stm.setString(1, product.getName());
        stm.setDouble(2, product.getPrice());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        stm.setString(3, sdf.format(product.getExpDate()));
        // Thuc hien lenh SQL
        int count = stm.executeUpdate();

        // Close connection
        con.close();
    }

    public void delete(String id) throws SQLException {
        //Tao connection
        Connection con = DBContext.getConnection();
        // Tao doi tuong stm va chuan bi cau lenh SQL
        PreparedStatement stm = con.prepareStatement("DELETE product WHERE id = ?");
        // Cung cap gia tri cho cac tham so
        stm.setString(1, id);

        // Thuc hien lenh SQL
        int count = stm.executeUpdate();

        // Close connection
        con.close();
    }

    public Product read(String id) throws SQLException {
        //Tao connection
        Connection con = DBContext.getConnection();
        // Tao doi tuong stm va chuan bi cau lenh SQL
        PreparedStatement stm = con.prepareStatement("SELECT * FROM product WHERE id = ?");
        // Cung cap gia tri cho cac tham so
        stm.setString(1, id);

        // Thuc hien lenh SQL
        ResultSet rs = stm.executeQuery();
        Product product = new Product();

        while (rs.next()) {
            // Doc row hien tai vao doi tuong product
            product.setId(rs.getString("Id"));
            product.setName(rs.getString("Name"));
            product.setPrice(rs.getDouble("Price"));
            product.setExpDate(rs.getDate("ExpDate"));
        }

        // Close connection
        con.close();
        return product;
    }

    public void update(Product product) throws SQLException {
        //Tao connection
        Connection con = DBContext.getConnection();
        // Tao doi tuong stm va chuan bi cau lenh SQL
        PreparedStatement stm = con.prepareStatement("UPDATE Product SET Name=?, Price=?, expDate=? WHERE id=?");
        // Cung cap gia tri cho cac tham so
        stm.setString(1, product.getName());
        stm.setDouble(2, product.getPrice());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        stm.setString(3, sdf.format(product.getExpDate()));
        stm.setString(4, product.getId());

        // Thuc hien lenh SQL
        int count = stm.executeUpdate();

        // Close connection
        con.close();
    }
}
