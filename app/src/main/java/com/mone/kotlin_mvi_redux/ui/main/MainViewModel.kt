package com.mone.kotlin_mvi_redux.ui.main

import android.os.Handler
import androidx.lifecycle.ViewModel
import com.mone.kotlin_mvi_redux.redux.reducer.Decrement
import com.mone.kotlin_mvi_redux.redux.reducer.Increment
import com.mone.kotlin_mvi_redux.redux.store

class MainViewModel : ViewModel() {

    fun increment() {
        store.dispatch(Increment())
    }
    fun decrement() {
        store.dispatch(Decrement())
    }

    fun incrementAsync() {
        Handler().postDelayed(
            {
                store.dispatch(Increment())
            },
            1000
        )
    }
}