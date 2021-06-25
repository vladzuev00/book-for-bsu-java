package by.bsu.zuevvlad.firstlab.logic.specification.exception;

public class SpecificationException extends Exception
{
    public SpecificationException()
    {
        super();
    }

    public SpecificationException(final String description)
    {
        super(description);
    }

    public SpecificationException(final Exception cause)
    {
        super(cause);
    }

    public SpecificationException(final String description, final Exception cause)
    {
        super(description, cause);
    }
}
