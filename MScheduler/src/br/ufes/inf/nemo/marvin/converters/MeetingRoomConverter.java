package br.ufes.inf.nemo.marvin.converters;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.component.UISelectItem;
import javax.faces.component.UISelectItems;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;

import br.ufes.inf.nemo.mscheduler.application.ManageMeetingRoomsService;
import br.ufes.inf.nemo.mscheduler.domain.MeetingRoom;


@FacesConverter("meetingRoomConverter")
public class MeetingRoomConverter implements Converter{

	@Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        if (value != null && !value.isEmpty()) {
            return (MeetingRoom) uiComponent.getAttributes().get(value);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
        if (value instanceof MeetingRoom) {
            MeetingRoom entity= (MeetingRoom) value;
            if (entity != null && entity instanceof MeetingRoom && entity.getId() != null) {
                uiComponent.getAttributes().put(entity.getId().toString(), entity);
                return entity.getId().toString();
            }
        }
        return "";
    }
}  
