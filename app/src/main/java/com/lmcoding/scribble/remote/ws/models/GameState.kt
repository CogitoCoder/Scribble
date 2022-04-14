package com.lmcoding.scribble.data.remote.ws.models

import com.lmcoding.scribble.data.remote.ws.models.BaseModel
import com.lmcoding.scribble.util.Constants.TYPE_GAME_STATE

data class GameState(
    val drawingPlayer: String,
    val word: String
): BaseModel(TYPE_GAME_STATE)
