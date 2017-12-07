# 自由选择文字复制功能
##前排：demo全面参考这位作者[传送门](https://jaeger.itscoder.com/android/2016/11/21/selectable-text-helper.html)

###  主要手动触发类似TextView长按出现的选择文字复制功能。
    主要的实现：
  ```java
   mSelectableTextHelper=new SelectableTextHelper.Builder(mTextView)
                .setSelectedColor(ContextCompat.getColor(this,R.color.colorPrimary))//选择文字的高亮颜色
                .setCursorHandleColor(ContextCompat.getColor(this,R.color.colorPrimaryDark))//游标的颜色
                .setEnbleLongClick(false)
                .build();
  ```
  ### demo不一样的地方只在与自己添加了一些个人方法，与外部退出复制状态的实现，大体还是与原作者一致。
