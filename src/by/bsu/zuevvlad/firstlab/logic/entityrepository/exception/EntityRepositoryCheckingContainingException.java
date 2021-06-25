package by.bsu.zuevvlad.firstlab.logic.entityrepository.exception;

public class EntityRepositoryCheckingContainingException extends EntityRepositoryException
{
    public EntityRepositoryCheckingContainingException()
    {
        super();
    }

    public EntityRepositoryCheckingContainingException(final String description)
    {
        super(description);
    }

    public EntityRepositoryCheckingContainingException(final Exception cause)
    {
        super(cause);
    }

    public EntityRepositoryCheckingContainingException(final String description, final Exception cause)
    {
        super(description, cause);
    }
}
