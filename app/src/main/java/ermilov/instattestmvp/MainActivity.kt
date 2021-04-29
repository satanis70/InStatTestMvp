package ermilov.instattestmvp

import android.os.Bundle
import android.widget.Toast
import ermilov.instattestmvp.model.Params
import ermilov.instattestmvp.model.PostApi
import ermilov.instattestmvp.presenters.MatchInfoPresenter
import ermilov.instattestmvp.views.MatchInfoView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import moxy.MvpAppCompatActivity
import moxy.presenter.InjectPresenter

class MainActivity : MvpAppCompatActivity(), MatchInfoView {

    @InjectPresenter
    lateinit var matchInfoPresenter: MatchInfoPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        CoroutineScope(Dispatchers.IO).launch {
            matchInfoPresenter.requestApi(PostApi("get_match_info", Params(1, 1724836)))
        }
    }

    override fun onDataCompleteFromApi(string: String) {
        Toast.makeText(this, string, Toast.LENGTH_LONG).show()
    }

    override fun onDataErrorFromApi(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}