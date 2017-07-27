package br.ufes.inf.nemo.marvin.core.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.ufes.inf.nemo.jbutler.ejb.application.CrudService;
import br.ufes.inf.nemo.jbutler.ejb.application.filters.LikeFilter;
import br.ufes.inf.nemo.jbutler.ejb.controller.CrudController;
import br.ufes.inf.nemo.jbutler.ejb.persistence.exceptions.MultiplePersistentObjectsFoundException;
import br.ufes.inf.nemo.jbutler.ejb.persistence.exceptions.PersistentObjectNotFoundException;
import br.ufes.inf.nemo.marvin.core.application.ManageAcademicsService;
import br.ufes.inf.nemo.marvin.core.domain.Academic;

@Named
@SessionScoped
public class ManageAcademicsController extends CrudController<Academic> {

	@EJB
	private ManageAcademicsService manageAcademicsService;
	
	private String stringBuscaAcademics;
	
	private List<Academic> academicsList;
	
	private List<Academic> selectedParticipants;
	
	
	


	@Override
	protected CrudService<Academic> getCrudService() {
		return manageAcademicsService;
	}

	@Override
	protected void initFilters() {
		// TODO Auto-generated method stub
		addFilter(new LikeFilter("manageAcademics.filter.byName", "name", getI18nMessage("msgsCore", "manageAcademics.text.filter.byName")));
		

	}

	
	
	public void retrieveAcademicsListByName() throws PersistentObjectNotFoundException, MultiplePersistentObjectsFoundException{
		if(stringBuscaAcademics != null){
			System.out.println(stringBuscaAcademics);
		}else{
			System.out.println("stringBuscaResources é null");
		}
		if (!stringBuscaAcademics.isEmpty()) {
			System.out.println("Buscando Academics "+stringBuscaAcademics);
			setAcademicsList(((ManageAcademicsService) getCrudService()).retrieveByName(stringBuscaAcademics));
		}
	}

	public ManageAcademicsService getManageAcademicsService() {
		return manageAcademicsService;
	}

	public void setManageAcademicsService(ManageAcademicsService manageAcademicsService) {
		this.manageAcademicsService = manageAcademicsService;
	}

	public String getStringBuscaAcademics() {
		return stringBuscaAcademics;
	}

	public void setStringBuscaAcademics(String stringBuscaAcademics) {
		this.stringBuscaAcademics = stringBuscaAcademics;
	}

	public List<Academic> getAcademicsList() {
		return academicsList;
	}

	public void setAcademicsList(List<Academic> academicsList) {
		this.academicsList = academicsList;
	}

	public List<Academic> getSelectedParticipants() {
		return selectedParticipants;
	}

	public void setSelectedParticipants(List<Academic> selectedParticipants) {
		this.selectedParticipants = selectedParticipants;
	}
	
	
}
