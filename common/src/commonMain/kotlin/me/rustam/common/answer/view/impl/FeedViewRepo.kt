package me.rustam.common.answer.view.impl

import me.rustam.common.answer.sampleData
import me.rustam.common.answer.view.store.FeedViewStoreFactory
import me.rustam.common.model.Feed


class FeedViewRepo(
) : FeedViewStoreFactory.Repo {

    override suspend fun loadFeed(feedID: Long): Feed =
        sampleData.find { it.id == feedID }!!

}
