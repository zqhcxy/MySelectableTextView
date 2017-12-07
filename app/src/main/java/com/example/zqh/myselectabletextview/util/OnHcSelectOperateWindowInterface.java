package com.example.zqh.myselectabletextview.util;

import android.view.View;

/**
 * Created by zqh on 2017/11/28.
 */
public interface OnHcSelectOperateWindowInterface {
    /**
     * 初始化的window视图
     * @param onSelectListener 选择位置信息类，复制功能的时候需要用到
     * @return
     */
    View getOncreteView(OnSelectListener onSelectListener);
    void showWindow();
}
