package com.codelabs.firstapp

import android.util.Log
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Created by Biekaeksa on 9/9/2017.
 */
class SecondPresenter: SecondContract.Presenter {
   lateinit var foodView : SecondContract.View

    override fun onAttach(view: SecondContract.View) {
        foodView = view
    }

    override fun onDetach() {
        foodView = null!!
    }

    override fun loadFood(category :String) {
        foodView.showProgress()
        val call : Observable<MahasiswaModel.MahasiswaDataModel> = APIService.factor.create().loadFoodCategory(category)
        call.subscribeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {result ->
                            Log.e("Sukses ", "Coy")
                            val list = ArrayList<MahasiswaModel>()

                            foodView.showFoodData(result.result)},
                        { e -> Log.e("Error ", e.message)})
    }


}