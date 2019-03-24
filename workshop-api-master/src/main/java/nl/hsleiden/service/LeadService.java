package nl.hsleiden.service;

import nl.hsleiden.model.Lead;
import nl.hsleiden.persistence.LeadDAO;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

public class LeadService {

    private final LeadDAO leadDAO;

    @Inject
    public LeadService(LeadDAO leadDao) {
        this.leadDAO = leadDao;
    }

    public List<Lead> getAll() {
        return leadDAO.getAll();
    }

    public Optional<Lead> get(int id) {
        return leadDAO.get(id);
    }

    public void add(Lead lead) {
        leadDAO.save(lead);
    }

    public void update(Lead lead) {
        leadDAO.update(lead);
    }

    public void delete(int id) {
        leadDAO.delete(id);
    }
}
