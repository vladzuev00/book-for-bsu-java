package by.bsu.zuevvlad.firstlab.logic.databaseconnection.file.exception;

import by.bsu.zuevvlad.firstlab.logic.databaseconnection.exception.DataBaseConnectionRemovingException;

public class FileDataBaseConnectionRemovingException extends DataBaseConnectionRemovingException
{
    public FileDataBaseConnectionRemovingException()
    {
        super();
    }

    public FileDataBaseConnectionRemovingException(final String description)
    {
        super(description);
    }

    public FileDataBaseConnectionRemovingException(final Exception cause)
    {
        super(cause);
    }

    public FileDataBaseConnectionRemovingException(final String description, final Exception cause)
    {
        super(description, cause);
    }
}
