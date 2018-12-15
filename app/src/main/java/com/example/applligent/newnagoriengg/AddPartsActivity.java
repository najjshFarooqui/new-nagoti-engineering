package com.example.applligent.newnagoriengg;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.applligent.newnagoriengg.databinding.ActivityAddPartsBinding;

public class AddPartsActivity extends AppCompatActivity {
    ActivityAddPartsBinding binding;
    ItemDao itemDao;
    Item item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_parts);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_parts);
        itemDao=MyNagoriApplication.getDatabase().itemDao();
        binding.insertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Item insert = new Item();
           insert.companyName=binding.companyName.getText().toString();
           insert.partName=binding.partName.getText().toString();
           insert.partNumber=binding.partNo.getText().toString();
           insert.priceRate=Float.parseFloat(binding.rate.getText().toString());
            if(binding.rate.getText().toString().isEmpty() && binding.partNo.getText().toString().isEmpty() && binding.companyName.getText().toString().isEmpty() && binding.partName.getText().toString().isEmpty()) {
                binding.textView.setText("please enter all the fields carefully");
            }else{
                itemDao.insert(insert);
                Intent intent = new Intent(getApplicationContext(), ItemList.class);
                startActivity(intent);
            }}

        });



    }
}
