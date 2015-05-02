package net.npaka.mediaplayerex;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.MediaPlayer;
import android.view.MotionEvent;
import android.view.View;

//�T�E���h�̍Đ�
public class MediaPlayerView extends View
    implements MediaPlayer.OnCompletionListener {
    private MediaPlayer player;//�v���[���[

    //�R���X�g���N�^
    public MediaPlayerView(Context context) {
        super(context);
        setBackgroundColor(Color.WHITE);
        setFocusable(true);
        player=null;
    }

    //�`��
    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint=new Paint();
        paint.setAntiAlias(true);
        paint.setTextSize(32);
        canvas.drawText("MediaPlayerEx",0,40,paint);
    }

    //�^�b�`�C�x���g�̏���
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction()==MotionEvent.ACTION_DOWN) {
            if (player==null) {
                playSound();
            } else {
                stopSound();
            }
        }
        return true;
    }

    //�T�E���h�̍Đ�
    public void playSound() {
        try {
            stopSound();
            
            //���f�B�A�v���C���[�̐���(1)
            player=MediaPlayer.create(getContext(),R.raw.sample);
            
            //�T�E���h�̍Đ�(2)
            player.seekTo(0);
            player.start();
            
            //�T�E���h�̍Đ��������X�i�[�̎w��(3)
            player.setOnCompletionListener(this);
        } catch (Exception e) {
        }
    }

    //�T�E���h�̒�~
    public void stopSound() {
        try {
            if (player==null) return;

            //�T�E���h�̒�~(4)
            player.stop();
            player.setOnCompletionListener(null);
            player.release();
            player=null;
        } catch (Exception e) {
        }
    }

    //�T�E���h�Đ��I�����ɌĂ΂��(3)
    public void onCompletion(MediaPlayer mediaPlayer) {
        stopSound();
    }
}