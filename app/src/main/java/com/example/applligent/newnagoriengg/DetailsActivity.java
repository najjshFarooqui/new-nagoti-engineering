package com.example.applligent.newnagoriengg;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.applligent.newnagoriengg.databinding.ActivityDetailsBinding;

public class DetailsActivity extends AppCompatActivity {
    int itemId;
    Item companyItem;
    ItemDao itemDao;
    ActivityDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_details);
        itemId = getIntent().getIntExtra("arg_student_id", -1);
        itemDao=MyNagoriApplication.getDatabase().itemDao();

    }
    @Override
    protected void onResume() {
        super.onResume();
        companyItem = itemDao.get(itemId);
        binding.setItem(companyItem);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.company_names, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.delete) {
            itemDao.delete(companyItem);
            Toast.makeText(this, "delete selected", Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.update) {
            Intent intent = new Intent(getApplicationContext(), UpdateActivity.class);
            //intent.putExtra("arg_item", companyItem);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
