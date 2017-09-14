package com.codelabs.firstapp.second

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.codelabs.firstapp.R
import com.codelabs.firstapp.data.MahasiswaModel

import kotlinx.android.synthetic.main.activity_second_row_item.view.*

/**
 * Created by Biekaeksa on 8/5/2017.
 */

class SecondAdapter(private var list: List<MahasiswaModel>, private val context: Context) : RecyclerView.Adapter<SecondAdapter.SecondViewHelper>() {
    override fun onBindViewHolder(holder: SecondViewHelper?, position: Int) {
        holder!!.bindItems(list[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): SecondViewHelper {
        val view = LayoutInflater.from(context).inflate(R.layout.activity_second_row_item, null)

        return SecondViewHelper(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class SecondViewHelper(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(mahasiswaModel: MahasiswaModel) {
            val textViewNama = itemView.second_textview_nama
            val textViewAlamat = itemView.second_textview_alamat
            textViewNama.text = mahasiswaModel.nama_food
            textViewAlamat.text = mahasiswaModel.kategori
        }
    }

    fun replaceData(mList:List<MahasiswaModel>){
        this.list = mList
        notifyDataSetChanged()
    }


}