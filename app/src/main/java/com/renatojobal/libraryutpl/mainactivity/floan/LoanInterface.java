package com.renatojobal.libraryutpl.mainactivity.floan;

import com.renatojobal.libraryutpl.mainactivity.fsearchbook.SearchBookBody;
import com.renatojobal.libraryutpl.mainactivity.fsearchbook.response.SearchResponse;
import com.renatojobal.libraryutpl.mainactivity.util.DetailedResponse;
import com.renatojobal.libraryutpl.repository.model.InternalLoan;
import com.renatojobal.libraryutpl.repository.model.SampleBookModel;
import com.renatojobal.libraryutpl.repository.webservice.ServiceConstants;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;

public interface LoanInterface {

    @GET(ServiceConstants.INTERNAL_DETAILED_LOAN_URL)
    Call<List<DetailedResponse>> pullInternalLoans();


    @GET(ServiceConstants.SINGULAR_BOOK_STATISTICS_URL)
    Call<List<SampleBookModel>> pullSingularBookStatistics();

}
