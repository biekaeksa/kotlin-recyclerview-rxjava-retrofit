package com.codelabs.firstapp.data

/**
 * Created by Biekaeksa on 8/5/2017.
 */
data class MahasiswaModel(val id_food : Int,
                          val nama_food : String,
                          val kategori : String,
                          val foto : String,
                          val harga : Int){
    data class MahasiswaDataModel(val result : List<MahasiswaModel>)
}