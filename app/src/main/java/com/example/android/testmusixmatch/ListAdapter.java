package com.example.android.testmusixmatch;

import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.testmusixmatch.models.ArtistModel;

import java.util.List;

/**
 * Created by leonidtiskevic on 07.09.17.
 */

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    private List<ArtistModel> mArtistList;

    public ListAdapter(List<ArtistModel> artists){
        this.mArtistList = artists;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_artist,
                parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ArtistModel artist = mArtistList.get(position);
        holder.mName.setText(Html.fromHtml(String.valueOf(artist.getMessage().getBody()
                .getArtistList().get(position))));
    }

    @Override
    public int getItemCount() {
        if (mArtistList.size() == 0) {
            return 0;
        }
        return mArtistList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView mName;

        public ViewHolder(View itemView) {
            super(itemView);
            mName = (TextView) itemView.findViewById(R.id.artist_post);
        }
    }
}
