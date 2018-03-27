package com.gw.scrollbug;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * The button should scroll to position 750 in the {@link RecyclerView} and does so correctly. The item 750 is on the top of the {@link RecyclerView} fully visible.
 * But if you scroll the {@link RecyclerView}. You can see that it keeps scrolling because it has some velocity and only slows down slowly.
 * If you press the button while the {@link RecyclerView} is still scrolling. The {@link LinearLayoutManager} jumps to 750 but because of that velocity the {@link RecyclerView} keeps scrolling.
 * Most times the item 750 won't even be visible at the time the {@link RecyclerView} has stopped.
 */
public class MainActivity extends AppCompatActivity {

    private LinearLayoutManager m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView foo = findViewById(R.id.foo);
        m = new LinearLayoutManager(this);
        foo.setLayoutManager(m);
        foo.setAdapter(new ExampleAdapter());
    }

    public void scroll(View v) {
        m.scrollToPositionWithOffset(750, 0);
    }

    public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ViewHolder> {

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new ViewHolder(getLayoutInflater().inflate(R.layout.item, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            holder.bar.setText(String.valueOf(position));
        }

        @Override
        public int getItemCount() {
            return 1500;
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            public TextView bar;

            public ViewHolder(View itemView) {
                super(itemView);
                bar = (TextView)itemView.findViewById(R.id.bar);

            }
        }
    }
}
