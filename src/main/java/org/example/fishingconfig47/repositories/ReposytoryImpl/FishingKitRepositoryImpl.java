package org.example.fishingconfig47.repositories.ReposytoryImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example.fishingconfig47.entities.FishingKit;
import org.example.fishingconfig47.repositories.IRepository.IFishingKitRepository;

import java.util.List;

public class FishingKitRepositoryImpl implements IFishingKitRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void delete(FishingKit entity) {
        if (entityManager.contains(entity)) {
            entityManager.remove(entity);
        } else {
            entityManager.remove(entityManager.merge(entity));
        }
    }

    @Override
    public void deleteById(Integer id) {
        FishingKit entity = findById(id);
        if (entity != null) {
            delete(entity);
        }
    }

    @Override
    public FishingKit findById(Integer id) {
        return entityManager.find(FishingKit.class, id);
    }

    @Override
    public List<FishingKit> findAll() {
        return entityManager.createQuery("from FishingKit", FishingKit.class).getResultList();
    }

    @Override
    public List<FishingKit> findByName(String name) {
        String jpql = "SELECT fk FROM FishingKit fk WHERE fk.name = :name";
        return entityManager.createQuery(jpql, FishingKit.class)
                .setParameter("name", name)
                .getResultList();
    }

    @Override
    public <S extends FishingKit> S update(S entity) {
        return entityManager.merge(entity);
    }

    @Override
    public List<FishingKit> findKitsByRodNameAndReelName(String rodName, String reelName) {
        String jpql = "SELECT fk FROM FishingKit fk WHERE fk.rod.name LIKE :rodName AND fk.reel.name LIKE :reelName";
        return entityManager.createQuery(jpql, FishingKit.class)
                .setParameter("rodName", "%" + rodName + "%")
                .setParameter("reelName", "%" + reelName + "%")
                .getResultList();
    }

    @Override
    public <S extends FishingKit> S save(S entity) {
        if (entity.getId() == null) {
            entityManager.persist(entity);
            return entity;
        } else {
            return entityManager.merge(entity);
        }
    }
}
