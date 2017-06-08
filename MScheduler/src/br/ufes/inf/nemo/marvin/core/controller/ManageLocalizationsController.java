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
import br.ufes.inf.nemo.marvin.core.application.SessionInformation;
import br.ufes.inf.nemo.marvin.core.controller.SessionController;
import br.ufes.inf.nemo.marvin.core.domain.Academic;
import br.ufes.inf.nemo.mscheduler.application.ManageLocalizationsService;
import br.ufes.inf.nemo.mscheduler.application.ManageMeetingsService;
import br.ufes.inf.nemo.mscheduler.domain.Localization;
import br.ufes.inf.nemo.mscheduler.domain.Meeting;

@Named
@SessionScoped
public class ManageLocalizationsController extends CrudController<Localization> {

	@EJB
	private ManageLocalizationsService manageLocalizationsService;
	
	@Inject
	SessionController sessionController;
	
	private List<Localization> localizations;
	
	@PostConstruct
    public void init() {
		 localizations = manageLocalizationsService.getDAO().retrieveAll();
	
	 }
	
	@Override
	protected CrudService<Localization> getCrudService(){
		return manageLocalizationsService;
	}

	

	@Override
	protected void initFilters() {
		// TODO Auto-generated method stub
		
	}

	public List<Localization> getLocalizations() {
		return localizations;
	}

	public void setLocalizations(List<Localization> localizations) {
		this.localizations = localizations;
	}
	

}
