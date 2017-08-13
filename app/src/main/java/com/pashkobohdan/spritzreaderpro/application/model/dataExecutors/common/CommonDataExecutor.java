package com.pashkobohdan.spritzreaderpro.application.model.dataExecutors.common;

import com.pashkobohdan.spritzreaderpro.application.model.database.ormlite.common.DatabaseManager;
import com.pashkobohdan.spritzreaderpro.application.model.dto.common.CommonDTO;

import org.reactivestreams.Subscriber;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public abstract class CommonDataExecutor<T extends CommonDTO> {

    @Inject
    protected DatabaseManager databaseManager;

    public Observable<List<T>> execute(Subscriber<List<T>> subscriber) {
        Observable<List<T>> observable = createDefaultObservable();
        observable.subscribe(data -> {
            subscriber.onNext(data);
            subscriber.onComplete();
        }, throwable -> {
            subscriber.onError(throwable);
            subscriber.onComplete();
        });
        return observable;
    }

    public abstract List<T> getData() throws SQLException;

    private Observable<List<T>> createDefaultObservable() {
        return Observable
                .fromCallable(this::getData)
                .observeOn(Schedulers.newThread());
    }
}
