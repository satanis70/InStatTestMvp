package ermilov.instattestmvp.services

import com.google.gson.JsonObject
import ermilov.instattestmvp.models.videoStreamModel.ModelVideoStream
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface RetrofitServiceVideoStream {
    @Headers("Content-Type: application/json")
    @POST("test/video-urls")
    suspend fun getApiVideoStream(@Body bode: JsonObject): Response<ModelVideoStream>
}