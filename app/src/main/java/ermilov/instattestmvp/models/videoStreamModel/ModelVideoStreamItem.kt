package ermilov.instattestmvp.models.videoStreamModel

data class ModelVideoStreamItem(
    val abc: String,
    val abc_type: String,
    val checksum: Long,
    val duration: Int,
    val folder: String,
    val fps: Int,
    val match_id: Int,
    val name: String,
    val period: Int,
    val quality: String,
    val server_id: Int,
    val size: Int,
    val start_ms: Int,
    val url: String,
    val url_root: String,
    val video_type: String
)