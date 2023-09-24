package com.vansh.hospitalmanagement1.Admin_Panel.Dashboard.Pending_Request;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.vansh.hospitalmanagement1.R;

public class PendingRequestActivity extends AppCompatActivity {

    private RecyclerView recyclerViewPendingRequests;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pending_request);

        recyclerViewPendingRequests= findViewById(R.id.recyclerViewPendingRequests);

    }

}