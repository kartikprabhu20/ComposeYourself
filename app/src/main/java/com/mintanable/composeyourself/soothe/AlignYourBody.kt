package com.mintanable.composeyourself.soothe

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mintanable.composeyourself.R
import com.mintanable.composeyourself.ui.theme.ComposeYourselfTheme

val alignList = listOf<AlignYourBodyData>(
    AlignYourBodyData(R.drawable.ab1_inversions,R.string.ab1_inversions),
    AlignYourBodyData(R.drawable.ab2_quick_yoga,R.string.ab2_quick_yoga),
    AlignYourBodyData(R.drawable.ab3_stretching,R.string.ab3_stretching),
    AlignYourBodyData(R.drawable.ab4_tabata,R.string.ab4_tabata),
    AlignYourBodyData(R.drawable.ab5_hiit,R.string.ab5_hiit),
    AlignYourBodyData(R.drawable.ab6_pre_natal_yoga,R.string.ab6_pre_natal_yoga),
    )

@Composable
fun AlignYourBody(
    modifier: Modifier = Modifier,
    alignYourBodyData: List<AlignYourBodyData> = alignList
){
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
        ) {
        items(alignYourBodyData) { item ->
            BodyItem(item.drawable, item.text)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AlignYourBodyPreview() {
    ComposeYourselfTheme {
        AlignYourBody(alignYourBodyData = alignList)
    }
}


@Composable
fun BodyItem(@DrawableRes drawable: Int,
             @StringRes text: Int,
             modifier:Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(4.dp)
    ){
        Image(painter = painterResource(id = drawable),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(88.dp)
                .clip(CircleShape)
        )
        Text(text=stringResource(text),
            textAlign = TextAlign.Center)
    }
}

@Preview(showBackground = true)
@Composable
fun BodyItemPreview() {
    ComposeYourselfTheme {
        BodyItem(
            drawable = R.drawable.ab1_inversions,
            text= R.string.ab1_inversions
        )
    }
}