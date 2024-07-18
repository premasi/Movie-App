package com.rakarguntara.movieapp.models

data class MovieData(
    val id: String,
    val title: String,
    val year: String,
    val genre: String,
    val director: String,
    val actor: String,
    val plot: String,
    val images: List<String>,
    val rating: String
)

fun getMovieData(): List<MovieData>{
    return listOf(
        MovieData("1","Gundam Seed", "2001", "Anime, Mecha", "-", "Kira Yamato, Arthun Zala",
            "Nuclear Weapon",
            listOf(
                "https://cdn.wallpapersafari.com/55/99/ovkOKY.jpg",
                "https://th.bing.com/th/id/OIP.od56T6jEvBqNcSEldTeSUQHaJV?w=476&h=600&rs=1&pid=ImgDetMain"
            ),
            "10"
        ), MovieData("1","Gundam Seed Destiny", "2002", "Anime, Mecha", "-", "Kira Yamato, Arthun Zala, Shinn Asuka",
            "Nuclear Weapon",
            listOf(
                "https://th.bing.com/th/id/OIP.EFSDfhtNBF9r2IyY239EnwHaF7?rs=1&pid=ImgDetMain",
                "https://wallpaperset.com/w/full/f/a/4/112559.jpg"
            ),
            "10"
        ), MovieData("1","Gundam Seed Freedom", "2024", "Anime, Mecha", "-", "Kira Yamato, Arthun Zala, Shinn Asuka",
            "Nuclear Weapon Nuclear WeaponNuclear WeaponNuclear WeaponNuclear WeaponNuclear WeaponNuclear WeaponNuclear WeaponNuclear WeaponNuclear Weapon",
            listOf(
                "https://th.bing.com/th/id/OIP.oFH1obIvYmgvK6eK77qxiAHaEK?rs=1&pid=ImgDetMain",
                "https://th.bing.com/th/id/OIP.13Ck58Hfjdi1DxxNhkwjGAHaEK?w=1920&h=1080&rs=1&pid=ImgDetMain"
            ),
            "10"
        ),
    )
}
