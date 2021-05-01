package ermilov.instattestmvp.presenters
import android.util.Log
import ermilov.instattestmvp.services.RetrofitServiceVideoStream
import ermilov.instattestmvp.views.VideoStreamView
import kotlinx.coroutines.launch
import moxy.InjectViewState
import moxy.MvpPresenter
import moxy.presenterScope
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.google.gson.JsonObject;

@InjectViewState
class VideoStreamPresenter : MvpPresenter<VideoStreamView>() {

    suspend fun requestApiVideoStream(){

        presenterScope.launch {
            //val retrofit = RetrofitServiceVideoStream.create().getApiVideoStream(ParamsMatch(1724836, 1))
            val interceptor = HttpLoggingInterceptor()
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            val client: OkHttpClient = OkHttpClient.Builder().addInterceptor(interceptor).build()
            val retrofit = Retrofit.Builder()
                    .baseUrl("https://api.instat.tv/")
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(RetrofitServiceVideoStream::class.java)

            val jsonVideoParams = JsonObject()
            jsonVideoParams.addProperty("match_id", 1724836)
            jsonVideoParams.addProperty("sport_id", 1)
            val call = retrofit.getApiVideoStream(jsonVideoParams)
            if (call.isSuccessful){
                Log.i("tagvideo", call.body()!![0].url)
                viewState.onCompleteVideoStream(call.body()!![0].url)
            } else {
                viewState.onErrorVideoStream(call.message().toString())
            }
        }
    }
}