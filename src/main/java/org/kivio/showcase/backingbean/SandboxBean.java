package org.kivio.showcase.backingbean;

import com.martinlinha.c3faces.component.C3Chart;
import com.martinlinha.c3faces.constants.ChartType;
import com.martinlinha.c3faces.model.C3DataSet;
import com.martinlinha.c3faces.model.C3ViewDataSet;
import com.martinlinha.c3faces.script.property.Data;
import com.martinlinha.c3faces.script.property.GridProperties;
import com.martinlinha.c3faces.script.property.Legend;
import com.martinlinha.c3faces.script.property.Size;
import java.io.Serializable;
import java.util.Arrays;
import java.util.LinkedHashSet;
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

    private LinkedHashSet<C3ViewDataSet> newDataSet = null;
    private Data data = new Data();
    private C3Chart chart;
    private int counter = 1;
    private final C3ViewDataSet c3ViewDataSet1 = new C3ViewDataSet("New data set 1", new C3DataSet(Arrays.asList(50, 50, 50, 50, 50)), "#16525E");
    private final C3ViewDataSet c3ViewDataSet2 = new C3ViewDataSet("New data set 2", new C3DataSet(Arrays.asList(150, 250, 350, 50, 50)), "#16525E");
    private boolean rendered = true;

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
    }

    public void resizeTest() {
        Legend legend = (Legend) chart.getComponentProperties().getProperty(Legend.NAME);
        GridProperties grids = (GridProperties) chart.getComponentProperties().getProperty(GridProperties.NAME);

        switch (counter) {
            case 1:
                grids.removeXGrids();
                Size size = (Size) chart.getComponentProperties().getProperty(Size.NAME);

                // see how chart handles multiple changes on same property
                size.setHeight(80);
                size.setHeight(120);
                size.setHeight(150);
                size.setHeight(220);
                size.setWidth(550);
                size.setWidth(730);

                data.getDataSets().add(c3ViewDataSet2);
                data.getDataSets().add(c3ViewDataSet1);

                data.setChartType(ChartType.BAR.getName());

                c3ViewDataSet1.setType(ChartType.BAR.getName());
                c3ViewDataSet2.setType(ChartType.SPLINE.getName());

                counter++;
                break;
            case 2:
                grids.addYGrid(40d, "Test 1");
                grids.addYGrid(300d, "Test 2");

                c3ViewDataSet1.setName("Newly set name");
                c3ViewDataSet2.setName("Newly set name 2");
                legend.setShow(true);

                counter++;
                break;
            case 3:
                grids.removeYGrids();
                c3ViewDataSet2.setName("Another new name.");
                data.getDataSets().remove(c3ViewDataSet1);

                counter++;
                break;
            case 4: {
                newDataSet = new LinkedHashSet<>();
                newDataSet.add(new C3ViewDataSet("Newly added set 1 (catched by observable set)",
                        new C3DataSet(Arrays.asList(88, 13, 2, 2, 151)), "#333333"));
                newDataSet.add(new C3ViewDataSet("Newly added set 2 (catched by observable set)",
                        new C3DataSet(Arrays.asList(5, 13, 100, 211, 6)), "#FF9900"));
                newDataSet.add(new C3ViewDataSet("Newly added set 3 (catched by observable set)",
                        new C3DataSet(Arrays.asList(90.4, 24, 100, 21, 1000)), "#666666"));
                newDataSet.add(new C3ViewDataSet("Newly set 4 (catched by observable set)",
                        new C3DataSet(Arrays.asList(33.4949, 134, 100, 411, 6)), "#FFCC11"));

                data.setDataSets(newDataSet);

                counter++;
                break;
            }
            case 5:
                int c = 20;
                boolean foo = false;
                for (C3ViewDataSet dataSet : newDataSet) {
                    dataSet.setDataSet(foo ? null : new C3DataSet(Arrays.asList(c, c, c)));
                    foo = true;
                    c += 400;
                }

                counter++;
                break;
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

    public boolean isRendered() {
        return rendered;
    }

    public void setRendered(boolean rendered) {
        this.rendered = rendered;
    }

    public int getCounter() {
        return counter;
    }
}
