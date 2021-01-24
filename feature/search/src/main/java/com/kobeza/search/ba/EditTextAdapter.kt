package com.kobeza.search.ba

import android.view.inputmethod.EditorInfo
import android.widget.EditText
import androidx.databinding.BindingAdapter
import com.kobeza.search.ui.SearchViewModel

object EditTextAdapter {

    @BindingAdapter("app:editorAction")
    @JvmStatic
    fun loadImage(view: EditText, viewModel: SearchViewModel) {
        view.setOnEditorActionListener { _, actionId, _ ->

            when (actionId) {
                EditorInfo.IME_ACTION_DONE -> viewModel.onDoneButtonClick(view.text.toString().trim())
            }
            true
        }
    }
}