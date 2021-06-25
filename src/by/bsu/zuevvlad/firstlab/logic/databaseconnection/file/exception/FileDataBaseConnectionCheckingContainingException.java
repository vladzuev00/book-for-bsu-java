package by.bsu.zuevvlad.firstlab.logic.databaseconnection.file.exception;

import by.bsu.zuevvlad.firstlab.logic.databaseconnection.exception.DataBaseConnectionCheckingContainingException;

public class FileDataBaseConnectionCheckingContainingException extends DataBaseConnectionCheckingContainingException
{
    public FileDataBaseConnectionCheckingContainingException()
    {
        super();
    }

    public FileDataBaseConnectionCheckingContainingException(final String description)
    {
        super(description);
    }

    public FileDataBaseConnectionCheckingContainingException(final Exception cause)
    {
        super(cause);
    }

    public FileDataBaseConnectionCheckingContainingException(final String description, final Exception cause)
    {
        super(description, cause);
    }
}
