package com.pashkobohdan.spritzreaderpro.application.ui.common.adapter;

import android.view.ViewGroup;

import com.pashkobohdan.spritzreaderpro.application.model.dto.common.CommonDTO;
import com.pashkobohdan.spritzreaderpro.application.ui.adapter.AbstractListItemHolder;

public abstract class AbstractItemWidget<T extends CommonDTO> {

    public abstract AbstractListItemHolder<T> getHolder(ViewGroup parent);

    public abstract void bindHolder(T t);
}
