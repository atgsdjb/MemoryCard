package td.seraphim.base;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class DjTimeText extends View {
	Paint mPaint=new Paint();
	Rect rect = null;
	public DjTimeText(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
	}
	public DjTimeText(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}
	public DjTimeText(Context context ) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		int height =  canvas.getHeight();
		int width = canvas.getWidth();
		Log.e("com.seraphim.base","height==="+height+"\twidth==="+width);
		mPaint.setColor(0xff000000);
		canvas.drawColor(0xffffffff);
		float[] pts = new float[]{0f,0f,width,0f,width,height,0f,height};
		float[] pts2 = new float[]{0f,0f,width,height};
		canvas.drawLines(pts, mPaint);
		canvas.drawLines(pts2, mPaint);
		
	}
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		// TODO Auto-generated method stub
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	}
	

}
