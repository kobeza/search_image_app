package com.kobeza.core.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.KodeinTrigger
import org.kodein.di.android.closestKodein
import org.kodein.di.android.retainedKodein

abstract class BaseActivity<B : ViewDataBinding>() : AppCompatActivity(), KodeinAware {

    abstract fun diModule(): Kodein.Module

    abstract fun getLayoutId(): Int

    abstract val viewModel: BaseViewModel

    private lateinit var _binding: B
    protected val binding: B
        get() = _binding

    private val _parentKodein by closestKodein()
    override val kodein: Kodein by retainedKodein {
        extend(_parentKodein)
        import(diModule(), allowOverride = true)
    }
    override val kodeinTrigger = KodeinTrigger()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = DataBindingUtil.inflate(LayoutInflater.from(this), getLayoutId(), null, false)
        _binding.lifecycleOwner = this
        setContentView(_binding.root)

        kodeinTrigger.trigger()

        lifecycle.addObserver(viewModel)

    }

    inline fun <reified VM : BaseViewModel> vm(factory: ViewModelProvider.Factory): VM =
        ViewModelProviders.of(this, factory)[VM::class.java]
}