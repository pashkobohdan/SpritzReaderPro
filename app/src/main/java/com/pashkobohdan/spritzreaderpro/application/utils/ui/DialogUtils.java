package com.pashkobohdan.spritzreaderpro.application.utils.ui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;

import com.pashkobohdan.spritzreaderpro.R;

import rx.functions.Action0;

public class DialogUtils {
    private DialogUtils() {
        //closed constructor
    }

    public static void showAlert(int titleId, int textId, Context context, @NonNull Action0 okCallback) {
        showAlert(context.getString(titleId), context.getString(textId), context, okCallback);
    }

    public static void showAlert(@Nullable String title, @Nullable String text, @NonNull Context context, @NonNull Action0 okCallback) {
        showAlert(title, text, context.getString(R.string.ok), context.getString(R.string.cancel), context, okCallback, null);
    }

    public static void showAlert(@Nullable String title, @Nullable String text, String okButtonText, String cancelButtonText, @NonNull Context context, @NonNull Action0 okCallback, @Nullable Action0 cancelCallback) {
        new AlertDialog.Builder(context)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle(title)
                .setMessage(text)
                .setPositiveButton(okButtonText, (dialog, which) -> {
                    okCallback.call();
                })
                .setNegativeButton(cancelButtonText, (dialog, which) -> {
                    cancelCallback.call();
                })
                .show();
    }

    public static void showConfirm(int textId, Context context, @NonNull Action0 okCallback) {
        showConfirm(R.string.confirmation, textId,  context, okCallback);
    }

    public static void showConfirm(int titleId, int textId, Context context, @NonNull Action0 okCallback) {
        showConfirm(context.getString(titleId), context.getString(textId), context, okCallback);
    }

    public static void showConfirm(@Nullable String title, @Nullable String text, @NonNull Context context, @NonNull Action0 okCallback) {
        showConfirm(title, text, context.getString(R.string.ok), context.getString(R.string.cancel), context, okCallback, null);
    }

    public static void showConfirm(@Nullable String title, @Nullable String text, String okButtonText, String cancelButtonText, @NonNull Context context, @NonNull Action0 okCallback, @Nullable Action0 cancelCallback) {
        new AlertDialog.Builder(context)
                .setIcon(android.R.drawable.ic_dialog_info)
                .setTitle(title)
                .setMessage(text)
                .setPositiveButton(okButtonText, (dialog, which) -> {
                    okCallback.call();
                })
                .setNegativeButton(cancelButtonText, (dialog, which) -> {
                    if (cancelCallback != null) {
                        cancelCallback.call();
                    }
                })
                .show();
    }
}
