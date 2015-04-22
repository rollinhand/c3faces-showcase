package com.martinlinha.showcase.backingbean;

import com.martinlinha.c3faces.model.C3DataSet;
import com.martinlinha.c3faces.model.C3ViewDataSet;
import com.martinlinha.c3faces.script.property.Data;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Martin Linha
 */
@ManagedBean(name = "editableComplexAnimationBean")
@ViewScoped
public class EditableComplexAnimationBean implements Serializable {

    private Data data = new Data();
    private C3ViewDataSet dataSetToAdd = new C3ViewDataSet();

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public C3ViewDataSet getDataSetToAdd() {
        return dataSetToAdd;
    }

    public void setDataSetToAdd(C3ViewDataSet dataSetToAdd) {
        this.dataSetToAdd = dataSetToAdd;
    }

    public void reinit() {
        this.dataSetToAdd = new C3ViewDataSet();
    }
    

    public void generateDummyData(C3ViewDataSet dataSet) {
        List<Integer> intLis = new ArrayList<Integer>();
        for (int i = 0; i < 7; i++) {
            intLis.add(randomInteger(0, 500));
        }
        dataSet.setDataSet(new C3DataSet(intLis));
    }

    public static int randomInteger(int min, int max) {
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }
}
