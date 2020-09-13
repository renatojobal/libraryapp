package com.renatojobal.libraryutpl.mainactivity.fnotification;

import com.renatojobal.libraryutpl.mainactivity.util.DetailedResponse;
import com.renatojobal.libraryutpl.repository.model.InternalLoan;
import com.renatojobal.libraryutpl.repository.model.NotificationModel;
import com.renatojobal.libraryutpl.repository.webservice.ServiceConstants;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NotificationInterface {


    @GET(ServiceConstants.INTERNAL_DETAILED_LOAN_URL)
    Call<List<DetailedResponse>> pullNotifications();

}
