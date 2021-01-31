package me.rustam.common.answer.list.store

import com.arkivanov.mvikotlin.core.store.Reducer
import com.arkivanov.mvikotlin.core.store.SimpleBootstrapper
import com.arkivanov.mvikotlin.core.store.Store
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.arkivanov.mvikotlin.extensions.coroutines.SuspendExecutor
import me.rustam.common.BaseStoreFactory
import me.rustam.common.answer.list.store.FeedListStore.*
import me.rustam.common.model.Feed
import me.rustam.common.model.UserProfile

internal class FeedListStoreFactory(
    private val storeFactory: StoreFactory,
    private val currentUser: UserProfile,
    private val repo: Repo,
) : BaseStoreFactory<FeedListStore> {

    override fun create(): FeedListStore =
        object : FeedListStore, Store<Intent, State, Label> by storeFactory.create(
            name = "InquiryListStore",
            initialState = State(currentUser),
            bootstrapper = SimpleBootstrapper(Unit),
            executorFactory = ::ExecutorImpl,
            reducer = ReducerImpl()
        ) {}

    private sealed class Result {
        data class InquiriesUpdated(val feeds: List<Feed>) : Result()
    }

    private inner class ExecutorImpl : SuspendExecutor<Intent, Unit, State, Result, Label>() {

        override suspend fun executeAction(action: Unit, getState: () -> State) {

            doFilter(getState())

        }

        override suspend fun executeIntent(intent: Intent, getState: () -> State) {
            when (intent) {
                is Intent.ViewInquiry -> publish(Label.InquirySelected(intent.id))

            }
        }

        private suspend fun doFilter(state: State) {

            val inquiries = repo.loadInquiries()

            dispatch(Result.InquiriesUpdated(inquiries))
        }
    }

    private inner class ReducerImpl : Reducer<State, Result> {
        override fun State.reduce(result: Result): State {
            return when (result) {
                is Result.InquiriesUpdated -> copy(
                    feeds = result.feeds
                )
            }
        }
    }

    interface Repo {
        suspend fun loadInquiries(): List<Feed>

    }
}