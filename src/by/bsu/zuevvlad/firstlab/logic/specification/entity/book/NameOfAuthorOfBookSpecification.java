package by.bsu.zuevvlad.firstlab.logic.specification.entity.book;

import by.bsu.zuevvlad.firstlab.entity.book.Book;
import by.bsu.zuevvlad.firstlab.logic.specification.entity.EntitySpecification;
import by.bsu.zuevvlad.firstlab.logic.specification.exception.SpecificationCreatingException;
import by.bsu.zuevvlad.firstlab.logic.specification.exception.SpecificationUpdatingException;
import by.bsu.zuevvlad.firstlab.logic.validator.entity.book.ValidatorForPropertiesOfBook;

import java.util.Objects;

public final class NameOfAuthorOfBookSpecification implements EntitySpecification<Book>
{
    private String requiredNameOfAuthor;

    public NameOfAuthorOfBookSpecification()
    {
        this.requiredNameOfAuthor = NameOfAuthorOfBookSpecification.VALUE_OF_NOT_DEFINED_REQUIRED_NAME_OF_AUTHOR;
    }

    public static final String VALUE_OF_NOT_DEFINED_REQUIRED_NAME_OF_AUTHOR = Book.VALUE_OF_NOT_DEFINED_NAME;

    public NameOfAuthorOfBookSpecification(final String requiredNameOfAuthor)
            throws SpecificationCreatingException
    {
        if(!NameOfAuthorOfBookSpecification.VALIDATOR_FOR_PROPERTIES_OF_BOOK.isValidNameOfAuthor(requiredNameOfAuthor))
        {
            throw new SpecificationCreatingException("Impossible to create specification-object of class '"
                    + this.getClass().getName() + "' with not valid given required name of author: "
                    + requiredNameOfAuthor + ".");
        }
        this.requiredNameOfAuthor = requiredNameOfAuthor;
    }

    private static final ValidatorForPropertiesOfBook VALIDATOR_FOR_PROPERTIES_OF_BOOK
            = new ValidatorForPropertiesOfBook();

    public final void setRequiredNameOfAuthor(final String requiredNameOfAuthor)
            throws SpecificationUpdatingException
    {
        if(!NameOfAuthorOfBookSpecification.VALIDATOR_FOR_PROPERTIES_OF_BOOK.isValidNameOfAuthor(requiredNameOfAuthor))
        {
            throw new SpecificationUpdatingException("Impossible to update specification-object of class '"
                    + this.getClass().getName() + "' by not valid given required name of author: "
                    + requiredNameOfAuthor + ".");
        }
        this.requiredNameOfAuthor = requiredNameOfAuthor;
    }

    public final String getRequiredNameOfAuthor()
    {
        return this.requiredNameOfAuthor;
    }

    @Override
    public final boolean isMatch(final Book researchBook)
    {
        for(final String nameOfAuthorOfBook : researchBook.getNamesOfAuthors())
        {
            if(Objects.equals(this.requiredNameOfAuthor, nameOfAuthorOfBook))
            {
                return true;
            }
        }
        return false;
    }
}
