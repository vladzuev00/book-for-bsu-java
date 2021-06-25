package by.bsu.zuevvlad.firstlab.logic.databaseconnection.file.exception;

import by.bsu.zuevvlad.firstlab.logic.databaseconnection.exception.DataBaseConnectionClearingException;

public class FileDataBaseConnectionClearingException extends DataBaseConnectionClearingException
{
    public FileDataBaseConnectionClearingException()
    {
        super();
    }

    public FileDataBaseConnectionClearingException(final String description)
    {
        super(description);
    }

    public FileDataBaseConnectionClearingException(final Exception cause)
    {
        super(cause);
    }

    public FileDataBaseConnectionClearingException(final String description, final Exception cause)
    {
        super(description, cause);
    }
}
