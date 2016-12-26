> ## 栗子——自定义EditText实现右下角计数控件

---


> ### 栗子惯例，先上GIF

| PERCENTAGE效果        | SINGULAR效果           |
|:-------------:|:-------------:|
| ![百分比类型.gif](http://upload-images.jianshu.io/upload_images/2071764-b45df6bf1d00205e.gif)      | ![单数类型.gif](http://upload-images.jianshu.io/upload_images/2071764-7be37be47251b7d4.gif) |

> ### 用法：

1.引用

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
	dependencies {
	    compile 'com.github.FJ917:FJEditTextCount:v1.0.1'
	}

2.xml添加

    <fj.edittextcount.lib.FJEditTextCount
        android:id="@+id/fjEdit"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"/>
        
2.java设置

    fjEdit = (FJEditTextCount) findViewById(R.id.fjEdit);
    fjEdit.setEtHint("内容")//设置提示文字
            .setEtMinHeight(200)//设置最小高度，单位px
            .setLength(50)//设置总字数
            //TextView显示类型(SINGULAR单数类型)(PERCENTAGE百分比类型)
            .setType(FJEditTextCount.SINGULAR)
            .setLineColor("#3F51B5")//设置横线颜色
            .show();
                
> #### [博客地址](http://www.jianshu.com/p/383ba123c201)

> [English](https://github.com/FTandJYQ/AnFQNumEditText/blob/master/README-En.md)|[中文](https://github.com/FTandJYQ/AnFQNumEditText/blob/master/README.md)