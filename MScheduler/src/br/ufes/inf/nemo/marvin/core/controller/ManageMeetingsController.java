package br.ufes.inf.nemo.marvin.core.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.ufes.inf.nemo.jbutler.ejb.application.CrudService;
import br.ufes.inf.nemo.jbutler.ejb.application.filters.LikeFilter;
import br.ufes.inf.nemo.jbutler.ejb.controller.CrudController;
import br.ufes.inf.nemo.marvin.core.application.SessionInformation;
import br.ufes.inf.nemo.marvin.core.controller.SessionController;
import br.ufes.inf.nemo.marvin.core.domain.Academic;
import br.ufes.inf.nemo.mscheduler.application.ManageMeetingRoomsService;
import br.ufes.inf.nemo.mscheduler.application.ManageMeetingsService;
import br.ufes.inf.nemo.mscheduler.domain.Meeting;
import br.ufes.inf.nemo.mscheduler.domain.MeetingRoom;
import br.ufes.inf.nemo.mscheduler.domain.Resource;

@Named
@SessionScoped
public class ManageMeetingsController extends CrudController<Meeting> {

	@EJB
	private ManageMeetingsService manageMeetingsService;
	
	@EJB
	private ManageMeetingRoomsService manageMeetingRoomsService;
	
	@Inject
	SessionController sessionController;
	
	private List<Academic> selectedParticipants;
	private List<MeetingRoom> meetingRooms;
	
	@Override
	protected CrudService<Meeting> getCrudService(){
		return manageMeetingsService;
	}


	public void saveSelectedParticipants(){
		System.out.println("saveselectedParticipants");
		System.out.println(selectedParticipants.get(0).getName());
		
		if(selectedEntity.getParticipants() == null){			
			selectedEntity.setParticipants(new HashSet<Academic>(selectedParticipants));
		}else{
			selectedEntity.getParticipants().addAll(selectedParticipants);
		}		
	}
	
	@Override
	protected void initFilters() {
		// TODO Auto-generated method stub
		addFilter(new LikeFilter("manageMeetings.filter.byName", "nome", getI18nMessage("msgsCore", "manageAcademics.text.filter.byName")));
	}
	
	public String getCurrentUser() {
		if(sessionController.getCurrentUser() != null){
			if(selectedEntity!=null && selectedEntity.getRequester() == null){
				selectedEntity.setRequester(sessionController.getCurrentUser());
			}
			return sessionController.getCurrentUser().getName();
		}else{
			return "User not logged";
		}
	}

	public ManageMeetingsService getManageMeetingsService() {
		return manageMeetingsService;
	}

	public void setManageMeetingsService(ManageMeetingsService manageMeetingsService) {
		this.manageMeetingsService = manageMeetingsService;
	}

	public List<Academic> getSelectedParticipants() {
		return selectedParticipants;
	}

	public void setSelectedParticipants(List<Academic> selectedParticipants) {
		this.selectedParticipants = selectedParticipants;
	}


	public ManageMeetingRoomsService getManageMeetingRoomsService() {
		return manageMeetingRoomsService;
	}


	public void setManageMeetingRoomsService(ManageMeetingRoomsService manageMeetingRoomsService) {
		this.manageMeetingRoomsService = manageMeetingRoomsService;
	}


	public List<MeetingRoom> getMeetingRooms() {
		return manageMeetingRoomsService.getDAO().retrieveAll();
	}


	public void setMeetingRooms(List<MeetingRoom> meetingRooms) {
		this.meetingRooms = meetingRooms;
	}
	
	
	
}
