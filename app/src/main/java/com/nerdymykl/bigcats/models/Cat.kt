package com.nerdymykl.bigcats.models

// To parse the JSON, install Klaxon and do:
//
//   val cat = Cat.fromJson(jsonString)

import com.beust.klaxon.*

private val klaxon = Klaxon()

data class Cat (
    val id: String,
    val name: String,
    val description: Int,
    val image: Int
) {
    public fun toJson() = klaxon.toJsonString(this)

    companion object {
        public fun fromJson(json: String) = klaxon.parse<Cat>(json)
    }
}