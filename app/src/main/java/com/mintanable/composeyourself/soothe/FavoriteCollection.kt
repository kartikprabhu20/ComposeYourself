package com.mintanable.composeyourself.soothe

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mintanable.composeyourself.R
import com.mintanable.composeyourself.ui.theme.ComposeYourselfTheme
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items

val favoriteCollectionsData = listOf<FavoriteData>(
    FavoriteData(R.drawable.fc1_short_mantras,R.string.fc1_short_mantras),
    FavoriteData(R.drawable.fc2_nature_meditations,R.string.fc2_nature_meditations),
    FavoriteData(R.drawable.fc3_stress_and_anxiety,R.string.fc3_stress_and_anxiety),
    FavoriteData(R.drawable.fc4_self_massage,R.string.fc4_self_massage),
    FavoriteData(R.drawable.fc5_overwhelmed,R.string.fc5_overwhelmed),
    FavoriteData(R.drawable.fc6_nightly_wind_down,R.string.fc6_nightly_wind_down),
)

@Composable
fun FavoriteCollection(
    modifier: Modifier = Modifier
) {
    LazyHorizontalGrid(
        rows = GridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier.height(120.dp)
    ) {
        items(favoriteCollectionsData) { item ->
            FavoriteItem(item.drawable, item.text)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FavoriteCollectionPreview() {
    ComposeYourselfTheme {
        FavoriteCollection()
    }
}


@Composable
fun FavoriteItem(
    @DrawableRes drawable: Int,
    @StringRes text: Int,
    modifier: Modifier = Modifier
) {
    Surface(
        shape = MaterialTheme.shapes.small,
        modifier = modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.width(192.dp)
        ) {
            Image(
                painter = painterResource(drawable),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(56.dp)
            )
            Text(
                text = stringResource(text),
                style = MaterialTheme.typography.h3,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FavoriteItemPreview() {
    ComposeYourselfTheme {
        FavoriteItem(
            text = R.string.fc2_nature_meditations,
            drawable = R.drawable.fc2_nature_meditations,
            modifier = Modifier.padding(8.dp)
        )
    }
}