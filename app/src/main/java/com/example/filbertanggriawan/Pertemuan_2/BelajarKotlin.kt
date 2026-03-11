package com.example.filbertanggriawan.Pertemuan_2

fun main() {
    println("Hai rekan-rekan...")
    println("Selamat datang di bahasa pemrograman kotlin")

    println("=========")

    var angka = 15
    println("Hasil dari 15 + 10  = ${angka + 10}")

    val nilaiint = 10000
    val nilaidouble = 100.003
    val nilaifloat = 1000.0f

    println("nilai integer = $nilaiint")
    println("nilai double = $nilaidouble")
    println("nilai float = $nilaifloat")

    println("=========== STRING ==========")

    val huruf = 'a'
    println("Ini penggunaan karakter '$huruf'")

    val nilaiString = " Mawar"
    println("Halo $nilaiString \nApa kabar?")

println ("===========Kondisi==============")

val nilai = 10
    if(nilai<0)
        println("bilangan negatif")

    else {
        if(nilai%2 == 0)
            println( "bilangan genap")

        else
            println("bilangan ganjil")
    }

    println("===========PERULANGAN============")

    val kampusKu: Array<String> = arrayOf("Kampus", "Politeknik", "Caltex", "Riau")

    for (kampus: String in kampusKu) {
        println(kampus)

    }
}