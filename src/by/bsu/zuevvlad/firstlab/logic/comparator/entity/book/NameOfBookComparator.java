package by.bsu.zuevvlad.firstlab.logic.comparator.entity.book;

import by.bsu.zuevvlad.firstlab.entity.book.Book;

import java.util.Comparator;

public final class NameOfBookComparator implements Comparator<Book>
{
    @Override
    public final int compare(final Book firstBook, final Book secondBook)
    {
        final String nameOfFirstBook = firstBook.getName();
        final String nameOfSecondBook = secondBook.getName();
        return nameOfFirstBook.compareTo(nameOfSecondBook);
    }
}
