package dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import entity.Person

@Dao
interface PersonDao {
    @Insert
    fun createPerson(person:Person):Long

    @Query("select * from Person")
    fun getPersons():List<Person>
}