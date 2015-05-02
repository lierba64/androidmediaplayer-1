package net.npaka.mediaplayerex;
import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

//�T�E���h�̍Đ�
public class MediaPlayerEx extends Activity {
    private MediaPlayerView view;

    //�A�v���̏�����
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        view=new MediaPlayerView(this);
        setContentView(view);
    }

    //�A�v���̒�~
    @Override
    public void onStop() {
        super.onStop();
        
        //�A�v���I�����̃T�E���h��~(5)
        view.stopSound();
    }
}