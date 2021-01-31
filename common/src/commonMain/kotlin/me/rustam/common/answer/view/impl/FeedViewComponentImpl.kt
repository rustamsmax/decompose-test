package me.rustam.common.answer.view.impl

import com.arkivanov.decompose.value.Value
import com.arkivanov.decompose.value.operator.map
import me.rustam.common.AppComponentContext
import me.rustam.common.answer.AppBackPressHandler
import me.rustam.common.answer.view.FeedViewComponent
import me.rustam.common.answer.view.FeedViewComponent.Dependencies
import me.rustam.common.answer.view.FeedViewComponent.Model
import me.rustam.common.answer.view.store.FeedViewStoreFactory
import me.rustam.common.asValue
import me.rustam.common.getStore

internal class FeedViewComponentImpl(
   componentContext: AppComponentContext,
   dependencies: Dependencies,
   backPressHandler: AppBackPressHandler
) : FeedViewComponent,
   AppComponentContext by componentContext,
   Dependencies by dependencies,
   AppBackPressHandler by backPressHandler {

   private val store = instanceKeeper.getStore {
      FeedViewStoreFactory(
         storeFactory = storeFactory,
         userProfile = currentUser,
         repo = FeedViewRepo(),
         feedId = feedId
      ).create()
   }

   override val model: Value<Model> = store.asValue().map(stateToModel)

   override fun onAppBackPressed() {
      onAppBackPress()
   }


}