package com.edsonmoreirajr.kotlinquarkusdemo.service

import com.edsonmoreirajr.kotlinquarkusdemo.model.Playlist
import com.edsonmoreirajr.kotlinquarkusdemo.repository.PlaylistRepository
import io.quarkus.panache.common.Sort
import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import jakarta.transaction.Transactional

@ApplicationScoped
class PlaylistService @Inject constructor(private val playlistRepository: PlaylistRepository) {

    fun findAll(): List<Playlist> {
        return playlistRepository.listAll(Sort.by("name"))
    }

    fun findById(id: Int): Playlist? {
        return playlistRepository.findById(id)
    }

    @Transactional
    fun createOrUpdate(playlist: Playlist) {
        return playlistRepository.persist(playlist)
    }

    @Transactional
    fun deleteById(id: Int) {
        playlistRepository.deleteById(id)
    }

    fun searchByName(name: String): List<Playlist> {
        return playlistRepository.list("name", name)
    }
}