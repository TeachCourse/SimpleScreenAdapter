## 摘要：
Google推荐使用`dip`、`sp`代替`px`，原因是密度无关像素（density independent pixel、scale independent pixel），既然这样，我在想能不能将设计稿上的px转换成dp，然后直接使用dp，基于这样的一种思想设计的一个工具`SimpleScrenAdapter`，将设计稿上的px单位转换成dp单位

用法，运行项目并生成资源文件`res/values/dimens-xxx.xml`，将生成的资源文件导入Android项目中，最后直接引用即可

```
    public static void main(String[] args){
        File file=new File("res/values");
        if (!file.exists()){
            file.mkdirs();
        }
        File desFile=new File(file.getAbsoluteFile(),"dimens-1136x640.xml");
        DimensUtil.newInstance().generateFile(desFile,640,1136,4.0f);
    }
```

生成的`dimens-1136x640`的资源文件（640表示设计稿的宽度，1136表示设计稿的高度，4.0f表示设计稿基于的手机尺寸）

```
<?xml version="1.0" encoding="utf-8"?>
<resources>
<dimen name="px1">0.49084dp</dimen>
<dimen name="px2">0.98169dp</dimen>
<dimen name="px3">1.47253dp</dimen>
<dimen name="px4">1.96337dp</dimen>
<dimen name="px5">2.45422dp</dimen>
<dimen name="px6">2.94506dp</dimen>
<dimen name="px7">3.43591dp</dimen>
<dimen name="px8">3.92675dp</dimen>
<dimen name="px9">4.41759dp</dimen>
...
</resources>
```

考虑设计稿标注的是px，引用的时候直接选择对应的名称即可，比如：240px，在布局文件中的引用

```
<RelativeLayout
    android:layout_width="match_parent"
    android:layout_height="@dimen/px240"
    android:background="@drawable/main_bg_shape"/>
```



