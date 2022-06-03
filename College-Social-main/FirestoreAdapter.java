package com.app.collegesocial2;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.paging.FirestorePagingAdapter;
import com.firebase.ui.firestore.paging.FirestorePagingOptions;
import com.firebase.ui.firestore.paging.LoadingState;

public class FirestoreAdapter extends FirestorePagingAdapter<PetitionModel, FirestoreAdapter.PetitionViewHolder> {

    private OnListItemClick  onListItemClick;


    public FirestoreAdapter(@NonNull FirestorePagingOptions<PetitionModel> options, OnListItemClick onListItemClick) {
        super(options);
        this.onListItemClick= onListItemClick;
    }

    @Override
    protected void onBindViewHolder(@NonNull PetitionViewHolder holder, int position, @NonNull PetitionModel model) {
        holder.list_title.setText(model.getTitle());
        holder.list_content.setText(model.getContent());

    }

    @NonNull
    @Override
    public PetitionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_single, parent, false);
        return new PetitionViewHolder(view);
    }

    @Override
    protected void onLoadingStateChanged(@NonNull LoadingState state) {
        super.onLoadingStateChanged(state);
        switch (state){
            case LOADING_INITIAL:
                Log.d("PAGING_LOG", "Loading initial data");
                break;
            case LOADING_MORE:
                Log.d("PAGING_LOG", "Loading next page");
                break;
            case FINISHED:
                Log.d("PAGING_LOG", "All data loaded");
                break;


            case ERROR:
                Log.d("PAGING_LOG", "Error loading data");

                break;
            case LOADED:
                Log.d("PAGING_LOG", "Total items loaded" + getItemCount());
                break;
        }
    }

    public class PetitionViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView list_title;
        private TextView list_content;

        public PetitionViewHolder(@NonNull View itemView) {
            super(itemView);

            list_title = itemView.findViewById(R.id.list_title);
            list_content = itemView.findViewById(R.id.list_content);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

           onListItemClick.onItemClick();

        }
    }
    public interface OnListItemClick{
        void onItemClick();
    }

}
