package me.rustam.compose

import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ListItem
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.jetbrains.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.asState
import com.github.aakira.napier.Napier
import me.rustam.common.answer.FeedListRootComponent
import me.rustam.common.answer.FeedListRootComponent.Child
import me.rustam.common.answer.list.FeedListComponent
import me.rustam.common.answer.list.FeedListComponent.Model
import me.rustam.common.answer.view.FeedViewComponent
import me.rustam.compose.common.HorizontalSpacer
import me.rustam.compose.common.LabelText
import me.rustam.compose.common.crossfade

@Composable
fun FeedRootContent(component: FeedListRootComponent) {
    Children(routerState = component.routerState, animation = crossfade()) { child, _ ->
        Napier.d(tag = "Decompose", message = "FeedRootContent: child switch")
        when (child) {
            is Child.InquiryList -> FeedListContent(child.component)
            is Child.InquiryView -> FeedViewContent(child.component)
        }
    }
}

@Composable
fun FeedListContent(component: FeedListComponent) {
    val model by component.model.asState()

    Napier.d(tag = "Decompose", message = "FeedListContent: state $model")

    Scaffold(
        topBar = { TopAppBar(title = { Text(text = "List") }) },
        bodyContent = { FeedList(model, component::onInquirySelected) }
    )
}

@Composable
fun FeedList(model: Model, onItemClick: (Long) -> Unit) {
    LazyColumn {
        items(model.feeds) { item ->
            ListItem(
                overlineText = { Text(text = "Feed id: ${item.id}") },
                text = { Text(text = item.title) },
                secondaryText = { Text(text = item.content) },
                modifier = Modifier.clickable(onClick = { onItemClick(item.id) })
            )
        }
    }
}

@Composable
fun FeedViewContent(component: FeedViewComponent) {

    val model by component.model.asState()

    Napier.d(tag = "Decompose", message = "FeedViewContent: state $model")

    model.feed?.let { feed ->
        Scaffold(
            topBar = { TopAppBar(title = { Text(text = "view") }) },
            bodyContent = {
                LabelText(label = "Id", text = "${feed.id}")
                HorizontalSpacer()
                LabelText(label = "Title", text = feed.title)
                HorizontalSpacer()
                LabelText(label = "Content", text = feed.content)
            }
        )
    }
}
