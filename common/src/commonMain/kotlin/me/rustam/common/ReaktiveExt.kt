package me.rustam.common

import com.badoo.reaktive.base.Consumer
import com.badoo.reaktive.completable.CompletableCallbacks
import com.badoo.reaktive.disposable.Disposable
import com.badoo.reaktive.observable.Observable
import com.badoo.reaktive.observable.ObservableObserver
import com.badoo.reaktive.observable.observable

@Suppress("FunctionName") // Factory function
inline fun <T> Consume(crossinline block: (T) -> Unit): Consumer<T> =
   object : Consumer<T> {
      override fun onNext(value: T) {
         block(value)
      }
   }

fun <T> Observable<T?>.filterNotNull(): Observable<T> = observable { emitter ->
   subscribe(
      object : ObservableObserver<T?>, CompletableCallbacks by emitter {
         override fun onSubscribe(disposable: Disposable) {
            emitter.setDisposable(disposable)
         }

         override fun onNext(value: T?) {
            if (value != null) {
               emitter.onNext(value)
            }
         }
      }
   )
}

