package br.ufes.inf.nemo.mscheduler.persistence;

import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.ufes.inf.nemo.jbutler.ejb.persistence.BaseJPADAO;
import br.ufes.inf.nemo.mscheduler.domain.Meeting;
import br.ufes.inf.nemo.mscheduler.domain.MeetingRoom;
import br.ufes.inf.nemo.mscheduler.domain.Resource;

@Stateless
public class ResourceJPADAO extends BaseJPADAO<Resource> implements ResourceDAO{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger.getLogger(ResourceJPADAO.class.getCanonicalName());
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	protected EntityManager getEntityManager() {
		return entityManager;
	}

}
