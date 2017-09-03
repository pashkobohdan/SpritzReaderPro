package com.pashkobohdan.spritzreaderpro.application.ui.fragments.book.widget;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pashkobohdan.spritzreaderpro.R;
import com.pashkobohdan.spritzreaderpro.application.model.dto.book.BookDTO;
import com.pashkobohdan.spritzreaderpro.application.ui.adapter.AbstractListItemHolder;
import com.pashkobohdan.spritzreaderpro.application.ui.fragments.common.AbstractListItemWidget;
import com.pashkobohdan.spritzreaderpro.databinding.WidgetBookListItemBinding;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.functions.Action1;

public class BookListItemWidget extends AbstractListItemWidget<BookDTO> {

    @BindView(R.id.book_list_item_book_progress)
    TextView progress;

    @Inject
    public BookListItemWidget() {
    }

    @Override
    public AbstractListItemHolder<BookDTO> getHolder(ViewGroup parent, Action1<BookDTO> okClickCallback) {
        WidgetBookListItemBinding binding = WidgetBookListItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        ButterKnife.bind(this, binding.getRoot());
        return new AbstractListItemHolder<>(binding.getRoot(), okClickCallback, bookDTO -> {
            binding.setBook(bookDTO);
            progress.setText(parent.getContext().getString(R.string.book_progress_label, String.valueOf(55)));//TODO replace with calculating percentage
        });
    }
}
