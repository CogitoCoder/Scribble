package com.lmcoding.scribble.data.remote.ws.models

import com.lmcoding.scribble.data.remote.ws.Room
import com.lmcoding.scribble.data.remote.ws.models.BaseModel
import com.lmcoding.scribble.util.Constants.TYPE_PHASE_CHANGE

data class PhaseChange(
        var phase: Room.Phase?,
        var time: Long,
        val drawingPlayer: String? = null
) : BaseModel(TYPE_PHASE_CHANGE)
