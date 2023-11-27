package com.glory.preciousblood.ui.screens

import android.service.quicksettings.Tile
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.glory.preciousblood.R

@Composable
fun BottomNavigationBar(navController: NavHostController) {
//val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    NavigationBar(modifier = Modifier.fillMaxWidth()) {
        NAV_ITEMS.forEach() { navItem ->
            NavigationBarItem(
                icon = {
                    if (navItem.isSelected) {
                        navItem.selectedIcon
                    } else {
                        navItem.unSelectedIcon
                    }
                },
                label = { Text(text = stringResource(id = navItem.titleId)) },
                onClick = {
                    navController.navigate(navItem.navRoute)
                },
                selected = navItem.isSelected
            )
        }
    }
}


@Composable
fun HomeTile(tileItem: TileItem) {
    Column(
        modifier = Modifier
            .padding(5.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedCard(shape = RoundedCornerShape(8.dp), modifier = Modifier.padding(5.dp)) {
            Icon(
                imageVector = tileItem.icon,
                contentDescription = null, // Provide a meaningful content description if needed
                modifier = Modifier
                    .size(24.dp)
                    .align(Alignment.CenterHorizontally) // Adjust the size as needed
            )
            Text(text = stringResource(id = tileItem.titleId), modifier = Modifier.padding(5.dp))
        }
    }
}
@Composable
fun HomeTileBox(tileItem: TileItem) {
    Box( modifier = Modifier.padding(5.dp).align(Alignment.CenterHorizontally)) {
        Column(
            modifier = Modifier
                .padding(5.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                imageVector = tileItem.icon,
                contentDescription = null, // Provide a meaningful content description if needed
                modifier = Modifier
                    .size(24.dp)
                    .align(Alignment.CenterHorizontally) // Adjust the size as needed
            )
            Text(text = stringResource(id = tileItem.titleId),
                modifier = Modifier.padding(5.dp).align(Alignment.CenterHorizontally))
        }
    }
}

@Preview(showBackground = false)
@Composable
fun BottomNavigationBarPreview() {
    BottomNavigationBar(rememberNavController())
}

@Preview(showBackground = true)
@Composable
fun HomeTilePreview() {
    HomeTile(TileItem("home", Icons.Filled.Home, R.string.label_home))
}

@Preview(showBackground = true, name = "Box Home Tile Box")
@Composable
fun HomeTilePreviewBox() {
    HomeTileBox(TileItem("home", Icons.Filled.Home, R.string.label_home))
}