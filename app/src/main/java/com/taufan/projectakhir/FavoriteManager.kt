package com.taufan.projectakhir

object FavoriteManager {
    private val favoriteList = mutableListOf<Wisata>()

    fun addFavorite(wisata: Wisata) {
        if (!favoriteList.contains(wisata)) favoriteList.add(wisata)
    }

    fun removeFavorite(wisata: Wisata) = favoriteList.remove(wisata)
    fun getFavorites(): List<Wisata> = favoriteList
    fun isFavorite(wisata: Wisata): Boolean = favoriteList.contains(wisata)
}