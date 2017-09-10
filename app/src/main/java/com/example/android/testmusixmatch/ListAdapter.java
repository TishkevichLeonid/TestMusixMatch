package com.example.android.testmusixmatch;

import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.testmusixmatch.modelArtist.Artist;
import com.example.android.testmusixmatch.modelTrack.TrackBox;

import java.util.List;

/**
 * Created by leonidtiskevic on 07.09.17.
 */

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    private List<Artist> mArtistList;
    private TrackBox mBox;

    public ListAdapter(List<Artist> artists){
        this.mArtistList = artists;
        mBox = TrackBox.get();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_artist,
                parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Artist artist = mArtistList.get(position);
        mBox.getTrack(artist.getArtistId());
        holder.mName.setText(Html.fromHtml(String.valueOf(artist.getArtistName())));
        holder.mNumber.setText(Integer.toString(position + 1));
        if (mBox.getTrack(artist.getArtistId()) != null) {
            holder.mTestTracksView.setText(mBox.getTrack(artist.getArtistId()).getTrackName());
        } else{
            holder.mTestTracksView.setText(" ");
        }

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
        TextView mNumber;
        TextView mTestTracksView;

        public ViewHolder(View itemView) {
            super(itemView);
            mName = (TextView) itemView.findViewById(R.id.artist_post);
            mNumber = (TextView) itemView.findViewById(R.id.number_of_artist);
            mTestTracksView = (TextView) itemView.findViewById(R.id.test_tracks_view);
        }
    }
}
