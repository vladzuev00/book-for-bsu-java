package by.bsu.zuevvlad.firstlab.logic.entityrepository.exception;

public class EntityRepositoryAddingException extends EntityRepositoryException
{
    public EntityRepositoryAddingException()
    {
        super();
    }

    public EntityRepositoryAddingException(final String description)
    {
        super(description);
    }

    public EntityRepositoryAddingException(final Exception cause)
    {
        super(cause);
    }

    public EntityRepositoryAddingException(final String description, final Exception cause)
    {
        super(description, cause);
    }
}
