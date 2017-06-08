package br.ufes.inf.nemo.mscheduler.application;

import javax.ejb.Local;

import br.ufes.inf.nemo.jbutler.ejb.application.CrudService;
import br.ufes.inf.nemo.mscheduler.domain.Localization;
import br.ufes.inf.nemo.mscheduler.domain.Meeting;
import br.ufes.inf.nemo.mscheduler.domain.MeetingRoom;

@Local
public interface ManageLocalizationsService extends CrudService<Localization> {

}