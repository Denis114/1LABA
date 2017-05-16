/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManageBeans;


import DAO.UslugaRemote;
import Singleton.SltBean;
import egb.Usluga;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.interceptor.Interceptors;

/**
 *
 * @author Денис
 */
@Stateful
@Named(value = "detaUslBean")
@ConversationScoped
public class DetaUslBean implements IDetaUslBean, Serializable {

    @Inject//иньекция
    private Conversation conv;
    @EJB
    private UslugaRemote usldao;
    private Usluga selectUsluga;
    private String selectedName;

    

    @Override
    public void setSelectName(String name)
    {
        
        if (conv.isTransient()) {
            conv.begin();
        }
         try {
               
              selectUsluga=usldao.getByName(name);
            conv.end();
            FacesContext.getCurrentInstance().getExternalContext().redirect("./selected.xhtml");
        } catch (ParseException | IOException ex) {
            Logger.getLogger(DetaUslBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DetaUslBean.class.getName()).log(Level.SEVERE, null, ex);
        }
           } 
     @Override
    public void setSelectedId(int id) {
        if(conv.isTransient()){
            conv.begin();
        }
        try {
            selectUsluga=usldao.GetByID(id);
            conv.end();
            FacesContext.getCurrentInstance().getExternalContext().redirect("./selected.xhtml");
        } catch (SQLException | ParseException | IOException ex) {
            Logger.getLogger(DetaUslBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    @Override
     @Interceptors(SltBean.class)
     public Usluga getSelectUsluga() {
                return selectUsluga;
    }
}



    
  
    

