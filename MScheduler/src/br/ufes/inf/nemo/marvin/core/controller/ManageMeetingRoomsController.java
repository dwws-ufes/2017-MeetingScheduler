package br.ufes.inf.nemo.marvin.core.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.faces.model.SelectItem;

import br.ufes.inf.nemo.jbutler.ejb.application.CrudService;
import br.ufes.inf.nemo.jbutler.ejb.controller.CrudController;
import br.ufes.inf.nemo.jbutler.ejb.persistence.exceptions.MultiplePersistentObjectsFoundException;
import br.ufes.inf.nemo.jbutler.ejb.persistence.exceptions.PersistentObjectNotFoundException;
import br.ufes.inf.nemo.mscheduler.application.ManageLocalizationsService;
import br.ufes.inf.nemo.mscheduler.application.ManageMeetingRoomsService;
import br.ufes.inf.nemo.mscheduler.application.ManageResourcesService;
import br.ufes.inf.nemo.mscheduler.domain.Localization;
import br.ufes.inf.nemo.mscheduler.domain.MeetingRoom;
import br.ufes.inf.nemo.mscheduler.domain.Resource;

@Named
@SessionScoped
public class ManageMeetingRoomsController extends CrudController<MeetingRoom> {

	@EJB
	private ManageMeetingRoomsService manageMeetingRoomsService;
	
	@Inject
	private ManageResourcesService manageResourcesService;
	
	@EJB
	private ManageLocalizationsService manageLocalizationsService;
	
	private List<MeetingRoom> meetingRooms;
	
	private List<Resource> resourcesList;
	
	private List<Resource> selectedResources;
	
	private List<Localization> localizations;
	
	private String stringBuscaResources;
	
	
	@PostConstruct
    public void init() {
		meetingRooms = manageMeetingRoomsService.getDAO().retrieveAll();
	
	 }
	
	
	public void saveSelectedResources(){
		for(Resource resource : selectedResources){
			resource.setBelongs(selectedEntity);
			manageResourcesService.update(resource);
		}
	}

	
	public void removeResource(Resource resource){
		System.out.println("deletando atributo belongs do resource");
		
		selectedEntity.getResource().clear();
		manageMeetingRoomsService.update(selectedEntity);
		
		
	}
	
	public void retrieveResourceListByNameDescription() throws PersistentObjectNotFoundException, MultiplePersistentObjectsFoundException{
		if(stringBuscaResources != null){
			System.out.println(stringBuscaResources);
		}else{
			System.out.println("stringBuscaResources é null");
		}
		if (!stringBuscaResources.isEmpty()) {
			setResourcesList(manageResourcesService.retrieveByDescriptionName(stringBuscaResources));
		}
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



	public List<Resource> getResourcesList() {
		return resourcesList;
	}



	public void setResourcesList(List<Resource> resourcesList) {
		this.resourcesList = resourcesList;
	}
	
	public List<Resource> getSelectedResources() {
		return selectedResources;
	}

	public void setSelectedResources(List<Resource> selectedResources) {
		this.selectedResources = selectedResources;
	}

	public String getStringBuscaResources() {
		return stringBuscaResources;
	}

	public void setStringBuscaResources(String stringBuscaResources) {
		this.stringBuscaResources = stringBuscaResources;
	}


	public ManageMeetingRoomsService getManageMeetingRoomsService() {
		return manageMeetingRoomsService;
	}


	public void setManageMeetingRoomsService(ManageMeetingRoomsService manageMeetingRoomsService) {
		this.manageMeetingRoomsService = manageMeetingRoomsService;
	}


	public ManageResourcesService getManageResourcesService() {
		return manageResourcesService;
	}


	public void setManageResourcesService(ManageResourcesService manageResourcesService) {
		this.manageResourcesService = manageResourcesService;
	}


	public ManageLocalizationsService getManageLocalizationsService() {
		return manageLocalizationsService;
	}


	public void setManageLocalizationsService(ManageLocalizationsService manageLocalizationsService) {
		this.manageLocalizationsService = manageLocalizationsService;
	}


	public List<Localization> getLocalizations() {
		return manageLocalizationsService.getDAO().retrieveAll();
	}


	public void setLocalizations(List<Localization> localizations) {
		this.localizations = localizations;
	}


	
}
