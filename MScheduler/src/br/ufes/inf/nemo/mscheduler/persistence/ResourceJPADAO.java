package br.ufes.inf.nemo.mscheduler.persistence;

import java.util.ArrayList;
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
import br.ufes.inf.nemo.mscheduler.domain.Meeting;
import br.ufes.inf.nemo.mscheduler.domain.MeetingRoom;
import br.ufes.inf.nemo.mscheduler.domain.Resource;
import br.ufes.inf.nemo.mscheduler.domain.Resource_;

@Stateless
public class ResourceJPADAO extends BaseJPADAO<Resource> implements ResourceDAO{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger.getLogger(ResourceJPADAO.class.getCanonicalName());
	

	
	@PersistenceContext
	private EntityManager entityManager;
	
	
	public List<Resource> retrieveByNomeDescricao(String nomeDescricao) throws PersistentObjectNotFoundException, MultiplePersistentObjectsFoundException{		
		logger.log(Level.FINE, "Retrieving the resources whose name or description is \"{0}\"...", nomeDescricao);
		
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Resource> cq = cb.createQuery(Resource.class);
		Root<Resource> root = cq.from(Resource.class);

		//cq.where(cb.equal(root.get(Resource_.type), nomeDescricao));
		cq.where(cb.or(cb.like(root.get(Resource_.description), "%"+nomeDescricao+"%"), cb.like(root.get(Resource_.type), "%"+nomeDescricao+"%")));
				
		TypedQuery<Resource> query = entityManager.createQuery(cq);
		List<Resource> results = query.getResultList();
				
		//Resource result = executeSingleResultQuery(cq, nomeDescricao);
		//logger.log(Level.INFO, "Retrieve resoruces by the name or description \"{0}\" returned \"{1}\"", new Object[] { nomeDescricao, result });
		//List<Resource> list = new ArrayList<Resource>(); 
		//list.add(result);
		return results;		
	}
	
	
	
	
	@Override
	protected EntityManager getEntityManager() {
		return entityManager;
	}


}
