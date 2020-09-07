package com.chaolemen.ergedd.look;

import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.chaolemen.ergedd.R;
import com.chaolemen.ergedd.app.Contents;
import com.chaolemen.ergedd.look.bean.SItemBean;
import com.chaolemen.ergedd.look.contract.SiftItemContract;
import com.chaolemen.ergedd.look.presenter.SiftItemPresenter;
import com.chaolemen.mvplibrary.base.BaseMvpActivity;
import com.google.android.exoplayer2.ExoPlaybackException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Arrays;
import java.util.logging.Logger;

import javax.sql.DataSource;

import butterknife.BindView;
import butterknife.ButterKnife;
import chuangyuan.ycj.videolibrary.listener.VideoInfoListener;
import chuangyuan.ycj.videolibrary.listener.VideoWindowListener;
import chuangyuan.ycj.videolibrary.video.ExoUserPlayer;
import chuangyuan.ycj.videolibrary.video.VideoPlayerManager;
import chuangyuan.ycj.videolibrary.widget.VideoPlayerView;

public class SiftItemActivity extends BaseMvpActivity<SiftItemContract.View, SiftItemPresenter> implements SiftItemContract.View {

    @BindView(R.id.vpv_sift_item_video)
    VideoPlayerView mVpvSiftItemVideo;
    private int id;
    private ExoUserPlayer exoPlayerManager;

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_sift_item);
//
//
////        //创建一个存放参数的实体对象
////        TabParameter tabParameter = new TabParameter();
////        tabParameter.setLimit(100);
////        tabParameter.setOffset(0);
////        tabParameter.setAddition_album_count(20);
////        tabParameter.setChannel("new");
////        //调用presenter的方法
////        mPresenter.getDataTabItem(id, tabParameter);
//    }

    @Override
    protected int getLayoutId() {
        //获取用intent带过来的id
        id = getIntent().getIntExtra(Contents.TAB_ITEM_ID, 0);
        return R.layout.activity_sift_item;
    }

    @Override
    protected SiftItemPresenter initPresenter() {
        return new SiftItemPresenter();
    }

    @Override
    protected void initData() {

        mPresenter.getDataSift(id);

    }

    @Override
    public void onSuccessSIftItem(SItemBean sItemBean) {
//        exoPlayerManager = new VideoPlayerManager.Builder(VideoPlayerManager.TYPE_PLAY_GESTURE, videoPlayerView)
//                .setVerticalFullScreen(true);
//
//        //实例化
//        exoPlayerManager = new VideoPlayerManager.Builder(VideoPlayerManager.TYPE_PLAY_MANUAL, videoPlayerView)
//                .setDataSource(new DataSource(this) {
//                    @Override
//                    public PrintWriter getLogWriter() throws SQLException {
//                        return null;
//                    }
//
//                    @Override
//                    public void setLogWriter(PrintWriter out) throws SQLException {
//
//                    }
//
//                    @Override
//                    public void setLoginTimeout(int seconds) throws SQLException {
//
//                    }
//
//                    @Override
//                    public int getLoginTimeout() throws SQLException {
//                        return 0;
//                    }
//
//                    @Override
//                    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
//                        return null;
//                    }
//
//                    @Override
//                    public <T> T unwrap(Class<T> iface) throws SQLException {
//                        return null;
//                    }
//
//                    @Override
//                    public boolean isWrapperFor(Class<?> iface) throws SQLException {
//                        return false;
//                    }
//
//                    @Override
//                    public Connection getConnection() throws SQLException {
//                        return null;
//                    }
//
//                    @Override
//                    public Connection getConnection(String username, String password) throws SQLException {
//                        return null;
//                    }
//                })
//                //加载rtmp 协议视频
//                .setPlayUri("rtmp://live.hkstv.hk.lxdns.com/live/hks")
//                //加载m3u8
//                .setPlayUri("http://dlhls.cdn.zhanqi.tv/zqlive/35180_KUDhx.m3u8")
//                //加载ts.文件
////                .setPlayUri("http://185.73.239.15:25461/live/1/1/924.ts")
//                //播放本地视频
////                .setPlayUri("/storage/emulated/0/DCIM/Camera/VID_20170717_011150.mp4")
//        //设置开始播放进度
//                      .setPosition(1000)
//                //示例本地路径 或者 /storage/emulated/0/DCIM/Camera/VID_20180215_131926.mp4
////                .setPlayUri(Environment.getExternalStorageDirectory().getAbsolutePath()+"/VID_20170925_154925.mp4")
//                //开启线路设置
//                .setShowVideoSwitch(true)
////                .setPlaySwitchUri(0,test,name)
////                .setPlaySwitchUri(0, 0, getString(R.string.uri_test_11), Arrays.asList(test), Arrays.asList(name))
//                //设置播放视频倍数  快进播放和慢放播放
//                .setPlaybackParameters(0.5f, 0.5f)
//                //是否屏蔽进度控件拖拽快进视频（例如广告视频，（不允许用户））
//                .setSeekBarSeek(false)
//                //设置视循环播放
//                .setLooping(10)
//                //视频进度回调
//                .addOnWindowListener(new VideoWindowListener() {
//                    @Override
//                    public void onCurrentIndex(int currentIndex, int windowCount) {
//                        Toast.makeText(getApplication(), currentIndex + "windowCount:" + windowCount,                                                    Toast.LENGTH_SHORT).show();
//                    }
//                })
//                .addOnWindowListener(new VideoWindowListener() {
//                    @Override
//                    public void onCurrentIndex(int currentIndex, int windowCount) {
//                        Toast.makeText(getApplication(), currentIndex + "windowCount:" + windowCount, Toast.LENGTH_SHORT)                                             .show();
//                    }
//                })
//                .addVideoInfoListener(new VideoInfoListener() {
//
//                    @Override
//                    public void onPlayStart(long currPosition) {
//
//                    }
//
//                    @Override
//                    public void onLoadingChanged() {
//
//                    }
//
//                    @Override
//                    public void onPlayerError(@Nullable ExoPlaybackException e) {
//
//                    }
//
//                    @Override
//                    public void onPlayEnd() {
//
//                    }
//
//                    @Override
//                    public void isPlaying(boolean playWhenReady) {
//
//                    }
//                })
//                //创建
//                .create()
//                //播放视频
//                .startPlayer();
    }

    @Override
    public void onFail(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCancel() {
        mPresenter.onCancel();
    }

}
