package com.codelabs.firstapp;

/**
 * Created by Biekaeksa on 9/9/2017.
 */

public interface BasePresenter<T extends BaseView> {
    void onAttach(T view);
    void onDetach();
}
