package com.codelabs.firstapp


import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager


import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() , SecondContract.View {
    override fun showProgress() {

    }

    override fun getContext(): Context {
        return this
    }

    override fun hideProgress() {

    }

    override fun onAttachView() {
        presenter.onAttach(this)
    }

    override fun showFoodData(foodModel: List<MahasiswaModel>) {
        adapter.replaceData(foodModel)
    }

    override fun onDetachView() {
        presenter.onDetach()
    }

    lateinit var adapter : SecondAdapter
    lateinit var presenter : SecondPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        presenter = SecondPresenter()
        onAttachView()

        setRecycler()
        presenter.loadFood("makanan")


    }



    private fun setRecycler() {
        val layoutManager = LinearLayoutManager(this)
        recycler_view.layoutManager = layoutManager
        adapter = SecondAdapter(ArrayList<MahasiswaModel>(), this)
        recycler_view.adapter = adapter

    }


}
