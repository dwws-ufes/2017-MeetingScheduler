package br.ufes.inf.nemo.marvin.core.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.ufes.inf.nemo.jbutler.ejb.application.CrudService;
import br.ufes.inf.nemo.jbutler.ejb.application.filters.LikeFilter;
import br.ufes.inf.nemo.jbutler.ejb.controller.CrudController;
import br.ufes.inf.nemo.jbutler.ejb.persistence.exceptions.MultiplePersistentObjectsFoundException;
import br.ufes.inf.nemo.jbutler.ejb.persistence.exceptions.PersistentObjectNotFoundException;
import br.ufes.inf.nemo.mscheduler.application.ManageResourcesService;
import br.ufes.inf.nemo.mscheduler.domain.Localization;
import br.ufes.inf.nemo.mscheduler.domain.Resource;

@Named
@SessionScoped
public class ManageResourcesController extends CrudController<Resource> {

	@EJB
	private ManageResourcesService manageResourcesService;

	@Inject
	SessionController sessionController;
	
	private List<Resource> resources;
	
	private List<Resource> resourcesList;
	
	private List<Resource> selectedResources;
	
	private String stringBuscaResources;
	
	@Override
	protected CrudService<Resource> getCrudService(){
		return manageResourcesService;
	}
	
	@PostConstruct
    public void init() {
		 resources = manageResourcesService.getDAO().retrieveAll();
		 resourcesList = new ArrayList<Resource>();
		 stringBuscaResources = "";
	
	 }
	
	public void retrieveResourceListByNameDescription() throws PersistentObjectNotFoundException, MultiplePersistentObjectsFoundException{
		if(stringBuscaResources != null){
			System.out.println(stringBuscaResources);
		}else{
			System.out.println("stringBuscaResources é null");
		}
		if (!stringBuscaResources.isEmpty()) {
			setResourcesList(((ManageResourcesService)getCrudService()).retrieveByDescriptionName(stringBuscaResources));
		}
	}
	
	


	@Override
	protected void initFilters() {
		// TODO Auto-generated method stub
		
	}

	public String getStringBuscaResources() {
		return stringBuscaResources;
	}

	public void setStringBuscaResources(String stringBuscaResources) {
		this.stringBuscaResources = stringBuscaResources;
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


	
}
