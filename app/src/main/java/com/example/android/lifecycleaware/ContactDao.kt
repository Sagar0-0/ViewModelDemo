package com.example.android.lifecycleaware

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ContactDao {
    @Insert
    suspend fun insertContact(contact:Contact)
    @Update
    suspend fun updateContact(contact:Contact)
    @Delete
    suspend fun deleteContact(contact:Contact)
    @Query("SELECT * FROM CONTACTS")
    fun getContacts() : LiveData<List<Contact>>
}