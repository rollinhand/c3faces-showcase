package org.kivio.showcase.backingbean;

import org.kivio.c3faces.model.C3DataSet;
import org.kivio.c3faces.model.C3ViewDataSet;
import org.kivio.c3faces.script.property.Data;
import java.io.Serializable;
import java.util.Arrays;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Björn Berg
 */
@ManagedBean(name = "chartPropertiesFaceletBean")
@ViewScoped
public class ChartPropertiesFaceletBean implements Serializable {

    private final Data data = new Data();

    @PostConstruct
    public void init() {
        data.getDataSets().add(new C3ViewDataSet("Data sample 1",
                new C3DataSet(Arrays.asList(22.2, 91, 158, 93.33, 201, 11)), "#0F9413"));
        data.getDataSets().add(new C3ViewDataSet("Data sample 2",
                new C3DataSet(Arrays.asList(1, 72, 23, 33, 21)), "#558A57"));
        data.getDataSets().add(new C3ViewDataSet("Data sample 3",
                new C3DataSet(Arrays.asList(45, 231, 2.232, 151, 341, 254)), "#A4DEA6"));
        data.getDataSets().add(new C3ViewDataSet("Data sample 4",
                new C3DataSet(Arrays.asList(88, 13, 258.1, 211, 151)), "#07F70F"));
    }

    public Data getData() {
        return data;
    }
}
