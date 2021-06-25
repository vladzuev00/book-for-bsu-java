package by.bsu.zuevvlad.firstlab.logic.filecleaner;

import by.bsu.zuevvlad.firstlab.logic.filecleaner.exception.FileClearingException;
import by.bsu.zuevvlad.firstlab.logic.filefounder.FileFounder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public final class FileCleaner
{
    public final void clearFile(final File clearedFile)
            throws FileClearingException
    {
        try(final FileOutputStream fileOutputStream = new FileOutputStream(clearedFile))
        {
            final String emptyString = "";
            fileOutputStream.write(emptyString.getBytes());
        }
        catch(final IOException cause)
        {
            throw new FileClearingException(cause);
        }
    }

    public final void clearFile(final String nameOfClearedFile, final String... partsOfPathToClearedFile)
            throws FileClearingException
    {
        final FileFounder fileFounder = new FileFounder();
        final File clearedFile;
        try
        {
            clearedFile = fileFounder.findFile(nameOfClearedFile, partsOfPathToClearedFile);
        }
        catch(final FileNotFoundException cause)
        {
            throw new FileClearingException(cause);
        }
        this.clearFile(clearedFile);
    }
}
