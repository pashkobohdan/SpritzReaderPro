package com.pashkobohdan.spritzreaderpro.application.model.dataExecutors.common;

import com.pashkobohdan.spritzreaderpro.application.model.dto.common.CommonDTO;

import org.reactivestreams.Subscriber;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public abstract class CommonDataExecutor<T extends CommonDTO> {

    public Observable<List<T>> execute(Subscriber<List<T>> subscriber){
        Observable<List<T>> observable = createDefaultObservable(subscriber);
        observable.subscribe(data -> {
            subscriber.onNext(data);
            subscriber.onComplete();
        });
        return observable;
    }

    public abstract List<T> getData();

    private Observable<List<T>> createDefaultObservable(Subscriber<List<T>> subscriber) {
        return Observable
                .fromCallable(this::getData)
                .observeOn(Schedulers.newThread());
    }
}
