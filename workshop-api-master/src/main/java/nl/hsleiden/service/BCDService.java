package nl.hsleiden.service;

import nl.hsleiden.model.BCD;
import nl.hsleiden.persistence.BcdDAO;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

public class BCDService {

    private final BcdDAO bcdDAO;

    @Inject
    public BCDService(BcdDAO bcdDao) {
        this.bcdDAO = bcdDao;
    }

    public List<BCD> getAll() {
        return bcdDAO.getAll();
    }

    public Optional<BCD> get(int id) {
        return bcdDAO.get(id);
    }

    public void add(BCD bcd) {
        bcdDAO.save(bcd);
    }

    public void update(BCD bcd) {
        bcdDAO.update(bcd);
    }

    public void delete(int id) {
        bcdDAO.delete(id);
    }
}
