package ermilov.instattestmvp.models.matchinfomodel

data class ModelMatchInfo(
        val date: String,
        val stream_status: Int,
        val team1: Team1,
        val team2: Team2,
        val tournament: Tournament
)