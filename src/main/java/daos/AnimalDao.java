package daos;

import entities.Animal;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class AnimalDao implements AnimalDaoInterface{

    private EntityManager entityManager;
    public AnimalDao(EntityManager em){
        this.entityManager = em;
    }

    @Override
    public Animal getAnimalById(int id) {
        Animal result = entityManager.find(Animal.class, id);
        return result;
    }

    @Override
    public boolean save(Animal a) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(a);
            transaction.commit();
            return true;
        }catch(EntityExistsException e){
            System.out.println("An EntityExistsException occurred when persisting " + a);
            System.out.println(e.getMessage());
            transaction.rollback();
            return false;
        }
    }
}
