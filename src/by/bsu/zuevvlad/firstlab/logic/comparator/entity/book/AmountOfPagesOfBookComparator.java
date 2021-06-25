package by.bsu.zuevvlad.firstlab.logic.comparator.entity.book;

import by.bsu.zuevvlad.firstlab.entity.book.Book;

import java.util.Comparator;

public final class AmountOfPagesOfBookComparator implements Comparator<Book>
{
    @Override
    public final int compare(final Book firstBook, final Book secondBook)
    {
        final int amountOfPagesOfFirstBook = firstBook.getAmountOfPages();
        final int amountOfPagesOfSecondBook = secondBook.getAmountOfPages();
        return amountOfPagesOfFirstBook - amountOfPagesOfSecondBook;
    }
}

