package by.bsu.zuevvlad.firstlab.logic.databaseconnection.exception;

public class DataBaseConnectionSearchingException extends DataBaseConnectionException
{
    public DataBaseConnectionSearchingException()
    {
        super();
    }

    public DataBaseConnectionSearchingException(final String description)
    {
        super(description);
    }

    public DataBaseConnectionSearchingException(final Exception cause)
    {
        super(cause);
    }

    public DataBaseConnectionSearchingException(final String description, final Exception cause)
    {
        super(description, cause);
    }
}
