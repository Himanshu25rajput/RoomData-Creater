package com.example.roomdemo

import androidx.room.*
import kotlinx.coroutines.flow.Flow


@Dao
interface EmployeeDao {
    @Insert
    suspend fun insert(employeeEntity: EmployeeEntity)

    @Update
    suspend fun  update(employeeEntity: EmployeeEntity)

    @Delete
    suspend fun  delete(employeeEntity: EmployeeEntity)

    @Query("SELECT * FROM'employee-table'")
    fun fetchAllEmployee():Flow<List<EmployeeEntity>>

    @Query("SELECT * FROM'employee-table' where id=:id")
    fun fetchEmployeeByid(id:Int):Flow<EmployeeEntity>
}