package by.bsu.zuevvlad.firstlab.logic.comparator.entity.book;

import by.bsu.zuevvlad.firstlab.entity.book.Book;

import java.math.BigDecimal;
import java.util.Comparator;

public final class PriceOfBookComparator implements Comparator<Book>
{
    @Override
    public final int compare(final Book firstBook, final Book secondBook)
    {
        final BigDecimal priceOfFirstBook = firstBook.getPrice();
        final BigDecimal priceOfSecondBook = secondBook.getPrice();
        return priceOfFirstBook.compareTo(priceOfSecondBook);
    }
}
