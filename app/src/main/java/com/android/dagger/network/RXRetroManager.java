package com.android.dagger.network;


import android.annotation.SuppressLint;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public abstract class RXRetroManager<T> {

    protected abstract void onSuccess(T Response);

    protected abstract void onFailure(String msg);

    @SuppressWarnings("ResultOfMethodCallIgnored")
    @SuppressLint("CheckResult")
    public void rxSingleCall(Observable<T> observable) {
        Observable.just(
                observable.subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(new DisposableObserver<T>() {
                            @Override
                            public void onNext(T t) {
                                onSuccess(t);
                            }

                            @Override
                            public void onError(Throwable e) {
                                onFailure(e.getMessage());
                            }

                            @Override
                            public void onComplete() {

                            }
                        })
        );
    }


}
