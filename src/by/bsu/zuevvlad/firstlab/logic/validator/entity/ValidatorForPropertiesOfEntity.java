package by.bsu.zuevvlad.firstlab.logic.validator.entity;

import by.bsu.zuevvlad.firstlab.entity.Entity;

public class ValidatorForPropertiesOfEntity<TypeOfEntity extends Entity>
{
    public ValidatorForPropertiesOfEntity()
    {
        super();
    }

    public boolean isValidEntity(final TypeOfEntity researchEntity)
    {
        final long idOfResearchEntity = researchEntity.getId();
        return this.isValidId(idOfResearchEntity);
    }

    public final boolean isValidId(final long id)
    {
        return     ValidatorForPropertiesOfEntity.MINIMAL_ALLOWABLE_VALUE_OF_ID <= id
                && id <= ValidatorForPropertiesOfEntity.MAXIMAL_ALLOWABLE_VALUE_OF_ID;
    }

    public static final long MINIMAL_ALLOWABLE_VALUE_OF_ID = 1;
    public static final long MAXIMAL_ALLOWABLE_VALUE_OF_ID = Long.MAX_VALUE;
}
