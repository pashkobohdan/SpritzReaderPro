package com.pashkobohdan.spritzreaderpro.application.utils.ui;

import android.content.Context;

import rx.functions.Action0;

public class DialogUtils {
    private DialogUtils() {
        //closed constructor
    }

    public static void showAlert(int titleId, int textId, Context context, Action0 okCallback){
        showAlert(context.getString(titleId), context.getString(titleId), context, okCallback);
    }

    public static void showAlert(String title, String text, Context context, Action0 okCallback){
        //TODO show Dialog
    }
}
