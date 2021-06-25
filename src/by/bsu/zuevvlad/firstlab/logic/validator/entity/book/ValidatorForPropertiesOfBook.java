package by.bsu.zuevvlad.firstlab.logic.validator.entity.book;

import by.bsu.zuevvlad.firstlab.entity.book.Book;
import by.bsu.zuevvlad.firstlab.logic.validator.entity.ValidatorForPropertiesOfEntity;

import java.math.BigDecimal;
import java.time.LocalDate;

public final class ValidatorForPropertiesOfBook extends ValidatorForPropertiesOfEntity<Book>
{
    public ValidatorForPropertiesOfBook()
    {
        super();
    }

    @Override
    public final boolean isValidEntity(final Book researchBook)
    {
        return     super.isValidEntity(researchBook) && this.isValidName(researchBook.getName())
                && this.isValidNamesOfAuthors(researchBook.getNamesOfAuthors())
                && this.isValidPublishingHouse(researchBook.getPublishingHouse())
                && this.isValidYearOfPublishing(researchBook.getYearOfPublishing())
                && this.isValidAmountOfPages(researchBook.getAmountOfPages())
                && this.isValidPrice(researchBook.getPrice()) && this.isValidTypeOfCover(researchBook.getTypeOfCover());
    }

    public final boolean isValidName(final String researchName)
    {
        return researchName.matches(ValidatorForPropertiesOfBook.REGULAR_EXPRESSION_FOR_NAME_OF_BOOK);
    }

    private static final String REGULAR_EXPRESSION_FOR_NAME_OF_BOOK = "[-a-zA-Z '0-9]{"
            + ValidatorForPropertiesOfBook.MINIMAL_ALLOWABLE_LENGTH_OF_NAME_OF_BOOK + ","
            + ValidatorForPropertiesOfBook.MAXIMAL_ALLOWABLE_LENGTH_OF_NAME_OF_BOOK + "}";
    private static final int MINIMAL_ALLOWABLE_LENGTH_OF_NAME_OF_BOOK = 5;
    private static final int MAXIMAL_ALLOWABLE_LENGTH_OF_NAME_OF_BOOK = 30;

    public final boolean isValidNamesOfAuthors(final String[] researchNamesOfAuthors)
    {
        if(researchNamesOfAuthors.length == 0)
        {
            return false;
        }
        for(final String researchNameOfAuthor : researchNamesOfAuthors)
        {
            if(!this.isValidNameOfAuthor(researchNameOfAuthor))
            {
                return false;
            }
        }
        return true;
    }

    public final boolean isValidNameOfAuthor(final String nameOfAuthor)
    {
        return nameOfAuthor.matches(ValidatorForPropertiesOfBook.REGULAR_EXPRESSION_FOR_NAME_OF_AUTHOR);
    }

    private static final String REGULAR_EXPRESSION_FOR_NAME_OF_AUTHOR = "[-a-zA-Z ]{"
            + ValidatorForPropertiesOfBook.MINIMAL_ALLOWABLE_LENGTH_OF_NAME_OF_AUTHOR + ","
            + ValidatorForPropertiesOfBook.MAXIMAL_ALLOWABLE_LENGTH_OF_NAME_OF_AUTHOR + "}";
    private static final int MINIMAL_ALLOWABLE_LENGTH_OF_NAME_OF_AUTHOR = 5;
    private static final int MAXIMAL_ALLOWABLE_LENGTH_OF_NAME_OF_AUTHOR = 30;

    public final boolean isValidPublishingHouse(final String researchPublishingHouse)
    {
        return researchPublishingHouse.matches(ValidatorForPropertiesOfBook.REGULAR_EXPRESSION_FOR_PUBLISHING_HOUSE);
    }

    private static final String REGULAR_EXPRESSION_FOR_PUBLISHING_HOUSE = "[-a-zA-Z ']{"
            + ValidatorForPropertiesOfBook.MINIMAL_ALLOWABLE_LENGTH_OF_PUBLISHING_HOUSE + ","
            + ValidatorForPropertiesOfBook.MAXIMAL_ALLOWABLE_LENGTH_OF_PUBLISHING_HOUSE + "}";
    private static final int MINIMAL_ALLOWABLE_LENGTH_OF_PUBLISHING_HOUSE = 5;
    private static final int MAXIMAL_ALLOWABLE_LENGTH_OF_PUBLISHING_HOUSE = 30;

    public final boolean isValidYearOfPublishing(final int researchYearOfPublishing)
    {
        return     ValidatorForPropertiesOfBook.MINIMAL_ALLOWABLE_YEAR_OF_PUBLISHING <= researchYearOfPublishing
                && researchYearOfPublishing <= ValidatorForPropertiesOfBook.MAXIMAL_ALLOWABLE_YEAR_OF_PUBLISHING;
    }

    private static final int MINIMAL_ALLOWABLE_YEAR_OF_PUBLISHING = 1564;
    private static final int MAXIMAL_ALLOWABLE_YEAR_OF_PUBLISHING = LocalDate.now().getYear();

    public final boolean isValidAmountOfPages(final int researchAmountOfPages)
    {
        return     ValidatorForPropertiesOfBook.MINIMAL_ALLOWABLE_VALUE_OF_AMOUNT_OF_PAGES <= researchAmountOfPages
                && researchAmountOfPages <= ValidatorForPropertiesOfBook.MAXIMAL_ALLOWABLE_VALUE_OF_AMOUNT_OF_PAGES;
    }

    private static final int MINIMAL_ALLOWABLE_VALUE_OF_AMOUNT_OF_PAGES = 48;
    private static final int MAXIMAL_ALLOWABLE_VALUE_OF_AMOUNT_OF_PAGES = 3604;

    public final boolean isValidPrice(final BigDecimal researchPrice)
    {
        return     researchPrice.compareTo(ValidatorForPropertiesOfBook.MINIMAL_ALLOWABLE_VALUE_OF_PRICE) >= 0
                && researchPrice.compareTo(ValidatorForPropertiesOfBook.MAXIMAL_ALLOWABLE_VALUE_OF_PRICE) <= 0;
    }

    private static final BigDecimal MINIMAL_ALLOWABLE_VALUE_OF_PRICE = BigDecimal.ZERO;
    private static final BigDecimal MAXIMAL_ALLOWABLE_VALUE_OF_PRICE
            = new BigDecimal(ValidatorForPropertiesOfBook.DESCRIPTION_OF_MAXIMAL_ALLOWABLE_VALUE_OF_PRICE);
    private static final String DESCRIPTION_OF_MAXIMAL_ALLOWABLE_VALUE_OF_PRICE = "30800000";

    public final boolean isValidTypeOfCover(final Book.TypeOfCover researchTypeOfCover)
    {
        return researchTypeOfCover != Book.TypeOfCover.NOT_DEFINED;
    }
}
