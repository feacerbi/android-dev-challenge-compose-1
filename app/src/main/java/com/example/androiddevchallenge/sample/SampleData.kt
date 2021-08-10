package com.example.androiddevchallenge.sample

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.MyTheme


fun generateNumbers(max: Int) = (1..max).toList()

@Composable
fun NarrowItem(
    pageNumber: Int
) {
    Text(
        modifier = Modifier
            .background(color = MaterialTheme.colors.background)
            .padding(horizontal = 4.dp, vertical = 4.dp),
        text = "$pageNumber\n\uD83D\uDCD6",
        color = MaterialTheme.colors.primary,
        textAlign = TextAlign.Center,
    )
}

@Composable
fun WideItem(
    pageNumber: Int
) {
    Text(
        modifier = Modifier
            .background(color = MaterialTheme.colors.background)
            .padding(horizontal = 4.dp, vertical = 4.dp),
        text = "This is page number $pageNumber",
        color = MaterialTheme.colors.primary,
        textAlign = TextAlign.Center,
    )
}


@Preview
@Composable
fun SampleDataPreview() {
    MyTheme {
        LazyRow(content = {
            val generatedNumbers = generateNumbers(100)
            items(generatedNumbers) { item ->
//                WideItem(pageNumber = item)
                NarrowItem(pageNumber = item)
            }
        })
    }
}