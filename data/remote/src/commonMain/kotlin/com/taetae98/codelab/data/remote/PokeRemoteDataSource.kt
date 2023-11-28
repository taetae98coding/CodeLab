package com.taetae98.codelab.data.remote

import com.taetae98.codelab.data.dto.PokeDetailDto
import com.taetae98.codelab.data.dto.PokePageDto

public interface PokeRemoteDataSource {
    public suspend fun page(limit: Int, offset: Int): PokePageDto
    public suspend fun detail(id: Int): PokeDetailDto
}
