package by.bsu.zuevvlad.firstlab.logic.databaseconnection.file.exception;

import by.bsu.zuevvlad.firstlab.logic.databaseconnection.exception.DataBaseConnectionReloadingException;

public class FileDataBaseConnectionReloadingException extends DataBaseConnectionReloadingException
{
    public FileDataBaseConnectionReloadingException()
    {
        super();
    }

    public FileDataBaseConnectionReloadingException(final String description)
    {
        super(description);
    }

    public FileDataBaseConnectionReloadingException(final Exception cause)
    {
        super(cause);
    }

    public FileDataBaseConnectionReloadingException(final String description, final Exception cause)
    {
        super(description, cause);
    }
}
