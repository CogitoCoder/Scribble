package com.lmcoding.scribble.data.remote.ws.models

import com.lmcoding.scribble.data.remote.ws.models.BaseModel
import com.lmcoding.scribble.util.Constants.TYPE_DRAW_ACTION

data class DrawAction(
    val action: String
): BaseModel(TYPE_DRAW_ACTION) {

    companion object {
        const val ACTION_UNDO = "ACTION_UNDO"
    }
}
