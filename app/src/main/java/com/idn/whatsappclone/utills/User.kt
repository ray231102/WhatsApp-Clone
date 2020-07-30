package com.idn.whatsappclone.utills

data class User(
    val email: String? = "",        // Model merupakan layer yang menunjuk pada objek dan
    val phone: String? = "",        // data yang ada pada aplikasi
    val name: String? = "",         // sehingga User disini akan memiliki data-data disamping
    val imageUrl: String? = "",
    val status: String? = "",
    val statusUrl: String? = "",
    val statusTime: String? = "",
    val password: String? = ""
)