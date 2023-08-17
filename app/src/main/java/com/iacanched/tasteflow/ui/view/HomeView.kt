package com.iacanched.tasteflow.ui.view


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.iacanched.tasteflow.domain.model.Recipe
import com.iacanched.tasteflow.ui.components.AppName
import com.iacanched.tasteflow.ui.components.ErrorMessage
import com.iacanched.tasteflow.ui.components.RecipesList
import com.iacanched.tasteflow.ui.components.SearchBar
import com.iacanched.tasteflow.ui.theme.Orange900
import com.iacanched.tasteflow.ui.viewmodel.HomeViewModel
import com.iacanched.tasteflow.ui.viewmodel.State
import kotlinx.coroutines.flow.combine

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(viewModel: HomeViewModel = hiltViewModel(), navController: NavController) {

    val state by viewModel.state.collectAsStateWithLifecycle()
    val filteredList by viewModel.filteredList.collectAsStateWithLifecycle()

    Scaffold {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(10.dp),
        ) {
            Column {
                AppName()
                SearchBar { text ->
                    viewModel.searchAction(text = text)
                }
                Box(modifier = Modifier.fillMaxSize()) {
                    when (state) {
                        is State.Loading -> CircularProgressIndicator(
                            modifier = Modifier.align(
                                Center
                            ), color = Orange900
                        )
                        is State.Success -> RecipesList(
                            recipes = filteredList,
                            onRecipeClick = {
                                navController.navigate("recipe/$it")
                            })
                        is State.Error -> {
                            ErrorMessage(modifier = Modifier.align(Center)){
                                viewModel.loadRecipes()
                            }
                        }
                    }
                }
            }
        }
    }

}


@Composable
@Preview(showBackground = true)
fun HomeViewPreview() {
    //HomeView()
}