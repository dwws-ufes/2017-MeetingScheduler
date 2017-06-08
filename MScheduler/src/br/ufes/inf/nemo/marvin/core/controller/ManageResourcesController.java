package br.ufes.inf.nemo.marvin.core.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.ufes.inf.nemo.jbutler.ejb.application.CrudService;
import br.ufes.inf.nemo.jbutler.ejb.application.filters.LikeFilter;
import br.ufes.inf.nemo.jbutler.ejb.controller.CrudController;
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
	
	@PostConstruct
    public void init() {
		 resources = manageResourcesService.getDAO().retrieveAll();
	
	 }
	
	
	
	
	@Override
	protected CrudService<Resource> getCrudService(){
		return manageResourcesService;
	}

	@Override
	protected void initFilters() {
		// TODO Auto-generated method stub
		
	}
	
}
