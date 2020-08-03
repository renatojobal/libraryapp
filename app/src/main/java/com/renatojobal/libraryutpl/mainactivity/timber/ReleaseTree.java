package com.renatojobal.libraryutpl.mainactivity.timber;

import android.util.Log;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import timber.log.Timber;

/**
 * Tree settings when the version is a release build
 */
public class ReleaseTree extends Timber.Tree {

    public static final int MAX_LOG_LENGTH = 4000;


    /**
     * Return whether a message at {@code priority} or {@code tag} should be logged.
     *
     * @param tag
     * @param priority
     */
    @Override
    protected boolean isLoggable(@Nullable String tag, int priority) {
        return priority != Log.VERBOSE && priority != Log.DEBUG && priority != Log.INFO;

        // Only log warn, error and _what the fucks_
    }

    /**
     * Write a log message to its destination. Called for all level-specific methods by default.
     *
     * @param priority Log level. See {@link Log} for constants.
     * @param tag      Explicit or inferred tag. May be {@code null}.
     * @param message  Formatted log message. May be {@code null}, but then {@code t} will not be.
     * @param t        Accompanying exceptions. May be {@code null}, but then {@code message} will not be.
     */
    @Override
    protected void log(int priority, @Nullable String tag, @NotNull String message, @Nullable Throwable t) {
        if (isLoggable(tag, priority)) {

            // Report caught exception to yout crash library
            if (priority == Log.ERROR && t != null) {
                // FirebaseCrashlytics.getInstance().log(tag + message + t.getMessage());
            }


            // If message is short enough
            if (message.length() < MAX_LOG_LENGTH) {
                if (priority == Log.ASSERT) {
                    Log.wtf(tag, message);
                } else {
                    Log.println(priority, tag, message);
                }
                return;
            }

            // If the message is not short enough we need to split into chunks
            // Split by line, then ensure each line can fit  into Log's  maximum length
            for (int i = 0, length = message.length(); i < length; i++) {
                int newLine = message.indexOf('\n', i);
                newLine = newLine != -1 ? newLine : length;
                do {
                    int end = Math.min(newLine, i + MAX_LOG_LENGTH);
                    String part = message.substring(i, end);
                    if (priority == Log.ASSERT) {
                        Log.wtf(tag, part);
                    } else {
                        Log.println(priority, tag, part);
                    }
                    i = end;
                } while (i < newLine);

            }

        }

    }
}
