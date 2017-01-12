package mediaplayer.cursoandroid.com.mediaplayer;

import android.media.MediaPlayer;
import android.support.v4.print.PrintHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.security.PrivateKey;

public class MainActivity extends AppCompatActivity {

    private Button botaoTocar;
    private MediaPlayer mediaPlayer;
    private Button botaoStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botaoTocar = (Button) findViewById(R.id.botaoTocarID);
        mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.musica);
        botaoStop = (Button) findViewById(R.id.botaoStopID);

        botaoTocar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mediaPlayer.isPlaying()) {
                    pausarMusica();
                } else {
                    tocarMusica();
                }
            }
        });

        botaoStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( mediaPlayer.isPlaying()) {
                    stopMusica();
                }
            }
        });
    }

    //método criado para executar a musica
    private void tocarMusica() {
        if ( mediaPlayer != null ) {
            mediaPlayer.start();
            botaoTocar.setText("Pause");
        }
    }

    //método para pausar musica
    private void pausarMusica(){
        if ( mediaPlayer != null ) {
            mediaPlayer.pause();
            botaoTocar.setText("Play");
        }
    }

    //método para stopar musica
    private void stopMusica(){
        if ( mediaPlayer != null ) {
            mediaPlayer.stop();
            botaoStop.setText("Stop Music");
        }
    }


    //método criado para liberar a memmória do celular após o encerramento da música

    @Override
    protected void onDestroy() {
        if (mediaPlayer != null && mediaPlayer.isPlaying()){
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
        super.onDestroy();
    }

}
