package com.edsonmoreirajr.kotlinquarkusdemo.controller

import com.edsonmoreirajr.kotlinquarkusdemo.model.Playlist
import com.edsonmoreirajr.kotlinquarkusdemo.service.PlaylistService
import jakarta.inject.Inject
import jakarta.validation.Valid
import jakarta.ws.rs.Consumes
import jakarta.ws.rs.DELETE
import jakarta.ws.rs.GET
import jakarta.ws.rs.POST
import jakarta.ws.rs.PUT
import jakarta.ws.rs.Path
import jakarta.ws.rs.PathParam
import jakarta.ws.rs.Produces
import jakarta.ws.rs.QueryParam
import jakarta.ws.rs.WebApplicationException
import jakarta.ws.rs.core.MediaType
import jakarta.ws.rs.core.Response

@Path("/playlists")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class PlaylistController @Inject constructor(private val playlistService: PlaylistService) {

    @GET
    fun getAllPlaylists(): List<Playlist> {
        return playlistService.findAll()
    }

    @GET
    @Path("/{id}")
    fun getPlaylistById(@PathParam("id") id: Int): Playlist? {
        return playlistService.findById(id)
    }

    @POST
    fun createPlaylist(@Valid playlist: Playlist): Response {
        val createdPlaylist = playlistService.createOrUpdate(playlist)
        return Response.status(Response.Status.CREATED).entity(createdPlaylist).build()
    }

    @PUT
    @Path("/{id}")
    fun updatePlaylist(@PathParam("id") id: Int, @Valid playlist: Playlist) {
        if (playlistService.findById(id) == null) {
            throw WebApplicationException("Playlist with id $id not found.", Response.Status.NOT_FOUND)
        }
        playlistService.createOrUpdate(playlist)
    }

    @DELETE
    @Path("/{id}")
    fun deletePlaylist(@PathParam("id") id: Int) {
        playlistService.deleteById(id)
    }

    @GET
    @Path("/search")
    fun searchPlaylistsByName(@QueryParam("name") name: String): List<Playlist> {
        return playlistService.searchByName(name)
    }
}