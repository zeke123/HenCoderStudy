package com.zhoujian.rxjava.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.zhoujian.rxjava.R;
import com.zhoujian.rxjava.model.Repo;
import com.zhoujian.rxjava.network.Api;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Disposable disposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        Api api = retrofit.create(Api.class);

        /*api.getRepos("rengwuxian")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<Repo>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        textView.setText("正在请求");
                    }

                    @Override
                    public void onSuccess(List<Repo> value) {
                        textView.setText(value.get(0).name);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });*/


        Single.just("1").subscribe(new SingleObserver<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onSuccess(String s) {
                textView.setText(s);
            }

            @Override
            public void onError(Throwable e) {

            }
        });


    }
}
