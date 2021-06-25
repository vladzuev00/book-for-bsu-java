package by.bsu.zuevvlad.firstlab.logic.filefounder;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Optional;

public final class FileFounder
{
    public final File findFile(final String nameOfFile, final String... partsOfPathToFile)
            throws FileNotFoundException
    {
        final String separatorOfPartsOfPathToFile = File.separator;
        final Optional<String> pathToFile = Arrays.stream(partsOfPathToFile).reduce(
                (holder, newPart) -> holder + separatorOfPartsOfPathToFile + newPart);
        final String pathToFileWithItsName = pathToFile.orElse(FileFounder.DEFAULT_PATH_TO_FILE)
                + File.separator + nameOfFile;
        final File foundFile = new File(pathToFileWithItsName);
        if(!foundFile.exists())
        {
            throw new FileNotFoundException("Impossible to find file by path: " + pathToFileWithItsName + ".");
        }
        return foundFile;
    }

    private static final String DEFAULT_PATH_TO_FILE = "data";
}
