package com.example.applligent.newnagoriengg;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.applligent.newnagoriengg.databinding.ActivityUpdateBinding;

public class UpdateActivity extends AppCompatActivity {

    ActivityUpdateBinding binding;
    ItemDao itemDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_update);
        itemDao = MyNagoriApplication.getDatabase().itemDao();
        Item item =getIntent().getParcelableExtra("arg_item");
        binding.setItem(item);
        binding.updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemDao.update(binding.getItem());

            }
        });


    }
}
