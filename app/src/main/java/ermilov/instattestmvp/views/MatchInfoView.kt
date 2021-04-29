package ermilov.instattestmvp.views

import ermilov.instattestmvp.model.ModelMatchInfo
import moxy.MvpView
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(value = OneExecutionStateStrategy::class)
interface MatchInfoView : MvpView {
    fun onDataCompleteFromApi(string: String)
    fun onDataErrorFromApi(message: String)
}