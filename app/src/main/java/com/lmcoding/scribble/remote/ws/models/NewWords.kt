package com.lmcoding.scribble.data.remote.ws.models

import com.lmcoding.scribble.util.Constants.TYPE_NEW_WORDS

data class NewWords(
    val newWords: List<String>
): BaseModel(TYPE_NEW_WORDS)
