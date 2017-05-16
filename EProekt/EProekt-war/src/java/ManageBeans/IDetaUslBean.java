/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManageBeans;


import egb.Usluga;
import javax.ejb.Local;

/**
 *
 * @author Денис
 */
@Local
public interface IDetaUslBean {
public Usluga getSelectUsluga();
public void setSelectName(String name);
public void setSelectedId(int id);
}
  


 