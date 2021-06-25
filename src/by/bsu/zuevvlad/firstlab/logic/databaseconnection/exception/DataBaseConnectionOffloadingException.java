package by.bsu.zuevvlad.firstlab.logic.databaseconnection.exception;

public class DataBaseConnectionOffloadingException extends DataBaseConnectionException
{
    public DataBaseConnectionOffloadingException()
    {
        super();
    }

    public DataBaseConnectionOffloadingException(final String description)
    {
        super(description);
    }

    public DataBaseConnectionOffloadingException(final Exception cause)
    {
        super(cause);
    }

    public DataBaseConnectionOffloadingException(final String description, final Exception cause)
    {
        super(description, cause);
    }
}
