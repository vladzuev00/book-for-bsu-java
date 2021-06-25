package by.bsu.zuevvlad.firstlab.entity.book;

import by.bsu.zuevvlad.firstlab.entity.Entity;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Objects;

public final class Book extends Entity
{
    private static final long serialVersionUID = 1L;

    private String name;
    private String[] namesOfAuthors;
    private String publishingHouse;
    private int yearOfPublishing;
    private int amountOfPages;
    private BigDecimal price;
    private TypeOfCover typeOfCover;

    public static enum TypeOfCover
    {
        NOT_DEFINED, HARD, SOFT
    }

    public Book()
    {
        super();
        this.initializeFields(
                Book.VALUE_OF_NOT_DEFINED_NAME, Book.VALUE_OF_NOT_DEFINED_NAMES_OF_AUTHORS,
                Book.VALUE_OF_NOT_DEFINED_PUBLISHING_HOUSE, Book.VALUE_OF_NOT_DEFINED_YEAR_OF_PUBLISHING,
                Book.VALUE_OF_NOT_DEFINED_AMOUNT_OF_PAGES, Book.VALUE_OF_NOT_DEFINED_PRICE,
                Book.VALUE_OF_NOT_DEFINED_TYPE_OF_COVER);
    }

    private final void initializeFields(final String name, final String[] namesOfAuthors, final String publishingHouse,
                                        final int yearOfPublishing, final int amountOfPages, final BigDecimal price,
                                        final TypeOfCover typeOfCover)
    {
        this.name = name;
        this.namesOfAuthors = namesOfAuthors;
        this.publishingHouse = publishingHouse;
        this.yearOfPublishing = yearOfPublishing;
        this.amountOfPages = amountOfPages;
        this.price = price;
        this.typeOfCover = typeOfCover;
    }

    public static final String VALUE_OF_NOT_DEFINED_NAME = "not defined";
    public static final String[] VALUE_OF_NOT_DEFINED_NAMES_OF_AUTHORS = new String[0];
    public static final String VALUE_OF_NOT_DEFINED_PUBLISHING_HOUSE = "not defined";
    public static final int VALUE_OF_NOT_DEFINED_YEAR_OF_PUBLISHING = 0;
    public static final int VALUE_OF_NOT_DEFINED_AMOUNT_OF_PAGES = 0;
    public static final BigDecimal VALUE_OF_NOT_DEFINED_PRICE = BigDecimal.ZERO;
    public static final TypeOfCover VALUE_OF_NOT_DEFINED_TYPE_OF_COVER = Book.TypeOfCover.NOT_DEFINED;

    public Book(final long id)
    {
        super(id);
        this.initializeFields(
                Book.VALUE_OF_NOT_DEFINED_NAME, Book.VALUE_OF_NOT_DEFINED_NAMES_OF_AUTHORS,
                Book.VALUE_OF_NOT_DEFINED_PUBLISHING_HOUSE, Book.VALUE_OF_NOT_DEFINED_YEAR_OF_PUBLISHING,
                Book.VALUE_OF_NOT_DEFINED_AMOUNT_OF_PAGES, Book.VALUE_OF_NOT_DEFINED_PRICE,
                Book.VALUE_OF_NOT_DEFINED_TYPE_OF_COVER);
    }

    public Book(final String name, final String[] namesOfAuthors, final String publishingHouse,
                final int yearOfPublishing, final int amountOfPages, final BigDecimal price,
                final TypeOfCover typeOfCover)
    {
        super();
        this.initializeFields(name, namesOfAuthors, publishingHouse, yearOfPublishing, amountOfPages, price,
                typeOfCover);
    }

    public Book(final long id, final String name, final String[] namesOfAuthors, final String publishingHouse,
                final int yearOfPublishing, final int amountOfPages, final BigDecimal price,
                final TypeOfCover typeOfCover)
    {
        super(id);
        this.initializeFields(name, namesOfAuthors, publishingHouse, yearOfPublishing, amountOfPages, price,
                typeOfCover);
    }

    public final void setName(final String name)
    {
        this.name = name;
    }

    public final String getName()
    {
        return this.name;
    }

    public final void setNamesOfAuthors(final String[] namesOfAuthors)
    {
        this.namesOfAuthors = namesOfAuthors;
    }

    public final String[] getNamesOfAuthors()
    {
        return this.namesOfAuthors;
    }

    public final void setPublishingHouse(final String publishingHouse)
    {
        this.publishingHouse = publishingHouse;
    }

    public final String getPublishingHouse()
    {
        return this.publishingHouse;
    }

    public final void setYearOfPublishing(final int yearOfPublishing)
    {
        this.yearOfPublishing = yearOfPublishing;
    }

    public final int getYearOfPublishing()
    {
        return this.yearOfPublishing;
    }

    public final void setAmountOfPages(final int amountOfPages)
    {
        this.amountOfPages = amountOfPages;
    }

    public final int getAmountOfPages()
    {
        return this.amountOfPages;
    }

    public final void setPrice(final BigDecimal price)
    {
        this.price = price;
    }

    public final BigDecimal getPrice()
    {
        return this.price;
    }

    public final void setTypeOfCover(final TypeOfCover typeOfCover)
    {
        this.typeOfCover = typeOfCover;
    }

    public final TypeOfCover getTypeOfCover()
    {
        return this.typeOfCover;
    }

    @Override
    public final String toString()
    {
        return    super.toString() + "[name = " + this.name + ", namesOfAuthors = "
                + Arrays.toString(this.namesOfAuthors) + ", publishingHouse = " + this.publishingHouse
                + ", yearOfPublishing = " + this.yearOfPublishing + ", amountOfPages " + this.amountOfPages
                + ", price = " + this.price + ", typeOfCover = " + this.typeOfCover + "]";
    }

    @Override
    public final boolean equals(final Object otherObject)
    {
        if(!super.equals(otherObject))
        {
            return false;
        }
        final Book other = (Book)otherObject;
        return     Objects.equals(this.name, other.name) && Arrays.equals(this.namesOfAuthors, other.namesOfAuthors)
                && Objects.equals(this.publishingHouse, other.publishingHouse)
                && this.yearOfPublishing == other.yearOfPublishing && this.amountOfPages == other.amountOfPages
                && Objects.equals(this.price, other.price) && this.typeOfCover == other.typeOfCover;
    }

    @Override
    public final int hashCode()
    {
        return    super.hashCode() + Arrays.hashCode(this.namesOfAuthors)
                + Objects.hash(this.name, this.publishingHouse, this.yearOfPublishing, this.amountOfPages,
                this.price, this.typeOfCover);
    }
}
