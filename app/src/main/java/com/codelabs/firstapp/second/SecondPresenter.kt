package com.codelabs.firstapp.second

import android.util.Log
import com.codelabs.firstapp.data.source.remote.APIService
import com.codelabs.firstapp.data.MahasiswaModel
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Created by Biekaeksa on 9/9/2017.
 */
class SecondPresenter : SecondContract.Presenter {
    lateinit var foodView: SecondContract.View

    override fun onAttach(view: SecondContract.View) {
        foodView = view
    }

    override fun onDetach() {
        foodView = null!!
    }

    override fun loadFood(category: String) {
        foodView.showProgress()
        val call: Observable<MahasiswaModel.MahasiswaDataModel> = APIService.factor.create().loadFoodCategory(category)
        call.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { result: MahasiswaModel.MahasiswaDataModel ->
                            foodView.hideProgress()

                            foodView.showFoodData(result.result)
                        },
                        { e: Throwable ->
                            foodView.hideProgress()
                            Log.e("Error ", e.message)
                        })
    }


}