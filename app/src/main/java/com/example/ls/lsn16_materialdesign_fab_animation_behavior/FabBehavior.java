package com.example.ls.lsn16_materialdesign_fab_animation_behavior;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.RelativeLayout;

import java.util.jar.Attributes;

/**
 * Created by 路很长~ on 2018/4/10.
 */

public class FabBehavior extends CoordinatorLayout.Behavior {
    private boolean visible = true;//是否可见
    private ToobarLisenner lisenner;

    public FabBehavior(Context context, AttributeSet attributes) {
        super(context, attributes);
       // this.lisenner = (ToobarLisenner) context;

    }

    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View child, View directTargetChild, View target, int nestedScrollAxes) {
        // 当观察的View（RecyclerView）发生滑动的开始的时候回调的
        //nestedScrollAxes:滑动关联轴， 我们现在只关心垂直的滑动。
        return nestedScrollAxes == ViewCompat.SCROLL_AXIS_VERTICAL || super.onStartNestedScroll(coordinatorLayout, child, directTargetChild,
                target, nestedScrollAxes);
      //  return super.onStartNestedScroll(coordinatorLayout, child, directTargetChild, target, nestedScrollAxes);
    }

    @Override
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, View child, View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed);
        // 当观察的view滑动的时候回调的
        //根据情况执行动画
        if (dyConsumed > 0 && visible) {
            //show
            visible = false;
            if (lisenner != null) {
                lisenner.hide();
            }
            onHide((FloatingActionButton) child);
        } else if (dyConsumed < 0) {
            //hide
            visible = true;
            if (lisenner != null) {
                lisenner.visible();
            }
            onShow((FloatingActionButton) child);
        }

    }

    /*@Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout,
                                       FloatingActionButton child, View directTargetChild, View target,
                                       int nestedScrollAxes) {
        // 当观察的View（RecyclerView）发生滑动的开始的时候回调的
        //nestedScrollAxes:滑动关联轴， 我们现在只关心垂直的滑动。
        return nestedScrollAxes == ViewCompat.SCROLL_AXIS_VERTICAL || super.onStartNestedScroll(coordinatorLayout, child, directTargetChild,
                target, nestedScrollAxes);
    }

    @Override
    public void onNestedScroll(CoordinatorLayout coordinatorLayout,
                               FloatingActionButton child, View target, int dxConsumed,
                               int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed,
                dxUnconsumed, dyUnconsumed);
        // 当观察的view滑动的时候回调的
        //根据情况执行动画
        if (dyConsumed > 0 && visible) {
            //show
            visible = false;
            if (lisenner != null) {
                lisenner.hide();
            }
            onHide(child);
        } else if (dyConsumed < 0) {
            //hide
            visible = true;
            if (lisenner != null) {
                lisenner.visible();
            }
            onShow(child);
        }

    }*/

    public void onHide(FloatingActionButton fab) {
        // 隐藏动画--属性动画
//		toolbar.animate().translationY(-toolbar.getHeight()).setInterpolator(new AccelerateInterpolator(3));
        ViewGroup.LayoutParams layoutParams = (ViewGroup.LayoutParams) fab.getLayoutParams();
        //fab.animate().translationY(fab.getHeight()+fab.getBottom()).setInterpolator(new AccelerateInterpolator(3));
//		fab.animate().translationY(fab.getHeight()+layoutParams.bottomMargin).setInterpolator(new AccelerateInterpolator(3));
        ViewCompat.animate(fab).scaleX(0f).scaleY(0f).start();
    }

    public void onShow(FloatingActionButton fab) {
        // 显示动画--属性动画
//		toolbar.animate().translationY(0).setInterpolator(new DecelerateInterpolator(3));
        ViewGroup.LayoutParams layoutParams = (ViewGroup.LayoutParams) fab.getLayoutParams();
//        fab.animate().translationY(0).setInterpolator(new DecelerateInterpolator(3));
//		fab.animate().translationY(0).setInterpolator(new DecelerateInterpolator(3));
        ViewCompat.animate(fab).scaleX(1f).scaleY(1f).start();
    }
}
