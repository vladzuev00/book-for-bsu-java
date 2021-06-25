package by.bsu.zuevvlad.firstlab.logic.specification.entity.book;

import by.bsu.zuevvlad.firstlab.entity.book.Book;
import by.bsu.zuevvlad.firstlab.logic.specification.entity.EntitySpecification;
import by.bsu.zuevvlad.firstlab.logic.specification.exception.SpecificationCreatingException;
import by.bsu.zuevvlad.firstlab.logic.validator.entity.book.ValidatorForPropertiesOfBook;

import java.util.Objects;

public final class NameOfBookSpecification implements EntitySpecification<Book>
{
    private String requiredName;

    public NameOfBookSpecification()
    {
        this.requiredName = NameOfBookSpecification.VALUE_OF_NOT_DEFINED_REQUIRED_NAME;
    }

    private static final String VALUE_OF_NOT_DEFINED_REQUIRED_NAME = Book.VALUE_OF_NOT_DEFINED_NAME;

    public NameOfBookSpecification(final String requiredName)
            throws SpecificationCreatingException
    {
        if(!NameOfBookSpecification.VALIDATOR_FOR_PROPERTIES_OF_BOOK.isValidName(requiredName))
        {
            throw new SpecificationCreatingException("Impossible to create specification-object of class '"
                    + this.getClass().getName() + "' with given not valid required name. Given "
                    + "required name: " + requiredName + ".");
        }
        this.requiredName = requiredName;
    }

    private static final ValidatorForPropertiesOfBook VALIDATOR_FOR_PROPERTIES_OF_BOOK
            = new ValidatorForPropertiesOfBook();

    public final void setRequiredName(final String requiredName)
            throws SpecificationCreatingException
    {
        if(!NameOfBookSpecification.VALIDATOR_FOR_PROPERTIES_OF_BOOK.isValidName(requiredName))
        {
            throw new SpecificationCreatingException("Impossible to update specification-object of class '"
                    + this.getClass().getName() + "' by given not valid required name. Given "
                    + "required name: " + requiredName + ".");
        }
        this.requiredName = requiredName;
    }

    public final String getRequiredName()
    {
        return this.requiredName;
    }

    @Override
    public final boolean isMatch(final Book researchBook)
    {
        return Objects.equals(this.requiredName, researchBook.getName());
    }
}
