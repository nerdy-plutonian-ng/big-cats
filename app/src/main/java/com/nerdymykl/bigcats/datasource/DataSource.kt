package com.nerdymykl.bigcats.datasource

import com.nerdymykl.bigcats.R
import com.nerdymykl.bigcats.models.Cat

val cats = listOf(
    Cat("C01","Lion", R.string.lion_desc,R.drawable.lion),
    Cat("C02","Tiger", R.string.tiger_desc,R.drawable.tiger),
    Cat("C03","Jaguar", R.string.jaguar_desc,R.drawable.jaguar),
    Cat("C04","Leopard", R.string.leopard_desc,R.drawable.leopard),
    Cat("C05","Cheetah", R.string.cheetah_desc,R.drawable.cheetah),
)

val favourites = mutableListOf<String>()