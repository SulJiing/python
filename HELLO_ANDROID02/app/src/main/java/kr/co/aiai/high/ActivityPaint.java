package kr.co.aiai.high;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Mesh;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;

public class ActivityPaint extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( new ViewMe(this));
    }
    class ViewMe extends View {

        public ViewMe(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            Paint paint = new Paint();
            paint.setColor(Color.BLACK);
            // paint.setAlpha(125);

            // 행렬
//            Matrix matrix = new Matrix();
//            matrix.postRotate(45, 100, 100);
//            canvas.setMatrix(matrix);
//            String txt = "Hello graphic";
//            canvas.drawText(txt, 0, txt.length(), 100, 100, paint);
//            canvas.drawRect(0,0,100,200,paint);
//            canvas.drawCircle(200,300,100,paint);

            // rgb(224,27,30)
            // rgb(224,184,27)
            // rgb(228,247,12)
            // rgb(11,252,17)
            // rgb(10,100,252)
            // rgb(66,10,252)
            // rgb(226,10,252)

            // 굵기
            paint.setStrokeWidth(10);

            paint.setColor(Color.rgb(224,27,30));
            canvas.drawLine(0,100,200,100,paint);
            paint.setColor(Color.rgb(224,184,27));
            canvas.drawLine(0,200,200,200,paint);
            paint.setColor(Color.rgb(228,247,12));
            canvas.drawLine(0,300,200,300,paint);
            paint.setColor(Color.rgb(11,252,17));
            canvas.drawLine(0,400,200,400,paint);
            paint.setColor(Color.rgb(10,100,252));
            canvas.drawLine(0,500,200,500,paint);
            paint.setColor(Color.rgb(66,10,252));
            canvas.drawLine(0,600,200,600,paint);
            paint.setColor(Color.rgb(226,10,252));
            canvas.drawLine(0,700,200,700,paint);

            super.onDraw(canvas);
        }
    }
}