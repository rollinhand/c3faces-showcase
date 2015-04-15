package com.martinlinha.showcase.backingbean;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Martin Linha
 */
@ManagedBean(name = "pieChartBean")
@ViewScoped
public class PieChartBean implements Serializable {
//
//    private ChartModel model1;
//    private ChartModel model2;
//    private ChartModel model3;
//    private ChartModel selectedModel;
//    private C3ViewDataSet selectedData;
//    private String str;
//    private C3ViewDataSet data1;
//    private C3ViewDataSet data2;
//    private C3ViewDataSet data3 = new C3ViewDataSet("Kladno", new C3DataSet(Arrays.asList(32, 522, 5)), "#EE11EF");
//    private C3ViewDataSet data4 = new C3ViewDataSet("Kladno", new C3DataSet(Arrays.asList(22, 322, 611)), "#AAEE1F");
//    private boolean rendered = true;
//
//    @PostConstruct
//    public void init() {
//
//        model1 = new ChartModel();
//        model1.getDataSets().add(new C3ViewDataSet("Kladno", new C3DataSet(Arrays.asList(232, 322, 43)), "#EE11EF"));
//        model1.getDataSets().add(new C3ViewDataSet("Praha", new C3DataSet(Arrays.asList(31, 2, 2222, 23)), "#008000"));
//        model1.getDataSets().add(new C3ViewDataSet("Liberec", new C3DataSet(Arrays.asList(11, 234, 115)), "#ffec8b"));
//
//        model2 = new ChartModel();
//
//        data1 = new C3ViewDataSet("New york", new C3DataSet(Arrays.asList(232, 322, 23, 43)), "#8f8fa4");
//        data2 = new C3ViewDataSet("Washington D.C.", new C3DataSet(Arrays.asList(1, 232, 23, 43)), "#EFEFEF");
//
//        model2.getDataSets().add(data1);
//        model2.getDataSets().add(data3);
//        model2.getDataSets().add(data4);
//
//        model3 = new ChartModel();
//        model3.getDataSets().add(new C3ViewDataSet("London", new C3DataSet(Arrays.asList(23532, 231, 43)), "#d3ffce"));
//        model3.getDataSets().add(new C3ViewDataSet("Manchester", new C3DataSet(Arrays.asList(663, 322, 43)), "#ccff00"));
//        model3.getDataSets().add(new C3ViewDataSet("Oxford", new C3DataSet(Arrays.asList(23211, 322, 633)), "#8d93e1"));
//        model3.getDataSets().add(new C3ViewDataSet("Birmingham", new C3DataSet(Arrays.asList(63, 6, 43)), "#4752e0"));
//        model3.getDataSets().add(new C3ViewDataSet("Crystal Palace", new C3DataSet(Arrays.asList(632, 512, 632)), "#8f8fa4"));
//        selectedModel = model2;
//
//    }
//
//    public ChartModel getModel1() {
//        return model1;
//    }
//
//    public void setModel1(ChartModel model1) {
//        this.model1 = model1;
//    }
//
//    public ChartModel getModel2() {
//        return model2;
//    }
//
//    public void setModel2(ChartModel model2) {
//        this.model2 = model2;
//    }
//
//    public ChartModel getModel3() {
//        return model3;
//    }
//
//    public void setModel3(ChartModel model3) {
//        this.model3 = model3;
//    }
//
//    public ChartModel getSelectedModel() {
//        return selectedModel;
//    }
//
//    public void setSelectedModel(ChartModel selectedModel) {
//        this.selectedModel = selectedModel;
//    }
//
//    public void change() {
//        double i = Math.random();
//        if (i >= 0.5) {
//            selectedModel = model1;
//        }
//        if (i < 0.5 && i >= 0.3) {
//            selectedModel = model2;
//        }
//        if (i < 0.3) {
//            selectedModel = model3;
//        }
//    }
//
//    public C3ViewDataSet getSelectedData() {
//        return selectedData;
//    }
//
//    public void setSelectedData(C3ViewDataSet selectedData) {
//        this.selectedData = selectedData;
//    }
//
//    public String getStr() {
//        return str;
//    }
//
//    public void setStr(String str) {
//        this.str = str;
//    }
//
//    public void changeVal() {
//
//        Double random2 = Math.random() * 1000;
//        Integer intRandom2 = random2.intValue();
//
//        if (intRandom2 < 700) {
//            model2.getDataSets().add(data2);
//            data2.setName("name 2");
//            data1.setName("vole");
//            data1.getDataSet().setValues(Arrays.asList(1, 2323, 33));
//            data1.setType(ChartType.AREASPLINE);
//            data2.setType(ChartType.BAR);
//        }
//    }
//
//    public boolean isRendered() {
//        return rendered;
//    }
//
//    private int getRandom() {
//        Double random2 = Math.random() * 1000;
//        Integer intRandom2 = random2.intValue();
//        return intRandom2;
//    }
}
