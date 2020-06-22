package com.renatojobal.libraryutpl.repository.webservice;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

/**
 * In this class we call handle all the onFailures calls that use this response
 * Also we can try the call another time or whatever
 *
 * @param <T>
 */
public abstract class GeneralCallback<T> implements Callback<T> {

    private static final int TOTAL_RETRIES = 1;
    private final Call<T> call;
    private int retryCount = 0;


    /**
     * Constructor
     *
     * @param call call to wrap
     */
    public GeneralCallback(Call<T> call) {
        this.call = call;
    }


    /**
     * We manage all the onFailure callBacks here,
     * but you can override this function if you want
     *
     * @param call
     * @param t
     */
    @Override
    public void onFailure(Call<T> call, Throwable t) {


        Timber.e("Call failed");
        Timber.e(t);
        Timber.d(t.getMessage());

        // Retry the call
        if (retryCount++ < TOTAL_RETRIES) {
            Timber.i("Retrying call (" + retryCount + " out of " + TOTAL_RETRIES + ")");
            retryCall();
        } else {
            onFinalFailure(call, t);
        }
    }

    /**
     * Invoked for a received HTTP response.
     * <p>
     * Note: An HTTP response may still indicate an application-level failure such as a 404 or 500.
     * Call {@link Response#isSuccessful()} to determine if the response indicates success.
     *
     * @param call
     * @param response
     */
    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        onFinalResponse(call, response);
    }

    /**
     * Method to be override by the calling class
     * @param call
     * @param response
     */
    public abstract void onFinalResponse(Call<T> call, Response<T> response);

    /**
     * Method to be override by the calling class
     *
     * @param call
     * @param t
     */
    public void onFinalFailure(Call<T> call, Throwable t) {
        Timber.i("On final failure no override");
        Timber.e("Call failed ");
        Timber.e(t);
    }


    private void retryCall() {
        Timber.i("Retrying call");
        call.clone().enqueue(this); // clone the original call and enqueue it for retry
    }
}
