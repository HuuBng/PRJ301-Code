/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.car;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import pe.utils.DBUtils;

/**
 *
 * @author hd
 */
public class CarDAO {

//   your code here
    public List<CarDTO> list() throws ClassNotFoundException, SQLException {
        Connection con = DBUtils.getConnection();

        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery("SELECT * FROM tblCars");

        List<CarDTO> list = new ArrayList<>();

        while (rs.next()) {
            CarDTO car = new CarDTO();
            car.setId(rs.getString("id"));
            car.setName(rs.getString("name"));
            car.setDescription(rs.getString("description"));
            car.setPrice(rs.getDouble("price"));
            car.setSpeed(rs.getInt("speed"));
            car.setStatus(rs.getBoolean("status"));

            list.add(car);
        }

        con.close();
        return list;
    }

    public void create(String id, String name, String description, double price, int speed, boolean status) throws SQLException, ClassNotFoundException {
        Connection con = DBUtils.getConnection();
        
        PreparedStatement stm = con.prepareStatement("INSERT tblCars VALUES(?,?,?,?,?,?)");
        
        stm.setString(1, id);
        stm.setString(2, name);
        stm.setString(3, description);
        stm.setDouble(4, price);
        stm.setInt(5, speed);
        stm.setBoolean(6, status);
        
        int count = stm.executeUpdate();
        
        con.close();
    }
}
