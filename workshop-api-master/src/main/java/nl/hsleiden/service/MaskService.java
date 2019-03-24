package nl.hsleiden.service;

import nl.hsleiden.model.Mask;
import nl.hsleiden.persistence.MaskDAO;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

public class MaskService {

    private final MaskDAO maskDAO;

    @Inject
    public MaskService(MaskDAO maskDao) {
        this.maskDAO = maskDao;
    }

    public List<Mask> getAll() {
        return maskDAO.getAll();
    }

    public Optional<Mask> get(int id) {
        return maskDAO.get(id);
    }

    public void add(Mask mask) {
        maskDAO.save(mask);
    }

    public void update(Mask mask) {
        maskDAO.update(mask);
    }

    public void delete(int id) {
        maskDAO.delete(id);
    }
}
