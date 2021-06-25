package by.bsu.zuevvlad.firstlab.logic.comparator.entity.book;

import by.bsu.zuevvlad.firstlab.entity.book.Book;

import java.util.Comparator;

public final class NamesOfAuthorsOfBookComparator implements Comparator<Book>
{
    @Override
    public final int compare(final Book firstBook, final Book secondBook)
    {
        final String[] namesOfAuthorsOfFirstBook = firstBook.getNamesOfAuthors();
        final String[] namesOfAuthorsOfSecondBook = secondBook.getNamesOfAuthors();
        if(namesOfAuthorsOfFirstBook.length != namesOfAuthorsOfSecondBook.length)
        {
            return namesOfAuthorsOfFirstBook.length - namesOfAuthorsOfSecondBook.length;
        }
        int resultOfComparingOfTwoAuthorsWithEqualIndexes;
        for(int i = 0; i < namesOfAuthorsOfFirstBook.length; i++)
        {
            resultOfComparingOfTwoAuthorsWithEqualIndexes = namesOfAuthorsOfFirstBook[i]
                    .compareTo(namesOfAuthorsOfSecondBook[i]);
            if(resultOfComparingOfTwoAuthorsWithEqualIndexes == 0)
            {
                continue;
            }
            return resultOfComparingOfTwoAuthorsWithEqualIndexes;
        }
        return 0;
    }
}
