package com.cfr4123.cryptoapp.domain.models

import com.cfr4123.cryptoapp.data.remote.dto.TeamMember

data class CoinDetail(
    val id: String,
    val name: String,
    val description: String,
    val symbol: String,
    val rank: Int,
    val isActive: Boolean,
    val tags: List<String>,
    val team: List<TeamMember>
)
