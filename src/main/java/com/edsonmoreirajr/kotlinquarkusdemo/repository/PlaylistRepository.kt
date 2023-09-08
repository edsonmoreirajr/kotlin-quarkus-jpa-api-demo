package com.edsonmoreirajr.kotlinquarkusdemo.repository

import com.edsonmoreirajr.kotlinquarkusdemo.model.Playlist
import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepositoryBase
import jakarta.enterprise.context.ApplicationScoped

@ApplicationScoped
class PlaylistRepository : PanacheRepositoryBase<Playlist, Int>
