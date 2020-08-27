package com.renatojobal.libraryutpl.repository.localdatabase;

/**
 * This class will set constant values for the column names into database
 *
 * I think the Android Jetpack should fix this
 *
 * For avoid db problems, make sure that ANY ONE NAME IS REPEATED
 */
public class DBConstants {

    public static final String DATABASE_NAME = "library_database";


    /** SampleBook model */
    public static final String SAMPLE_BOOK_TABLE = "sample_books";
    public static final String SAMPLE_BOOK_ID = "sample_book_id";
    public static final String SAMPLE_BOOK_BORROWED_EXTERNALLY = "borrowed_externally";
    public static final String SAMPLE_BOOK_BORROWED_INTERNALLY = "borrowed_internally";
    public static final String SAMPLE_BOOK_TAG = "tag";
    public static final String SAMPLE_BOOK_STATE = "sample_book_state";
    public static final String SAMPLE_BOOK_SHELF_OWNER_ID = "shelf_owner_fk";
    public static final String SAMPLE_BOOK_ACTUAL_SHELF_ID = "actual_shelf_fk";
    public static final String SAMPLE_BOOK_BOOK_INFO_ID = "book_info_fk";

    /** BookInfo model */
    public static final String BOOK_INFO_TABLE = "book_infos";
    public static final String BOOK_INFO_ID = "book_info_id";
    public static final String BOOK_INFO_TITLE = "title";
    public static final String BOOK_INFO_BOOK_IMAGE = "book_image";
    public static final String BOOK_INFO_ABSTRACT = "abstract";
    public static final String BOOK_INFO_ACTUAL_STOCK = "actual_stock";
    public static final String BOOK_INFO_TOTAL_STOCK = "total_stock";
    public static final String BOOK_INFO_PUBLICATION_DATE = "publication_date";
    public static final String BOOK_INFO_PAGES = "pages";
    public static final String BOOK_INFO_EDITORIAL = "editorial";
    public static final String BOOK_INFO_AUTHOR_ID = "author_fk";

    /** Author model */
    public static final String AUTHOR_TABLE = "authors";
    public static final String AUTHOR_ID = "author_id";
    public static final String AUTHOR_NAME = "author_name";
    public static final String AUTHOR_PSEUDONYM = "pseudonym";
    public static final String AUTHOR_NATIONALITY = "nationality";
    public static final String AUTHOR_STATE = "author_state";

    /** Shelf model */
    public static final String SHELF_TABLE = "shelfs";
    public static final String SHELF_ID = "shelf_id";
    public static final String SHELF_CODE = "shelf_code";
    public static final String SHELF_LOCATION = "location";
    public static final String SHELF_ACTIVE = "shelf_active";

    /** Author-BookInfo model */
    public static final String MM_AUTHOR_BOOK_INFO_TABLE = "author_book_info";
    public static final String MM_AUTHOR_BOOK_INFO_ID = "author_book_info_id";
    public static final String MM_AUTHOR_BOOK_INFO_AUTHOR_ID = "author_fk";
    public static final String MM_AUTHOR_BOOK_INFO_BOOK_INFO_ID = "book_fk";

    /** Agent model */
    public static final String AGENT_TABLE = "agents";
    public static final String AGENT_ID = "agent_id";


    /** External Loan model */
    // Add if needed


    /** Person Model */
    // Add if needed



}
