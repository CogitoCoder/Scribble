package com.lmcoding.scribble.data.remote.ws.models

import com.lmcoding.scribble.data.remote.ws.models.BaseModel
import com.lmcoding.scribble.data.remote.ws.models.PlayerData
import com.lmcoding.scribble.util.Constants.TYPE_PLAYERS_LIST

data class PlayersList(
    val players: List<PlayerData>
): BaseModel(TYPE_PLAYERS_LIST)
