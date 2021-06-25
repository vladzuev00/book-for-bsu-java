package by.bsu.zuevvlad.firstlab.logic.comparator.entity;

import by.bsu.zuevvlad.firstlab.entity.Entity;

import java.util.Comparator;

public final class IdOfEntityComparator implements Comparator<Entity>
{
    @Override
    public final int compare(final Entity firstEntity, final Entity secondEntity)
    {
        final long idOfFirstEntity = firstEntity.getId();
        final long idOfSecondEntity = secondEntity.getId();
        return (int)(idOfFirstEntity - idOfSecondEntity);
    }
}
