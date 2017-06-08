package br.ufes.inf.nemo.mscheduler.persistence;

import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.ufes.inf.nemo.jbutler.ejb.persistence.BaseJPADAO;
import br.ufes.inf.nemo.mscheduler.domain.Meeting;
import br.ufes.inf.nemo.mscheduler.domain.MeetingRoom;

@Stateless
public class MeetingRoomJPADAO extends BaseJPADAO<MeetingRoom> implements MeetingRoomDAO{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger.getLogger(MeetingRoomJPADAO.class.getCanonicalName());
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	protected EntityManager getEntityManager() {
		return entityManager;
	}

}
