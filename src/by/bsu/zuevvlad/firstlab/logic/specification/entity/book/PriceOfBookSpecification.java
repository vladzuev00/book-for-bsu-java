package by.bsu.zuevvlad.firstlab.logic.specification.entity.book;

import by.bsu.zuevvlad.firstlab.entity.book.Book;
import by.bsu.zuevvlad.firstlab.logic.specification.entity.EntitySpecification;
import by.bsu.zuevvlad.firstlab.logic.specification.exception.SpecificationCreatingException;
import by.bsu.zuevvlad.firstlab.logic.specification.exception.SpecificationUpdatingException;
import by.bsu.zuevvlad.firstlab.logic.validator.entity.book.ValidatorForPropertiesOfBook;

import java.math.BigDecimal;
import java.util.Objects;

public final class PriceOfBookSpecification implements EntitySpecification<Book>
{
    private BigDecimal requiredPrice;

    public PriceOfBookSpecification()
    {
        this.requiredPrice = PriceOfBookSpecification.VALUE_OF_NOT_DEFINED_REQUIRED_PRICE;
    }

    private static final BigDecimal VALUE_OF_NOT_DEFINED_REQUIRED_PRICE = Book.VALUE_OF_NOT_DEFINED_PRICE;

    public PriceOfBookSpecification(final BigDecimal requiredPrice)
            throws SpecificationCreatingException
    {
        if(!PriceOfBookSpecification.VALIDATOR_FOR_PROPERTIES_OF_BOOK.isValidPrice(requiredPrice))
        {
            throw new SpecificationCreatingException("Impossible to create specification-object of class '"
                    + this.getClass().getName() + "' with given not valid required price. Given "
                    + "required price: " + requiredPrice + ".");
        }
        this.requiredPrice = requiredPrice;
    }

    private static final ValidatorForPropertiesOfBook VALIDATOR_FOR_PROPERTIES_OF_BOOK
            = new ValidatorForPropertiesOfBook();

    public final void setRequiredPrice(final BigDecimal requiredPrice)
            throws SpecificationUpdatingException
    {
        if(!PriceOfBookSpecification.VALIDATOR_FOR_PROPERTIES_OF_BOOK.isValidPrice(requiredPrice))
        {
            throw new SpecificationUpdatingException("Impossible to update specification-object of class '"
                    + this.getClass().getName() + "' by given not valid required price. Given "
                    + "required price: " + requiredPrice + ".");
        }
        this.requiredPrice = requiredPrice;
    }

    public final BigDecimal getRequiredPrice()
    {
        return this.requiredPrice;
    }

    @Override
    public final boolean isMatch(final Book researchBook)
    {
        final BigDecimal priceOfResearchBook = researchBook.getPrice();
        return Objects.equals(this.requiredPrice, priceOfResearchBook);
    }
}
