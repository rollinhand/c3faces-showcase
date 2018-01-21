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
@ManagedBean(name = "chartValuesBean")
@ViewScoped
public class ChartValuesBean implements Serializable {

    private final Data data = new Data();
    private C3ViewDataSet data1 = new C3ViewDataSet("Data sample 1",
            new C3DataSet(Arrays.asList(22, 91, 158, 93, 201, 11)), "#D7F707");
    private C3ViewDataSet data2 = new C3ViewDataSet("Data sample 2",
            new C3DataSet(Arrays.asList(1, 72, 23, 33, 21)), "#A3BA0B");
    private C3ViewDataSet data3 = new C3ViewDataSet("Data sample 3",
            new C3DataSet(Arrays.asList(45, 231, 2, 151, 341, 254)), "#BBC961");
    private C3ViewDataSet data4 = new C3ViewDataSet("Data sample 4",
            new C3DataSet(Arrays.asList(88, 13, 258, 211, 151)), "#EAFA7F");

    @PostConstruct
    public void init() {
        data.getDataSets().add(data1);
        data.getDataSets().add(data2);
        data.getDataSets().add(data3);
        data.getDataSets().add(data4);
    }

    public Data getData() {
        return data;
    }

    public C3ViewDataSet getData1() {
        return data1;
    }

    public void setData1(C3ViewDataSet data1) {
        this.data1 = data1;
    }

    public C3ViewDataSet getData2() {
        return data2;
    }

    public void setData2(C3ViewDataSet data2) {
        this.data2 = data2;
    }

    public C3ViewDataSet getData3() {
        return data3;
    }

    public void setData3(C3ViewDataSet data3) {
        this.data3 = data3;
    }

    public C3ViewDataSet getData4() {
        return data4;
    }

    public void setData4(C3ViewDataSet data4) {
        this.data4 = data4;
    }
}
