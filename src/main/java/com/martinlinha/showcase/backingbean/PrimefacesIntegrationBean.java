package com.martinlinha.showcase.backingbean;

import com.martinlinha.c3faces.model.C3DataSet;
import com.martinlinha.c3faces.model.C3ViewDataSet;
import com.martinlinha.c3faces.script.property.Data;
import java.util.Arrays;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Martin Linha
 */
@ManagedBean(name = "primefacesIntegrationBean")
@ViewScoped
public class PrimefacesIntegrationBean {

    private Data data1 = new Data();
    private Data data2 = new Data();
    private Data data3 = new Data();
    private Data data4 = new Data();

    private C3ViewDataSet selectedDataSet;

    private final C3ViewDataSet dataSet1 = new C3ViewDataSet("Data sample 1",
            new C3DataSet(Arrays.asList(22, 91, 158, 93, 201, 11)), "#D7F707");
    private final C3ViewDataSet dataSet2 = new C3ViewDataSet("Data sample 2",
            new C3DataSet(Arrays.asList(1, 72, 23, 33, 21)), "#CCCCCC");
    private final C3ViewDataSet dataSet3 = new C3ViewDataSet("Data sample 3",
            new C3DataSet(Arrays.asList(45, 231, 2, 151, 341, 254)), "#EEFFEE");
    private final C3ViewDataSet dataSet4 = new C3ViewDataSet("Data sample 4",
            new C3DataSet(Arrays.asList(88, 13, 258, 211, 151)), "#EAFA7F");

    @PostConstruct
    public void init() {
        data1.getDataSets().add(dataSet1);
        data1.getDataSets().add(dataSet2);
        data1.getDataSets().add(dataSet3);

        data2.getDataSets().add(dataSet2);
        data3.getDataSets().add(dataSet3);
        data4.getDataSets().add(dataSet4);
    }

    public void showMessageDialog() {
        if (selectedDataSet == null) {
            return;
        }
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Selected data set info",
                "Name: " + selectedDataSet.getName() + ", color: " + selectedDataSet.getColor());

        RequestContext.getCurrentInstance().showMessageInDialog(message);
    }

    public Data getData1() {
        return data1;
    }

    public void setData1(Data data1) {
        this.data1 = data1;
    }

    public Data getData2() {
        return data2;
    }

    public void setData2(Data data2) {
        this.data2 = data2;
    }

    public Data getData3() {
        return data3;
    }

    public void setData3(Data data3) {
        this.data3 = data3;
    }

    public Data getData4() {
        return data4;
    }

    public void setData4(Data data4) {
        this.data4 = data4;
    }

    public C3ViewDataSet getSelectedDataSet() {
        return selectedDataSet;
    }

    public void setSelectedDataSet(C3ViewDataSet selectedDataSet) {
        this.selectedDataSet = selectedDataSet;
    }
}
