package com.example.applligent.newnagoriengg;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;
@Dao
public interface ItemDao {
    @Query("select * from Item")
    List<Item> getAll();

    @Query("select max(Id) from Item limit 1 ")
    int getMaxId();

    @Query("select * from Item where Id =:sId ")
    Item get(int sId);

    @Query("Delete from Item where Id= :sid ")
    void deleteMany(int sid);

    @Query("SELECT * from Item where partName like :name limit 1")
    Item findByName(String name);

    @Insert
    void insertAll(List<Item> students);

    @Insert
    void insert(Item product);

    @Update
    void update(Item product);

    @Delete
    void delete(Item product);
}



