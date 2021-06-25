package by.bsu.zuevvlad.firstlab.logic.specification.exception;

public class SpecificationCreatingException extends SpecificationException
{
    public SpecificationCreatingException()
    {
        super();
    }

    public SpecificationCreatingException(final String description)
    {
        super(description);
    }

    public SpecificationCreatingException(final Exception cause)
    {
        super(cause);
    }

    public SpecificationCreatingException(final String description, final Exception cause)
    {
        super(description, cause);
    }
}
