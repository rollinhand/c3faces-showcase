package com.martinlinha.showcase.backingbean;

import com.martinlinha.c3faces.model.C3DataSet;
import com.martinlinha.c3faces.model.C3ViewDataSet;
import com.martinlinha.c3faces.script.property.Data;
import java.io.Serializable;
import java.util.Arrays;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Martin Linha
 */
@ManagedBean(name = "chartTypesBean")
@RequestScoped
public class ChartTypesBean implements Serializable {

    private Data model = new Data();

    @PostConstruct
    public void init() {
        model.getDataSets().add(new C3ViewDataSet("Data sample 1",
                new C3DataSet(Arrays.asList(22, 91, 158, 93, 201, 11)), "#1060E0"));
        model.getDataSets().add(new C3ViewDataSet("Data sample 2",
                new C3DataSet(Arrays.asList(1, 72, 23, 33, 21)), "#16525E"));
        model.getDataSets().add(new C3ViewDataSet("Data sample 3",
                new C3DataSet(Arrays.asList(45, 231, 2, 151, 341, 254)), "#0792AD"));
        model.getDataSets().add(new C3ViewDataSet("Data sample 4",
                new C3DataSet(Arrays.asList(88, 13, 258, 211, 151)), "#8FE2F2"));

    }

    public Data getModel() {
        return model;
    }

    public void setModel(Data model) {
        this.model = model;
    }
}
