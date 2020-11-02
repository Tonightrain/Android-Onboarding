package entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Person(var name: String, var gender: Int, var age: Int) {

    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}