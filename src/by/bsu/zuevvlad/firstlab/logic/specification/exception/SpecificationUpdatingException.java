package by.bsu.zuevvlad.firstlab.logic.specification.exception;

public class SpecificationUpdatingException extends Exception
{
    public SpecificationUpdatingException()
    {
        super();
    }

    public SpecificationUpdatingException(final String description)
    {
        super(description);
    }

    public SpecificationUpdatingException(final Exception cause)
    {
        super(cause);
    }

    public SpecificationUpdatingException(final String description, final Exception cause)
    {
        super(description, cause);
    }
}
