package com.renatojobal.libraryutpl.mainactivity.fnotification;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.renatojobal.libraryutpl.mainactivity.floan.LoanInterface;
import com.renatojobal.libraryutpl.mainactivity.util.DetailedResponse;
import com.renatojobal.libraryutpl.repository.model.InternalLoan;
import com.renatojobal.libraryutpl.repository.model.NotificationModel;
import com.renatojobal.libraryutpl.repository.webservice.ApiClient;
import com.renatojobal.libraryutpl.repository.webservice.GeneralCallback;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class NotificationViewModel  extends ViewModel {

    // To expose all internal loans
    private MutableLiveData<List<DetailedResponse>> notifications = new MutableLiveData<>();


    public NotificationViewModel() {

        pullNotifications(notifications);
    }



    public LiveData<List<DetailedResponse>> getNotifications() {
        return this.notifications;
    }


    private void pullNotifications(MutableLiveData<List<DetailedResponse>> notifications) {

        NotificationInterface notificationInterface = ApiClient.getClient().create(NotificationInterface.class);

        Call<List<DetailedResponse>> callNotifications = notificationInterface.pullNotifications();

        callNotifications.enqueue(new GeneralCallback<List<DetailedResponse>>(callNotifications) {
            @Override
            public void onFinalResponse(Call<List<DetailedResponse>> call, Response<List<DetailedResponse>> response) {
                if(!response.body().isEmpty()){
                    notifications.postValue(response.body());
                }
            }
        });

    }




}
