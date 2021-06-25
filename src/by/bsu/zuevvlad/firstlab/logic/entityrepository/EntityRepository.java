package by.bsu.zuevvlad.firstlab.logic.entityrepository;

import by.bsu.zuevvlad.firstlab.entity.Entity;
import by.bsu.zuevvlad.firstlab.logic.databaseconnection.DataBaseConnection;
import by.bsu.zuevvlad.firstlab.logic.databaseconnection.exception.DataBaseConnectionAddingException;
import by.bsu.zuevvlad.firstlab.logic.databaseconnection.exception.DataBaseConnectionCheckingContainingException;
import by.bsu.zuevvlad.firstlab.logic.databaseconnection.exception.DataBaseConnectionRemovingException;
import by.bsu.zuevvlad.firstlab.logic.databaseconnection.exception.DataBaseConnectionSearchingException;
import by.bsu.zuevvlad.firstlab.logic.entityrepository.exception.EntityRepositoryAddingException;
import by.bsu.zuevvlad.firstlab.logic.entityrepository.exception.EntityRepositoryCheckingContainingException;
import by.bsu.zuevvlad.firstlab.logic.entityrepository.exception.EntityRepositoryRemovingException;
import by.bsu.zuevvlad.firstlab.logic.entityrepository.exception.EntityRepositorySearchingException;
import by.bsu.zuevvlad.firstlab.logic.specification.entity.EntitySpecification;

import java.util.Comparator;
import java.util.List;

public abstract class EntityRepository<TypeOfEntity extends Entity>
{
    private final DataBaseConnection<TypeOfEntity> dataBaseConnection;

    protected EntityRepository(final DataBaseConnection<TypeOfEntity> dataBaseConnection)
    {
        this.dataBaseConnection = dataBaseConnection;
    }

    public final void addEntity(final TypeOfEntity addedEntity)
            throws EntityRepositoryAddingException
    {
        try
        {
            this.dataBaseConnection.addEntity(addedEntity);
        }
        catch(final DataBaseConnectionAddingException cause)
        {
            throw new EntityRepositoryAddingException(cause);
        }
    }

    public final boolean isContain(final long idOfFoundEntity)
            throws EntityRepositoryCheckingContainingException
    {
        try
        {
            return this.dataBaseConnection.isContain(idOfFoundEntity);
        }
        catch(final DataBaseConnectionCheckingContainingException cause)
        {
            throw new EntityRepositoryCheckingContainingException(cause);
        }
    }

    public final boolean isContain(final TypeOfEntity foundEntity)
    {
        return this.dataBaseConnection.isContain(foundEntity);
    }

    public final void removeEntity(final long idOfRemovedEntity)
            throws EntityRepositoryRemovingException
    {
        try
        {
            this.dataBaseConnection.removeEntity(idOfRemovedEntity);
        }
        catch(final DataBaseConnectionRemovingException cause)
        {
            throw new EntityRepositoryRemovingException(cause);
        }
    }

    public final void removeEntity(final TypeOfEntity removedEntity)
            throws EntityRepositoryRemovingException
    {
        try
        {
            this.dataBaseConnection.removeEntity(removedEntity);
        }
        catch(final DataBaseConnectionRemovingException cause)
        {
            throw new EntityRepositoryRemovingException(cause);
        }
    }

    public final TypeOfEntity findEntity(final long idOfFoundEntity)
            throws EntityRepositorySearchingException
    {
        try
        {
            return this.dataBaseConnection.findEntity(idOfFoundEntity);
        }
        catch(final DataBaseConnectionSearchingException cause)
        {
            throw new EntityRepositorySearchingException(cause);
        }
    }

    public final List<TypeOfEntity> findEntities(final EntitySpecification<TypeOfEntity> entitySpecification)
    {
        return this.dataBaseConnection.findEntities(entitySpecification);
    }

    public final List<TypeOfEntity> findAllEntities()
    {
        return this.dataBaseConnection.findAllEntities();
    }

    public final List<TypeOfEntity> sortEntities(final Comparator<? super TypeOfEntity> comparator,
                                                 final boolean increasingSort)
    {
        return this.dataBaseConnection.sortEntities(comparator, increasingSort);
    }

    public final int findAmountOfEntities()
    {
        return this.dataBaseConnection.findAmountOfEntities();
    }
}
