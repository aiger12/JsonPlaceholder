package kz.tutorial.nedid.presentation.utils

fun interface ClickListener<T : Any> {
    fun onClick(item: T)
}