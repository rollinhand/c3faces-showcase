package com.martinlinha.showcase.backingbean;

import com.martinlinha.c3faces.component.C3Chart;
import com.martinlinha.c3faces.constants.ChartType;
import com.martinlinha.c3faces.script.modifier.LegendHide;
import com.martinlinha.c3faces.script.modifier.LegendShow;
import com.martinlinha.c3faces.model.C3DataSet;
import com.martinlinha.c3faces.model.C3ViewDataSet;
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

/**
 *
 * @author Martin Linha
 */
@ManagedBean(name = "sandboxBean")
@ViewScoped
public class SandboxBean implements Serializable {

    private Data data = new Data();
    private C3Chart chart;
    private int i = 0;
    private final C3ViewDataSet set = new C3ViewDataSet("BRAND NEW", new C3DataSet(Arrays.asList(50, 50, 50, 50, 50)), "#16525E");
    private final C3ViewDataSet set2 = new C3ViewDataSet("BRAND NEW 2", new C3DataSet(Arrays.asList(150, 250, 350, 50, 50)), "#16525E");

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
        System.out.println("Chart: " + chart);

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

        Set<C3ViewDataSet> newDataSet = new HashSet<C3ViewDataSet>();
        newDataSet.add(new C3ViewDataSet("Whole new! 1",
                new C3DataSet(Arrays.asList(88, 13, 2, 2, 151)), "#FFEEFF"));
        newDataSet.add(new C3ViewDataSet("Whole new! 2",
                new C3DataSet(Arrays.asList(5, 13, 100, 211, 6)), "#FFCCFF"));

        Legend legend = new Legend();
        chart.getComponentProperties().addProperty(legend);
        legend.addListener(new LegendHide().addModifier(new LegendShow()));
        legend.setHide(true);
        
        if (i < 1) {

            GridProperties grids = (GridProperties) chart.getComponentProperties().getProperty("grid");
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

            data.setChartType(ChartType.STEP);

            set.setType(ChartType.BAR);
            set2.setType(ChartType.SPLINE);

            i++;
        } else if (i < 3) {
            set2.setName("NEW NAME");
            set.setName("NEW NAME HA HA HA");
            legend.setHide(true);
            legend.setShow(true);
            i++;
        } else if (i >= 3 && i < 5) {
            set2.setName("New nice name.");
            data.getDataSets().remove(set);
            i++;
        } else if (i >= 4 && i < 6) {
            data.setDataSets(newDataSet);
            i++;
        } else if (i >= 5 && i < 7) {
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
        return "Nice title";
    }

    public Data getDonutData() {

        Data data = new Data();
        data.getDataSets().add(set);
        return data;
    }
}
