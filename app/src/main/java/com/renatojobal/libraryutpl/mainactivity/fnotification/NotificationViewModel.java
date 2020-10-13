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

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import timber.log.Timber;

public class NotificationViewModel  extends ViewModel {

    // To expose all internal loans
    private MutableLiveData<List<DetailedResponse>> notifications = new MutableLiveData<>();

    private MutableLiveData<ArrayList> filteredNotifications = new MutableLiveData<>();

    private ArrayList<DetailedResponse> notificationsNotReturned = new ArrayList<DetailedResponse>();

    private ArrayList<DetailedResponse> notificationsIncorrectPosition = new ArrayList<DetailedResponse>();

    private ArrayList<DetailedResponse> allNotifications = new ArrayList<>();

    public NotificationViewModel() {

        pullNotifications(notifications);
    }

    public LiveData<ArrayList> getFilteredNotifications() {
        return filteredNotifications;
    }

    public void updateFilteredNotifications(Boolean notReturned, Boolean incorrectPosition){

        Timber.d("Not returned: "+notReturned);
        Timber.d("Incorrect position: "+incorrectPosition);

        try {
            filteredNotifications.getValue().clear();
            filteredNotifications.postValue(new ArrayList());
        }catch (NullPointerException npe){

        }


        if (notReturned && incorrectPosition){
            filteredNotifications.postValue(getAllNotifications());
        }
        if(notReturned && !incorrectPosition){
            filteredNotifications.postValue(getNotificationsNotReturned());
        }
        if (incorrectPosition && !notReturned){
            filteredNotifications.postValue(getNotificationsIncorrectPosition());
        }
        if(!notReturned && !incorrectPosition) {
            filteredNotifications.postValue(new ArrayList<DetailedResponse>());
        }



    }


    private ArrayList<DetailedResponse> getNotificationsNotReturned() {

        notificationsNotReturned.clear();

        for (int i = 0; i < notifications.getValue().size(); i++){
            if(notifications.getValue().get(i).getNotification().getNotificationType() == 0){
                notificationsNotReturned.add(notifications.getValue().get(i));
            }
        }

        return notificationsNotReturned;
    }

    private ArrayList<DetailedResponse> getNotificationsIncorrectPosition() {
        notificationsIncorrectPosition.clear();

        for (int i = 0; i < notifications.getValue().size(); i++){
            if(notifications.getValue().get(i).getNotification().getNotificationType() == 2){
                notificationsIncorrectPosition.add(notifications.getValue().get(i));
            }
        }

        return notificationsIncorrectPosition;
    }

    private ArrayList<DetailedResponse> getAllNotifications(){


        return new ArrayList<DetailedResponse>(notifications.getValue());
    }





    private void pullNotifications(MutableLiveData<List<DetailedResponse>> notifications) {

        NotificationInterface notificationInterface = ApiClient.getClient().create(NotificationInterface.class);

        Call<List<DetailedResponse>> callNotifications = notificationInterface.pullNotifications();

        callNotifications.enqueue(new GeneralCallback<List<DetailedResponse>>(callNotifications) {
            @Override
            public void onFinalResponse(Call<List<DetailedResponse>> call, Response<List<DetailedResponse>> response) {
                if(!response.body().isEmpty()){
                    notifications.postValue(response.body());

                    ArrayList<DetailedResponse> filtered = new ArrayList<>(response.body());
                    filteredNotifications.postValue(filtered);
                }
            }
        });

    }




}
