/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ManageBeans;

import egb.Usluga;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;


@Named(value = "sessionBean")
@SessionScoped
public class SessionBean implements Serializable{

    @EJB
    private IDetaUslBean uslBean;
    @EJB
    private Singleton.SltBean singleton;
       private Usluga selectUsluga;
        private String selectName;

            public SessionBean() {
             }
            
             public Usluga getSelectUsluga() {
        return selectUsluga;
    }
             
         public void setSelectedName(String selectName) {
             this.selectName=selectName;
            uslBean.setSelectName(selectName);
            selectUsluga=uslBean.getSelectUsluga();
        
    }
          public void setSelectedId(int id) {
        uslBean.setSelectedId(id);
        selectUsluga = uslBean.getSelectUsluga();
    }
    
    public int getNumber() {
        return singleton.getCount();
    }
    
    public void setSelectUsluga(Usluga selectUsluga) {
        this.selectUsluga = selectUsluga;
    }
    public String getSelectName() {
        return selectName;
    }
   
       
        }



    

  
  


  
    
   
    







  




