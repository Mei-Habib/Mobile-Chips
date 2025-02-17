package com.example.md_lab4;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ChipGroup chipGroup;
    MobileAdapter adapter;
    List<Mobile> samsung = Arrays.asList(
            new Mobile(R.drawable.samsung, "Affordable device", "Samsung Galaxy Pocket"),
            new Mobile(R.drawable.samsung2, "Affordable device", "Samsung Galaxy Pocket"),
            new Mobile(R.drawable.samsung3, "Affordable device", "Samsung Galaxy Pocket"),
            new Mobile(R.drawable.samsung, "Affordable device", "Samsung Galaxy Pocket"),
            new Mobile(R.drawable.samsung2, "Affordable device", "Samsung Galaxy Pocket"),
            new Mobile(R.drawable.samsung3, "Affordable device", "Samsung Galaxy Pocket")
    );

    List<Mobile> apple = Arrays.asList(
            new Mobile(R.drawable.apple, "Affordable device", "iPhone 7 pro"),
            new Mobile(R.drawable.apple2, "Affordable device", "iPhone 8"),
            new Mobile(R.drawable.apple3, "Affordable device", "iPhone XS"),
            new Mobile(R.drawable.apple, "Affordable device", "iPhone 11 pro"),
            new Mobile(R.drawable.apple2, "Affordable device", "iPhone 12"),
            new Mobile(R.drawable.apple3, "Affordable device", "iPhone 6")
    );

    List<Mobile> oppo = Arrays.asList(
            new Mobile(R.drawable.oppo, "Affordable device 1", "OPPO Reno 1"),
            new Mobile(R.drawable.oppo2, "Affordable device 2", "OPPO Reno 2"),
            new Mobile(R.drawable.oppo3, "Affordable device 3", "OPPO Reno 3"),
            new Mobile(R.drawable.oppo4, "Affordable device 4", "OPPO Reno 4"),
            new Mobile(R.drawable.oppo5, "Affordable device 5", "OPPO Reno 5"),
            new Mobile(R.drawable.oppo6, "Affordable device 6", "OPPO Reno 6")
    );

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        chipGroup = findViewById(R.id.chip_group);
        recyclerView = findViewById(R.id.rv_mobiles);


        for (int i = 0; i < chipGroup.getChildCount(); i++) {
            Chip chip = (Chip) chipGroup.getChildAt(i);
            chip.setOnClickListener(view -> {
                if (chip.getText().toString().equals("Samsung")) {
                    adapter = new MobileAdapter(this, samsung);
                    recyclerView.setAdapter(adapter);
                } else if (chip.getText().toString().equals("Apple")) {
                    adapter = new MobileAdapter(this, apple);
                    recyclerView.setAdapter(adapter);
                } else {
                    adapter = new MobileAdapter(this, oppo);
                    recyclerView.setAdapter(adapter);
                }
            });
        }
    }
}
