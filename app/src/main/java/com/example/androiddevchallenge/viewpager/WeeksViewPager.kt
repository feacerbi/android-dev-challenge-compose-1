package com.example.androiddevchallenge.viewpager

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.activeTabBackgroundColor
import com.example.androiddevchallenge.ui.theme.activeTabTextColor

@Composable
fun WeekViewPager() {
    var index by remember { mutableStateOf(0) }

    ScrollableTabRow(
        selectedTabIndex = index,
        edgePadding = 16.dp,
        backgroundColor = Color.White
    ) {
        for (i in 0..4) {
            Tab(selected = index == i, onClick = {
              index = i
            }) {
                ActiveTab()
            }
        }
    }
}

@Composable
fun ActiveTab() {
        Box(
            modifier = Modifier
                .wrapContentSize()
                .defaultMinSize(16.dp)
                .padding(top = 8.dp, bottom = 8.dp, start = 4.dp, end = 4.dp)
                .background(activeTabBackgroundColor),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier
                    .padding(start = 32.dp, end = 32.dp)
                    .wrapContentHeight()
            ) {
                Text(
                    text = "Mon",
                    color = activeTabTextColor,
                    style = MaterialTheme.typography.body1
                )
                Text(
                    text = "16",
                    color = activeTabTextColor,
                    style = MaterialTheme.typography.h5
                )
                Text(
                    text = "AUG",
                    color = activeTabTextColor,
                    style = MaterialTheme.typography.body1
                )
            }
        }
}

@Composable
fun SampleScreen(pageNumber: Int) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
            text = "Page $pageNumber",
            color = MaterialTheme.colors.primary,
            textAlign = TextAlign.Center
        )
    }
}

@Preview
@Composable
fun Preview() {
    WeekViewPager()
}