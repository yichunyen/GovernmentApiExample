package yichunyen.governmentapi.example.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;

import yichunyen.governmentapi.example.R;
import yichunyen.governmentapi.example.adapter.ParkItem;
import yichunyen.governmentapi.example.adapter.ParkItemAdapter;

public class MainActivity extends AppCompatActivity implements MainMvpView.View {
    private RecyclerView recyclerView;
    private ParkItemAdapter adapter;
    private MainMvpView.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new MainPresenter(this);
    }

    @Override
    public void updateData(ArrayList<ParkItem> list) {
        adapter.updateData(list);
    }

    @Override
    public void showErrorToast() {
        Toast.makeText(this, "Fetched data failed.", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setPresenter(MainMvpView.Presenter presenter) {
        this.presenter = presenter;
        initView();
        this.presenter.start();
    }

    private void initView() {
        recyclerView = findViewById(R.id.activity_main_rv);
        adapter = new ParkItemAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}
