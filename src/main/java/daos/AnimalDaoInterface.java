package daos;

import entities.Animal;

public interface AnimalDaoInterface {
    Animal getAnimalById(int id);
    boolean save(Animal a);
}
