package com.renatojobal.libraryutpl.mainactivity.floan;

import com.renatojobal.libraryutpl.mainactivity.fsearchbook.SearchBookBody;
import com.renatojobal.libraryutpl.mainactivity.fsearchbook.response.SearchResponse;
import com.renatojobal.libraryutpl.repository.model.InternalLoan;
import com.renatojobal.libraryutpl.repository.webservice.ServiceConstants;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;

public interface LoanInterface {

    @GET(ServiceConstants.INTERNAL_LOAN_URL)
    Call<List<InternalLoan>> pullInternalLoans();

}
