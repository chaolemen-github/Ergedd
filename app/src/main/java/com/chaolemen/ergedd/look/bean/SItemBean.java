package com.chaolemen.ergedd.look.bean;

import java.util.List;

public class SItemBean {
    /**
     * mark : {"source":7}
     * sections : [{"number":0,"url":"http://video5lmv.ergedd.com/videos/11222_r_480_20171122143535_uv8q.mp4","md5":"68accc1184ae3072a3c4d6a06e1148b5"}]
     */

    private String mark;
    private List<SectionsBean> sections;

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public List<SectionsBean> getSections() {
        return sections;
    }

    public void setSections(List<SectionsBean> sections) {
        this.sections = sections;
    }

    public static class SectionsBean {
        /**
         * number : 0
         * url : http://video5lmv.ergedd.com/videos/11222_r_480_20171122143535_uv8q.mp4
         * md5 : 68accc1184ae3072a3c4d6a06e1148b5
         */

        private int number;
        private String url;
        private String md5;

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getMd5() {
            return md5;
        }

        public void setMd5(String md5) {
            this.md5 = md5;
        }
    }
}
