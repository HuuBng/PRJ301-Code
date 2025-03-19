package pe.employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import pe.utils.DBUtils;

public class EmployeeDAO {
    //your code here
    public List<EmployeeDTO> selectAll() throws SQLException, ClassNotFoundException {
        Connection con = DBUtils.getConnection();
        
        Statement stm = con.createStatement();
        
        ResultSet rs = stm.executeQuery("SELECT * FROM Employee");
        
        List<EmployeeDTO> list = new ArrayList<>();
        
        while(rs.next()) {
            EmployeeDTO em = new EmployeeDTO();
            em.setId(rs.getInt("Id"));
            em.setFullName(rs.getString("FullName"));
            em.setDob(rs.getDate("DoB"));
            em.setSalary(rs.getDouble("Salary"));
            
            list.add(em);
        }
        
        con.close();
        return list;
    }
    
    public void create(EmployeeDTO em) throws SQLException, ClassNotFoundException {
        Connection con = DBUtils.getConnection();
        
        PreparedStatement stm = con.prepareStatement("INSERT INTO Employee VALUES(?, ?, ?)");
        
        stm.setString(1, em.getFullName());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        stm.setString(2, sdf.format(em.getDob()));
        stm.setDouble(3, em.getSalary());
        
        int count = stm.executeUpdate();
        
        con.close();
    }
    
    public List<EmployeeDTO> search(String fullName) throws SQLException, ClassNotFoundException {
        Connection con = DBUtils.getConnection();
        
        String sql ="SELECT * FROM Employee WHERE FullName LIKE '%" + fullName + "%'";
        PreparedStatement stm = con.prepareStatement(sql);
        
        ResultSet rs = stm.executeQuery();
        
        List<EmployeeDTO> list = new ArrayList<>();
        
        while(rs.next()) {
            EmployeeDTO em = new EmployeeDTO();
            em.setId(rs.getInt("Id"));
            em.setFullName(rs.getString("FullName"));
            em.setDob(rs.getDate("DoB"));
            em.setSalary(rs.getDouble("Salary"));
            
            list.add(em);
        }
        
        con.close();
        return list;
    }
    
    public void remove(int id) throws SQLException, ClassNotFoundException {
        Connection con = DBUtils.getConnection();
        
        PreparedStatement stm = con.prepareStatement("DELETE FROM Employee WHERE id = ?");
        
        stm.setInt(1, id);
        
        int count = stm.executeUpdate();
        
        con.close();
    }
}
