package com.renatojobal.libraryutpl.mainactivity.timber;


import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import timber.log.Timber;

/**
 * Tree settings when the version is a release build
 */
public class DebugTree extends Timber.DebugTree {


    /**
     * Log normally, but create log to Crashlytics if an error happen
     *
     * @param priority
     * @param tag
     * @param message
     * @param t
     */
    @Override
    protected void log(int priority, String tag, @NotNull String message, Throwable t) {
        if (t != null) {
            // FirebaseCrashlytics.getInstance().log(tag + "\n" + message + "\n" + t.getMessage());
        } else {
            // FirebaseCrashlytics.getInstance().log(tag + "\n" + message);
        }
        super.log(priority, tag, message, t);
    }

    /**
     * Custom the message that appears in the console
     */
    @Override
    protected @Nullable String createStackElementTag(@NotNull StackTraceElement element) {
        return super.createStackElementTag(element) + ':' + element.getLineNumber();
    }


}
