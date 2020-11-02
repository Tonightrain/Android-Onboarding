package dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import entity.Person
import kotlinx.coroutines.selects.select

@Dao
interface PersonDao {
    @Insert
    fun createPerson(person:Person):Long

    @Query("select * from Person")
    fun getPersons():List<Person>
}