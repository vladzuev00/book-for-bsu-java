package by.bsu.zuevvlad.firstlab.logic.specification.entity.book;

import by.bsu.zuevvlad.firstlab.entity.book.Book;
import by.bsu.zuevvlad.firstlab.logic.specification.entity.EntitySpecification;
import by.bsu.zuevvlad.firstlab.logic.specification.exception.SpecificationCreatingException;
import by.bsu.zuevvlad.firstlab.logic.specification.exception.SpecificationUpdatingException;
import by.bsu.zuevvlad.firstlab.logic.validator.entity.book.ValidatorForPropertiesOfBook;

public final class TypeOfCoverOfBookSpecification implements EntitySpecification<Book>
{
    private Book.TypeOfCover requiredTypeOfCover;

    public TypeOfCoverOfBookSpecification()
    {
        this.requiredTypeOfCover = TypeOfCoverOfBookSpecification.VALUE_OF_NOT_DEFINED_TYPE_OF_COVER;
    }

    private static final Book.TypeOfCover VALUE_OF_NOT_DEFINED_TYPE_OF_COVER = Book.VALUE_OF_NOT_DEFINED_TYPE_OF_COVER;

    public TypeOfCoverOfBookSpecification(final Book.TypeOfCover requiredTypeOfCover)
            throws SpecificationCreatingException
    {
        if(!TypeOfCoverOfBookSpecification.VALIDATOR_FOR_PROPERTIES_OF_BOOK.isValidTypeOfCover(requiredTypeOfCover))
        {
            throw new SpecificationCreatingException("Impossible to create specification-object of class '"
                    + this.getClass().getName() + "' with given not valid required type of cover. Given "
                    + "required type of cover: " + requiredTypeOfCover + ".");
        }
        this.requiredTypeOfCover = requiredTypeOfCover;
    }

    private static final ValidatorForPropertiesOfBook VALIDATOR_FOR_PROPERTIES_OF_BOOK
            = new ValidatorForPropertiesOfBook();

    public final void setRequiredTypeOfCover(final Book.TypeOfCover requiredTypeOfCover)
            throws SpecificationUpdatingException
    {
        if(!TypeOfCoverOfBookSpecification.VALIDATOR_FOR_PROPERTIES_OF_BOOK.isValidTypeOfCover(requiredTypeOfCover))
        {
            throw new SpecificationUpdatingException("Impossible to update specification-object of class '"
                    + this.getClass().getName() + "' by given not valid required type of cover. Given "
                    + "required type of cover: " + requiredTypeOfCover + ".");
        }
        this.requiredTypeOfCover = requiredTypeOfCover;
    }

    public final Book.TypeOfCover getRequiredTypeOfCover()
    {
        return this.requiredTypeOfCover;
    }

    @Override
    public final boolean isMatch(final Book researchBook)
    {
        return this.requiredTypeOfCover == researchBook.getTypeOfCover();
    }
}
