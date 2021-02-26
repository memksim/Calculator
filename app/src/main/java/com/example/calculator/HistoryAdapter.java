package com.example.calculator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder> {

    private List<HistoryItem> operations;

    public HistoryAdapter(List<HistoryItem> operations){
        this.operations = operations;
    }

    @NonNull
    @Override
    public HistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.history_item, parent, false);
        HistoryViewHolder holder = new HistoryViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryViewHolder holder, int position) {
       HistoryItem item = operations.get(position);
       holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return operations.size();
    }

    public class HistoryViewHolder extends RecyclerView.ViewHolder {
        private TextView mCalcHistoryTextView;
        private TextView mResultTextView;


        public HistoryViewHolder(@NonNull View itemView) {
            super(itemView);
            mCalcHistoryTextView = (TextView)itemView.findViewById(R.id.calc_text_view);
            mResultTextView = (TextView)itemView.findViewById(R.id.result_text_view);
        }

        public void bind(HistoryItem item){
            mCalcHistoryTextView.setText(item.getAction());
            mResultTextView.setText(item.getResult());
        }

    }
}
