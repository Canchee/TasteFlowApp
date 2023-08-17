package com.iacanched.tasteflow.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.iacanched.tasteflow.domain.model.Ingredient

@Entity(tableName = "recipes_table")
data class RecipeEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "recipeId") var recipeId: Int? = null,
    @ColumnInfo(name = "name") var name: String? = null,
    @ColumnInfo(name = "city") var city: String? = null,
    @ColumnInfo(name = "description") var description: String? = null,
    @ColumnInfo(name = "imageUrl") var imageUrl: String? = null,
    @ColumnInfo(name = "latitude") var latitude: Double? = null,
    @ColumnInfo(name = "longitude") var longitude: Double? = null,
    @ColumnInfo(name = "yield") var yield: String? = null,
    @ColumnInfo(name = "difficulty") var difficulty: Int? = null,
    @ColumnInfo(name = "time") var time: String? = null,
    @ColumnInfo(name = "directions") var directions: String? = null
)