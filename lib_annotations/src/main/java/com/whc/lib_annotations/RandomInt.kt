package com.whc.lib_annotations

@Retention(AnnotationRetention.BINARY)
@Target(AnnotationTarget.FIELD)
annotation class RandomInt(val minValue: Int = 0, val maxValue: Int = 65535)
