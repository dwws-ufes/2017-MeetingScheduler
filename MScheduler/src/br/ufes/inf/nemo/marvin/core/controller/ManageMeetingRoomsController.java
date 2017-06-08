package br.ufes.inf.nemo.marvin.core.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.faces.model.SelectItem;

import br.ufes.inf.nemo.jbutler.ejb.application.CrudService;
import br.ufes.inf.nemo.jbutler.ejb.controller.CrudController;
import br.ufes.inf.nemo.mscheduler.application.ManageLocalizationsService;
import br.ufes.inf.nemo.mscheduler.application.ManageMeetingRoomsService;
import br.ufes.inf.nemo.mscheduler.domain.Localization;
import br.ufes.inf.nemo.mscheduler.domain.MeetingRoom;
import br.ufes.inf.nemo.mscheduler.domain.Resource;

@Named
@SessionScoped
public class ManageMeetingRoomsController extends CrudController<MeetingRoom> {

	@EJB
	private ManageMeetingRoomsService manageMeetingRoomsService;
	
	private List<MeetingRoom> meetingRooms;
	
	@PostConstruct
    public void init() {
		 meetingRooms = manageMeetingRoomsService.getDAO().retrieveAll();
	
	 }
	
	
	
	@Override
	protected CrudService<MeetingRoom> getCrudService(){
		return manageMeetingRoomsService;
	}

	@Override
	protected void initFilters() {
		// TODO Auto-generated method stub
		
	}

	public List<MeetingRoom> getMeetingRooms() {
		return meetingRooms;
	}

	public void setMeetingRooms(List<MeetingRoom> meetingRooms) {
		this.meetingRooms = meetingRooms;
	}

	
}
