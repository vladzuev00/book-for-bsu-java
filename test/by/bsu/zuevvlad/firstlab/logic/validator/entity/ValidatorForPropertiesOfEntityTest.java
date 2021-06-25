package by.bsu.zuevvlad.firstlab.logic.validator.entity;

import by.bsu.zuevvlad.firstlab.entity.Entity;
import org.testng.Assert;
import org.testng.annotations.Test;

public final class ValidatorForPropertiesOfEntityTest
{
    public ValidatorForPropertiesOfEntityTest()
    {
        super();
    }

    @Test
    public final void entityShouldBeValid()
    {
        final ValidatorForPropertiesOfEntity<Entity> validatorForPropertiesOfEntity
                = new ValidatorForPropertiesOfEntity<Entity>();
        final long idOfResearchEntity = 1;
        final Entity researchEntity = new SubEntity(idOfResearchEntity);
        Assert.assertTrue(validatorForPropertiesOfEntity.isValidEntity(researchEntity));
    }

    private static final class SubEntity extends Entity
    {
        SubEntity(final long id)
        {
            super(id);
        }
    }

    @Test
    public final void entityShouldNotBeValid()
    {
        final ValidatorForPropertiesOfEntity<Entity> validatorForPropertiesOfEntity
                = new ValidatorForPropertiesOfEntity<Entity>();
        final long idOfResearchEntity = 0;
        final Entity researchEntity = new SubEntity(idOfResearchEntity);
        Assert.assertFalse(validatorForPropertiesOfEntity.isValidEntity(researchEntity));
    }

    @Test
    public final void idShouldBeValid()
    {
        final ValidatorForPropertiesOfEntity<Entity> validatorForPropertiesOfEntity
                = new ValidatorForPropertiesOfEntity<Entity>();
        final long researchId = 1;
        Assert.assertTrue(validatorForPropertiesOfEntity.isValidId(researchId));
    }

    @Test
    public final void idShouldNotBeValid()
    {
        final ValidatorForPropertiesOfEntity<Entity> validatorForPropertiesOfEntity
                = new ValidatorForPropertiesOfEntity<Entity>();
        final long researchId = 0;
        Assert.assertFalse(validatorForPropertiesOfEntity.isValidId(researchId));
    }
}
