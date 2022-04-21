package com.gaziev.dogsapirxjava2example.presentation.screens.home.about

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.gaziev.dogsapirxjava2example.R

class AboutDialogFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return AlertDialog.Builder(requireContext(), R.style.AlertDialogTheme)
            .setTitle(getString(R.string.about))
            .setMessage(getString(R.string.about_message))
            .setPositiveButton(getString(R.string.ok)) { _, _ -> }
            .create()
    }

}