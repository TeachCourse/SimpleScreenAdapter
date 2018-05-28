package cn.teachcourse;

import cn.teachcourse.util.DimensUtil;

import java.io.File;

public class TestDriver {

    public static void main(String[] args){
        File file=new File("res/values");
        if (!file.exists()){
            file.mkdirs();
        }
        File desFile=new File(file.getAbsoluteFile(),"dimens-1136x640.xml");
        DimensUtil.newInstance().generateFile(desFile,640,1136,4.0f);
    }
}
