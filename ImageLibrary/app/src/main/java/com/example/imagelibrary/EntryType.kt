package com.example.imagelibrary

enum class EntryType {
    ADD, EDIT, REMOVE;
    companion object {
        fun from(name: String?): EntryType? {
            return EntryType.values().find {
                it.name.uppercase() == name?.uppercase()
            }
        }
    }
}