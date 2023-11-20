package application;

import daos.AnimalDao;
import daos.AnimalDaoInterface;
import entities.Animal;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.LogManager;

public class TestApp {
    public static void main(String[] args) {
        // Hide info messages about hibernate activities
        // Can also hide warnings by setting level to Level.SEVERE
        LogManager.getLogManager().getLogger("").setLevel(Level.SEVERE);
        EntityManagerFactory managerFactor = Persistence.createEntityManagerFactory("default");
        EntityManager manager = managerFactor.createEntityManager();

        AnimalDaoInterface animalDao = new AnimalDao(manager);
        Animal match = animalDao.getAnimalById(2);
        System.out.println(match);

        manager.close();
        managerFactor.close();
    }
}
