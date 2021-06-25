package by.bsu.zuevvlad.firstlab.logic.databaseconnection.exception;

public class DataBaseConnectionRemovingException extends DataBaseConnectionException
{
    public DataBaseConnectionRemovingException()
    {
        super();
    }

    public DataBaseConnectionRemovingException(final String description)
    {
        super(description);
    }

    public DataBaseConnectionRemovingException(final Exception cause)
    {
        super(cause);
    }

    public DataBaseConnectionRemovingException(final String description, final Exception cause)
    {
        super(description, cause);
    }
}
