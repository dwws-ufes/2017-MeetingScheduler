package br.ufes.inf.nemo.marvin.core.controller;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.ufes.inf.nemo.jbutler.ejb.application.CrudService;
import br.ufes.inf.nemo.jbutler.ejb.application.filters.LikeFilter;
import br.ufes.inf.nemo.jbutler.ejb.controller.CrudController;
import br.ufes.inf.nemo.marvin.core.application.ManageAcademicsService;
import br.ufes.inf.nemo.marvin.core.domain.Academic;

@Named
@SessionScoped
public class ManageAcademicsController extends CrudController<Academic> {

	@EJB
	private ManageAcademicsService manageAcademicsService;
	
	@Override
	protected CrudService<Academic> getCrudService() {
		return manageAcademicsService;
	}

	@Override
	protected void initFilters() {
		// TODO Auto-generated method stub
		addFilter(new LikeFilter("manageAcademics.filter.byName", "name", getI18nMessage("msgsCore", "manageAcademics.text.filter.byName")));

	}

}
