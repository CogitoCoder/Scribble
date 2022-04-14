package com.lmcoding.scribble.repository

import com.lmcoding.scribble.data.remote.responses.BasicApiResponse
import com.lmcoding.scribble.data.remote.ws.Room
import com.lmcoding.scribble.util.Resource

interface SetupRepository {

    suspend fun createRoom(room: Room): Resource<Unit>

    suspend fun getRooms(searchQuery: String): Resource<List<Room>>

    suspend fun joinRoom(username: String, roomName: String): Resource<Unit>
}