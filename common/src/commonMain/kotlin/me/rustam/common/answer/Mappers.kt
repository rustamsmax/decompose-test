package uz.abroad.common.main.root.answer

import me.rustam.common.answer.list.FeedListComponent
import me.rustam.common.answer.view.FeedViewComponent

val viewOutputToListInput: (FeedViewComponent.Output) -> FeedListComponent.Input = {
    when(it){
        FeedViewComponent.Output.Done -> FeedListComponent.Input.Refresh
    }
}