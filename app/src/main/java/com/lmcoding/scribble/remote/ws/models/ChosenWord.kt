package com.lmcoding.scribble.data.remote.ws.models

import com.lmcoding.scribble.data.remote.ws.models.BaseModel
import com.lmcoding.scribble.util.Constants.TYPE_CHOSEN_WORD

data class ChosenWord(
    val chosenWord: String,
    val roomName: String
): BaseModel(TYPE_CHOSEN_WORD)
