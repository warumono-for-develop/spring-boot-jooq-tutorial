/*
 * This file is generated by jOOQ.
*/
package com.warumono.databases.public_.tables;


import com.warumono.databases.public_.Keys;
import com.warumono.databases.public_.Public;
import com.warumono.databases.public_.tables.records.AuthorBookRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.9.2"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class AuthorBook extends TableImpl<AuthorBookRecord> {

    private static final long serialVersionUID = -136224528;

    /**
     * The reference instance of <code>PUBLIC.AUTHOR_BOOK</code>
     */
    public static final AuthorBook AUTHOR_BOOK = new AuthorBook();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<AuthorBookRecord> getRecordType() {
        return AuthorBookRecord.class;
    }

    /**
     * The column <code>PUBLIC.AUTHOR_BOOK.AUTHOR_ID</code>.
     */
    public final TableField<AuthorBookRecord, Long> AUTHOR_ID = createField("AUTHOR_ID", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>PUBLIC.AUTHOR_BOOK.BOOK_ID</code>.
     */
    public final TableField<AuthorBookRecord, Long> BOOK_ID = createField("BOOK_ID", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * Create a <code>PUBLIC.AUTHOR_BOOK</code> table reference
     */
    public AuthorBook() {
        this("AUTHOR_BOOK", null);
    }

    /**
     * Create an aliased <code>PUBLIC.AUTHOR_BOOK</code> table reference
     */
    public AuthorBook(String alias) {
        this(alias, AUTHOR_BOOK);
    }

    private AuthorBook(String alias, Table<AuthorBookRecord> aliased) {
        this(alias, aliased, null);
    }

    private AuthorBook(String alias, Table<AuthorBookRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<AuthorBookRecord> getPrimaryKey() {
        return Keys.CONSTRAINT_A;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<AuthorBookRecord>> getKeys() {
        return Arrays.<UniqueKey<AuthorBookRecord>>asList(Keys.CONSTRAINT_A);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<AuthorBookRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<AuthorBookRecord, ?>>asList(Keys.FK_AUTHOR_IN_AUTHOR_BOOK, Keys.FK_BOOK_IN_AUTHOR_BOOK);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AuthorBook as(String alias) {
        return new AuthorBook(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public AuthorBook rename(String name) {
        return new AuthorBook(name, null);
    }
}