package org.kivio.showcase.backingbean;

import org.kivio.c3faces.model.C3CategorySet;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;

/**
 *
 * @author Björn Berg, rollin.hand@gmx.de
 */
@ManagedBean(name = "categoryBean")
@RequestScoped
public class CategoryBean implements Serializable {

    private transient C3CategorySet c3Category;

    @PostConstruct
    public void init() {
        c3Category = new C3CategorySet(new String []{"Mon", "Tue", "Wed", "Thu", "Fri", "Sat"});
    }

    public C3CategorySet getCategory() {
        return c3Category;
    }

    public void setCategory(C3CategorySet c3Category) {
        this.c3Category = c3Category;
    }
}
