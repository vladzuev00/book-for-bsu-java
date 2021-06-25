package by.bsu.zuevvlad.firstlab.logic.databaseconnection.exception;

public class DataBaseConnectionClearingException extends DataBaseConnectionException
{
    public DataBaseConnectionClearingException()
    {
        super();
    }

    public DataBaseConnectionClearingException(final String description)
    {
        super(description);
    }

    public DataBaseConnectionClearingException(final Exception cause)
    {
        super(cause);
    }

    public DataBaseConnectionClearingException(final String description, final Exception cause)
    {
        super(description, cause);
    }
}
