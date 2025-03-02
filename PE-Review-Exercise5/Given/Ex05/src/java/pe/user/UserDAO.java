/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import pe.utils.DBUtils;


/**
 *
 * @author Hoadnt
 */
public class UserDAO {
//    your code here
    
    public UserDTO login(String userID, String password) throws ClassNotFoundException, SQLException {
        
        Connection con = DBUtils.getConnection();
        
        PreparedStatement stm = con.prepareStatement("SELECT * FROM tblUsers WHERE userID = ? AND password = ?");
        
        stm.setString(1, userID.toUpperCase());
        stm.setString(2, password);
        
        ResultSet rs = stm.executeQuery();
        UserDTO user = null;
        
        if(rs.next()) {
            user = new UserDTO();
            user.setUserID(rs.getString("userID"));
            user.setFullName(rs.getString("fullName"));
            user.setRoleID(rs.getString("roleID"));
            user.setPassword(rs.getString("password"));
        }
        
        con.close();
        return user;
    }
    
}
