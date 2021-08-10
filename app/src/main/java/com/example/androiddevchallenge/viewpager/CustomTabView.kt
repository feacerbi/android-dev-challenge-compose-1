package com.example.androiddevchallenge.viewpager

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.activeTabBackgroundColor
import com.example.androiddevchallenge.ui.theme.activeTabTextColor
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@ExperimentalPagerApi
@Composable
fun CustomTabView(state: PagerState) {

    val scope = rememberCoroutineScope()

    ScrollableTabRow(
        selectedTabIndex = state.currentPage,
        edgePadding = 16.dp,
        backgroundColor = Color.White,
        indicator = { tabPositions ->
            Box(modifier = Modifier
                .tabIndicatorOffset(tabPositions[state.currentPage])
                .fillMaxSize()
                .padding(top = 8.dp, start = 4.dp, end = 4.dp)
                .background(Color.Transparent)
                .border(width = 2.dp, color = activeTabTextColor, shape = RoundedCornerShape(4.dp))
            )
        }
    ) {
        for (i in 0 until state.pageCount) {
            Tab(selected = state.currentPage == i, onClick = {
                scope.launch { state.animateScrollToPage(i) }
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

@ExperimentalPagerApi
@Composable
fun MainScreen(){
    val pagerState = rememberPagerState(
        pageCount = 10,
        initialOffscreenLimit = 2,
    )
    Column(modifier = Modifier.fillMaxSize()) {
        CustomTabView(pagerState)
        CustomViewPager(pagerState = pagerState)
    }
    
}

@ExperimentalPagerApi
@Composable
fun CustomViewPager(pagerState: PagerState){
    HorizontalPager(state = pagerState) {
        SampleScreen(pageNumber = pagerState.currentPage)
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

@ExperimentalPagerApi
@Preview
@Composable
fun Preview() {
    MainScreen()
}