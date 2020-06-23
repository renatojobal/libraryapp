package com.renatojobal.libraryutpl.mainactivity;

/**
 * Is a listerner of a event
 * @param <T> Generic class
 */
public interface EventListener <T> {
    void onEvent(T t);
}