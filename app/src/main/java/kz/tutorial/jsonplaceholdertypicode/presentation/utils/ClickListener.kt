package kz.tutorial.jsonplaceholdertypicode.presentation.utils

import kz.tutorial.jsonplaceholdertypicode.domain.entity.Post

fun interface ClickListener<T : Any> {
    fun onClick(item: T)
}

fun interface ClickListenerWithThree<T : Any,Z:Any,B:Any> {
    fun onClick(item: T,item2: Z,item3: B)
}