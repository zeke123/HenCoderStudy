package com.zhoujian.retrofitdemo.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.gson.Gson;
import com.zhoujian.retrofitdemo.R;
import com.zhoujian.retrofitdemo.bean.Repo;
import com.zhoujian.retrofitdemo.service.GitHubService;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    /**
     * Retrofit:类型安全的http客户端请求库
     * 类型安全:运行时不会报类型错误，编译时期就会检查出来
     * <p>
     * OkHttp与Retrofit
     * <p>
     * Retrofit: 对OkHttp进一步包装，更好用，更方便，但是功能受到限制
     * OkHttp:功能更强，功能更多
     */

    Gson gson = new Gson();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        GitHubService service = retrofit.create(GitHubService.class);
        Call<List<Repo>> repos = service.listRepos("octocat");

        repos.enqueue(new Callback<List<Repo>>() {
            @Override
            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                System.out.println("response="+response.body().get(0).name);
            }

            @Override
            public void onFailure(Call<List<Repo>> call, Throwable t) {

            }
        });
    }
}
