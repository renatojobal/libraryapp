package com.renatojobal.libraryutpl.repository.webservice;

/**
 * Constants for the web service
 */
public class ServiceConstants {

    public static final String BASE_URL = "http://15.228.74.142:8000/";
    // public static final String BASE_URL = "http://10.0.2.2:8000"; // For development
    public static final String SEARCH_BOOK_BY_TITLE_URL = "/api/movilapp/search_book_by_title/";
    public static final String PULL_RECOMMENDED_BOOKS = "/api/movilapp/get_recommended_lists/";
    public static final String SHELF_URL = "/api/superadmin/shelfs/";
    public static final String BOOK_URL = "/api/superadmin/book_info/";
    public static final String SAMPLE_BOOK_URL = "/api/superadmin/singular_book/";
    public static final String INTERNAL_LOAN_URL = "/api/superadmin/internal_loan/";
    public static final String NOTIFICATION_URL = "/api/superadmin/notification/";
    public static final String INTERNAL_DETAILED_LOAN_URL = "/api/movilapp/get_all_detailed_internal_loans/";
    public static final String NOTIFICATION_DETAILED_URL = "/api/movilapp/get_all_detailed_notifications/";
    public static final String SINGULAR_BOOK_DETAILED_URL = "/api/movilapp/get_all_detailed_singular_books/";
    public static final String SINGULAR_BOOK_STATISTICS_URL = "/api/movilapp/get_singular_book_statistic/";
}
