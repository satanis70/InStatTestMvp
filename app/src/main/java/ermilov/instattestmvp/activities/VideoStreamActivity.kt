package ermilov.instattestmvp.activities

import android.net.Uri
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import ermilov.instattestmvp.R
import ermilov.instattestmvp.presenters.VideoStreamPresenter
import ermilov.instattestmvp.views.MatchInfoView
import ermilov.instattestmvp.views.VideoStreamView
import kotlinx.android.synthetic.main.activity_video_stream.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import moxy.MvpAppCompatActivity
import moxy.presenter.InjectPresenter

class VideoStreamActivity : MvpAppCompatActivity(), VideoStreamView {

    @InjectPresenter
    lateinit var videoStreamPresenter: VideoStreamPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_stream)
        CoroutineScope(Dispatchers.IO).launch {
            videoStreamPresenter.requestApiVideoStream()
        }
    }

    override fun onCompleteVideoStream(url: String) {
        video_view.setVideoURI(Uri.parse(url))
        video_view.start()
    }

    override fun onErrorVideoStream(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}