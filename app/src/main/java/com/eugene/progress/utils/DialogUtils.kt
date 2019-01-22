package com.eugene.progress.utils

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import com.eugene.progress.R
import com.google.android.material.snackbar.Snackbar

object DialogUtils {

    fun getOneButtonDialog(
        context: Context,
        dialogTitle: String,
        dialogMessage: String,
        buttonTitle: String,
        buttonOnClickListener: DialogInterface.OnClickListener? = null,
        view: View? = null,
        isCancelable: Boolean = true,
        dialogOnCancelListener: DialogInterface.OnCancelListener? = null
    ): Dialog {

        val alert = setupDialog(context, dialogTitle, dialogMessage, view, isCancelable, dialogOnCancelListener)

        alert.setNeutralButton(buttonTitle, buttonOnClickListener)

        return alert.create()
    }

    fun getTwoButtonsDialog(
        context: Context,
        dialogTitle: String,
        dialogMessage: String,
        positiveButtonTitle: String,
        negativeButtonTitle: String,
        positiveButtonOnClickListener: DialogInterface.OnClickListener? = null,
        negativeButtonOnClickListener: DialogInterface.OnClickListener? = null,
        view: View? = null,
        isCancelable: Boolean = true,
        dialogOnCancelListener: DialogInterface.OnCancelListener? = null
    ): Dialog {

        val alert = setupDialog(context, dialogTitle, dialogMessage, view, isCancelable, dialogOnCancelListener)

        alert.setPositiveButton(positiveButtonTitle, positiveButtonOnClickListener)
        alert.setNegativeButton(negativeButtonTitle, negativeButtonOnClickListener)

        return alert.create()
    }

    fun getThreeButtonsDialog(
        context: Context,
        dialogTitle: String,
        dialogMessage: String,
        positiveButtonTitle: String,
        negativeButtonTitle: String,
        neutralButtonTitle: String,
        positiveButtonOnClickListener: DialogInterface.OnClickListener? = null,
        negativeButtonOnClickListener: DialogInterface.OnClickListener? = null,
        neutralButtonOnClickListener: DialogInterface.OnClickListener? = null,
        view: View? = null,
        isCancelable: Boolean = true,
        dialogOnCancelListener: DialogInterface.OnCancelListener? = null
    ): Dialog {

        val alert = setupDialog(context, dialogTitle, dialogMessage, view, isCancelable, dialogOnCancelListener)

        alert.setPositiveButton(positiveButtonTitle, positiveButtonOnClickListener)
        alert.setNegativeButton(negativeButtonTitle, negativeButtonOnClickListener)
        alert.setNegativeButton(neutralButtonTitle, neutralButtonOnClickListener)

        return alert.create()
    }

    fun getSnackbar(
        context: Context,
        view: View,
        message: String,
        duration: Int = Snackbar.LENGTH_SHORT,
        actionTitle: String = "",
        actionOnClickListener: View.OnClickListener? = null
    ): Snackbar {

        val snb = Snackbar.make(view, message, duration)

        if (actionOnClickListener != null) {
            snb.setAction(actionTitle, actionOnClickListener)
            snb.setActionTextColor(ContextCompat.getColor(context, R.color.white))
        }

        return snb
    }


    private fun setupDialog(
        context: Context,
        dialogTitle: String,
        dialogMessage: String,
        view: View? = null,
        isCancelable: Boolean = true,
        dialogOnCancelListener: DialogInterface.OnCancelListener? = null
    ): AlertDialog.Builder {

        val builder = AlertDialog.Builder(context)
            .setTitle(dialogTitle)
            .setMessage(dialogMessage)

        if (view != null) {

            builder.setView(view)
        }

        builder.setCancelable(isCancelable)
        builder.setOnCancelListener(dialogOnCancelListener)

        return builder
    }
}
