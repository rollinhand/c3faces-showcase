package org.kivio.showcase.backingbean;


import org.kivio.c3faces.model.C3DataSet;
import org.kivio.c3faces.model.C3ViewDataSet;
import org.kivio.c3faces.script.property.Data;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.Arrays;

/**
 *
 * @author Björn Berg
 */
@ManagedBean(name = "changeChartTypeBean")
@ViewScoped
public class ChangeChartTypeBean implements Serializable {

    private final Data data = new Data();

    @PostConstruct
    public void init() {
        data.getDataSets().add(new C3ViewDataSet("Data sample 1",
                new C3DataSet(Arrays.asList(22, 91, 158, 93, 201, 11)), "#DE1820"));
        data.getDataSets().add(new C3ViewDataSet("Data sample 2",
                new C3DataSet(Arrays.asList(1, 72, 23, 33, 21)), "#96171B"));
        data.getDataSets().add(new C3ViewDataSet("Data sample 3",
                new C3DataSet(Arrays.asList(45, 231, 2, 151, 341, 254)), "#EB7F83"));
        data.getDataSets().add(new C3ViewDataSet("Data sample 4",
                new C3DataSet(Arrays.asList(88, 13, 258, 211, 151)), "#BF888A"));
    }

    public Data getData() {
        return data;
    }
}
