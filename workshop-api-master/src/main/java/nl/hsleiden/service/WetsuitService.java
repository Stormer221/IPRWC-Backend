package nl.hsleiden.service;

import nl.hsleiden.model.Wetsuit;
import nl.hsleiden.persistence.WetsuitDAO;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

public class WetsuitService {

    private final WetsuitDAO wetsuitDAO;

    @Inject
    public WetsuitService(WetsuitDAO wetsuitDao) {
        this.wetsuitDAO = wetsuitDao;
    }

    public List<Wetsuit> getAll() {
        return WetsuitDAO.getAll();
    }

    public Optional<Wetsuit> get(int id) {
        return wetsuitDAO.get(id);
    }

    public void add(Wetsuit wetsuit) {
        wetsuitDAO.save(wetsuit);
    }

    public void update(Wetsuit wetsuit) {
        wetsuitDAO.update(wetsuit);
    }

    public void delete(int id) {
        wetsuitDAO.delete(id);
    }
}
