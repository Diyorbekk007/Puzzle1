package com.example.puzzle.storage

import android.content.Context
import android.content.SharedPreferences
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class LocalStorage(context: Context) {

    private val pref = context.getSharedPreferences("local_storage", Context.MODE_PRIVATE)
    val recordOne by StringDelegation(pref, "")
    val recordSecond by StringDelegation(pref, "")
    val recordThree by StringDelegation(pref, "")

}


class StringDelegation(private val pref: SharedPreferences, private val defValue: String) :
    ReadWriteProperty<Any, String> {
    override fun getValue(thisRef: Any, property: KProperty<*>): String =
        pref.getString(property.name, defValue) ?: ""

    override fun setValue(thisRef: Any, property: KProperty<*>, value: String) {
        pref.edit().apply() {
            putString(property.name, value).apply()
        }
    }
}