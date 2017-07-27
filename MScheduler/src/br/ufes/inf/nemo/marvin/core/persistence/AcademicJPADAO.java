package br.ufes.inf.nemo.marvin.core.persistence;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.ufes.inf.nemo.jbutler.ejb.persistence.BaseJPADAO;
import br.ufes.inf.nemo.jbutler.ejb.persistence.exceptions.MultiplePersistentObjectsFoundException;
import br.ufes.inf.nemo.jbutler.ejb.persistence.exceptions.PersistentObjectNotFoundException;
import br.ufes.inf.nemo.marvin.core.domain.Academic;
import br.ufes.inf.nemo.marvin.core.domain.Academic_;
import br.ufes.inf.nemo.mscheduler.domain.Resource;
import br.ufes.inf.nemo.mscheduler.domain.Resource_;

/**
 * TODO: document this type.
 *
 * @author Vítor E. Silva Souza (vitorsouza@gmail.com)
 * @version 1.0
 */
@Stateless
public class AcademicJPADAO extends BaseJPADAO<Academic> implements AcademicDAO {
	/** Serialization id. */
	private static final long serialVersionUID = 1L;

	/** The logger. */
	private static final Logger logger = Logger.getLogger(AcademicJPADAO.class.getCanonicalName());

	/** The application's persistent context provided by the application server. */
	@PersistenceContext
	private EntityManager entityManager;

	/** @see br.ufes.inf.nemo.util.ejb3.persistence.BaseJPADAO#getEntityManager() */
	@Override
	protected EntityManager getEntityManager() {
		return entityManager;
	}

	/** @see br.ufes.inf.nemo.marvin.core.persistence.AcademicDAO#retrieveByEmail(java.lang.String) */
	@Override
	public Academic retrieveByEmail(String email) throws PersistentObjectNotFoundException, MultiplePersistentObjectsFoundException {
		logger.log(Level.FINE, "Retrieving the academic whose e-mail is \"{0}\"...", email);

		// Constructs the query over the Academic class.
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Academic> cq = cb.createQuery(Academic.class);
		Root<Academic> root = cq.from(Academic.class);

		// Filters the query with the email.
		cq.where(cb.equal(root.get(Academic_.email), email));
		Academic result = executeSingleResultQuery(cq, email);
		logger.log(Level.INFO, "Retrieve academic by the email \"{0}\" returned \"{1}\"", new Object[] { email, result });
		return result;
	}



	public List<Academic> retrieveByName (String name) throws PersistentObjectNotFoundException, MultiplePersistentObjectsFoundException {
		logger.log(Level.FINE, "Retrieving the academic whose name is \"{0}\"...", name);

		// Constructs the query over the Academic class.
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Academic> cq = cb.createQuery(Academic.class);
		Root<Academic> root = cq.from(Academic.class);

		// Filters the query with the email.
		cq.where(cb.like(root.get(Academic_.name), "%"+name+"%"));
		//Academic result = executeSingleResultQuery(cq, name);
		TypedQuery<Academic> query = entityManager.createQuery(cq);
		List<Academic> results = query.getResultList();
		logger.log(Level.INFO, "Retrieve academic by the name \"{0}\" returned \"{1}\"", new Object[] { name, results });
		return results;
		
		
	}
}
