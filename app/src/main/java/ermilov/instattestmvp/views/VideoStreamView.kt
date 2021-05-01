package ermilov.instattestmvp.views

import moxy.MvpView
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(value = OneExecutionStateStrategy::class)
interface VideoStreamView : MvpView {
    fun onCompleteVideoStream(url: String)
    fun onErrorVideoStream(message: String)
}