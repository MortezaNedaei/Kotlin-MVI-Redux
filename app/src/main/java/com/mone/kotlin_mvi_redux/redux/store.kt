package com.mone.kotlin_mvi_redux.redux

import com.mone.kotlin_mvi_redux.redux.reducer.globalReducer
import org.reduxkotlin.createThreadSafeStore

val store = createThreadSafeStore(globalReducer, 0)