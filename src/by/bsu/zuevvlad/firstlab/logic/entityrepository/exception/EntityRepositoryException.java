package by.bsu.zuevvlad.firstlab.logic.entityrepository.exception;

public class EntityRepositoryException extends Exception
{
    public EntityRepositoryException()
    {
        super();
    }

    public EntityRepositoryException(final String description)
    {
        super(description);
    }

    public EntityRepositoryException(final Exception cause)
    {
        super(cause);
    }

    public EntityRepositoryException(final String description, final Exception cause)
    {
        super(description, cause);
    }
}
