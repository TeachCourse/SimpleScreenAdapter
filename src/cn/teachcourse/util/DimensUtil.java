package cn.teachcourse.util;

import java.io.*;

public class DimensUtil {
    public static DimensUtil dimensUtil;
    private static final int DENSITY_DEFAULT = 160;


    public static DimensUtil newInstance() {
        if (dimensUtil == null) {
            dimensUtil = new DimensUtil();
        }
        return dimensUtil;
    }

    /**
     * 自定义屏幕密度，将px数值转换成dp数值
     *
     * @param pxValue
     * @param density
     * @return
     */
    public static float px2dip(float pxValue, float density) {
        final float scale = density / DENSITY_DEFAULT;
        return (pxValue / scale);
    }

    public void generateFile(File desFile, int designWidth, int designHeight, float inch) {

        BufferedWriter bw = null;
        FileOutputStream fos = null;

        try {
            fos = new FileOutputStream(desFile);
            bw = new BufferedWriter(new OutputStreamWriter(fos));

            String hear = "<?xml version=\"1.0\" encoding=\"utf-8\"?>";
            bw.write(hear + "\n");
            String tag = "<resources>";
            bw.write(tag + "\n");

            for (int i = 1; i < getMax(designWidth, designHeight); i++) {
                double density = getDensity(designWidth, designHeight, inch);
                float pxValue=px2dip(i, (float) density);

                String strPXValue = String.format("%1$.5f", pxValue);
                String contentLine = "<dimen name=\"px" + i + "\">" + strPXValue + "dp</dimen>" + "\n";
                bw.write(contentLine);
            }
            String end = "</resources>" + "\n";
            bw.write(end);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bw.close();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private int getMax(int designWidth, int designHeight) {
        int standard;
        if (designHeight >= designWidth)
            standard = designHeight;
        else
            standard = designWidth;
        return standard;
    }

    private double getDensity(int designWidth, int designHeight, float inch) {
        double width = Math.pow(designWidth, 2);
        double height = Math.pow(designHeight, 2);
        return Math.sqrt(width + height) / inch;
    }
}
