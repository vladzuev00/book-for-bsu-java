package by.bsu.zuevvlad.firstlab.logic.entityrepository.book;

import by.bsu.zuevvlad.firstlab.entity.book.Book;
import by.bsu.zuevvlad.firstlab.logic.databaseconnection.DataBaseConnection;
import by.bsu.zuevvlad.firstlab.logic.entityrepository.EntityRepository;

public final class BookRepository extends EntityRepository<Book>
{
    private BookRepository(final DataBaseConnection<Book> dataBaseConnection)
    {
        super(dataBaseConnection);
    }

    public static BookRepository getBookRepository(final DataBaseConnection<Book> dataBaseConnection)
    {
        if(BookRepository.bookRepository == null)
        {
            synchronized(BookRepository.class)
            {
                if(BookRepository.bookRepository == null)
                {
                    BookRepository.bookRepository = new BookRepository(dataBaseConnection);
                }
            }
        }
        return BookRepository.bookRepository;
    }

    private static BookRepository bookRepository = null;
}
