package by.bsu.zuevvlad.firstlab.logic.specification.entity.book;

import by.bsu.zuevvlad.firstlab.entity.book.Book;
import by.bsu.zuevvlad.firstlab.logic.specification.entity.EntitySpecification;
import by.bsu.zuevvlad.firstlab.logic.specification.exception.SpecificationCreatingException;
import by.bsu.zuevvlad.firstlab.logic.specification.exception.SpecificationUpdatingException;
import by.bsu.zuevvlad.firstlab.logic.validator.entity.book.ValidatorForPropertiesOfBook;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public final class NamesOfAuthorsOfBookSpecification implements EntitySpecification<Book>
{
    private List<String> requiredNamesOfAuthors;

    public NamesOfAuthorsOfBookSpecification()
    {
        this.requiredNamesOfAuthors
                = Arrays.asList(NamesOfAuthorsOfBookSpecification.VALUE_OF_NOT_DEFINED_REQUIRED_NAMES_OF_AUTHORS);
    }

    private static final String[] VALUE_OF_NOT_DEFINED_REQUIRED_NAMES_OF_AUTHORS
            = Book.VALUE_OF_NOT_DEFINED_NAMES_OF_AUTHORS;

    public NamesOfAuthorsOfBookSpecification(final String[] requiredNamesOfAuthors)
            throws SpecificationCreatingException
    {
        if(!NamesOfAuthorsOfBookSpecification.VALIDATOR_FOR_PROPERTIES_OF_BOOK
                .isValidNamesOfAuthors(requiredNamesOfAuthors))
        {
            throw new SpecificationCreatingException("Impossible to create specification-object of class '"
                    + this.getClass().getName() + "' with not valid given required names of authors. Given required "
                    + "names of authors: " + Arrays.toString(requiredNamesOfAuthors) + ".");
        }
        this.requiredNamesOfAuthors = Arrays.asList(requiredNamesOfAuthors);
    }

    private static final ValidatorForPropertiesOfBook VALIDATOR_FOR_PROPERTIES_OF_BOOK
            = new ValidatorForPropertiesOfBook();

    public final void setRequiredNamesOfAuthors(final String[] requiredNamesOfAuthors)
            throws SpecificationUpdatingException
    {
        if(!NamesOfAuthorsOfBookSpecification.VALIDATOR_FOR_PROPERTIES_OF_BOOK
                .isValidNamesOfAuthors(requiredNamesOfAuthors))
        {
            throw new SpecificationUpdatingException("Impossible to update specification-object of class '"
                    + this.getClass().getName() + "' by not valid given required names of authors. Given required "
                    + "names of authors: " + Arrays.toString(requiredNamesOfAuthors) + ".");
        }
        this.requiredNamesOfAuthors = Arrays.asList(requiredNamesOfAuthors);
    }

    public final String[] getRequiredNamesOfAuthors()
    {
        return (String[])this.requiredNamesOfAuthors.toArray();
    }

    public final void addRequiredNameOfAuthor(final String newRequiredNameOfAuthor)
            throws SpecificationUpdatingException
    {
        if(!NamesOfAuthorsOfBookSpecification.VALIDATOR_FOR_PROPERTIES_OF_BOOK
                .isValidNameOfAuthor(newRequiredNameOfAuthor))
        {
            throw new SpecificationUpdatingException("Impossible to add new required name of author "
                    + "in specification-object '" + this.getClass().getName());
        }
        this.requiredNamesOfAuthors.add(newRequiredNameOfAuthor);
    }

    @Override
    public final boolean isMatch(final Book researchBook)
    {
        final String[] namesOfAuthorsOfResearchBook = researchBook.getNamesOfAuthors();
        return NamesOfAuthorsOfBookSpecification.isContainAll(namesOfAuthorsOfResearchBook,
                this.requiredNamesOfAuthors);
    }

    private static boolean isContainAll(final String[] researchContainer, final List<String> researchContents)
    {
        boolean isCurrentResearchContentContain;
        for(final String researchContent : researchContents)
        {
            isCurrentResearchContentContain = false;
            for(final String elementOfContainer : researchContainer)
            {
                if(Objects.equals(elementOfContainer, researchContent))
                {
                    isCurrentResearchContentContain = true;
                    break;
                }
            }
            if(!isCurrentResearchContentContain)
            {
                return false;
            }
        }
        return true;
    }
}
