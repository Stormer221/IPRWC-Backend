package nl.hsleiden.service;

import nl.hsleiden.model.Fin;
import nl.hsleiden.persistence.FinDAO;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

public class FinsService {
   
    private final FinDAO finDAO;

    @Inject
    public FinsService(FinDAO finDao) {
        this.finDAO = finDao;
    }

    public List<Fin> getAll() {
        return finDAO.getAll();
    }

    public Optional<Fin> get(int id) {
        return finDAO.get(id);
    }

    public void add(Fin fin) {
        finDAO.save(fin);
    }

    public void update(Fin fin) {
        finDAO.update(fin);
    }

    public void delete(int id) {
        finDAO.delete(id);
    }
}
