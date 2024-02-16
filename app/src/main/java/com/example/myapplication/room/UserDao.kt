package com.example.myapplication.room
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {
    @Insert
     fun insert(user: User)

    @Query("SELECT * FROM outletData")
     fun getAllUsers(): List<User>

    @Query("DELETE FROM outletData WHERE id = :id")
    fun deleteById(id: Long)

    @Query("DELETE FROM outletData")
    fun deleteAll()

}
