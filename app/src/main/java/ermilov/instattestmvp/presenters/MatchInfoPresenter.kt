package ermilov.instattestmvp.presenters

import android.util.Log
import ermilov.instattestmvp.models.matchinfomodel.PostApi
import ermilov.instattestmvp.services.RetrofitServiceMatchInfo
import ermilov.instattestmvp.views.MatchInfoView
import kotlinx.coroutines.launch
import moxy.InjectViewState
import moxy.MvpPresenter
import moxy.presenterScope

@InjectViewState
class MatchInfoPresenter() : MvpPresenter<MatchInfoView>() {

    suspend fun requestApi(postApi: PostApi){
        presenterScope.launch {
            val retrofit = RetrofitServiceMatchInfo.create()
                .getApi(postApi)
            Log.i("tagMatch", retrofit.toString())
            if (retrofit.isSuccessful){
                viewState.onDataCompleteFromApi(retrofit.body()!!)
            } else {
                viewState.onDataErrorFromApi(retrofit.code().toString())
            }
        }
    }
}