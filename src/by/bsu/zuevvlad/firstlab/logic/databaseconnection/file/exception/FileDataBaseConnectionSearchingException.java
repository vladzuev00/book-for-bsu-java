package by.bsu.zuevvlad.firstlab.logic.databaseconnection.file.exception;

import by.bsu.zuevvlad.firstlab.logic.databaseconnection.exception.DataBaseConnectionSearchingException;

public class FileDataBaseConnectionSearchingException extends DataBaseConnectionSearchingException
{
    public FileDataBaseConnectionSearchingException()
    {
        super();
    }

    public FileDataBaseConnectionSearchingException(final String description)
    {
        super(description);
    }

    public FileDataBaseConnectionSearchingException(final Exception cause)
    {
        super(cause);
    }

    public FileDataBaseConnectionSearchingException(final String description, final Exception cause)
    {
        super(description, cause);
    }
}
