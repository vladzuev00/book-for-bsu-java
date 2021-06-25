package by.bsu.zuevvlad.firstlab.logic.filecleaner.exception;

public final class FileClearingException extends Exception
{
    public FileClearingException()
    {
        super();
    }

    public FileClearingException(final String description)
    {
        super(description);
    }

    public FileClearingException(final Exception cause)
    {
        super(cause);
    }

    public FileClearingException(final String description, final Exception cause)
    {
        super(description, cause);
    }
}
