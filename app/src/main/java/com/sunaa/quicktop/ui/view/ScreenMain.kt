package com.sunaa.quicktop.ui.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sunaa.quicktop.ui.theme.QuickTopTheme
import kotlinx.coroutines.launch


@Composable
fun ScreenMain(mainViewModel: MainViewModel = viewModel()) {
    val lazyListState = rememberLazyListState()
    val listItemsVariable by mainViewModel.items

    Box(modifier = Modifier.fillMaxSize().padding(WindowInsets.statusBars.asPaddingValues())) {
        ShowNiceListBehavior(lazyListState, listItemsVariable)
        Box(modifier = Modifier.align(Alignment.BottomEnd).padding(bottom = 50.dp)) {
            ScrollToTopButton(lazyListState)
        }

    }
}

@Composable
fun ShowNiceListBehavior(
    state: LazyListState,
    items: List<Int>
) {
    LazyColumn(
        modifier = Modifier
            .padding(start = 10.dp).fillMaxWidth(),
        state = state
    ) {
        item {
            Row { Text(text = "Here is the List") }
        }
        items(items) {
            Column {
                Text(text = it.toString())
            }
        }
    }

}

@Composable
fun ScrollToTopButton(
    state: LazyListState
) {
    val scope = rememberCoroutineScope()
    val showScrollToTopButton by remember {
        derivedStateOf {
            state.firstVisibleItemIndex >= 5
        }
    }
    if (showScrollToTopButton) {
        FloatingActionButton(
            onClick = {
                scope.launch {
                    state.animateScrollToItem(0)
                }
            },
            modifier = Modifier
                .padding(16.dp)
        ) {
            Text("^", fontSize = 25.sp)
        }
    }

}

@Preview(showBackground = true)
@Composable
fun ShowNiceList() {
    QuickTopTheme {
        ScreenMain()
    }
}