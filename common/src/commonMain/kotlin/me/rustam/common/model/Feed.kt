package me.rustam.common.model

import kotlinx.serialization.Serializable

@Serializable
data class Feed(val id: Long, val title: String, val content: String)