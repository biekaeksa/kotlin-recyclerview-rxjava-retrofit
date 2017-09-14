package com.codelabs.firstapp.second


import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import com.codelabs.firstapp.R
import com.codelabs.firstapp.data.MahasiswaModel


import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity(), SecondContract.View, SwipeRefreshLayout.OnRefreshListener {
    lateinit var adapter: SecondAdapter
    lateinit var presenter: SecondPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        presenter = SecondPresenter()

        onAttachView()

        setRecycler()

        presenter.loadFood("makanan")

        setupSwipeRefreshLayout()


    }

    private fun setupSwipeRefreshLayout() {
        second_swiperefresh.setColorSchemeColors(ContextCompat.getColor(this, R.color.colorPrimaryDark))
        second_swiperefresh.setOnRefreshListener(this)
    }


    private fun setRecycler() {
        val layoutManager = LinearLayoutManager(this)
        recycler_view!!.layoutManager = layoutManager
        adapter = SecondAdapter(ArrayList<MahasiswaModel>(), this)
        recycler_view!!.adapter = adapter

    }

    override fun onRefresh() {
        presenter.loadFood("minuman")
    }

    override fun showProgress() {
        second_swiperefresh.post { run { second_swiperefresh.isRefreshing = true } }
    }

    override fun getContext(): Context {
        return this
    }

    override fun hideProgress() {
        second_swiperefresh.post { run { second_swiperefresh.isRefreshing = false } }
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

    override fun onDestroy() {
        onAttachView()
        super.onDestroy()
    }


}
