package com.iacanched.tasteflow.ui.view

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.google.android.gms.maps.model.LatLng
import com.iacanched.tasteflow.domain.model.Recipe
import com.iacanched.tasteflow.ui.components.mapview.MapContent
import com.iacanched.tasteflow.ui.components.mapview.MapTopAppBar
import com.iacanched.tasteflow.ui.viewmodel.MapViewModel
import com.iacanched.tasteflow.ui.viewmodel.State

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MapView(viewModel: MapViewModel = hiltViewModel(), navController: NavController) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            MapTopAppBar{
                navController.popBackStack()
            }
        }
    ) {
        Surface(modifier = Modifier.padding(it)) {
            when (state) {
                is State.Success -> {
                    val recipe = (state as State.Success<Recipe>).data
                    val location = LatLng(recipe.latitude!!, recipe.longitude!!)
                    MapContent(location, recipe)
                }
                else -> {
                    // Handle other states...
                }
            }
        }
    }
}