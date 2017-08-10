package com.pashkobohdan.spritzreaderpro.application.mvp.common;

import com.arellomobile.mvp.MvpPresenter;

public class AbstractPresenter<T extends AbstractScreenView> extends MvpPresenter<T> {

    @Override
    public void attachView(T view) {
        super.attachView(view);
        view.onPresenterAttached(this);
    }
}
