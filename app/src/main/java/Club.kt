package id.ac.pnm.ti2a.utspm1
data class Club(
    val name: String,
    val premierLeague: Int,
    val faCup: Int,
    val eflCup: Int,
    val ligaChampions: Int,
    val ligaEropa: Int,
    val european: Int,

)
fun Club.recap(): String {
    return "$name berhasil meraih $premierLeague trofi Liga Primer Inggris, " +
            "$faCup trofi FA, $eflCup trofi EFL, $ligaChampions trofi Liga Champions, " +
            "$ligaEropa trofi Liga Eropa UEFA dan $european trofi EURO"
}

fun main() {
    val clubs = mutableListOf<Club>(
        Club("Liverpool", 19, 8, 9, 6, 3, 0),
        Club("Manchester United", 20, 12, 6, 3, 1, 0),
        Club("Chelsea", 6, 6, 5, 2, 2, 0),
        Club("Manchester City", 8, 8, 8, 0, 0, 0),
        Club("Arsenal", 13, 14, 2, 0, 0, 0)
    )

    println("Rekap perolehan trofi klub:")
    for (club in clubs) {
        println(club.recap())
    }
}