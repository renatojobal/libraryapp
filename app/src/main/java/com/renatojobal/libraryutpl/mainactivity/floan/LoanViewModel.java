package com.renatojobal.libraryutpl.mainactivity.floan;

import retrofit2.Call;
import retrofit2.Response;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.renatojobal.libraryutpl.repository.model.InternalLoan;
import com.renatojobal.libraryutpl.repository.webservice.ApiClient;
import com.renatojobal.libraryutpl.repository.webservice.GeneralCallback;

import java.util.List;

public class LoanViewModel extends ViewModel {

    // To expose all internal loans
    private MutableLiveData<List<InternalLoan>> internalLoans = new MutableLiveData<>();


    public LoanViewModel() {

        pullInternalLoans(internalLoans);
    }



    public LiveData<List<InternalLoan>> getInternalLoans() {
        return this.internalLoans;
    }

    /**
     * Method for pull the loans from the server
     * @param internalLoans
     */
    private void pullInternalLoans(MutableLiveData<List<InternalLoan>> internalLoans) {

        LoanInterface loanInterface = ApiClient.getClient().create(LoanInterface.class);

        Call<List<InternalLoan>> callInternalLoans = loanInterface.pullInternalLoans();

        callInternalLoans.enqueue(new GeneralCallback<List<InternalLoan>>(callInternalLoans) {
            @Override
            public void onFinalResponse(Call<List<InternalLoan>> call, Response<List<InternalLoan>> response) {

                if(!response.body().isEmpty()){
                    internalLoans.postValue(response.body());
                }

            }
        });

    }



}
