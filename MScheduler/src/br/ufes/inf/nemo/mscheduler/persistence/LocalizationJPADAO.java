package br.ufes.inf.nemo.mscheduler.persistence;

import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.ufes.inf.nemo.jbutler.ejb.persistence.BaseJPADAO;
import br.ufes.inf.nemo.mscheduler.domain.Localization;

@Stateless
public class LocalizationJPADAO extends BaseJPADAO<Localization> implements LocalizationDAO{
	
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = Logger.getLogger(LocalizationJPADAO.class.getCanonicalName());
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	protected EntityManager getEntityManager() {
		return entityManager;
	}

}
