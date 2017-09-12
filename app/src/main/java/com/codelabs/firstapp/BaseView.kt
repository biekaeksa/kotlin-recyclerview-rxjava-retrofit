package com.codelabs.firstapp

import android.content.Context

/**
 * Created by Biekaeksa on 9/9/2017.
 */
interface BaseView {
    fun getContext() : Context
    fun onAttachView()
    fun onDetachView()
}