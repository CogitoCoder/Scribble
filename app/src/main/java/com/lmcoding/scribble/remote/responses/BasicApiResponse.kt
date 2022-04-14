package com.lmcoding.scribble.data.remote.responses

data class BasicApiResponse(
    val successful: Boolean,
    val message: String? = null
)
