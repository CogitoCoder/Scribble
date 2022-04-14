package com.lmcoding.scribble.data.remote.ws.models

import com.lmcoding.scribble.data.remote.ws.models.BaseModel
import com.lmcoding.scribble.util.Constants.TYPE_CUR_ROUND_DRAW_INFO

data class RoundDrawInfo(
    val data: List<String>
): BaseModel(TYPE_CUR_ROUND_DRAW_INFO)
