package com.renatojobal.libraryutpl.mainactivity.floan;

import retrofit2.Call;
import retrofit2.Response;
import timber.log.Timber;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.renatojobal.libraryutpl.mainactivity.util.DetailedResponse;
import com.renatojobal.libraryutpl.repository.model.InternalLoan;
import com.renatojobal.libraryutpl.repository.model.SampleBookModel;
import com.renatojobal.libraryutpl.repository.webservice.ApiClient;
import com.renatojobal.libraryutpl.repository.webservice.GeneralCallback;

import java.util.List;

public class LoanViewModel extends ViewModel {

    // To expose all internal loans
    private MutableLiveData<List<DetailedResponse>> internalLoans = new MutableLiveData<>();

    // To expose all singular books statistics
    private MutableLiveData<List<SampleBookModel>> singularBookStatistics = new MutableLiveData<>();


    public LoanViewModel() {

        pullInternalLoans(internalLoans);

        pullSingularBookStatistics(singularBookStatistics);
    }

    private void pullSingularBookStatistics(MutableLiveData<List<SampleBookModel>> singularBookStatistics) {
        LoanInterface loanInterface = ApiClient.getClient().create(LoanInterface.class);

        Call<List<SampleBookModel>> callStatistics = loanInterface.pullSingularBookStatistics();

        callStatistics.enqueue(new GeneralCallback<List<SampleBookModel>>(callStatistics) {
            @Override
            public void onFinalResponse(Call<List<SampleBookModel>> call, Response<List<SampleBookModel>> response) {

                if(!response.body().isEmpty()){
                    Timber.d("Statistics response: %s", response.body());
                    singularBookStatistics.postValue(response.body());
                }

            }
        });

    }


    public LiveData<List<DetailedResponse>> getInternalLoans() {
        return this.internalLoans;
    }

    public LiveData<List<SampleBookModel>> getSingularBookStatistics(){
        return this.singularBookStatistics;
    }


    /**
     * Method for pull the loans from the server
     * @param internalLoans
     */
    private void pullInternalLoans(MutableLiveData<List<DetailedResponse>> internalLoans) {

        LoanInterface loanInterface = ApiClient.getClient().create(LoanInterface.class);

        Call<List<DetailedResponse>> callInternalLoans = loanInterface.pullInternalLoans();

        callInternalLoans.enqueue(new GeneralCallback<List<DetailedResponse>>(callInternalLoans) {
            @Override
            public void onFinalResponse(Call<List<DetailedResponse>> call, Response<List<DetailedResponse>> response) {

                if(!response.body().isEmpty()){
                    Timber.d("Loan response: %s", response.body());
                    internalLoans.postValue(response.body());
                }

            }
        });

    }



}
