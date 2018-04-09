package controller;

import dao.dao;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import model.model;
import org.json.JSONException;

@Named(value = "controller")
@SessionScoped
public class controller implements Serializable {

   model lm = new model();
    public void consultarDni() throws Exception {
        dao ds;
        try {
          ds = new dao();
          lm =   ds.consultarDni(lm);
        } catch (IOException | JSONException e) {
            throw e;
        }
    }
    
    public void consultarRuc() throws Exception {
        dao ds;
        try {
          ds = new dao();
          lm =   ds.consultarRuc(lm);
        } catch (IOException | JSONException e) {
            throw e;
        }
    }

    public model getLm() {
        return lm;
    }

    public void setLm(model lm) {
        this.lm = lm;
    }
    
}
