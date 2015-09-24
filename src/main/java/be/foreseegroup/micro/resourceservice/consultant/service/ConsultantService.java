package be.foreseegroup.micro.resourceservice.consultant.service;

import be.foreseegroup.micro.resourceservice.consultant.model.Consultant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Kaj on 24/09/15.
 */

@RestController
@RequestMapping("/consultants")
public class ConsultantService {
    private static final Logger LOG = LoggerFactory.getLogger(ConsultantService.class);

    @Autowired
    ConsultantRepository repo;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Iterable<Consultant>> getAll() {
        Iterable<Consultant> consultants = repo.findAll();
        LOG.info("/consultants getAll method called, response size: {}", repo.count());
        return new ResponseEntity<>(consultants, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "{id}")
    public ResponseEntity<Consultant> getById(@PathVariable String id) {
        LOG.info("/consultants getById method called");
        Consultant consultant = repo.findOne(id);
        if (consultant == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(consultant, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Consultant> create(@RequestBody Consultant consultant) {
        LOG.info("/consultants create method called");
        Consultant createdConsultant = repo.save(consultant);
        return new ResponseEntity<>(consultant, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "{id}")
    public ResponseEntity<Consultant> update(@PathVariable String id, @RequestBody Consultant consultant) {
        LOG.info("/consultants update method called");
        Consultant update = repo.findOne(id);
        if (update == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        update.setFirstname(consultant.getFirstname());
        update.setLastname(consultant.getLastname());
        update.setAddress(consultant.getAddress());
        Consultant updatedConsultant = repo.save(update);
        return new ResponseEntity<>(updatedConsultant, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "{id}")
    public ResponseEntity<Consultant> delete(@PathVariable String id) {
        LOG.info("/consultants delete method called");
        Consultant consultant = repo.findOne(id);
        if (consultant == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        repo.delete(consultant);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
