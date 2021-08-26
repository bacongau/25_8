package com.example.a25.model

import javax.inject.Inject

data class Post @Inject constructor(
    var userId: String,
    var id: String,
    var title: String,
    var body: String
) {
}