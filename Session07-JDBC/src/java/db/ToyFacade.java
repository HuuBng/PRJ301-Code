package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/*
Cung cap cac phuong thuc truy cap vao table toy
aka ToyDAO
 */
public class ToyFacade {

    /*
    Doc toan bo table toy
     */
    public List<Toy> select() throws SQLException {
        List<Toy> list = null;
        //Tao connection
        Connection con = DBContext.getConnection();
        // Tao doi tuong stm va thuc hien lenh SELECT
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery("SELECT * FROM Toy");
        list = new ArrayList<>();
        while (rs.next()) {
            // Doc row hien tai vao doi tuong toy
            Toy toy = new Toy();
            toy.setId(rs.getString("Id"));
            toy.setName(rs.getString("Name"));
            toy.setPrice(rs.getDouble("Price"));
            toy.setExpDate(rs.getDate("ExpDate"));
            toy.setBrand(rs.getString("Brand"));
            // Them toy vao list
            list.add(toy);
        }
        // Close connection
        con.close();
        return list;
    }

    public void create(Toy toy) throws SQLException {
        //Tao connection
        Connection con = DBContext.getConnection();
        // Tao doi tuong stm va chuan bi cau lenh SQL
        PreparedStatement stm = con.prepareStatement("INSERT toy VALUES(?, ?, ?, ?, ?)");
        // Cung cap gia tri cho cac tham so
        stm.setString(1, toy.getId());
        stm.setString(2, toy.getName());
        stm.setDouble(3, toy.getPrice());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        stm.setString(4, sdf.format(toy.getExpDate()));
        stm.setString(5, toy.getBrand());
        // Thuc hien lenh SQL
        int count = stm.executeUpdate();

        // Close connection
        con.close();
    }

    public void delete(String id) throws SQLException {
        //Tao connection
        Connection con = DBContext.getConnection();
        // Tao doi tuong stm va chuan bi cau lenh SQL
        PreparedStatement stm = con.prepareStatement("DELETE toy WHERE id = ?");
        // Cung cap gia tri cho cac tham so
        stm.setString(1, id);

        // Thuc hien lenh SQL
        int count = stm.executeUpdate();

        // Close connection
        con.close();
    }

    public Toy read(String id) throws SQLException {
        //Tao connection
        Connection con = DBContext.getConnection();
        // Tao doi tuong stm va chuan bi cau lenh SQL
        PreparedStatement stm = con.prepareStatement("SELECT * FROM toy WHERE id = ?");
        // Cung cap gia tri cho cac tham so
        stm.setString(1, id);

        // Thuc hien lenh SQL
        ResultSet rs = stm.executeQuery();
        Toy toy = new Toy();

        while (rs.next()) {
            // Doc row hien tai vao doi tuong toy
            toy.setId(rs.getString("Id"));
            toy.setName(rs.getString("Name"));
            toy.setPrice(rs.getDouble("Price"));
            toy.setExpDate(rs.getDate("ExpDate"));
            toy.setBrand(rs.getString("Brand"));
        }

        // Close connection
        con.close();
        return toy;
    }

    public void update(Toy toy) throws SQLException {
        //Tao connection
        Connection con = DBContext.getConnection();
        // Tao doi tuong stm va chuan bi cau lenh SQL
        PreparedStatement stm = con.prepareStatement("UPDATE Toy SET Name=?, Price=?, expDate=?, Brand=? WHERE id=?");
        // Cung cap gia tri cho cac tham so
        stm.setString(1, toy.getName());
        stm.setDouble(2, toy.getPrice());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        stm.setString(3, sdf.format(toy.getExpDate()));
        stm.setString(4, toy.getBrand());
        stm.setString(5, toy.getId());

        // Thuc hien lenh SQL
        int count = stm.executeUpdate();

        // Close connection
        con.close();
    }

}
