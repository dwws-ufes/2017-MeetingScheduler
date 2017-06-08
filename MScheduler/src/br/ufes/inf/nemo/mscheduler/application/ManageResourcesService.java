package br.ufes.inf.nemo.mscheduler.application;

import javax.ejb.Local;

import br.ufes.inf.nemo.jbutler.ejb.application.CrudService;
import br.ufes.inf.nemo.mscheduler.domain.Resource;

@Local
public interface ManageResourcesService extends CrudService<Resource> {


}