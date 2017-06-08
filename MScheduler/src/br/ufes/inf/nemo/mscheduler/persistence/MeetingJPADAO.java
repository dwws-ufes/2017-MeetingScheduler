package br.ufes.inf.nemo.mscheduler.persistence;

import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.ufes.inf.nemo.jbutler.ejb.persistence.BaseJPADAO;
import br.ufes.inf.nemo.marvin.core.persistence.AcademicJPADAO;
import br.ufes.inf.nemo.mscheduler.domain.Meeting;

@Stateless
public class MeetingJPADAO extends BaseJPADAO<Meeting> implements MeetingDAO{
	
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = Logger.getLogger(MeetingJPADAO.class.getCanonicalName());
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	protected EntityManager getEntityManager() {
		return entityManager;
	}

}
