package org.example.fishingconfig47.repositories.RepositoryImpl;

import org.example.fishingconfig47.entities.Line;
import org.example.fishingconfig47.repositories.IRepository.ILineRepository;


public class LineRepositoryImpl extends CustomCrudRepositoryImpl<Line, Integer> implements ILineRepository {

    protected LineRepositoryImpl(Class<Line> entityClass) {
        super(entityClass);
    }
}
