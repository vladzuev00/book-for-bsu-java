package by.bsu.zuevvlad.firstlab.logic.databaseconnection.file.exception;

import by.bsu.zuevvlad.firstlab.logic.databaseconnection.exception.DataBaseConnectionLoadingException;

public class FileDataBaseConnectionLoadingException extends DataBaseConnectionLoadingException
{
    public FileDataBaseConnectionLoadingException()
    {
        super();
    }

    public FileDataBaseConnectionLoadingException(final String description)
    {
        super(description);
    }

    public FileDataBaseConnectionLoadingException(final Exception cause)
    {
        super(cause);
    }

    public FileDataBaseConnectionLoadingException(final String description, final Exception cause)
    {
        super(description, cause);
    }
}
