package me.rustam.common.answer.view

import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.badoo.reaktive.base.Consumer
import me.rustam.common.AppComponentContext
import me.rustam.common.BaseNavComponent
import me.rustam.common.answer.AppBackPressHandler
import me.rustam.common.answer.view.FeedViewComponent.Dependencies
import me.rustam.common.answer.view.FeedViewComponent.Model
import me.rustam.common.answer.view.impl.FeedViewComponentImpl
import me.rustam.common.model.Feed
import me.rustam.common.model.UserProfile

interface FeedViewComponent: BaseNavComponent<Model> {


   data class Model(
      val userProfile: UserProfile,
      val feed: Feed?
   )

   sealed class Output {
      object Done : Output()
   }

   interface Dependencies {
      val storeFactory: StoreFactory
      val answerViewOutput: Consumer<Output>
      val feedId: Long
   }

}

fun InquiryViewComponent(
   componentContext: AppComponentContext,
   dependencies: Dependencies,
   backPressHandler: AppBackPressHandler
): FeedViewComponent = FeedViewComponentImpl(componentContext, dependencies, backPressHandler)