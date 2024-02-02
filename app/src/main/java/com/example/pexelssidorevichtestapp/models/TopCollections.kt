package com.example.pexelssidorevichtestapp.models

data class TopCollections(
    val collections: List<Collection>,
    val next_page: String,
    val page: Int,
    val per_page: Int,
    val prev_page: String,
    val total_results: Int
)