package br.ufes.inf.nemo.marvin.core.controller;

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
import br.ufes.inf.nemo.mscheduler.application.ManageMeetingsService;
import br.ufes.inf.nemo.mscheduler.domain.Meeting;

@Named
@SessionScoped
public class ManageMeetingsController extends CrudController<Meeting> {

	@EJB
	private ManageMeetingsService manageMeetingsService;
	
	@Inject
	SessionController sessionController;
	
	@Override
	protected CrudService<Meeting> getCrudService(){
		return manageMeetingsService;
	}

	@Override
	protected void initFilters() {
		// TODO Auto-generated method stub
		addFilter(new LikeFilter("manageMeetings.filter.byName", "nome", getI18nMessage("msgsCore", "manageAcademics.text.filter.byName")));
	}
	
	public String getCurrentUser() {
		System.out.println("currentUser Teste");
		System.out.println(sessionController.getCurrentUser().getName());
		return sessionController.getCurrentUser().getName();
	}
}
