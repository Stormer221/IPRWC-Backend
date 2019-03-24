package nl.hsleiden.service;

import nl.hsleiden.model.Shoe;
import nl.hsleiden.persistence.ShoeDAO;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

public class ShoeService {

    private final ShoeDAO shoeDAO;

    @Inject
    public ShoeService(ShoeDAO shoeDao) {
        this.shoeDAO = shoeDao;
    }

    public List<Shoe> getAll() {
        return shoeDAO.getAll();
    }

    public Optional<Shoe> get(int id) {
        return shoeDAO.get(id);
    }

    public void add(Shoe shoe) {
        shoeDAO.save(shoe);
    }

    public void update(Shoe shoe) {
        shoeDAO.update(shoe);
    }

    public void delete(int id) {
        shoeDAO.delete(id);
    }
}
