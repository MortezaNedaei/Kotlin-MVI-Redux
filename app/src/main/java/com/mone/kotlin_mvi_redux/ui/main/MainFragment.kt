package com.mone.kotlin_mvi_redux.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mone.kotlin_mvi_redux.databinding.MainFragmentBinding
import com.mone.kotlin_mvi_redux.redux.store
import org.reduxkotlin.StoreSubscription

class MainFragment : BaseFragment() {

    private lateinit var viewModel: MainViewModel
    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!
    lateinit var storeSubscription: StoreSubscription


    companion object {
        fun newInstance() = MainFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        storeSubscription = store.subscribe { render(store.state) }
        binding.btnIncrement.setOnClickListener { viewModel.increment() }
        binding.btnDecrement.setOnClickListener { viewModel.decrement() }

    }

    override fun render(state: Int) {
        binding.tvState.text = state.toString()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}