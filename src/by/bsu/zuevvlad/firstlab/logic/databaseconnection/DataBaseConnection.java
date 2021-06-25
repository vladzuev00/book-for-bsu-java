package by.bsu.zuevvlad.firstlab.logic.databaseconnection;

import by.bsu.zuevvlad.firstlab.entity.Entity;
import by.bsu.zuevvlad.firstlab.logic.databaseconnection.exception.DataBaseConnectionAddingException;
import by.bsu.zuevvlad.firstlab.logic.databaseconnection.exception.DataBaseConnectionCheckingContainingException;
import by.bsu.zuevvlad.firstlab.logic.databaseconnection.exception.DataBaseConnectionRemovingException;
import by.bsu.zuevvlad.firstlab.logic.databaseconnection.exception.DataBaseConnectionSearchingException;
import by.bsu.zuevvlad.firstlab.logic.specification.entity.EntitySpecification;

import java.util.Comparator;
import java.util.List;

public interface DataBaseConnection<TypeOfEntity extends Entity>
{
    public abstract void addEntity(final TypeOfEntity addedEntity)
            throws DataBaseConnectionAddingException;
    public abstract boolean isContain(final long idOfFoundEntity)
            throws DataBaseConnectionCheckingContainingException;
    public abstract boolean isContain(final TypeOfEntity foundEntity);
    public abstract void removeEntity(final long idOfRemovedEntity)
            throws DataBaseConnectionRemovingException;
    public abstract void removeEntity(final TypeOfEntity removedEntity)
            throws DataBaseConnectionRemovingException;
    public abstract TypeOfEntity findEntity(final long idOfFoundEntity)
            throws DataBaseConnectionSearchingException;
    public abstract List<TypeOfEntity> findEntities(final EntitySpecification<TypeOfEntity> entitySpecification);
    public abstract List<TypeOfEntity> findAllEntities();
    public abstract List<TypeOfEntity> sortEntities(final Comparator<? super TypeOfEntity> comparator,
                                                    final boolean increasingSort);
    public abstract int findAmountOfEntities();
}
