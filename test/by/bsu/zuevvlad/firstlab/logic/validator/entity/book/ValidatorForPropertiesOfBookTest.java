package by.bsu.zuevvlad.firstlab.logic.validator.entity.book;

import by.bsu.zuevvlad.firstlab.entity.book.Book;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigDecimal;

public final class ValidatorForPropertiesOfBookTest
{
    public ValidatorForPropertiesOfBookTest()
    {
        super();
    }

    @Test
    public final void nameShouldBeValid()
    {
        final ValidatorForPropertiesOfBook validatorForPropertiesOfBook = new ValidatorForPropertiesOfBook();
        final String researchName = "text text-text's123";
        Assert.assertTrue(validatorForPropertiesOfBook.isValidName(researchName));
    }

    @Test
    public final void nameShouldNotBeValid()
    {
        final ValidatorForPropertiesOfBook validatorForPropertiesOfBook = new ValidatorForPropertiesOfBook();
        final String researchName = "text";
        Assert.assertFalse(validatorForPropertiesOfBook.isValidName(researchName));
    }

    @Test
    public final void nameOfAuthorShouldBeValid()
    {
        final ValidatorForPropertiesOfBook validatorForPropertiesOfBook = new ValidatorForPropertiesOfBook();
        final String researchNameOfAuthor = "text text-text";
        Assert.assertTrue(validatorForPropertiesOfBook.isValidNameOfAuthor(researchNameOfAuthor));
    }

    @Test
    public final void nameOfAuthorShouldNotBeValid()
    {
        final ValidatorForPropertiesOfBook validatorForPropertiesOfBook = new ValidatorForPropertiesOfBook();
        final String researchNameOfAuthor = "text";
        Assert.assertFalse(validatorForPropertiesOfBook.isValidNameOfAuthor(researchNameOfAuthor));
    }

    @Test
    public final void publishingHouseShouldBeValid()
    {
        final ValidatorForPropertiesOfBook validatorForPropertiesOfBook = new ValidatorForPropertiesOfBook();
        final String researchPublishingHouse = "text text-text's";
        Assert.assertTrue(validatorForPropertiesOfBook.isValidPublishingHouse(researchPublishingHouse));
    }

    @Test
    public final void publishingHouseShouldNotBeValid()
    {
        final ValidatorForPropertiesOfBook validatorForPropertiesOfBook = new ValidatorForPropertiesOfBook();
        final String researchPublishingHouse = "text";
        Assert.assertFalse(validatorForPropertiesOfBook.isValidPublishingHouse(researchPublishingHouse));
    }

    @Test
    public final void yearOfPublishingShouldBeValid()
    {
        final ValidatorForPropertiesOfBook validatorForPropertiesOfBook = new ValidatorForPropertiesOfBook();
        final int researchYearOfPublishing = 1564;
        Assert.assertTrue(validatorForPropertiesOfBook.isValidYearOfPublishing(researchYearOfPublishing));
    }

    @Test
    public final void yearOfPublishingShouldNotBeValid()
    {
        final ValidatorForPropertiesOfBook validatorForPropertiesOfBook = new ValidatorForPropertiesOfBook();
        final int researchYearOfPublishing = 1563;
        Assert.assertFalse(validatorForPropertiesOfBook.isValidYearOfPublishing(researchYearOfPublishing));
    }

    @Test
    public final void amountOfPagesShouldBeValid()
    {
        final ValidatorForPropertiesOfBook validatorForPropertiesOfBook = new ValidatorForPropertiesOfBook();
        final int researchAmountOfPages = 48;
        Assert.assertTrue(validatorForPropertiesOfBook.isValidAmountOfPages(researchAmountOfPages));
    }

    @Test
    public final void amountOfPagesShouldNotBeValid()
    {
        final ValidatorForPropertiesOfBook validatorForPropertiesOfBook = new ValidatorForPropertiesOfBook();
        final int researchAmountOfPages = 37;
        Assert.assertFalse(validatorForPropertiesOfBook.isValidAmountOfPages(researchAmountOfPages));
    }

    @Test
    public final void priceShouldBeValid()
    {
        final ValidatorForPropertiesOfBook validatorForPropertiesOfBook = new ValidatorForPropertiesOfBook();
        final String descriptionOfResearchPrice = "30800000";
        final BigDecimal researchPrice = new BigDecimal(descriptionOfResearchPrice);
        Assert.assertTrue(validatorForPropertiesOfBook.isValidPrice(researchPrice));
    }

    @Test
    public final void priceShouldNotBeValid()
    {
        final ValidatorForPropertiesOfBook validatorForPropertiesOfBook = new ValidatorForPropertiesOfBook();
        final String descriptionOfResearchPrice = "30800001";
        final BigDecimal researchPrice = new BigDecimal(descriptionOfResearchPrice);
        Assert.assertFalse(validatorForPropertiesOfBook.isValidPrice(researchPrice));
    }

    @Test
    public final void typeOfCoverShouldBeValid()
    {
        final ValidatorForPropertiesOfBook validatorForPropertiesOfBook = new ValidatorForPropertiesOfBook();
        final Book.TypeOfCover researchTypeOfCover = Book.TypeOfCover.SOFT;
        Assert.assertTrue(validatorForPropertiesOfBook.isValidTypeOfCover(researchTypeOfCover));
    }

    @Test
    public final void typeOfCoverShouldNotBeValid()
    {
        final ValidatorForPropertiesOfBook validatorForPropertiesOfBook = new ValidatorForPropertiesOfBook();
        final Book.TypeOfCover researchTypeOfCover = Book.TypeOfCover.NOT_DEFINED;
        Assert.assertFalse(validatorForPropertiesOfBook.isValidTypeOfCover(researchTypeOfCover));
    }
}
