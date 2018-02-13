package com.example.perside.login.vod.VodFrenchMovies_tabFragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.perside.login.R;
import com.example.perside.login.api.Api;
import com.example.perside.login.api.RequestHandler;
import com.example.perside.login.livechannel_tabsfragment.AllChannelFragment;
import com.example.perside.login.model.Videos;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static android.view.View.GONE;

/**
 * Created by perside on 1/25/18.
 */

public class ScienceFictionFragment extends Fragment {
    private static final int CODE_GET_REQUEST = 1024;
    private static final int CODE_POST_REQUEST = 1025;

    ProgressBar progressBar;
    GridView gridView;

    List<Videos> VideoList;

    //TODO study the MyHero app main activity well and implement the database call here :)

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sciencfiction_view, container, false);

        progressBar = (ProgressBar) view.findViewById(R.id.progressBar);
        gridView = (GridView) view.findViewById(R.id.listViewVideos);

        VideoList = new ArrayList<>();

        readVideos();
        return view;
    }
    private void readVideos() {
        ScienceFictionFragment.PerformNetworkRequest request = new ScienceFictionFragment.PerformNetworkRequest(Api.URL_READ_CHANNELS, null, CODE_GET_REQUEST);
        request.execute();
    }

    private void refreshVideoList(JSONArray videos) throws JSONException {
        VideoList.clear();

        for (int i = 0; i < videos.length(); i++) {
            JSONObject obj = videos.getJSONObject(i);

            VideoList.add(new Videos(
                    obj.getInt("channelId"),
                    obj.getString("channelName"),
                    obj.getString("icon")
            ));
        }
        ScienceFictionFragment.VideoAdapter adapter = new ScienceFictionFragment.VideoAdapter(VideoList);
        gridView.setAdapter(adapter);
    }
    private class PerformNetworkRequest extends AsyncTask<Void, Void, String> {
        String url;
        HashMap<String, String> params;
        int requestCode;

        PerformNetworkRequest(String url, HashMap<String, String> params, int requestCode) {
            this.url = url;
            this.params = params;
            this.requestCode = requestCode;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            progressBar.setVisibility(GONE);
            try {
                JSONObject object = new JSONObject(s);
                if (!object.getBoolean("error")) {
                    Toast.makeText(getActivity(), object.getString("message"), Toast.LENGTH_SHORT).show();
                    refreshVideoList(object.getJSONArray("video"));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        @Override
        protected String doInBackground(Void... voids) {
            RequestHandler requestHandler = new RequestHandler();

            if (requestCode == CODE_POST_REQUEST)
                return requestHandler.sendPostRequest(url, params);


            if (requestCode == CODE_GET_REQUEST)
                return requestHandler.sendGetRequest(url);

            return null;
        }
    }

    class VideoAdapter extends ArrayAdapter<Videos> {
        List<Videos> videosList;
        String imageURL;

        public VideoAdapter(List<Videos> videosList) {
            super(getActivity(), R.layout.layout_video_list, videosList);
            this.videosList = videosList;
        }

        public void setImageUrl(String imageURL, ImageView imageView) {
            this.imageURL = imageURL;
            Glide.with(getContext())
                    .load(imageURL)
                    .override(150, 150)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(imageView);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = getActivity().getLayoutInflater();
            View listViewItem = inflater.inflate(R.layout.layout_video_list, null, true);

            ImageView imageView = (ImageView)listViewItem.findViewById(R.id.imageview_cover_art);

            TextView textViewName = (TextView) listViewItem.findViewById(R.id.textVideoName);

            final Videos video = VideoList.get(position);
            setImageUrl(video.getPicture(), imageView);
            textViewName.setText(video.getName());


            return listViewItem;
        }
    }


}
