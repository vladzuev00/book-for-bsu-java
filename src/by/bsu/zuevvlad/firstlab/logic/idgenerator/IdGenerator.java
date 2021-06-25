package by.bsu.zuevvlad.firstlab.logic.idgenerator;

import by.bsu.zuevvlad.firstlab.entity.Entity;
import by.bsu.zuevvlad.firstlab.logic.idgenerator.exception.IdGeneratorCreatingException;
import by.bsu.zuevvlad.firstlab.logic.validator.entity.ValidatorForPropertiesOfEntity;

public final class IdGenerator
{
    private long nextGeneratedId;

    public IdGenerator()
    {
        super();
        this.nextGeneratedId = IdGenerator.VALUE_OF_NOT_DEFINED_NEXT_GENERATED_ID;
    }

    private static final long VALUE_OF_NOT_DEFINED_NEXT_GENERATED_ID
            = ValidatorForPropertiesOfEntity.MINIMAL_ALLOWABLE_VALUE_OF_ID;

    public IdGenerator(final long nextGeneratedId)
            throws IdGeneratorCreatingException
    {
        if(!IdGenerator.VALIDATOR_FOR_PROPERTIES_OF_ENTITY.isValidId(nextGeneratedId))
        {
            throw new IdGeneratorCreatingException("Impossible to create id object-generator of class "
                    + this.getClass().getName() + " with given not valid next generated id. Given next generated id: "
                    + nextGeneratedId + ".");
        }
        this.nextGeneratedId = nextGeneratedId;
    }

    private static final ValidatorForPropertiesOfEntity<Entity> VALIDATOR_FOR_PROPERTIES_OF_ENTITY
            = new ValidatorForPropertiesOfEntity<Entity>();

    public final long generateId()
    {
        return this.nextGeneratedId++;
    }
}
