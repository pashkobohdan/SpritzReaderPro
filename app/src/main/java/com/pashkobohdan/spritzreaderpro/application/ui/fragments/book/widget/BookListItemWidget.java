package com.pashkobohdan.spritzreaderpro.application.ui.fragments.book.widget;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.pashkobohdan.spritzreaderpro.application.model.dto.book.BookDTO;
import com.pashkobohdan.spritzreaderpro.application.ui.adapter.AbstractListItemHolder;
import com.pashkobohdan.spritzreaderpro.application.ui.fragments.common.AbstractListItemWidget;
import com.pashkobohdan.spritzreaderpro.databinding.WidgetBookListItemBinding;

import javax.inject.Inject;

import rx.functions.Action1;

public class BookListItemWidget extends AbstractListItemWidget<BookDTO> {

    @Inject
    public BookListItemWidget() {
    }

    @Override
    public AbstractListItemHolder<BookDTO> getHolder(ViewGroup parent, Action1<BookDTO> okClickCallback) {
        WidgetBookListItemBinding binding = WidgetBookListItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new AbstractListItemHolder<>(binding.getRoot(), okClickCallback, binding::setBook);
    }
}
