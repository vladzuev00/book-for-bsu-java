package by.bsu.zuevvlad.firstlab.logic.entityrepository.exception;

public class EntityRepositoryRemovingException extends EntityRepositoryException
{
    public EntityRepositoryRemovingException()
    {
        super();
    }

    public EntityRepositoryRemovingException(final String description)
    {
        super(description);
    }

    public EntityRepositoryRemovingException(final Exception cause)
    {
        super(cause);
    }

    public EntityRepositoryRemovingException(final String description, final Exception cause)
    {
        super(description, cause);
    }
}
