package com.renatojobal.libraryutpl.mainactivity.fsearchbook;

public class SearchBookBody {
    /**
     * Body when hit the web service to search a book
     */
    private String title;

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
