package com.mintanable.composeyourself

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mintanable.composeyourself.ui.theme.ComposeYourselfTheme
import kotlinx.coroutines.launch
import coil.compose.rememberImagePainter

class MainActivity3 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContent {
//            ComposeYourselfTheme {
//                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colors.background
//                ) {
//                    LayoutsCodelab()
//                }
//            }
//        }

//        setContent {
//            ComposeYourselfTheme {
//                LayoutsCodelab()
//            }
//        }

//        setContent {
//            ComposeYourselfTheme {
//                ScrollingList()
//            }
//        }

//        setContent {
//            ComposeYourselfTheme {
//                StaggerdGrid()
//            }
//        }
    }
}

@Composable
fun LayoutsCodelab() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "LayoutsCodelab")
                },
                actions = {
                    IconButton(onClick = { /* doSomething() */ }) {
                        Icon(Icons.Filled.Favorite, contentDescription = null)
                    }
                }
            )
        }
    ) { innerPadding ->
        BodyContent(Modifier.padding(innerPadding))
    }
}

@Composable
fun BodyContent(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(text = "Hi there!")
        Text(text = "Thanks for going through the Layouts codelab")
    }
}

@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
fun LayoutsCodelabPreview() {
    ComposeYourselfTheme {
        LayoutsCodelab()
    }
}

@Composable
fun PhotographerCard(modifier: Modifier = Modifier) {
    Row(modifier
        .padding(8.dp)
        .clip(RoundedCornerShape(4.dp))
        .background(MaterialTheme.colors.surface)
        .clickable(onClick = { /* Ignoring onClick */ })
        .padding(16.dp)
    )  {
        Surface(
            modifier = Modifier.size(50.dp),
            shape = CircleShape,
            color = MaterialTheme.colors.onSurface.copy(alpha = 0.2f)
        ) {
            // Image goes here
        }
        Column {
            Text("Alfred Sisley", fontWeight = FontWeight.Bold)
            CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                Text("3 minutes ago", style = MaterialTheme.typography.body2)
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
fun PhotographerCardPreview() {
    ComposeYourselfTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            PhotographerCard()
        }
    }
}


@Composable
fun ImageListItem(index: Int) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = rememberImagePainter(
                data = "https://developer.android.com/images/brand/Android_Robot.png"
            ),
            contentDescription = "Android Logo",
            modifier = Modifier.size(50.dp)
        )
        Spacer(Modifier.width(10.dp))
        Text("Item #$index", style = MaterialTheme.typography.subtitle1)
    }
}

@Composable
fun ScrollingList() {
    val listSize = 100
    // We save the scrolling position with this state
    val scrollState = rememberLazyListState()
    // We save the coroutine scope where our animated scroll will be executed
    val coroutineScope = rememberCoroutineScope()

    Column {
        Row {
            Button(onClick = {
                coroutineScope.launch {
                    // 0 is the first item index
                    scrollState.animateScrollToItem(0)
                }
            }) {
                Text("Scroll to the top")
            }

            Button(onClick = {
                coroutineScope.launch {
                    // listSize - 1 is the last index of the list
                    scrollState.animateScrollToItem(listSize - 1)
                }
            }) {
                Text("Scroll to the end")
            }
        }

        LazyColumn(state = scrollState) {
            items(listSize) {
                ImageListItem(it)
            }
        }
    }
}


@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
fun ScrollListPreview() {
    ComposeYourselfTheme {
        ScrollingList()
    }
}

//
//@Composable
//fun StaggerdGrid(
//    modifier: Modifier = Modifier,
//    rows: Int = 3,
//    content: @Composable () -> Unit
//) {
//    Layout(
//        modifier = modifier,
//        content = content
//    ) { measurables, constraints ->
//        // measure and position children given constraints logic here
//
//        // Keep track of the width of each row
//        val rowWidths = IntArray(rows) { 0 }
//
//        // Keep track of the max height of each row
//        val rowHeights = IntArray(rows) { 0 }
//
//        // Don't constrain child views further, measure them with given constraints
//        // List of measured children
//        val placeables = measurables.mapIndexed { index, measurable ->
//
//            // Measure each child
//            val placeable = measurable.measure(constraints)
//
//            // Track the width and max height of each row
//            val row = index % rows
//            rowWidths[row] += placeable.width
//            rowHeights[row] = Math.max(rowHeights[row], placeable.height)
//        }
//
//        // Grid's width is the widest row
//        val width = rowWidths.maxOrNull()
//            ?.coerceIn(constraints.minWidth.rangeTo(constraints.maxWidth))
//            ?: constraints.minWidth
//
//        // Grid's height is the sum of the tallest element of each row
//        // coerced to the height constraints
//        val height = rowHeights.sumOf { it }
//            .coerceIn(constraints.minHeight.rangeTo(constraints.maxHeight))
//
//        // Y of each row, based on the height accumulation of previous rows
//        val rowY = IntArray(rows) { 0 }
//        for (i in 1 until rows) {
//            rowY[i] = rowY[i - 1] + rowHeights[i - 1]
//        }
//
//        layout(width, height) {
//            // x cord we have placed up to, per row
//            val rowX = IntArray(rows) { 0 }
//
//            placeables.forEachIndexed { index, placeable ->
//                val row = index % rows
//                placeable.placeRelative(
//                    x = rowX[row],
//                    y = rowY[row]
//                )
//                rowX[row] += placeable.width
//            }
//        }
//    }
//}

@Composable
@Preview(showBackground = true)
fun previewCustomLayout() {
    ComposeYourselfTheme {
        MyVerticalBox(
            name = "box1",
            modifier = Modifier.background(Color.Yellow)
        ) {
            Box(modifier = Modifier.size(60.dp).background(Color.Blue))
            Box(modifier = Modifier.size(80.dp, 40.dp).background(Color.Red))
            Box(modifier = Modifier.size(100.dp, 100.dp).background(Color.Cyan))
            Box(modifier = Modifier.size(50.dp).background(Color.Magenta))
            Box(modifier = Modifier.size(70.dp).background(Color.Green))
        }
    }
}

@Composable
inline fun MyVerticalBox(
    name: String,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit = {}
) {
    Layout(
        content = { content() },
        modifier = modifier
    ) { measurables,constraints ->
        // ① Measure children
        val placeables = measurables.mapIndexed { index, measurable ->
            measurable.measure(constraints)
        }

        // ② Decide own size
        val height = maxOf(placeables.sumOf { it.height }, constraints.minHeight)
        val width = maxOf(placeables.maxOfOrNull { it.width } ?: 0, constraints.minWidth)
        var indent = 0
        layout(width, height) {
            // ③ Place children
            var y = 0
            placeables.forEach { placable ->
                placable.placeRelative(x = indent, y = y)
                y += placable.height
                indent +=  placable.width
            }
        }
    }
}