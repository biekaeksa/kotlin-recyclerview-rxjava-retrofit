package com.codelabs.firstapp.second

import com.codelabs.firstapp.BasePresenter
import com.codelabs.firstapp.BaseView
import com.codelabs.firstapp.data.MahasiswaModel

/**
 * Created by Biekaeksa on 9/9/2017.
 */
class SecondContract {
    interface View : BaseView {
        fun showProgress()
        fun hideProgress()
        fun showFoodData(foodModel: List<MahasiswaModel>)
    }

    interface Presenter : BasePresenter<View> {
        fun loadFood(category : String)
    }
}