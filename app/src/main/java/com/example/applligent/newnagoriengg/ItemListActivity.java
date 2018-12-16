package com.example.applligent.newnagoriengg;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.example.applligent.newnagoriengg.databinding.ActivityItemListBinding;

import java.util.List;

public class ItemListActivity extends AppCompatActivity {
    ActivityItemListBinding binding;
    ItemDao itemDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_item_list);
        itemDao = MyNagoriApplication.getDatabase().itemDao();
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onResume() {
        super.onResume();
        List<Item> list = itemDao.getAll();
        binding.recyclerView.setAdapter(new ItemAdapter(list));
    }


}

