package com.martinlinha.showcase.backingbean;

import com.martinlinha.c3faces.model.C3DataSet;
import com.martinlinha.c3faces.model.C3ViewDataSet;
import com.martinlinha.c3faces.script.property.Data;
import java.io.Serializable;
import java.util.Arrays;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Martin Linha
 */
@ManagedBean(name = "chartValueChangeListenerBean")
@ViewScoped
public class ChartValueChangeListenerBean implements Serializable {

    private final Data data = new Data();
    private C3ViewDataSet data1 = new C3ViewDataSet("Data sample 1",
            new C3DataSet(Arrays.asList(55, 91, 158, 93, 201, 11)), "#996699");
    private C3ViewDataSet data2 = new C3ViewDataSet("Data sample 2",
            new C3DataSet(Arrays.asList(1, 31, 63, 13, 21)), "#CCCCCC");
    private C3ViewDataSet data3 = new C3ViewDataSet("Data sample 3",
            new C3DataSet(Arrays.asList(153, 231, 2, 151, 341, 254)), "#000000");
    private C3ViewDataSet data4 = new C3ViewDataSet("Data sample 4",
            new C3DataSet(Arrays.asList(211, 301, 258, 271, 151)), "#006699");

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
