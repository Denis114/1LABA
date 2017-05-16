/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package egb;

import java.io.Serializable;

/**
 *
 * @author Денис
 */

public class Usluga implements Serializable {

   
    private Integer usligaId;
    private String name;
    private float chena;
    
       
    public Integer getUsligaId() {
        return usligaId;
    }

    public void setUsligaId(Integer usligaId) {
        this.usligaId = usligaId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getChena() {
        return chena;
    }

    public void setChena(float chena) {
        this.chena = chena;
    }

      
}
