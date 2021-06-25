package by.bsu.zuevvlad.firstlab.logic.comparator.entity.book;

import by.bsu.zuevvlad.firstlab.entity.book.Book;

import java.util.Comparator;

public final class TypeOfCoverOfBookComparator implements Comparator<Book>
{
    @Override
    public final int compare(final Book firstBook, final Book secondBook)
    {
        final Book.TypeOfCover typeOfCoverOfFirstBook = firstBook.getTypeOfCover();
        final Book.TypeOfCover typeOfCoverOfSecondBook = secondBook.getTypeOfCover();
        return typeOfCoverOfFirstBook.compareTo(typeOfCoverOfSecondBook);
    }
}
