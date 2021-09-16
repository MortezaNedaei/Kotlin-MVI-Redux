package com.mone.kotlin_mvi_redux.ui.main

import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {
    abstract fun render(state: Int)
}