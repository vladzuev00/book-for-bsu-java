package by.bsu.zuevvlad.firstlab.logic.specification.entity.book;

import by.bsu.zuevvlad.firstlab.entity.book.Book;
import by.bsu.zuevvlad.firstlab.logic.specification.entity.EntitySpecification;
import by.bsu.zuevvlad.firstlab.logic.specification.exception.SpecificationCreatingException;
import by.bsu.zuevvlad.firstlab.logic.specification.exception.SpecificationUpdatingException;
import by.bsu.zuevvlad.firstlab.logic.validator.entity.book.ValidatorForPropertiesOfBook;

public final class YearOfPublishingOfBookSpecification implements EntitySpecification<Book>
{
    private int requiredYearOfPublishing;

    public YearOfPublishingOfBookSpecification()
    {
        this.requiredYearOfPublishing
                = YearOfPublishingOfBookSpecification.VALUE_OF_NOT_DEFINED_REQUIRED_YEAR_OF_PUBLISHING;
    }

    private static final int VALUE_OF_NOT_DEFINED_REQUIRED_YEAR_OF_PUBLISHING
            = Book.VALUE_OF_NOT_DEFINED_YEAR_OF_PUBLISHING;

    public YearOfPublishingOfBookSpecification(final int requiredYearOfPublishing)
            throws SpecificationCreatingException
    {
        if(!YearOfPublishingOfBookSpecification.VALIDATOR_FOR_PROPERTIES_OF_BOOK
                .isValidYearOfPublishing(requiredYearOfPublishing))
        {
            throw new SpecificationCreatingException("Impossible to create specification-object of class '"
                    + this.getClass().getName() + "' with not valid given required year of publishing. Given required "
                    + "year of publishing: " + this.requiredYearOfPublishing + ".");
        }
        this.requiredYearOfPublishing = requiredYearOfPublishing;
    }

    private static final ValidatorForPropertiesOfBook VALIDATOR_FOR_PROPERTIES_OF_BOOK
            = new ValidatorForPropertiesOfBook();

    public final void setRequiredYearOfPublishing(final int requiredYearOfPublishing)
            throws SpecificationUpdatingException
    {
        if(!YearOfPublishingOfBookSpecification.VALIDATOR_FOR_PROPERTIES_OF_BOOK
                .isValidYearOfPublishing(requiredYearOfPublishing))
        {
            throw new SpecificationUpdatingException("Impossible to update specification-object of class '"
                    + this.getClass().getName() + "' by not valid given required year of publishing. Given required "
                    + "year of publishing: " + this.requiredYearOfPublishing + ".");
        }
        this.requiredYearOfPublishing = requiredYearOfPublishing;
    }

    public final int getRequiredYearOfPublishing()
    {
        return this.requiredYearOfPublishing;
    }

    @Override
    public final boolean isMatch(final Book researchBook)
    {
        return this.requiredYearOfPublishing == researchBook.getYearOfPublishing();
    }
}
