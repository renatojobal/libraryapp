package com.renatojobal.libraryutpl.mainactivity.fnotification;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.renatojobal.libraryutpl.mainactivity.floan.LoanInterface;
import com.renatojobal.libraryutpl.repository.model.InternalLoan;
import com.renatojobal.libraryutpl.repository.model.NotificationModel;
import com.renatojobal.libraryutpl.repository.webservice.ApiClient;
import com.renatojobal.libraryutpl.repository.webservice.GeneralCallback;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class NotificationViewModel  extends ViewModel {

    // To expose all internal loans
    private MutableLiveData<List<NotificationModel>> notifications = new MutableLiveData<>();


    public NotificationViewModel() {

        pullNotifications(notifications);
    }



    public LiveData<List<NotificationModel>> getNotifications() {
        return this.notifications;
    }


    private void pullNotifications(MutableLiveData<List<NotificationModel>> notifications) {

        NotificationInterface notificationInterface = ApiClient.getClient().create(NotificationInterface.class);

        Call<List<NotificationModel>> callNotifications = notificationInterface.pullNotifications();

        callNotifications.enqueue(new GeneralCallback<List<NotificationModel>>(callNotifications) {
            @Override
            public void onFinalResponse(Call<List<NotificationModel>> call, Response<List<NotificationModel>> response) {
                if(!response.body().isEmpty()){
                    notifications.postValue(response.body());
                }
            }
        });

    }


}
