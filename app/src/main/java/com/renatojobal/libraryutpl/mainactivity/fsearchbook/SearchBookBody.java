package com.renatojobal.libraryutpl.mainactivity.fsearchbook;


/**
 * Body when hit the web service to search a book
 */
public class SearchBookBody {

    private String title;

    /**
     * Empty constructor
     */
    public SearchBookBody() {
    }

    public SearchBookBody(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
