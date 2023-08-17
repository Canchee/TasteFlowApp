package com.iacanched.tasteflow.data.model

import com.google.gson.annotations.SerializedName

data class RecipeModel(
    @SerializedName("id") var id: Int,
    @SerializedName("name") var name: String? = null,
    @SerializedName("city") var city: String? = null,
    @SerializedName("description") var description: String? = null,
    @SerializedName("imageUrl") var imageUrl: String? = null,
    @SerializedName("latitude") var latitude: Double? = null,
    @SerializedName("longitude") var longitude: Double? = null,
    @SerializedName("yield") var yield: String? = null,
    @SerializedName("difficulty") var difficulty: Int? = null,
    @SerializedName("time") var time: String? = null,
    @SerializedName("ingredients") var ingredients: List<IngredientModel> = arrayListOf(),
    @SerializedName("directions") var directions: String? = null
)
