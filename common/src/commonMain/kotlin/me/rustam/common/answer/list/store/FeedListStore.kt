package me.rustam.common.answer.list.store

import com.arkivanov.mvikotlin.core.store.Store
import me.rustam.common.answer.list.store.FeedListStore.*
import me.rustam.common.model.Feed
import me.rustam.common.model.UserProfile

interface FeedListStore: Store<Intent, State, Label> {

    sealed class Intent {
        data class ViewInquiry(val id: Long) : Intent()
    }

    sealed class Label {
        data class InquirySelected(val id: Long) : Label()
    }

    data class State(
        val userProfile: UserProfile,
        val feeds: List<Feed> = emptyList(),
    )
}