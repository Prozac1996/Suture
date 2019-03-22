package com.prozac.suture.divider;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class LineDividerItemDecoration extends RecyclerView.ItemDecoration {

    public static int[] ATTRS = new int[]{
            android.R.attr.listDivider
    };

    public static final int HORIZONTAL_LIST = LinearLayoutManager.HORIZONTAL;
    public static final int VERTICAL_LIST = LinearLayoutManager.VERTICAL;
    public static final int ALL = 2;

    private Drawable mDivider;
    private int mOrientation;

    public LineDividerItemDecoration(Context context,int mOrientation) {
        final TypedArray a = context.obtainStyledAttributes(ATTRS);
        mDivider = a.getDrawable(0);
        a.recycle();
        setOrientation(mOrientation);
    }

    public void setDivider(Drawable mDivider) {
        if(mDivider != null){
            this.mDivider = mDivider;
        }
    }

    /**
     * 设置排序方式
     * @param mOrientation
     */
    private void setOrientation(int mOrientation) {
        if(mOrientation != HORIZONTAL_LIST && mOrientation != VERTICAL_LIST && mOrientation != ALL){
            throw new IllegalArgumentException("Invalid orientation");
        }
        this.mOrientation = mOrientation;
    }

    @Override
    public void onDraw(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.onDraw(c, parent, state);
        if(mOrientation == HORIZONTAL_LIST){
            drawHorizontalLine(c,parent);
        } if(mOrientation == VERTICAL_LIST){
            drawVerticalLine(c,parent);
        }else if(mOrientation == ALL){
            drawHorizontalLine(c,parent);
            drawVerticalLine(c,parent);
        }
    }

    /**
     * 画横向分割线
     */
    private void drawVerticalLine(@NonNull Canvas c, @NonNull RecyclerView parent) {
        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = parent.getChildAt(i);
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) child.getLayoutParams();
            final int top = child.getBottom() + layoutParams.bottomMargin;
            final int bottom = top + mDivider.getIntrinsicHeight();
            final int left = child.getLeft() - layoutParams.leftMargin;
            final int right = child.getRight() + layoutParams.rightMargin;
            mDivider.setBounds(left,top,right,bottom);
            mDivider.draw(c);
        }
    }

    /**
     * 画竖向分割线
     */
    private void drawHorizontalLine(@NonNull Canvas c, @NonNull RecyclerView parent) {
        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = parent.getChildAt(i);
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) child.getLayoutParams();
            final int top = child.getTop() - layoutParams.topMargin;
            final int bottom = child.getBottom() + layoutParams.bottomMargin;
            final int left = child.getRight() + layoutParams.rightMargin;
            final int right = left + mDivider.getIntrinsicWidth();
            mDivider.setBounds(left,top,right,bottom);
            mDivider.draw(c);
        }
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        if(mOrientation == HORIZONTAL_LIST){
            outRect.set(0,0,mDivider.getIntrinsicWidth(),0);
        }else if(mOrientation == VERTICAL_LIST){
            outRect.set(0,0,0,mDivider.getIntrinsicHeight());
        }else if(mOrientation == ALL){
            outRect.set(0,0,mDivider.getIntrinsicWidth(),mDivider.getIntrinsicHeight());
        }
    }
}
