package com.example.test1;

import java.util.Random;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class CircleChat extends View {
	int[] statics ={2,3,8,4};
	RectF rect;
	Paint paint;
	Random random=new Random();
	public CircleChat(Context context,AttributeSet attrs){
		super(context,attrs);
		
		paint = new Paint();
	}
	@Override
	protected void onDraw(Canvas canvas){
		int sum=0;
		int rid = getWidth()>getHeight()?getHeight()/2:getWidth()/2;
		rect = new RectF(0,0,2*rid,2*rid);
		for(int v:statics){
			sum+=v;
		}
		float[] dr = new float[4];
		for(int i=0;i<statics.length;i++ ){
			dr[i] = 360*(float)statics[i]/sum;
		}
		
		paint.setTextSize(23);
		//canvas.drawCircle(getWidth()/2, getHeight()/2, 60, paint);
		float start=0,ac=0;
		for(int i=0;i<dr.length;i++){
			paint.setColor(Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
			ac=dr[i];
			canvas.drawArc(rect, start, ac, true, paint);
			paint.setColor(Color.BLACK);
			canvas.drawText(statics[i] + "",rid+rid/2*(float)Math.cos((start+ac/2)/180*Math.PI),rid+rid/2*(float)Math.sin((start+ac/2)/180*Math.PI),paint);
			start+=ac;
		}
		/*for(float i=0;i<360;i+=45.0){
			canvas.drawText(i + "",rid+rid/2*(float)Math.cos(i/180*Math.PI),rid+rid/2*(float)Math.sin(i/180*Math.PI),paint);
			Log.w("sin"+i,Math.sin(i/180*Math.PI)+"");
			Log.w("cos"+i,Math.cos(i/180*Math.PI)+"");
		}*/
		//canvas.drawText("AA",rid+rid/2*(float)Math.sin(180/Math.PI),rid+rid/2*(float)Math.cos(180/Math.PI),paint);
	} 
}
