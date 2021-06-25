package by.bsu.zuevvlad.firstlab.logic.databaseconnection.exception;

public class DataBaseConnectionAddingException extends DataBaseConnectionException
{
    public DataBaseConnectionAddingException()
    {
        super();
    }

    public DataBaseConnectionAddingException(final String description)
    {
        super(description);
    }

    public DataBaseConnectionAddingException(final Exception cause)
    {
        super(cause);
    }

    public DataBaseConnectionAddingException(final String description, final Exception cause)
    {
        super(description, cause);
    }
}
