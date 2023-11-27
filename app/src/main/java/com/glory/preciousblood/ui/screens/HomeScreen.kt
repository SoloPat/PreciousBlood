package com.glory.preciousblood.ui.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.glory.preciousblood.R
import com.glory.preciousblood.ui.theme.PreciousBloodTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(navController: NavHostController) {
    //val navController = rememberNavController()
    PreciousBloodTheme {
        Scaffold(bottomBar = { BottomNavigationBar(navController) }
        ) {
            it.calculateBottomPadding()
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                tonalElevation = 5.dp
            ) {
                EqualSizeVertialGrid()
            }
        }
    }
}

@Composable
fun EqualSizeVertialGrid(){
    LazyVerticalGrid(columns =GridCells.Fixed(2),
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp)){
        items(TILE_ITEMS){ item ->
            HomeTileBox(item)
        }
    }
}

@Composable
fun VerticalScrollingGrid() {
    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        state = rememberLazyListState()
    ) {
        items(TILE_ITEMS.chunked(2)) { rowItems ->
            LazyRow {
                items(rowItems) { item ->
                    HomeTileBox(item)
                }
            }
        }
    }
}
data class NavItem(
    val navRoute: String,
    val selectedIcon: ImageVector,
    val unSelectedIcon: ImageVector,
    val titleId: Int,
    val isSelected: Boolean = false)

object NavRoute {
    const val HOME = "home"
    const val ABOUT_US = "aboutUs"
    const val SETTINGS = "settings"

    //From Tile
    const val INTRODUCTION = "introduction"
    const val BISHOPS_MESSAGE = "bishopsMessage"
    const val OPENING_PRAYER = "openingPrayer"
    const val PROMISES = "promises"
    const val CHAPLET = "chaplet"
    const val LITANY = "litany"
    const val CONSECRATION = "consecration"
    const val THANKSGIVING = "thanksgiving"
}

data class TileItem(
    val navRoute: String,
    val icon: ImageVector,
    val titleId: Int,
)

val TILE_ITEMS = listOf(
    TileItem(NavRoute.INTRODUCTION,Icons.Filled.Home, R.string.label_introduction),
    TileItem(NavRoute.BISHOPS_MESSAGE,Icons.Filled.Person, R.string.label_bishops_message),
    TileItem(NavRoute.OPENING_PRAYER,Icons.Filled.Search, R.string.label_opening_prayer),
    TileItem(NavRoute.PROMISES,Icons.Filled.Settings, R.string.label_promises),
    TileItem(NavRoute.CHAPLET,Icons.Filled.Home, R.string.label_chaplet),
    TileItem(NavRoute.LITANY,Icons.Filled.Person, R.string.label_litany),
    TileItem(NavRoute.CONSECRATION,Icons.Filled.Search, R.string.label_consecration),
    TileItem(NavRoute.THANKSGIVING,Icons.Filled.Settings, R.string.label_thanksgiving)
)
val NAV_ITEMS = listOf(
    NavItem(NavRoute.HOME, Icons.Filled.Home, Icons.Outlined.Home, R.string.label_home),
    NavItem(NavRoute.ABOUT_US, Icons.Filled.Search, Icons.Outlined.Search, R.string.label_about_us),
    NavItem(NavRoute.SETTINGS, Icons.Filled.Settings, Icons.Outlined.Settings, R.string.label_settings),
)

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    Home(rememberNavController())
}