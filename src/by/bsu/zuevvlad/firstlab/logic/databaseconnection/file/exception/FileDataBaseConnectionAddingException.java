package by.bsu.zuevvlad.firstlab.logic.databaseconnection.file.exception;

import by.bsu.zuevvlad.firstlab.logic.databaseconnection.exception.DataBaseConnectionAddingException;

public class FileDataBaseConnectionAddingException extends DataBaseConnectionAddingException
{
    public FileDataBaseConnectionAddingException()
    {
        super();
    }

    public FileDataBaseConnectionAddingException(final String description)
    {
        super(description);
    }

    public FileDataBaseConnectionAddingException(final Exception cause)
    {
        super(cause);
    }

    public FileDataBaseConnectionAddingException(final String description, final Exception cause){
        super(description, cause);
    }
}
