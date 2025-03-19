package pe.account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import pe.utils.DBUtils;

public class AccountDAO {

    //your code here
    public List<AccountDTO> selectAll() throws SQLException, ClassNotFoundException {
        Connection con = DBUtils.getConnection();

        Statement stm = con.createStatement();

        ResultSet rs = stm.executeQuery("SELECT * FROM Account");

        List<AccountDTO> list = new ArrayList<>();

        while (rs.next()) {
            AccountDTO ac = new AccountDTO();
            ac.setId(rs.getInt("Id"));
            ac.setEmail(rs.getString("Email"));
            ac.setFullName(rs.getString("FullName"));
            ac.setRoleId(rs.getString("RoleId"));
            ac.setPassword(rs.getString("Password"));

            list.add(ac);
        }

        con.close();
        return list;
    }

    public AccountDTO login(String email, String password) throws SQLException, ClassNotFoundException {
        Connection con = DBUtils.getConnection();

        String sql = "SELECT * FROM Account WHERE Email = '" + email + "' AND Password = '"+ password +"'";
        
        PreparedStatement stm = con.prepareStatement(sql);

        ResultSet rs = stm.executeQuery();

        AccountDTO ac = new AccountDTO();

        if (rs.next()) {
            ac.setId(rs.getInt("Id"));
            ac.setEmail(rs.getString("Email"));
            ac.setFullName(rs.getString("FullName"));
            ac.setRoleId(rs.getString("RoleId"));
            ac.setPassword(rs.getString("Password"));
        }

        con.close();
        return ac;
    }
}
