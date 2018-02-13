package com.example.perside.login.model;

import java.io.Serializable;
/**
 * Created by perside on 12/12/17.
 */

public class Videos {

        private int channelId;
        private String channelName;
        private String video_pic;
        /* private String video_link;*/

        public Videos(int channelId, String channelName, String video_pic/*String video_link*/) {
            this.channelId = channelId;
            this.channelName = channelName;
            this.video_pic = video_pic;
            /*this.video_link = video_link;*/
        }

        public int getId() {
            return channelId;
        }

        public String getName() {
            return channelName;
        }

        public String getPicture() {
            return video_pic;
        }
/*
        public String getLink() {
            return video_link;
        }
*/
}
