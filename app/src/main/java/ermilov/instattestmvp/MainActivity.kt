package ermilov.instattestmvp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import ermilov.instattestmvp.activities.VideoStreamActivity
import ermilov.instattestmvp.models.matchinfomodel.ModelMatchInfo
import ermilov.instattestmvp.models.matchinfomodel.Params
import ermilov.instattestmvp.models.matchinfomodel.PostApi
import ermilov.instattestmvp.presenters.MatchInfoPresenter
import ermilov.instattestmvp.presenters.VideoStreamPresenter
import ermilov.instattestmvp.views.MatchInfoView
import kotlinx.android.synthetic.main.activity_main.*
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

        button_translation.setOnClickListener {
            val intent = Intent(this, VideoStreamActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onDataCompleteFromApi(modelMatchInfo: ModelMatchInfo) {
        team1.text = modelMatchInfo.team1.name_rus
        team2.text = modelMatchInfo.team2.name_rus
        match_date.text = modelMatchInfo.date
        tournament.text = modelMatchInfo.tournament.name_rus
        score_team1.append(modelMatchInfo.team1.score.toString())
        score_team2.append(modelMatchInfo.team2.score.toString())
    }

    override fun onDataErrorFromApi(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

}