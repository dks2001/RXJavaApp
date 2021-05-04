package com.dheerendrakumar.rxjavaapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.math.BigDecimal;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Consumer;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.hi)
    TextView hi;
    @BindView(R.id.myRecyclerView)
    RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private RVCustomAdapter rvCustomAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        linearLayoutManager = new LinearLayoutManager(this);
        rvCustomAdapter = new RVCustomAdapter();
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(rvCustomAdapter);


        Entry entry = new Entry("ps4", BigDecimal.valueOf(1500),new Date());
        Entry entry1 = new Entry("ps5", BigDecimal.valueOf(1530),new Date());
        Entry entry2 = new Entry("ps6", BigDecimal.valueOf(1570),new Date());
        Entry entry3 = new Entry("ps7", BigDecimal.valueOf(1230),new Date());
        Entry entry4 = new Entry("ps8", BigDecimal.valueOf(2340),new Date());

        Observable.just(entry,entry1,entry2,entry3,entry4).subscribe(new Consumer<Entry>() {
            @Override
            public void accept(Entry entry) throws Throwable {

                rvCustomAdapter.addToString(entry);
            }
        });
    }
}