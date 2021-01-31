package me.rustam.common.answer.view.impl

import me.rustam.common.answer.view.store.FeedViewStore.*
import me.rustam.common.answer.view.FeedViewComponent.Model

internal val stateToModel: (State) -> Model = {
   Model(
      userProfile = it.userProfile,
      feed = it.feed,
   )
}