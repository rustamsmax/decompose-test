package me.rustam.common.answer.list.impl

import me.rustam.common.answer.list.store.FeedListStoreFactory
import me.rustam.common.answer.sampleData
import me.rustam.common.model.Feed

internal class FeedListRepo(
) : FeedListStoreFactory.Repo {
    override suspend fun loadInquiries(): List<Feed> = sampleData

}