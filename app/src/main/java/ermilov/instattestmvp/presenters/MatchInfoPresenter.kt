package ermilov.instattestmvp.presenters

import android.content.Context
import ermilov.instattestmvp.model.PostApi
import ermilov.instattestmvp.services.RetrofitService
import ermilov.instattestmvp.views.MatchInfoView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import moxy.InjectViewState
import moxy.MvpPresenter
import moxy.presenterScope
import retrofit2.Retrofit

@InjectViewState
class MatchInfoPresenter() : MvpPresenter<MatchInfoView>() {

    suspend fun requestApi(postApi: PostApi){
        presenterScope.launch {
            val retrofit = RetrofitService.create()
                .getApi(postApi.proc, postApi.params)
            if (retrofit.isSuccessful){
                viewState.onDataCompleteFromApi(retrofit.body()?.team1.toString())
            } else {
                viewState.onDataErrorFromApi(retrofit.code().toString())
            }
        }
    }
}