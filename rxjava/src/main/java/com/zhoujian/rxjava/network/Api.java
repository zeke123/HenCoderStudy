package com.zhoujian.rxjava.network;

import com.zhoujian.rxjava.model.Repo;
import java.util.List;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Api {

    @GET("users/{username}/repos")
    Single<List<Repo>> getRepos(@Path("username") String username);
}
