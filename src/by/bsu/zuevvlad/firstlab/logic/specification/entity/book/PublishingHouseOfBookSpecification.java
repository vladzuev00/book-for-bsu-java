package by.bsu.zuevvlad.firstlab.logic.specification.entity.book;

import by.bsu.zuevvlad.firstlab.entity.book.Book;
import by.bsu.zuevvlad.firstlab.logic.specification.entity.EntitySpecification;
import by.bsu.zuevvlad.firstlab.logic.specification.exception.SpecificationCreatingException;
import by.bsu.zuevvlad.firstlab.logic.specification.exception.SpecificationUpdatingException;
import by.bsu.zuevvlad.firstlab.logic.validator.entity.book.ValidatorForPropertiesOfBook;

import java.util.Objects;

public final class PublishingHouseOfBookSpecification implements EntitySpecification<Book>
{
    private String requiredPublishingHouse;

    public PublishingHouseOfBookSpecification()
    {
        this.requiredPublishingHouse
                = PublishingHouseOfBookSpecification.VALUE_OF_NOT_DEFINED_REQUIRED_PUBLISHING_HOUSE;
    }

    public static final String VALUE_OF_NOT_DEFINED_REQUIRED_PUBLISHING_HOUSE
            = Book.VALUE_OF_NOT_DEFINED_PUBLISHING_HOUSE;

    public PublishingHouseOfBookSpecification(final String requiredPublishingHouse)
            throws SpecificationCreatingException
    {
        if(!PublishingHouseOfBookSpecification.VALIDATOR_FOR_PROPERTIES_OF_BOOK
                .isValidPublishingHouse(requiredPublishingHouse))
        {
            throw new SpecificationCreatingException("Impossible to create specification-object of class '"
                    + this.getClass().getName() + "' with not valid given required name of publishing house: "
                    + requiredPublishingHouse + ".");
        }
        this.requiredPublishingHouse = requiredPublishingHouse;
    }

    private static final ValidatorForPropertiesOfBook VALIDATOR_FOR_PROPERTIES_OF_BOOK
            = new ValidatorForPropertiesOfBook();

    public final void setRequiredPublishingHouse(final String requiredPublishingHouse)
            throws SpecificationUpdatingException
    {
        if(!PublishingHouseOfBookSpecification.VALIDATOR_FOR_PROPERTIES_OF_BOOK
                .isValidPublishingHouse(requiredPublishingHouse))
        {
            throw new SpecificationUpdatingException("Impossible to update specification-object of class '"
                    + this.getClass().getName() + "' by not valid given required name publishing house: "
                    + requiredPublishingHouse + ".");
        }
        this.requiredPublishingHouse = requiredPublishingHouse;
    }

    public final String getRequiredPublishingHouse()
    {
        return this.requiredPublishingHouse;
    }

    @Override
    public final boolean isMatch(final Book researchBook)
    {
        return Objects.equals(this.requiredPublishingHouse, researchBook.getPublishingHouse());
    }
}
