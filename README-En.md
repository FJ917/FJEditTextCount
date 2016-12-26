> ## Example——Customize EditText

---

> ### Preview

| PERCENTAGE        | SINGULAR           |
|:-------------:|:-------------:|
| ![PERCENTAGE.gif](http://upload-images.jianshu.io/upload_images/2071764-b45df6bf1d00205e.gif)      | ![SINGULAR.gif](http://upload-images.jianshu.io/upload_images/2071764-7be37be47251b7d4.gif) |

> ### usage：

1. xml Add to

        <fj.edittextcount.lib.FJEditTextCount
            android:id="@+id/fjEdit"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"/>

2. java Set up

        fjEdit = (FJEditTextCount) findViewById(R.id.fjEdit);
        fjEdit.setEtHint("content")//Set prompt text
                .setEtMinHeight(200)//Set minimum height in px
                .setLength(50)//Set the total number of words
                //type(SINGULAR)(PERCENTAGE)
                .setType(AnFQNumEditText.SINGULAR)
                .setLineColor("#3F51B5")//Setting horizontal color
                .show();
                
> #### [blog Address](http://www.jianshu.com/p/383ba123c201)

> [English](https://github.com/FTandJYQ/AnFQNumEditText/blob/master/README-En.md)|[中文](https://github.com/FTandJYQ/AnFQNumEditText/blob/master/README.md)