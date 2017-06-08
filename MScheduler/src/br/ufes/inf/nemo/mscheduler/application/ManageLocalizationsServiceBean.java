package br.ufes.inf.nemo.mscheduler.application;

import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;

import br.ufes.inf.nemo.jbutler.ejb.application.CrudServiceBean;
import br.ufes.inf.nemo.jbutler.ejb.persistence.BaseDAO;
import br.ufes.inf.nemo.marvin.core.controller.SessionController;
import br.ufes.inf.nemo.mscheduler.domain.Localization;
import br.ufes.inf.nemo.mscheduler.domain.MeetingRoom;
import br.ufes.inf.nemo.mscheduler.persistence.LocalizationDAO;
import br.ufes.inf.nemo.mscheduler.persistence.MeetingRoomDAO;

@Stateless
@PermitAll
public class ManageLocalizationsServiceBean extends CrudServiceBean<Localization> implements ManageLocalizationsService{

	@EJB
	private LocalizationDAO localizationDAO;
	
	@Inject	private SessionController sessionController;
	
	
	@Override
	public BaseDAO<Localization> getDAO() {
		// TODO Auto-generated method stub
		return localizationDAO;
	}
	
}
