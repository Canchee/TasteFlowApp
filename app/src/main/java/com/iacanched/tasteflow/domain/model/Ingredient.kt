package com.iacanched.tasteflow.domain.model

import com.google.gson.annotations.SerializedName
import com.iacanched.tasteflow.data.db.entities.IngredientEntity
import com.iacanched.tasteflow.data.model.IngredientModel

data class Ingredient(
    @SerializedName("name") var name: String? = null,
    @SerializedName("amount") var amount: String? = null
)

fun IngredientModel.toDomain() = Ingredient(name = name, amount = amount)
fun IngredientEntity.toDomain() = Ingredient(name=  name, amount = amount)
