
package id.ac.pnm.ti2a.utspm1

fun main() {
    // Inisialisasi mutableList dan tambah data List
    val clubs = mutableListOf(
        Club("Liverpool", 19, 8, 9, 6, 3, 0),
        Club("Manchester United", 20, 12, 6, 3, 1, 0),
        Club("Chelsea", 6, 6, 5, 2, 2, 0),
        Club("Manchester City", 8, 8, 8, 0, 0, 0),
        Club("Arsenal", 13, 14, 2, 0, 0, 0)
    )

    // Passing a named function ::sortByNumberTrophyTotal
    val sortedClubs = filterAndSort(clubs, ::sortByNumberTrophyTotal)
    // Hasil sorting total trofi
    println("============================================")
    println("Urutan klub berdasarkan jumlah total trofi: ")
    println("============================================")
    for (club in sortedClubs) {
        println("${club.name} - Total trofi: ${club.totalTrophy}")
    }

    // Passing a named function ::filterByEuropeanTrophy
    val filteredClubs = filterAndSort(clubs, ::filterByEuropeanTrophy)
    // Hasil filtering klub yang belum pernah memenangkan UCL dan UEL
    println("============================================")
    println("Klub yang belum pernah memenangkan UCL dan UEL:")
    println("============================================")
    for (club in filteredClubs) {
        println("${club.name} - Total trofi: ${club.totalTrophy}")
    }

    // Panggil extension function Club recap
    println("============================================")
    println("Rekap perolehan trofi klub:")
    println("============================================")
    for (club in clubs) {
        println(club.recap)
    }
}

// High order function filter and sort
fun filterAndSort(clubs: List<Club>, options: (List<Club>) -> List<Club>): List<Club> {
    return options(clubs)
}

// Fungsi sorting
fun sortByNumberTrophyTotal(clubs: List<Club>): List<Club> {
    val sortedClubs = clubs.sortedByDescending {
        it.totalTrophy
    }
    return sortedClubs
}

// Fungsi filter
fun filterByEuropeanTrophy(clubs: List<Club>): List<Club> {
    val filteredClubs = clubs.filter { club -> !(club.ligaChampions > 0 || club.ligaEropa > 0)
    }
    return filteredClubs
}

// Extension function Club recap
fun Club.totalTrophy(): Int {
    return this.premier + this.fa + this.efl + this.ucl + this.uel
}

    val Club.totalTrophy: Int
    get() = this.totalTrophy()

    val Club.premier: Int
    get() = this.premierLeague

    val Club.fa: Int
    get() = this.faCup

    val Club.efl: Int
    get() = this.eflCup

    val Club.ucl: Int
    get() = this.ligaChampions

    val Club.uel: Int
    get() = this.ligaEropa

    val Club.recap: String
    get() = "${this.name} berhasil meraih ${this.premier} trofi Liga Primer Inggris, " +
            "${this.fa} trofi FA, ${this.efl} trofi EFL, " +
            "${this.ucl} trofi Liga Champions, dan ${this.uel} trofi Liga Eropa UEFA"