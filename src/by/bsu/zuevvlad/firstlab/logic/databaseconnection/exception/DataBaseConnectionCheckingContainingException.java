package by.bsu.zuevvlad.firstlab.logic.databaseconnection.exception;

public class DataBaseConnectionCheckingContainingException extends DataBaseConnectionException
{
    public DataBaseConnectionCheckingContainingException()
    {
        super();
    }

    public DataBaseConnectionCheckingContainingException(final String description)
    {
        super(description);
    }

    public DataBaseConnectionCheckingContainingException(final Exception cause)
    {
        super(cause);
    }

    public DataBaseConnectionCheckingContainingException(final String description, final Exception cause)
    {
        super(description, cause);
    }
}
