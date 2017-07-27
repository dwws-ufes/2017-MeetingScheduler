package br.ufes.inf.nemo.mscheduler.application;

import java.util.List;

import javax.ejb.Local;

import br.ufes.inf.nemo.jbutler.ejb.application.CrudService;
import br.ufes.inf.nemo.jbutler.ejb.persistence.exceptions.MultiplePersistentObjectsFoundException;
import br.ufes.inf.nemo.jbutler.ejb.persistence.exceptions.PersistentObjectNotFoundException;
import br.ufes.inf.nemo.mscheduler.domain.Resource;

@Local
public interface ManageResourcesService extends CrudService<Resource> {


	public List<Resource> retrieveByDescriptionName(String nomeDescricao) throws PersistentObjectNotFoundException, MultiplePersistentObjectsFoundException;
	
}