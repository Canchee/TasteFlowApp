package com.iacanched.tasteflow.data.model

import com.google.gson.annotations.SerializedName

data class IngredientModel(
    @SerializedName("name") var name: String? = null,
    @SerializedName("amount") var amount: String? = null
)
