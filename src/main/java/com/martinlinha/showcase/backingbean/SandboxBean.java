package com.martinlinha.showcase.backingbean;

import com.martinlinha.c3faces.component.C3Chart;
import com.martinlinha.c3faces.constants.ChartType;
import com.martinlinha.c3faces.model.C3DataSet;
import com.martinlinha.c3faces.model.C3ViewDataSet;
import com.martinlinha.c3faces.script.modifier.LegendHide;
import com.martinlinha.c3faces.script.modifier.LegendShow;
import com.martinlinha.c3faces.script.property.Data;
import com.martinlinha.c3faces.script.property.GridProperties;
import com.martinlinha.c3faces.script.property.Legend;
import com.martinlinha.c3faces.script.property.Size;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Martin Linha
 */
@ManagedBean(name = "sandboxBean")
@ViewScoped
public class SandboxBean implements Serializable {

    private C3ViewDataSet selectedValue;
    private Set<C3ViewDataSet> newDataSet = null;
    private Data data = new Data();
    private Data data2 = new Data();
    private C3Chart chart;
    private int i = 0;
    private final C3ViewDataSet set = new C3ViewDataSet("BRAND NEW", new C3DataSet(Arrays.asList(50, 50, 50, 50, 50)), "#16525E");
    private final C3ViewDataSet set2 = new C3ViewDataSet("BRAND NEW 2", new C3DataSet(Arrays.asList(150, 250, 350, 50, 50)), "#16525E");
    private boolean rendered = false;
    private String title = "old ttl";

    @PostConstruct
    public void init() {
        data.getDataSets().add(new C3ViewDataSet("Data sample 1",
                new C3DataSet(Arrays.asList(22, 91, 158, 93, 201, 11)), "#1060E0"));
        data.getDataSets().add(new C3ViewDataSet("Data sample 2",
                new C3DataSet(Arrays.asList(1, 72, 23, 33, 21)), "#16525E"));
        data.getDataSets().add(new C3ViewDataSet("Data sample 3",
                new C3DataSet(Arrays.asList(45, 231, 2, 151, 341, 254)), "#0792AD"));
        data.getDataSets().add(new C3ViewDataSet("Data sample 4",
                new C3DataSet(Arrays.asList(88, 13, 258, 211, 151)), "#8FE2F2"));
        data2.getDataSets().add(new C3ViewDataSet("Data sample 1",
                new C3DataSet(Arrays.asList(22, 91, 158, 93, 201, 11)), "#1060E0"));
        data2.getDataSets().add(new C3ViewDataSet("Data sample 2",
                new C3DataSet(Arrays.asList(1, 72, 23, 33, 21)), "#16525E"));
        data2.getDataSets().add(new C3ViewDataSet("Data sample 3",
                new C3DataSet(Arrays.asList(45, 231, 2, 151, 341, 254)), "#0792AD"));
        data2.getDataSets().add(new C3ViewDataSet("Data sample 4",
                new C3DataSet(Arrays.asList(88, 13, 258, 211, 151)), "#8FE2F2"));

//        !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//        !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//        !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//        !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//        chart = new Pie();
//        Legend legend = (Legend) chart.getComponentProperties().getProperty("legend");
//        if (legend == null) {
//            legend = new Legend();
//            legend.setHide(true);
//            chart.getComponentProperties().addProperty(legend);
//        }
    }

    public void resizeTest() {
        System.out.println("Chart: " + chart);
        System.out.println("CONTEXT: " + FacesContext.getCurrentInstance().getPartialViewContext().getPartialResponseWriter());

        Legend legend = (Legend) chart.getComponentProperties().getProperty(Legend.NAME);
        if (legend != null) {
            legend.addListener(new LegendHide().addModifier(new LegendShow()));
        }

        GridProperties grids = (GridProperties) chart.getComponentProperties().getProperty("grid");

        if (i < 1) {
            grids.removeXGrids();
            Size size = (Size) chart.getComponentProperties().getProperty(Size.NAME);
            size.setHeight(80);
            size.setHeight(120);
            size.setHeight(150);
            size.setHeight(220);
            size.setWidth(550);
            size.setWidth(730);

            data.getDataSets().add(set2);
            data.getDataSets().add(set);
            data2.getDataSets().add(set2);
            data2.getDataSets().add(set);

            data.setChartType(ChartType.BAR);
            data2.setChartType(ChartType.BAR);

            set.setType(ChartType.BAR);
            set2.setType(ChartType.SPLINE);

            i++;
        } else if (i < 3) {
            grids.addYGrid(40d, "test 1");
            grids.addYGrid(300d, "test 2");

            set2.setName("NEW NAME");
            set.setName("NEW NAME HA HA HA");
            legend.setShow(true);
            i++;
        } else if (i >= 3 && i < 5) {
            grids.removeYGrids();
            set2.setName("New nice name.");
            data.getDataSets().remove(set);
            i++;
        } else if (i >= 4 && i < 6) {
            newDataSet = new HashSet<C3ViewDataSet>();
            newDataSet.add(new C3ViewDataSet("Whole new! 1",
                    new C3DataSet(Arrays.asList(88, 13, 2, 2, 151)), "#FFEEFF"));
            newDataSet.add(new C3ViewDataSet("Whole new! 2",
                    new C3DataSet(Arrays.asList(5, 13, 100, 211, 6)), "#FFCCFF"));

            data.setDataSets(newDataSet);
            i++;
        } else if (i >= 5 && i < 7) {
            int c = 20;
            for (C3ViewDataSet dataSet : newDataSet) {
                dataSet.setDataSet(new C3DataSet(Arrays.asList(c, c, c)));
                c += 50;
            }
            i++;
        } else if (i >= 6 && i < 8) {
            data = null;

        }
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public C3Chart getChart() {
        return chart;
    }

    public void setChart(C3Chart chart) {
        this.chart = chart;
    }

    public String getTitle() {
        return title;
    }

    public void generateTitle() {
        title = "new ttl";
    }

    public Data getDonutData() {

        Data data = new Data();
        data.getDataSets().add(set);
        return data;
    }

    public boolean isRendered() {
        return rendered;
    }

    public void setRendered(boolean rendered) {
        this.rendered = rendered;
    }

    public void renderIt() {
        this.rendered = true;
    }

    public Data getData2() {
        return data2;
    }

    public void setData2(Data data2) {
        this.data2 = data2;
    }

    public void sayIt() {
        System.out.println(FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds());
    }

    public C3ViewDataSet getSelectedValue() {
        return selectedValue;
    }

    public void setSelectedValue(C3ViewDataSet selectedValue) {
        this.selectedValue = selectedValue;
    }

}
