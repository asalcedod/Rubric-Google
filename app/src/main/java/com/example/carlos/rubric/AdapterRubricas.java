package com.example.carlos.rubric;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

/**
 * Created by carlos on 16/04/17.
 */

public class AdapterRubricas extends RecyclerView.Adapter<AdapterRubricas.ViewHolder> {
    static Context context;
    private List<Rubric> data;
    //Constructor


    public AdapterRubricas(List<Rubric> data) {
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mTextView.setText(this.data.get(position).getRubric());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mTextView;
        public Button mButton;

        public ViewHolder(View v) {
            super(v);
            mTextView = (TextView) v.findViewById(R.id.row_textview);
            mButton = (Button) v.findViewById(R.id.row_button);
            mButton.setOnClickListener(new View.OnClickListener() {

                @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
                @Override
                public void onClick(View arg0) {
                    context = itemView.getContext();
                    Intent detail = new Intent(context.getApplicationContext(), nrubrica.class);
                    detail.putExtra("rubrica", mTextView.getText().toString());
                    detail.putExtra("nueva","No");
                    context.startActivity(detail);
                    // TODO Auto-generated method stub
                }

            });
        }
    }
}
