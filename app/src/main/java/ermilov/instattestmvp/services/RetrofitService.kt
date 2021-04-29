package ermilov.instattestmvp.services

import ermilov.instattestmvp.model.ModelMatchInfo
import ermilov.instattestmvp.model.Params
import ermilov.instattestmvp.model.PostApi
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface RetrofitService {
    @Headers("Content-Type: application/json")
    @POST("test/data")
    suspend fun getApi(@Query("proc") proc: String,
                       @Query("params") params: Params) : Response<ModelMatchInfo>
    companion object{
        fun create(): RetrofitService{
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://api.instat.tv/")
                .build()
            return retrofit.create(RetrofitService::class.java)
        }
    }
}