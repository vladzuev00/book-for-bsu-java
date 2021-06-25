package by.bsu.zuevvlad.firstlab.logic.specification.entity.book;

import by.bsu.zuevvlad.firstlab.entity.book.Book;
import by.bsu.zuevvlad.firstlab.logic.specification.entity.EntitySpecification;
import by.bsu.zuevvlad.firstlab.logic.specification.exception.SpecificationCreatingException;
import by.bsu.zuevvlad.firstlab.logic.specification.exception.SpecificationUpdatingException;
import by.bsu.zuevvlad.firstlab.logic.validator.entity.book.ValidatorForPropertiesOfBook;

public final class AmountOfPagesOfBookSpecification implements EntitySpecification<Book>
{
    private int requiredAmountOfPages;

    public AmountOfPagesOfBookSpecification()
    {
        this.requiredAmountOfPages = AmountOfPagesOfBookSpecification.VALUE_OF_NOT_DEFINED_REQUIRED_AMOUNT_OF_PAGES;
    }

    private static final int VALUE_OF_NOT_DEFINED_REQUIRED_AMOUNT_OF_PAGES = Book.VALUE_OF_NOT_DEFINED_AMOUNT_OF_PAGES;

    public AmountOfPagesOfBookSpecification(final int requiredAmountOfPages)
            throws SpecificationCreatingException
    {
        if(!AmountOfPagesOfBookSpecification.VALIDATOR_FOR_PROPERTIES_OF_BOOK
                .isValidAmountOfPages(requiredAmountOfPages))
        {
            throw new SpecificationCreatingException("Impossible to create specification-object of class '"
                    + this.getClass().getName() + "' with not valid given required amount of pages: "
                    + requiredAmountOfPages + ".");
        }
        this.requiredAmountOfPages = requiredAmountOfPages;
    }

    private static final ValidatorForPropertiesOfBook VALIDATOR_FOR_PROPERTIES_OF_BOOK
            = new ValidatorForPropertiesOfBook();

    public final void setRequiredAmountOfPages(final int requiredAmountOfPages)
            throws SpecificationUpdatingException
    {
        if(!AmountOfPagesOfBookSpecification.VALIDATOR_FOR_PROPERTIES_OF_BOOK
                .isValidAmountOfPages(requiredAmountOfPages))
        {
            throw new SpecificationUpdatingException("Impossible to update specification-object of class '"
                    + this.getClass().getName() + "' by not valid given required amount of pages: "
                    + requiredAmountOfPages + ".");
        }
        this.requiredAmountOfPages = requiredAmountOfPages;
    }

    public final int getRequiredAmountOfPages()
    {
        return this.requiredAmountOfPages;
    }

    @Override
    public final boolean isMatch(final Book researchBook)
    {
        return this.requiredAmountOfPages == researchBook.getAmountOfPages();
    }
}
