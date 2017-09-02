package com.pashkobohdan.spritzreaderpro.application.ui.fragments.common;

import android.view.ViewGroup;

import com.pashkobohdan.spritzreaderpro.application.model.dto.common.CommonDTO;
import com.pashkobohdan.spritzreaderpro.application.ui.adapter.AbstractListItemHolder;

import rx.functions.Action1;

public abstract class AbstractListItemWidget<T extends CommonDTO> {

    public AbstractListItemWidget(){
        //Must have empty constructor
    }

    public abstract AbstractListItemHolder<T> getHolder(ViewGroup parent, Action1<T> okClickCallback) ;
}
