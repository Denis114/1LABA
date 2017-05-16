package ManageBeans;

import egb.Usluga;
import DAO.UslugaDAO;
import DAO.UslugaRemote;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.event.CellEditEvent;

@Named(value = "uslugaBean")
@RequestScoped
public class UslugaBean {

    private List<Usluga> uslugas;
    @EJB
    private UslugaRemote dao;
    private List<Usluga> selectedUslugas;
    private Usluga selectedUsluga;

    public UslugaBean() {
        this.dao = new UslugaDAO();
    }

    public void delete() throws ParseException {
        try {
            dao.Delete(getSelectedUsluga());
            FacesContext.getCurrentInstance().getExternalContext().redirect("./managerIndex.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(UslugaBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();
        selectedUsluga = uslugas.get(event.getRowIndex());
        if (newValue != null && !newValue.equals(oldValue)) {
            dao.Update(selectedUsluga);
        }
    }

    @PostConstruct
    public void allUslugas(){
        try {
            uslugas=dao.getAllUsluga();
        } catch (SQLException ex) {
            Logger.getLogger(UslugaBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(UslugaBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        }

    public List<Usluga> getUslugas() {
        return uslugas;
    }

    public List<Usluga> getSelectedUslugas() {
        return selectedUslugas;
    }

    public void setAUslugas(List<Usluga> uslugas) {
        this.uslugas = uslugas;
    }
    public Usluga getSelectedUsluga() {
        return selectedUsluga;
    }

    public void setSelectedUsluga(Usluga selectedUsluga) {
        this.selectedUsluga = selectedUsluga;
    }

}
