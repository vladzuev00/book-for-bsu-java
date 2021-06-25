package by.bsu.zuevvlad.firstlab.logic.databaseconnection.file.exception;

import by.bsu.zuevvlad.firstlab.logic.databaseconnection.exception.DataBaseConnectionCreatingException;

public class FileDataBaseConnectionCreatingException extends DataBaseConnectionCreatingException
{
    public FileDataBaseConnectionCreatingException()
    {
        super();
    }

    public FileDataBaseConnectionCreatingException(final String description)
    {
        super(description);
    }

    public FileDataBaseConnectionCreatingException(final Exception cause)
    {
        super(cause);
    }

    public FileDataBaseConnectionCreatingException(final String description, final Exception cause)
    {
        super(description, cause);
    }
}
