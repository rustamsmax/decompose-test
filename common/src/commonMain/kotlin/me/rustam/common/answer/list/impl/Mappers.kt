package me.rustam.common.answer.list.impl

import me.rustam.common.answer.list.FeedListComponent.*
import me.rustam.common.answer.list.store.FeedListStore.*

val stateToModel: (State) -> (Model) ={
    Model(
        userProfile = it.userProfile,
        feeds = it.feeds
    )
}

val labelToOutput: (Label) -> (Output) ={
    when(it){
        is Label.InquirySelected -> Output.InquirySelected(it.id)
    }
}
