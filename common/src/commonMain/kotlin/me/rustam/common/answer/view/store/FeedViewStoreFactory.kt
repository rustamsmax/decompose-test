package me.rustam.common.answer.view.store

import com.arkivanov.mvikotlin.core.store.Reducer
import com.arkivanov.mvikotlin.core.store.SimpleBootstrapper
import com.arkivanov.mvikotlin.core.store.Store
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.arkivanov.mvikotlin.extensions.coroutines.SuspendExecutor
import me.rustam.common.BaseStoreFactory
import me.rustam.common.answer.view.store.FeedViewStore.*
import me.rustam.common.model.Feed
import me.rustam.common.model.UserProfile

internal class FeedViewStoreFactory(
   private val storeFactory: StoreFactory,
   private val userProfile: UserProfile,
   private val repo: Repo,
   private val feedId: Long
) : BaseStoreFactory<FeedViewStore> {

   override fun create(): FeedViewStore =
      object : FeedViewStore, Store<Intent, State, Nothing> by storeFactory.create(
         name = "FeedViewStore",
         initialState = State(userProfile),
         bootstrapper = SimpleBootstrapper(Unit),
         executorFactory = ::ExecutorImpl,
         reducer = ReducerImpl
      ) {}

   private sealed class Result {
      data class FeedLoaded(
         val feed: Feed,
      ) : Result()

   }

   private inner class ExecutorImpl : SuspendExecutor<Intent, Unit, State, Result, Nothing>() {
      override suspend fun executeAction(action: Unit, getState: () -> State) {
         repo.loadFeed(feedId)?.let { feed ->
            dispatch(Result.FeedLoaded(feed))
         }
      }

      override suspend fun executeIntent(intent: Intent, getState: () -> State) {
         when (intent) {

            else -> {}
         }
      }
   }

   private object ReducerImpl : Reducer<State, Result> {
      override fun State.reduce(result: Result): State =
         when (result) {
            is Result.FeedLoaded -> copy(feed = result.feed)
         }
   }

   interface Repo {

      suspend fun loadFeed(inquiryId: Long): Feed?
   }
}