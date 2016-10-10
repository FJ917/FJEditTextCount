> ## 栗子——自定义EditText实现右下角计数控件

---

> ### 栗子惯例，先上GIF

![栗子1.gif](http://upload-images.jianshu.io/upload_images/2071764-b45df6bf1d00205e.gif)


![栗子2.gif](http://upload-images.jianshu.io/upload_images/2071764-7be37be47251b7d4.gif)

> ### 用法：

1. xml添加

        <anfq.numedittext.lib.AnFQNumEditText
            android:id="@+id/anetDemo"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"/>

2. java设置

        anetDemo = (AnFQNumEditText) findViewById(R.id.anetDemo);
        anetDemo.setEtHint("内容")//设置提示文字
                .setEtMinHeight(200)//设置最小高度，单位px
                .setLength(50)//设置总字数
                //TextView显示类型(SINGULAR单数类型)(PERCENTAGE百分比类型)
                .setType(AnFQNumEditText.SINGULAR)
                .setLineColor("#3F51B5")//设置横线颜色
                .show();