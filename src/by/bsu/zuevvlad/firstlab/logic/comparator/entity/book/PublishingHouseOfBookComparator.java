package by.bsu.zuevvlad.firstlab.logic.comparator.entity.book;

import by.bsu.zuevvlad.firstlab.entity.book.Book;

import java.util.Comparator;

public final class PublishingHouseOfBookComparator implements Comparator<Book>
{
    @Override
    public final int compare(final Book firstBook, final Book secondBook)
    {
        final String publishingHouseOfFirstBook = firstBook.getPublishingHouse();
        final String publishingHouseOfSecondBook = secondBook.getPublishingHouse();
        return publishingHouseOfFirstBook.compareTo(publishingHouseOfSecondBook);
    }
}
