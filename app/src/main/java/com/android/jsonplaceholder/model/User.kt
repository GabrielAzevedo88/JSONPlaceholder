package com.android.jsonplaceholder.model

import com.android.jsonplaceholder.model.Address
import com.android.jsonplaceholder.model.Company

data class User(
    val address: Address,
    val company: Company,
    val email: String,
    val id: Int,
    val name: String,
    val phone: String,
    val username: String,
    val website: String
)