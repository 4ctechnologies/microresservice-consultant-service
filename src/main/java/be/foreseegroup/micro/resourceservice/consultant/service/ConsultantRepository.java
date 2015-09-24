package be.foreseegroup.micro.resourceservice.consultant.service;

import be.foreseegroup.micro.resourceservice.consultant.model.Consultant;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Kaj on 24/09/15.
 */
public interface ConsultantRepository extends CrudRepository<Consultant, String> {}