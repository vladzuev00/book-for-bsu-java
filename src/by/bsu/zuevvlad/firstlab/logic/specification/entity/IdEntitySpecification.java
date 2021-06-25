package by.bsu.zuevvlad.firstlab.logic.specification.entity;

import by.bsu.zuevvlad.firstlab.entity.Entity;
import by.bsu.zuevvlad.firstlab.logic.specification.exception.SpecificationCreatingException;
import by.bsu.zuevvlad.firstlab.logic.specification.exception.SpecificationUpdatingException;
import by.bsu.zuevvlad.firstlab.logic.validator.entity.ValidatorForPropertiesOfEntity;

public final class IdEntitySpecification<TypeOfEntity extends Entity> implements EntitySpecification<TypeOfEntity>
{
    private long requiredId;

    public IdEntitySpecification()
    {
        super();
        this.requiredId = IdEntitySpecification.VALUE_OF_NOT_DEFINED_REQUIRED_ID;
    }

    private static final long VALUE_OF_NOT_DEFINED_REQUIRED_ID = Entity.VALUE_OF_NOT_DEFINED_ID;

    public IdEntitySpecification(final long requiredId)
            throws SpecificationCreatingException
    {
        if(!IdEntitySpecification.VALIDATOR_FOR_PROPERTIES_OF_ENTITY.isValidId(requiredId))
        {
            throw new SpecificationCreatingException("Impossible to create specification-object of class '"
                    + IdEntitySpecification.class.getName() + "' with given not valid required id. Given "
                    + "required id: " + requiredId + ".");
        }
        this.requiredId = requiredId;
    }

    private static final ValidatorForPropertiesOfEntity<Entity> VALIDATOR_FOR_PROPERTIES_OF_ENTITY
            = new ValidatorForPropertiesOfEntity<>();

    public final void setRequiredId(final long requiredId)
            throws SpecificationUpdatingException
    {
        if(!IdEntitySpecification.VALIDATOR_FOR_PROPERTIES_OF_ENTITY.isValidId(requiredId))
        {
            throw new SpecificationUpdatingException("Impossible to update specification-object of class '"
                    + IdEntitySpecification.class.getName() + "' with given not valid required id. Given "
                    + "required id: " + requiredId + ".");
        }
        this.requiredId = requiredId;
    }

    public final long getRequiredId()
    {
        return this.requiredId;
    }

    @Override
    public final boolean isMatch(final Entity researchEntity)
    {
        return this.requiredId == researchEntity.getId();
    }
}
