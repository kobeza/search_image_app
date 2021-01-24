package com.kobeza.search.ui

import android.os.Bundle
import android.widget.Toast
import com.kobeza.core.base.BaseActivity
import com.kobeza.search.R
import com.kobeza.search.adapter.SearchAdapter
import com.kobeza.search.databinding.ActivitySearchBinding
import com.kobeza.search.di.SearchModule
import org.kodein.di.generic.instance

class SearchActivity : BaseActivity<ActivitySearchBinding>() {

    override fun diModule() = SearchModule.get(this)

    override fun getLayoutId() = R.layout.activity_search

    override val viewModel: SearchViewModel by instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.viewModel = viewModel

        val adapter = SearchAdapter()

        binding.searchRecycler.adapter = adapter

        viewModel.searchHistory.observe(this, {
            adapter.setData(it)
        })

        viewModel.state.errorMessage.observe(this, {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        })
    }
}