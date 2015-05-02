package net.npaka.mediaplayerex;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.MediaPlayer;
import android.view.MotionEvent;
import android.view.View;

//サウンドの再生
public class MediaPlayerView extends View
    implements MediaPlayer.OnCompletionListener {
    private MediaPlayer player;//プレーヤー

    //コンストラクタ
    public MediaPlayerView(Context context) {
        super(context);
        setBackgroundColor(Color.WHITE);
        setFocusable(true);
        player=null;
    }

    //描画
    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint=new Paint();
        paint.setAntiAlias(true);
        paint.setTextSize(32);
        canvas.drawText("MediaPlayerEx",0,40,paint);
    }

    //タッチイベントの処理
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

    //サウンドの再生
    public void playSound() {
        try {
            stopSound();
            
            //メディアプレイヤーの生成(1)
            player=MediaPlayer.create(getContext(),R.raw.sample);
            
            //サウンドの再生(2)
            player.seekTo(0);
            player.start();
            
            //サウンドの再生完了リスナーの指定(3)
            player.setOnCompletionListener(this);
        } catch (Exception e) {
        }
    }

    //サウンドの停止
    public void stopSound() {
        try {
            if (player==null) return;

            //サウンドの停止(4)
            player.stop();
            player.setOnCompletionListener(null);
            player.release();
            player=null;
        } catch (Exception e) {
        }
    }

    //サウンド再生終了時に呼ばれる(3)
    public void onCompletion(MediaPlayer mediaPlayer) {
        stopSound();
    }
}