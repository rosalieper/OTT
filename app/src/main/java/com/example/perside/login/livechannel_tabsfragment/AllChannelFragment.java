package com.example.perside.login.livechannel_tabsfragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.perside.login.LiveChannel;
import com.example.perside.login.R;
import com.example.perside.login.Vod;
import com.example.perside.login.api.Api;
import com.example.perside.login.api.RequestHandler;
import com.example.perside.login.model.Videos;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static android.view.View.GONE;

/**
 * Created by perside on 11/20/17.
 */

public class AllChannelFragment extends Fragment {

    private static final int CODE_GET_REQUEST = 1024;
    private static final int CODE_POST_REQUEST = 1025;

    ProgressBar progressBar;
    ListView listView;

    List<Videos> VideoList;

    //TODO study the MyHero app main activity well and implement the database call here :)

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.allchannels_view, container, false);

        progressBar = (ProgressBar) view.findViewById(R.id.progressBar);
        listView = (ListView) view.findViewById(R.id.listViewVideos);

        VideoList = new ArrayList<>();

        readVideos();
        return view;
    }
    private void readVideos() {
        PerformNetworkRequest request = new PerformNetworkRequest(Api.URL_READ_CHANNELS, null, CODE_GET_REQUEST);
        request.execute();
    }

    private void refreshVideoList(JSONArray videos) throws JSONException {
        VideoList.clear();

        for (int i = 0; i < videos.length(); i++) {
            JSONObject obj = videos.getJSONObject(i);

            VideoList.add(new Videos(
                    obj.getInt("channelId"),
                    obj.getString("channelName")
                    ));
        }
        VideoAdapter adapter = new VideoAdapter(VideoList);
        listView.setAdapter(adapter);
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

        public VideoAdapter(List<Videos> videosList) {
            super(getActivity(), R.layout.layout_video_list, videosList);
            this.videosList = videosList;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = getActivity().getLayoutInflater();
            View listViewItem = inflater.inflate(R.layout.layout_video_list, null, true);

            TextView textViewName = (TextView) listViewItem.findViewById(R.id.textVideoName);

            final Videos video = VideoList.get(position);

            textViewName.setText(video.getName());

            return listViewItem;
        }
    }
}
