package net.npaka.mediaplayerex;
import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

//サウンドの再生
public class MediaPlayerEx extends Activity {
    private MediaPlayerView view;

    //アプリの初期化
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        view=new MediaPlayerView(this);
        setContentView(view);
    }

    //アプリの停止
    @Override
    public void onStop() {
        super.onStop();
        
        //アプリ終了時のサウンド停止(5)
        view.stopSound();
    }
}