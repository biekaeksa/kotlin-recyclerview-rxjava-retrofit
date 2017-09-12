package com.codelabs.firstapp

/**
 * Created by Biekaeksa on 9/9/2017.
 */
class SecondContract {
    interface View : BaseView{
        fun showProgress()
        fun hideProgress()
        fun showFoodData(foodModel: List<MahasiswaModel>)
    }

    interface Presenter : BasePresenter<View>{
        fun loadFood(category : String)
    }
}