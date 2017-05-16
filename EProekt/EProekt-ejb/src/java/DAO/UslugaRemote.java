/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import egb.Usluga;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Денис
 */
@Remote
public interface UslugaRemote {
    public void AddNewUsluga(Usluga z);
    public void Update(Usluga z);
    public void Delete(Usluga z);
    public List<Usluga> getAllUsluga()throws SQLException, ParseException;
    public Usluga getByName(String name)throws SQLException, ParseException; 
    public Usluga GetByID(int uid) throws SQLException, ParseException;
    
}
