package br.ufes.inf.nemo.marvin.core.application;

import java.util.Date;

import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.ufes.inf.nemo.jbutler.ejb.application.CrudServiceBean;
import br.ufes.inf.nemo.jbutler.ejb.persistence.BaseDAO;
import br.ufes.inf.nemo.marvin.core.domain.Academic;
import br.ufes.inf.nemo.marvin.core.persistence.AcademicDAO;

@Stateless
@PermitAll
public class ManageAcademicsServiceBean extends CrudServiceBean<Academic> implements ManageAcademicsService {

	
	@EJB
	private AcademicDAO academicDAO;
	
	@Override
	public BaseDAO<Academic> getDAO() {
		// TODO Auto-generated method stub
		return academicDAO;
	}
	
	@Override
	protected Academic validate(Academic newEntity, Academic oldEntity){
		Date now = new Date(System.currentTimeMillis());
		if(oldEntity == null) newEntity.setCreationDate(now);
		
		newEntity.setLastUpdateDate(now);
		
		newEntity.setShortName(newEntity.getName().substring(newEntity.getName().indexOf(" ")));
		
		return newEntity;
	}

}
