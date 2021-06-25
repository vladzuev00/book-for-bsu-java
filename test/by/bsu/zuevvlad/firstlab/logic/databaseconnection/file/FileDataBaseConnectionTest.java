package by.bsu.zuevvlad.firstlab.logic.databaseconnection.file;

import by.bsu.zuevvlad.firstlab.entity.Entity;
import by.bsu.zuevvlad.firstlab.logic.databaseconnection.exception.DataBaseConnectionAddingException;
import by.bsu.zuevvlad.firstlab.logic.databaseconnection.exception.DataBaseConnectionCheckingContainingException;
import by.bsu.zuevvlad.firstlab.logic.databaseconnection.exception.DataBaseConnectionRemovingException;
import by.bsu.zuevvlad.firstlab.logic.databaseconnection.file.exception.FileDataBaseConnectionAddingException;
import by.bsu.zuevvlad.firstlab.logic.databaseconnection.file.exception.FileDataBaseConnectionCreatingException;
import by.bsu.zuevvlad.firstlab.logic.databaseconnection.file.exception.FileDataBaseConnectionRemovingException;
import by.bsu.zuevvlad.firstlab.logic.filefounder.FileFounder;
import by.bsu.zuevvlad.firstlab.logic.idgenerator.IdGenerator;
import by.bsu.zuevvlad.firstlab.logic.validator.entity.ValidatorForPropertiesOfEntity;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public final class FileDataBaseConnectionTest
{
    @BeforeClass
    public final void loadEntitiesInFileDataBaseAndCreateFileDataBaseConnection()
            throws IOException, FileDataBaseConnectionCreatingException
    {
        final FileFounder fileFounder = new FileFounder();
        FileDataBaseConnectionTest.fileDataBase = fileFounder.findFile(
                FileDataBaseConnectionTest.NAME_OF_CONNECTED_FILE_DATA_BASE,
                FileDataBaseConnectionTest.PARTS_OF_PATH_TO_CONNECTED_FILE_DATA_BASE);
        FileDataBaseConnectionTest.loadEntitiesInFileDataBase();
        FileDataBaseConnectionTest.fileDataBaseConnection = FileDataBaseConnection.createFileDataBaseConnection(
                FileDataBaseConnectionTest.fileDataBase);
    }

    private static File fileDataBase = null;
    private static final String[] PARTS_OF_PATH_TO_CONNECTED_FILE_DATA_BASE = {"data", "fortest"};
    private static final String NAME_OF_CONNECTED_FILE_DATA_BASE = "entity";
    private static FileDataBaseConnection<SubEntity> fileDataBaseConnection = null;


    private static final class SubEntity extends Entity
    {
        public SubEntity()
        {
            super();
        }

        public SubEntity(final long id)
        {
            super(id);
        }
    }

    private static void loadEntitiesInFileDataBase()
            throws FileNotFoundException, IOException
    {
        try(final FileOutputStream fileOutputStream = new FileOutputStream(FileDataBaseConnectionTest.fileDataBase);
            final BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            final ObjectOutputStream objectOutputStream = new ObjectOutputStream(bufferedOutputStream))
        {
            for(final Entity loadedEntity : FileDataBaseConnectionTest.ENTITIES_FOR_FILE_DATA_BASE)
            {
                objectOutputStream.writeObject(loadedEntity);
            }
        }
    }

    private static final IdGenerator ID_GENERATOR = new IdGenerator();

    private static final SubEntity[] ENTITIES_FOR_FILE_DATA_BASE =
            {
                    new SubEntity(FileDataBaseConnectionTest.ID_GENERATOR.generateId()),
                    new SubEntity(FileDataBaseConnectionTest.ID_GENERATOR.generateId()),
                    new SubEntity(FileDataBaseConnectionTest.ID_GENERATOR.generateId()),
                    new SubEntity(FileDataBaseConnectionTest.ID_GENERATOR.generateId()),
                    new SubEntity(FileDataBaseConnectionTest.ID_GENERATOR.generateId())
            };

    @Test
    public final void fileDataBaseConnectionShouldBeCreatedByFileDataBase()
    {
        FileDataBaseConnection<Entity> fileDataBaseConnection = null;
        try
        {
            fileDataBaseConnection = FileDataBaseConnection.createFileDataBaseConnection(
                    FileDataBaseConnectionTest.fileDataBase);
        }
        catch(final FileDataBaseConnectionCreatingException notExpectedException)
        {
            Assert.fail();
        }
        final List<Entity> actualLoadedEntities = fileDataBaseConnection.findAllEntities();
        final List<Entity> expectedLoadedEntities
                = Arrays.asList(FileDataBaseConnectionTest.ENTITIES_FOR_FILE_DATA_BASE);
        Assert.assertEquals(actualLoadedEntities, expectedLoadedEntities);
    }

    @Test
    public final void fileDataBaseConnectionShouldNotBeCreatedByFileDataBase()
    {
        boolean exceptionArisen = false;
        try
        {
            FileDataBaseConnection.createFileDataBaseConnection(FileDataBaseConnectionTest.NOT_EXISTING_FILE);
        }
        catch(final FileDataBaseConnectionCreatingException expectedException)
        {
            exceptionArisen = true;
        }
        Assert.assertTrue(exceptionArisen);
    }

    private static final File NOT_EXISTING_FILE = new File(FileDataBaseConnectionTest.NAME_OF_NOT_EXISTING_FILE);
    private static final String NAME_OF_NOT_EXISTING_FILE = "notexistingfile";

    @Test
    public final void fileDataBaseConnectionShouldBeCreatedByPathOfFileDataBase()
    {
        FileDataBaseConnection<Entity> fileDataBaseConnection = null;
        try
        {
            fileDataBaseConnection = FileDataBaseConnection.createFileDataBaseConnection(
                    FileDataBaseConnectionTest.NAME_OF_CONNECTED_FILE_DATA_BASE,
                    FileDataBaseConnectionTest.PARTS_OF_PATH_TO_CONNECTED_FILE_DATA_BASE);
        }
        catch(final FileDataBaseConnectionCreatingException notExpectedException)
        {
            Assert.fail();
        }
        final List<Entity> actualLoadedEntities = fileDataBaseConnection.findAllEntities();
        final List<Entity> expectedLoadedEntities = Arrays.asList(FileDataBaseConnectionTest.ENTITIES_FOR_FILE_DATA_BASE);
        Assert.assertEquals(actualLoadedEntities, expectedLoadedEntities);
    }

    @Test
    public final void fileDataBaseConnectionShouldNotBeCreatedByPathOfFileDataBase()
    {
        boolean exceptionIsArisen = false;
        try
        {
            FileDataBaseConnection.createFileDataBaseConnection(FileDataBaseConnectionTest.NAME_OF_NOT_EXISTING_FILE,
                    FileDataBaseConnectionTest.PARTS_OF_PATH_TO_NOT_EXISTING_FILE);
        }
        catch(final FileDataBaseConnectionCreatingException expectedException)
        {
            exceptionIsArisen = true;
        }
        Assert.assertTrue(exceptionIsArisen);
    }

    private static final String[] PARTS_OF_PATH_TO_NOT_EXISTING_FILE = {"not", "existing", "path"};

    @Test
    public final void entityShouldBeAddedInFileDataBase()
            throws DataBaseConnectionRemovingException
    {
        final SubEntity addedEntity = new SubEntity(FileDataBaseConnectionTest.ID_GENERATOR.generateId());
        try
        {
            FileDataBaseConnectionTest.fileDataBaseConnection.addEntity(addedEntity);
        }
        catch(final DataBaseConnectionAddingException notExpectedException)
        {
            Assert.fail();
        }
        Assert.assertTrue(FileDataBaseConnectionTest.fileDataBaseConnection.isContain(addedEntity));
        FileDataBaseConnectionTest.fileDataBaseConnection.removeEntity(addedEntity);
    }

    @Test
    public final void entityShouldNotBeAddedInFileDataBase()
    {
        final long idOfAddedEntity = FileDataBaseConnectionTest.ENTITIES_FOR_FILE_DATA_BASE[0].getId();
        final SubEntity addedEntity = new SubEntity(idOfAddedEntity);
        boolean exceptionIsArisen = false;
        try
        {
            FileDataBaseConnectionTest.fileDataBaseConnection.addEntity(addedEntity);
        }
        catch(final DataBaseConnectionAddingException expectedException)
        {
            exceptionIsArisen = true;
        }
        Assert.assertTrue(exceptionIsArisen);
    }

    @Test
    public final void entityWithGivenIdShouldBeContainedInFileDataBase()
    {
        final long idOfResearchEntity = FileDataBaseConnectionTest.ENTITIES_FOR_FILE_DATA_BASE[0].getId();
        final boolean expectedResultOfCheckingContainingOfEntityInFileDataBase = true;
        boolean actualResultOfCheckingContainingOfEntityInFileDataBase = false;
        try
        {
            actualResultOfCheckingContainingOfEntityInFileDataBase
                    = FileDataBaseConnectionTest.fileDataBaseConnection.isContain(idOfResearchEntity);
        }
        catch(final DataBaseConnectionCheckingContainingException notExpectedException)
        {
            Assert.fail();
        }
        Assert.assertSame(actualResultOfCheckingContainingOfEntityInFileDataBase,
                expectedResultOfCheckingContainingOfEntityInFileDataBase);
    }

    @Test
    public final void entityWithGivenValidIdShouldNotBeContainedInFileDataBase()
    {
        final long idOfResearchEntity = FileDataBaseConnectionTest.ID_GENERATOR.generateId();
        final boolean expectedResultOfCheckingContainingOfEntityInFileDataBase = false;
        boolean actualResultOfCheckingContainingOfEntityInFileDataBase = true;
        try
        {
            actualResultOfCheckingContainingOfEntityInFileDataBase
                    = FileDataBaseConnectionTest.fileDataBaseConnection.isContain(idOfResearchEntity);
        }
        catch(final DataBaseConnectionCheckingContainingException notExpectedException)
        {
            Assert.fail();
        }
        Assert.assertSame(actualResultOfCheckingContainingOfEntityInFileDataBase,
                expectedResultOfCheckingContainingOfEntityInFileDataBase);
    }

    @Test
    public final void checkingContainingOfEntityByNotValidIdShouldBeImpossible()
    {
        final long idOfResearchEntity = ValidatorForPropertiesOfEntity.MINIMAL_ALLOWABLE_VALUE_OF_ID - 1;
        boolean exceptionIsArisen = false;
        try
        {
            FileDataBaseConnectionTest.fileDataBaseConnection.isContain(idOfResearchEntity);
        }
        catch(final DataBaseConnectionCheckingContainingException expectedException)
        {
            exceptionIsArisen = true;
        }
        Assert.assertTrue(exceptionIsArisen);
    }

    @Test
    public final void entityShouldBeContainedByFileDataBase()
    {
        final SubEntity researchEntity = FileDataBaseConnectionTest.ENTITIES_FOR_FILE_DATA_BASE[0];
        final boolean resultOfCheckingContainingOfEntityInFileDataBase
                = FileDataBaseConnectionTest.fileDataBaseConnection.isContain(researchEntity);
        Assert.assertTrue(resultOfCheckingContainingOfEntityInFileDataBase);
    }

    @Test
    public final void entityShouldNotBeContainedByFileDataBase()
    {
        final long idOfResearchEntity = FileDataBaseConnectionTest.ID_GENERATOR.generateId();
        final SubEntity researchEntity = new SubEntity(idOfResearchEntity);
        final boolean resultOfCheckingContainingOfEntityInFileDataBase
                = FileDataBaseConnectionTest.fileDataBaseConnection.isContain(researchEntity);
        Assert.assertFalse(resultOfCheckingContainingOfEntityInFileDataBase);
    }

    @Test
    public final void entityShouldBeRemovedFromFileDataBaseById()
            throws FileDataBaseConnectionAddingException
    {
        final SubEntity removedEntity = FileDataBaseConnectionTest.ENTITIES_FOR_FILE_DATA_BASE[0];
        final long idOfRemovedEntity = removedEntity.getId();
        try
        {
            FileDataBaseConnectionTest.fileDataBaseConnection.removeEntity(idOfRemovedEntity);
        }
        catch(final DataBaseConnectionRemovingException notExpectedException)
        {
            Assert.fail();
        }
        final List<SubEntity> actualEntitiesOfFileDataBase
                = FileDataBaseConnectionTest.fileDataBaseConnection.findAllEntities();
        final List<SubEntity> expectedEntitiesOfFileDataBase = Arrays.asList(ENTITIES_FOR_FILE_DATA_BASE)
                .subList(1, FileDataBaseConnectionTest.ENTITIES_FOR_FILE_DATA_BASE.length);
        Assert.assertEquals(actualEntitiesOfFileDataBase, expectedEntitiesOfFileDataBase);
        FileDataBaseConnectionTest.fileDataBaseConnection.addEntity(removedEntity);
    }

    @Test
    public final void entityShouldNotBeRemovedFromFileDataBaseByNotValidId()
    {
        final long idOfRemovedEntity = ValidatorForPropertiesOfEntity.MINIMAL_ALLOWABLE_VALUE_OF_ID - 1;
        boolean exceptionIsArisen = false;
        try
        {
            FileDataBaseConnectionTest.fileDataBaseConnection.removeEntity(idOfRemovedEntity);
        }
        catch(final FileDataBaseConnectionRemovingException expectedException)
        {
            exceptionIsArisen = true;
        }
        Assert.assertTrue(exceptionIsArisen);
    }

    @Test
    public final void entityShouldNotBeRemovedFromFileDataBaseByNotExistingId()
    {
        final long idOfRemovedEntity = FileDataBaseConnectionTest.ID_GENERATOR.generateId();
        boolean exceptionIsArisen = false;
        try
        {
            FileDataBaseConnectionTest.fileDataBaseConnection.removeEntity(idOfRemovedEntity);
        }
        catch(final FileDataBaseConnectionRemovingException expectedException)
        {
            exceptionIsArisen = true;
        }
        Assert.assertTrue(exceptionIsArisen);
    }

}
