package me.rustam.common.answer.list.impl

import com.arkivanov.decompose.lifecycle.doOnDestroy
import com.arkivanov.decompose.value.Value
import com.arkivanov.decompose.value.operator.map
import com.arkivanov.mvikotlin.core.binder.BinderLifecycleMode
import com.arkivanov.mvikotlin.extensions.reaktive.bind
import com.arkivanov.mvikotlin.extensions.reaktive.labels
import com.badoo.reaktive.observable.mapNotNull
import me.rustam.common.AppComponentContext
import me.rustam.common.answer.AppBackPressHandler
import me.rustam.common.answer.list.FeedListComponent
import me.rustam.common.answer.list.FeedListComponent.Dependencies
import me.rustam.common.answer.list.FeedListComponent.Model
import me.rustam.common.answer.list.store.FeedListStore.Intent
import me.rustam.common.answer.list.store.FeedListStoreFactory
import me.rustam.common.asMviLifecycle
import me.rustam.common.asValue
import me.rustam.common.getStore

internal class FeedListComponentImpl(
   componentContext: AppComponentContext,
   dependencies: Dependencies,
   backPressHandler: AppBackPressHandler
) : FeedListComponent,
   AppComponentContext by componentContext,
   Dependencies by dependencies,
   AppBackPressHandler by backPressHandler {

   private val store = instanceKeeper.getStore {
      FeedListStoreFactory(
         storeFactory = storeFactory,
         currentUser = currentUser,
         repo = FeedListRepo()
      ).create()
   }

   override val model: Value<Model> = store.asValue().map(stateToModel)

   init {
      bind(lifecycle.asMviLifecycle(), BinderLifecycleMode.CREATE_DESTROY) {
         store.labels.mapNotNull(labelToOutput) bindTo answerListOutput
      }
      lifecycle.doOnDestroy(store::dispose)
   }

   override fun onAppBackPressed() {
      onAppBackPress()
   }

   override fun onInquirySelected(id: Long) {
      store.accept(Intent.ViewInquiry(id))
   }
}