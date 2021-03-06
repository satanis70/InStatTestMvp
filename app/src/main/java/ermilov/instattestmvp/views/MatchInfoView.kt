package ermilov.instattestmvp.views

import ermilov.instattestmvp.models.matchinfomodel.ModelMatchInfo
import moxy.MvpView
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(value = OneExecutionStateStrategy::class)
interface MatchInfoView : MvpView {
    fun onDataCompleteFromApi(modelMatchInfo: ModelMatchInfo)
    fun onDataErrorFromApi(message: String)
}