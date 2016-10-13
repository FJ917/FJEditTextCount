> ## Example——Customize EditText

---

> ### Preview

![example.gif](http://upload-images.jianshu.io/upload_images/2071764-b45df6bf1d00205e.gif)


![example.gif](http://upload-images.jianshu.io/upload_images/2071764-7be37be47251b7d4.gif)

> ### usage：

1. xml Add to

        <anfq.numedittext.lib.AnFQNumEditText
            android:id="@+id/anetDemo"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"/>

2. java Set up

        anetDemo = (AnFQNumEditText) findViewById(R.id.anetDemo);
        anetDemo.setEtHint("content")//Set prompt text
                .setEtMinHeight(200)//Set minimum height in px
                .setLength(50)//Set the total number of words
                //type(SINGULAR)(PERCENTAGE)
                .setType(AnFQNumEditText.SINGULAR)
                .setLineColor("#3F51B5")//Setting horizontal color
                .show();
                
> #### [blog Address](http://www.jianshu.com/p/383ba123c201)

> [English](https://github.com/FTandJYQ/AnFQNumEditText/blob/master/README-En.md)|[中文](https://github.com/FTandJYQ/AnFQNumEditText/blob/master/README.md)