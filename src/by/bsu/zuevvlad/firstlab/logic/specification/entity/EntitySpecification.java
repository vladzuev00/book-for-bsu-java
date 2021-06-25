package by.bsu.zuevvlad.firstlab.logic.specification.entity;

import by.bsu.zuevvlad.firstlab.entity.Entity;

@FunctionalInterface
public interface EntitySpecification<TypeOfEntity extends Entity>
{
    public abstract boolean isMatch(final TypeOfEntity researchEntity);
}
