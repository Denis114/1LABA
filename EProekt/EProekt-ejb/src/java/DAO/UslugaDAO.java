package DAO;

import egb.Usluga;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import java.sql.Statement;
import java.text.ParseException;


@Stateless
public class UslugaDAO extends DAO.Dao implements Serializable, UslugaRemote{
       private static PreparedStatement stm;
    private static ResultSet rs;
    private static String sql;          
      
      @Override
       public List<Usluga> getAllUsluga() throws SQLException, ParseException {
           List<Usluga> list = new ArrayList<>(); 
                openConnection();
          sql = "SELECT * FROM `usluga`";
         stm = connection.prepareStatement(sql);
         rs = stm.executeQuery();
               while (rs.next()) {
            Usluga us = new Usluga();
            us.setUsligaId(rs.getInt("usligaId"));
            us.setName(rs.getString("name"));
           us.setChena(rs.getFloat("chena"));
            list.add(us);
               }
           closeConnection();
        return list;
       }
    
    @Override
        
      public  void AddNewUsluga(Usluga z) {
        try {
          openConnection();
         sql = "INSERT INTO `usluga`(UsligaId, name, chena) VALUES (null,?,?)";
        stm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        stm.setString(1, z.getName());
        stm.setFloat(2, z.getChena());
       stm.executeUpdate();
       } catch (SQLException ex) {
            Logger.getLogger(UslugaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
           closeConnection();
    }
      }
  
     

  @Override
  
  public  void Update(Usluga z) {
      try {
       openConnection();
         sql = "UPDATE `usluga` SET name=?, chena=? WHERE UsligaId=?";
         stm = connection.prepareStatement(sql);
        stm.setString(1, z.getName());
        stm.setFloat(2, z.getChena());
        stm.setInt(3, z.getUsligaId());
        stm.executeUpdate();
       } catch (SQLException ex) {
            Logger.getLogger(UslugaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnection();
        }
    }  
  
     public  void Delete(Usluga z)  {
         try {
       openConnection();
         sql = "DELETE FROM `usluga` WHERE UsligaId=?";
         stm = connection.prepareStatement(sql);
        stm.setInt(1, z.getUsligaId());
        stm.executeUpdate();
     } catch (SQLException ex) {
            Logger.getLogger(UslugaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnection();
        }
    }  
      
     @Override
    public Usluga getByName(String name) throws SQLException, ParseException   {
        Usluga a = new Usluga();
        try {
            openConnection();
            sql = "SELECT * FROM `usluga` WHERE name = ?";
            stm = connection.prepareStatement(sql);
            stm.setString(1, name);
            rs = stm.executeQuery();
            rs.next();            
            a.setName(rs.getString("name"));
            a.setChena(rs.getFloat("chena"));
            a.setUsligaId(rs.getInt("usligaId"));
             } catch (SQLException ex) {
            Logger.getLogger(UslugaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnection();
            return a;
        }
    }
     public Usluga GetByID(int uid) throws SQLException, ParseException {
           openConnection();
        sql = "SELECT * FROM usluga WHERE UsligaId=" + uid;
        
        stm = connection.prepareStatement(sql);
        rs = stm.executeQuery();
        Usluga usluga = new Usluga();
        while (rs.next()) {
        
        usluga.setUsligaId(rs.getInt("usligaId"));
        usluga.setName(rs.getString("name"));
        usluga.setChena(rs.getFloat("chena"));
                }
        closeConnection();
        return usluga;
    }
}

