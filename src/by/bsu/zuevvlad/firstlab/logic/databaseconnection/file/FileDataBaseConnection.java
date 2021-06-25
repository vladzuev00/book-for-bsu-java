package by.bsu.zuevvlad.firstlab.logic.databaseconnection.file;

import by.bsu.zuevvlad.firstlab.entity.Entity;
import by.bsu.zuevvlad.firstlab.logic.databaseconnection.DataBaseConnection;
import by.bsu.zuevvlad.firstlab.logic.databaseconnection.file.exception.*;
import by.bsu.zuevvlad.firstlab.logic.filecleaner.FileCleaner;
import by.bsu.zuevvlad.firstlab.logic.filecleaner.exception.FileClearingException;
import by.bsu.zuevvlad.firstlab.logic.filefounder.FileFounder;
import by.bsu.zuevvlad.firstlab.logic.specification.entity.EntitySpecification;
import by.bsu.zuevvlad.firstlab.logic.validator.entity.ValidatorForPropertiesOfEntity;

import java.io.*;
import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

public final class FileDataBaseConnection<TypeOfEntity extends Entity> implements DataBaseConnection<TypeOfEntity>
{
    private final File connectedDataBaseFile;
    private final Map<Long, TypeOfEntity> entitiesAndTheirIdentificationNumbers;
    private final Lock lock;

    public static <TypeOfEntity extends Entity> FileDataBaseConnection<TypeOfEntity> createFileDataBaseConnection(
            final File connectedFileDataBase)
            throws FileDataBaseConnectionCreatingException
    {
        if(!(connectedFileDataBase.exists() && connectedFileDataBase.isFile()))
        {
            throw new FileDataBaseConnectionCreatingException("Impossible to connect to '"
                    + connectedFileDataBase.getAbsolutePath() + "'.");
        }
        final Map<Long, TypeOfEntity> entitiesFromDataBase;
        try(final FileInputStream fileInputStream = new FileInputStream(connectedFileDataBase);
            final BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            final ObjectInputStream objectInputStream = new ObjectInputStream(bufferedInputStream))
        {
            synchronized(connectedFileDataBase)
            {
                entitiesFromDataBase = FileDataBaseConnection.<TypeOfEntity>offloadEntities(objectInputStream);
            }
        }
        catch(final IOException | FileDataBaseConnectionOffloadingException cause)
        {
            throw new FileDataBaseConnectionCreatingException(cause);
        }
        return new FileDataBaseConnection<TypeOfEntity>(connectedFileDataBase, entitiesFromDataBase);
    }

    private FileDataBaseConnection(final File connectedDataBaseFile,
                                   final Map<Long, TypeOfEntity> entitiesAndTheirIdentificationNumbers)
    {
        super();
        this.connectedDataBaseFile = connectedDataBaseFile;
        this.entitiesAndTheirIdentificationNumbers = entitiesAndTheirIdentificationNumbers;
        this.lock = new ReentrantLock();
    }

    private static <TypeOfEntity extends Entity> Map<Long, TypeOfEntity> offloadEntities(
            final ObjectInputStream objectInputStream)
            throws FileDataBaseConnectionOffloadingException
    {
        final Map<Long, TypeOfEntity> entitiesAndTheirIdentificationNumbers = new HashMap<Long, TypeOfEntity>();
        Object lastReadObject;
        TypeOfEntity lastReadEntity;
        try
        {
            while(true)
            {
                lastReadObject = objectInputStream.readObject();
                if(!(lastReadObject instanceof Entity))
                {
                    throw new FileDataBaseConnectionOffloadingException(new ClassCastException(
                            "Impossible to offload object of class '" + lastReadObject.getClass().getName()
                                    + "' from file, because it is not entity."));
                }
                lastReadEntity = (TypeOfEntity)lastReadObject;
                entitiesAndTheirIdentificationNumbers.put(lastReadEntity.getId(), lastReadEntity);
            }
        }
        catch(final EOFException exceptionOfEndDeserialization)
        {
            return entitiesAndTheirIdentificationNumbers;
        }
        catch(final IOException | ClassNotFoundException cause)
        {
            throw new FileDataBaseConnectionOffloadingException(cause);
        }
    }

    public static <TypeOfEntity extends Entity> FileDataBaseConnection<TypeOfEntity> createFileDataBaseConnection(
            final String nameOfConnectedDataBaseFile, final String... partsOfPathToConnectedDataBaseFile)
            throws FileDataBaseConnectionCreatingException
    {
        final FileFounder fileFounder = new FileFounder();
        final File connectedDataBaseFile;
        try
        {
            connectedDataBaseFile = fileFounder.findFile(nameOfConnectedDataBaseFile,
                    partsOfPathToConnectedDataBaseFile);
        }
        catch(final FileNotFoundException cause)
        {
            throw new FileDataBaseConnectionCreatingException(cause);
        }
        return FileDataBaseConnection.<TypeOfEntity>createFileDataBaseConnection(connectedDataBaseFile);
    }

    public final File getConnectedDataBaseFile()
    {
        return this.connectedDataBaseFile;
    }

    @Override
    public final void addEntity(final TypeOfEntity addedEntity)
            throws FileDataBaseConnectionAddingException
    {
        if(this.isContain(addedEntity))
        {
            throw new FileDataBaseConnectionAddingException("Impossible to add given entity, because entity with the"
                    + " same id has already been added. Given entity: " + addedEntity + ".");
        }
        final boolean writingInTheEndOfFile = true;
        this.lock.lock();
        try(final FileOutputStream fileOutputStream = new FileOutputStream(this.connectedDataBaseFile, writingInTheEndOfFile);
            final BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            final ObjectOutputStream objectOutputStream = new ObjectOutputStream(bufferedOutputStream))
        {
            this.entitiesAndTheirIdentificationNumbers.put(addedEntity.getId(), addedEntity);
            objectOutputStream.writeObject(addedEntity);
        }
        catch(final IOException cause)
        {
            throw new FileDataBaseConnectionAddingException(cause);
        }
        finally
        {
            this.lock.unlock();
        }
    }

    @Override
    public final boolean isContain(final long idOfFoundEntity)
            throws FileDataBaseConnectionCheckingContainingException
    {
        if(!FileDataBaseConnection.VALIDATOR_FOR_PROPERTIES_OF_ENTITY.isValidId(idOfFoundEntity))
        {
            throw new FileDataBaseConnectionCheckingContainingException("Given id of entity to determine, if it is"
                    + " contained by file data base, is not valid. Given id: " + idOfFoundEntity + ".");
        }
        this.lock.lock();
        try
        {
            return this.entitiesAndTheirIdentificationNumbers.containsKey(idOfFoundEntity);
        }
        finally
        {
            this.lock.unlock();
        }
    }

    private static final ValidatorForPropertiesOfEntity<Entity> VALIDATOR_FOR_PROPERTIES_OF_ENTITY
            = new ValidatorForPropertiesOfEntity<>();

    @Override
    public final boolean isContain(final TypeOfEntity foundEntity)
    {
        final long idOfFoundEntity = foundEntity.getId();
        this.lock.lock();
        try
        {
            return this.entitiesAndTheirIdentificationNumbers.containsKey(idOfFoundEntity);
        }
        finally
        {
            this.lock.unlock();
        }
    }

    @Override
    public final void removeEntity(final long idOfRemovedEntity)
            throws FileDataBaseConnectionRemovingException
    {
        if(!FileDataBaseConnection.VALIDATOR_FOR_PROPERTIES_OF_ENTITY.isValidId(idOfRemovedEntity))
        {
            throw new FileDataBaseConnectionRemovingException("Impossible to remove entity from data base "
                    + "by given not valid id: " + idOfRemovedEntity + ".");
        }
        if(!this.entitiesAndTheirIdentificationNumbers.containsKey(idOfRemovedEntity))
        {
            throw new FileDataBaseConnectionRemovingException("Impossible to remove entity from data base by given id,"
                    + " because entity with given id hasn't added in data base. Given id: " + idOfRemovedEntity + ".");
        }
        this.lock.lock();
        try
        {
            this.entitiesAndTheirIdentificationNumbers.remove(idOfRemovedEntity);
            FileDataBaseConnection.<TypeOfEntity>reloadEntities(this.connectedDataBaseFile,
                    new LinkedList<TypeOfEntity>(this.entitiesAndTheirIdentificationNumbers.values()));
        }
        catch(final FileDataBaseConnectionReloadingException cause)
        {
            throw new FileDataBaseConnectionRemovingException(cause);
        }
        finally
        {
            this.lock.unlock();
        }
    }

    private static <TypeOfEntity extends Entity> void reloadEntities(final File connectedDataBaseFile,
                                                                     final List<TypeOfEntity> loadedEntities)
            throws FileDataBaseConnectionReloadingException
    {
        final FileCleaner fileCleaner = new FileCleaner();
        try
        {
            fileCleaner.clearFile(connectedDataBaseFile);
            FileDataBaseConnection.<TypeOfEntity>loadEntities(connectedDataBaseFile, loadedEntities);
        }
        catch(final FileClearingException | FileDataBaseConnectionLoadingException cause)
        {
            throw new FileDataBaseConnectionReloadingException(cause);
        }
    }

    private static <TypeOfEntity extends Entity> void loadEntities(final File fileDataBase,
                                                                   final List<TypeOfEntity> loadedEntities)
            throws FileDataBaseConnectionLoadingException
    {
        try(final FileOutputStream fileOutputStream = new FileOutputStream(fileDataBase);
            final BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            final ObjectOutputStream objectOutputStream = new ObjectOutputStream(bufferedOutputStream))
        {
            for(final TypeOfEntity loadedEntity : loadedEntities)
            {
                objectOutputStream.writeObject(loadedEntity);
            }
        }
        catch(final IOException cause)
        {
            throw new FileDataBaseConnectionLoadingException(cause);
        }
    }

    @Override
    public final void removeEntity(final TypeOfEntity removedEntity)
            throws FileDataBaseConnectionRemovingException
    {
        final long idOfRemovedEntity = removedEntity.getId();
        this.removeEntity(idOfRemovedEntity);
    }

    @Override
    public final TypeOfEntity findEntity(final long idOfFoundEntity)
            throws FileDataBaseConnectionSearchingException
    {
        if(!FileDataBaseConnection.VALIDATOR_FOR_PROPERTIES_OF_ENTITY.isValidId(idOfFoundEntity))
        {
            throw new FileDataBaseConnectionSearchingException("Impossible to find entity in file data base by given"
                    + " not valid id. Given id : " + idOfFoundEntity + ".");
        }
        if(!this.entitiesAndTheirIdentificationNumbers.containsKey(idOfFoundEntity))
        {
            throw new FileDataBaseConnectionSearchingException("File data base doesn't contain entity with given id. "
                    + "Given id : " + idOfFoundEntity + ".");
        }
        this.lock.lock();
        try
        {
            return this.entitiesAndTheirIdentificationNumbers.get(idOfFoundEntity);
        }
        finally
        {
            this.lock.unlock();
        }
    }

    @Override
    public final List<TypeOfEntity> findEntities(final EntitySpecification<TypeOfEntity> entitySpecification)
    {
        this.lock.lock();
        try
        {
            final List<TypeOfEntity> matchingEntities = new ArrayList<>();
            final Collection<TypeOfEntity> entitiesOfFileDataBase = this.entitiesAndTheirIdentificationNumbers.values();
            for(final TypeOfEntity researchEntity : entitiesOfFileDataBase)
            {
                if(entitySpecification.isMatch(researchEntity))
                {
                    matchingEntities.add(researchEntity);
                }
            }
            return matchingEntities;
        }
        finally
        {
            this.lock.unlock();
        }
    }

    @Override
    public final List<TypeOfEntity> findAllEntities()
    {
        this.lock.lock();
        try
        {
            return new ArrayList<TypeOfEntity>(this.entitiesAndTheirIdentificationNumbers.values());
        }
        finally
        {
            this.lock.unlock();
        }
    }

    @Override
    public final List<TypeOfEntity> sortEntities(final Comparator<? super TypeOfEntity> comparator,
                                                 final boolean increasingSort)
    {
        if(!increasingSort)
        {
            final Comparator<? super TypeOfEntity> reversedComparator = comparator.reversed();
            this.sortEntities(reversedComparator, true);
        }
        this.lock.lock();
        try
        {
            return this.entitiesAndTheirIdentificationNumbers.values().stream().sorted(comparator)
                    .collect(Collectors.toList());
        }
        finally
        {
            this.lock.unlock();
        }
    }

    @Override
    public final int findAmountOfEntities()
    {
        this.lock.lock();
        try
        {
            return this.entitiesAndTheirIdentificationNumbers.size();
        }
        finally
        {
            this.lock.unlock();
        }
    }
}
