package me.rustam.common.answer.view.store

import com.arkivanov.mvikotlin.core.store.Store
import me.rustam.common.answer.view.store.FeedViewStore.*
import me.rustam.common.model.Feed
import me.rustam.common.model.UserProfile

interface FeedViewStore: Store<Intent, State, Nothing> {

   sealed class Intent{
   }

   data class State(
      val userProfile: UserProfile,
      val feed: Feed? = null,
   )
}