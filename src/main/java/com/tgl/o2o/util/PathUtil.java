package com.tgl.o2o.util;

public class PathUtil {
    //获取系统文件的分隔符
    private static String seperator = java.io.File.separator;
    //获取图片的根路径
    public static String getImgBasePath(){
        String os = System.getProperty("os.name");
        String basePath="";
        if (os.toLowerCase().startsWith("win")){
            basePath = "H:/IdeaProjects/Maven/image";
        }else {
            basePath = "/home/tgl/image";
        }
        basePath = basePath.replace("/", seperator);
        return basePath;
    }
    public static String getShopImagePath(long shopId){
        String imagePath = "/upload/item/shop/" + shopId + "/";
        return imagePath.replace("/", seperator);
    }
}
