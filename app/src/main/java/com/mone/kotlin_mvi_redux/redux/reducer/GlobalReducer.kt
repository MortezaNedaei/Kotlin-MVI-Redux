package com.mone.kotlin_mvi_redux.redux.reducer

import org.reduxkotlin.Reducer

class Increment
class Decrement

val globalReducer: Reducer<Int> = { state, action ->
    when (action) {
        is Increment -> state + 1
        is Decrement -> state - 1
        else -> state
    }
}