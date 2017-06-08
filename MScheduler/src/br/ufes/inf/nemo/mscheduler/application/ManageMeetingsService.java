package br.ufes.inf.nemo.mscheduler.application;

import javax.ejb.EJB;
import javax.ejb.Local;

import br.ufes.inf.nemo.jbutler.ejb.application.CrudException;
import br.ufes.inf.nemo.jbutler.ejb.application.CrudService;
import br.ufes.inf.nemo.mscheduler.domain.Meeting;

@Local
public interface ManageMeetingsService extends CrudService<Meeting> {


}