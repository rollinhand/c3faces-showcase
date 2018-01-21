package org.kivio.showcase.listener;

import org.kivio.c3faces.model.C3ViewDataSet;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ValueChangeEvent;
import javax.faces.event.ValueChangeListener;

/**
 *
 * @author Björn Berg
 */
public class DataChangeValueListener implements ValueChangeListener {

    @Override
    public void processValueChange(ValueChangeEvent event) throws AbortProcessingException {
        C3ViewDataSet oldVal = (C3ViewDataSet) event.getOldValue();
        C3ViewDataSet newVal = (C3ViewDataSet) event.getNewValue();
        StringBuilder sb = new StringBuilder();
        if (oldVal != null) {
            sb.append("Old value: ");
            sb.append((oldVal.getName()));
            sb.append(" ");
        }
        if (newVal != null) {
            sb.append("New value: ");
            sb.append((newVal.getName()));
            sb.append(" ");
        }
        if (oldVal != null || newVal != null) {
            FacesContext.getCurrentInstance().addMessage(event.getComponent().getClientId(),
                    new FacesMessage("Value change processed. " + sb.toString()));
        }
    }
}
