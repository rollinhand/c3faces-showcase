package org.kivio.showcase.backingbean;

import org.kivio.c3faces.model.C3DataSet;
import org.kivio.c3faces.model.C3ViewDataSet;
import org.kivio.c3faces.script.property.Data;
import org.kivio.c3faces.style.C3Theme;

import java.io.Serializable;
import java.util.Arrays;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Björn Berg
 */
@ManagedBean(name = "chartTypesBean")
@RequestScoped
public class ChartTypesBean implements Serializable {

    private Data data = new Data();

    @PostConstruct
    public void init() {
        data.getDataSets().add(new C3ViewDataSet("Data sample 1",
                new C3DataSet(Arrays.asList(22, 91, 158, 93, 201, 11)),
                C3Theme.WARM_BLUE.getColor(0)));
        data.getDataSets().add(new C3ViewDataSet("Data sample 2",
                new C3DataSet(Arrays.asList(1, 72, 23, 33, 21)),
                C3Theme.WARM_BLUE.getColor(1)));
        data.getDataSets().add(new C3ViewDataSet("Data sample 3",
                new C3DataSet(Arrays.asList(45, 231, 2, 151, 341, 254)),
                C3Theme.WARM_BLUE.getColor(2)));
        data.getDataSets().add(new C3ViewDataSet("Data sample 4",
                new C3DataSet(Arrays.asList(88, 13, 258, 211, 151)),
                C3Theme.WARM_BLUE.getColor(3)));

    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
