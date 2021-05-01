package ermilov.instattestmvp.services

import ermilov.instattestmvp.models.matchinfomodel.ModelMatchInfo
import ermilov.instattestmvp.models.matchinfomodel.PostApi
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface RetrofitServiceMatchInfo {
    @Headers("Content-Type: application/json")
    @POST("test/data")
    suspend fun getApi(@Body postApi: PostApi): Response<ModelMatchInfo>

    companion object{
        fun create(): RetrofitServiceMatchInfo{
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://api.instat.tv/")
                .build()
            return retrofit.create(RetrofitServiceMatchInfo::class.java)
        }
    }
}