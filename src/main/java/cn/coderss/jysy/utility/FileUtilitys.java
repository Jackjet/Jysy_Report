package cn.coderss.jysy.utility;

import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveInputStream;
import org.apache.commons.compress.archivers.tar.TarArchiveOutputStream;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created with report.
 * User: shenwei
 * Date: 17/6/30
 * Time: 下午3:31
 * Blog: http://www.coderss.cn
 */
public class FileUtilitys {
    private static final String BASE_DIR = "";

    // 符号"/"用来作为目录标识判断符
    private static final String PATH = "/";
    private static final int BUFFER = 1024;

    private static final String EXT = ".tar";

    public static boolean makeDir(String strDir) {
        File fileNew = new File(strDir);

        if (!fileNew.exists()) {
            return fileNew.mkdirs();
        } else {
            return true;
        }
    }

    public static boolean fileToZip(String sourceFilePath,String zipFilePath,String fileName){
        boolean flag = false;
        File sourceFile = new File(sourceFilePath);
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        FileOutputStream fos = null;
        ZipOutputStream zos = null;

        if(sourceFile.exists() == false){
            System.out.println("待压缩的文件目录："+sourceFilePath+"不存在.");
        }else{
            try {
                File zipFile = new File(zipFilePath + "/" + fileName +".zip");
                if(zipFile.exists()){
                    System.out.println(zipFilePath + "目录下存在名字为:" + fileName +".zip" +"打包文件.");
                }else{
                    File[] sourceFiles = sourceFile.listFiles();
                    if(null == sourceFiles || sourceFiles.length<1){
                        System.out.println("待压缩的文件目录：" + sourceFilePath + "里面不存在文件，无需压缩.");
                    }else{
                        fos = new FileOutputStream(zipFile);
                        zos = new ZipOutputStream(new BufferedOutputStream(fos));
                        byte[] bufs = new byte[1024*10];
                        for(int i=0;i<sourceFiles.length;i++){
                            //创建ZIP实体，并添加进压缩包
                            ZipEntry zipEntry = new ZipEntry(sourceFiles[i].getName());
                            zos.putNextEntry(zipEntry);
                            //读取待压缩的文件并写进压缩包里
                            fis = new FileInputStream(sourceFiles[i]);
                            bis = new BufferedInputStream(fis, 1024*10);
                            int read = 0;
                            while((read=bis.read(bufs, 0, 1024*10)) != -1){
                                zos.write(bufs,0,read);
                            }
                        }
                        flag = true;
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            } finally{
                //关闭流
                try {
                    if(null != bis) bis.close();
                    if(null != zos) zos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }
        }
        return flag;
    }

    public static String getStackMsg(Exception e) {
        StringBuffer sb = new StringBuffer();
        StackTraceElement[] stackArray = e.getStackTrace();

        for(int i = 0; i < stackArray.length; ++i) {
            StackTraceElement element = stackArray[i];
            sb.append(element.toString() + "\n");
        }

        return sb.toString();
    }


    /**
     * 归档
     *
     * @param srcPath
     * @param destPath
     * @throws Exception
     */
    public static void archive(String srcPath, String destPath)
            throws Exception {

        File srcFile = new File(srcPath);

        archive(srcFile, destPath);

    }

    /**
     * 归档
     *
     * @param srcFile
     *            源路径
     * @param destPath
     *            目标路径
     * @throws Exception
     */
    public static void archive(File srcFile, File destFile) throws Exception {

        TarArchiveOutputStream taos = new TarArchiveOutputStream(
                new FileOutputStream(destFile));

        archive(srcFile, taos, BASE_DIR);

        taos.flush();
        taos.close();
    }

    /**
     * 归档
     *
     * @param srcFile
     * @throws Exception
     */
    public static void archive(File srcFile) throws Exception {
        String name = srcFile.getName();
        String basePath = srcFile.getParent();
        String destPath = basePath + name + EXT;
        archive(srcFile, destPath);
    }

    /**
     * 归档文件
     *
     * @param srcFile
     * @param destPath
     * @throws Exception
     */
    public static void archive(File srcFile, String destPath) throws Exception {
        archive(srcFile, new File(destPath));
    }

    /**
     * 归档
     *
     * @param srcPath
     * @throws Exception
     */
    public static void archive(String srcPath) throws Exception {
        File srcFile = new File(srcPath);

        archive(srcFile);
    }

    /**
     * 归档
     *
     * @param srcFile
     *            源路径
     * @param taos
     *            TarArchiveOutputStream
     * @param basePath
     *            归档包内相对路径
     * @throws Exception
     */
    private static void archive(File srcFile, TarArchiveOutputStream taos,
                                String basePath) throws Exception {
        if (srcFile.isDirectory()) {
            archiveDir(srcFile, taos, basePath);
        } else {
            archiveFile(srcFile, taos, basePath);
        }
    }

    /**
     * 目录归档
     *
     * @param dir
     * @param taos
     *            TarArchiveOutputStream
     * @param basePath
     * @throws Exception
     */
    private static void archiveDir(File dir, TarArchiveOutputStream taos,
                                   String basePath) throws Exception {

        File[] files = dir.listFiles();

        if (files.length < 1) {
            TarArchiveEntry entry = new TarArchiveEntry(basePath
                    + dir.getName() + PATH);

            taos.putArchiveEntry(entry);
            taos.closeArchiveEntry();
        }

        for (File file : files) {

            // 递归归档
            archive(file, taos, basePath + dir.getName() + PATH);

        }
    }

    /**
     * 数据归档
     *
     * @param data
     *            待归档数据
     * @param path
     *            归档数据的当前路径
     * @param name
     *            归档文件名
     * @param taos
     *            TarArchiveOutputStream
     * @throws Exception
     */
    private static void archiveFile(File file, TarArchiveOutputStream taos,
                                    String dir) throws Exception {

        /**
         * 归档内文件名定义
         *
         * <pre>
         * 如果有多级目录，那么这里就需要给出包含目录的文件名
         * 如果用WinRAR打开归档包，中文名将显示为乱码
         * </pre>
         */
        TarArchiveEntry entry = new TarArchiveEntry(dir + file.getName());

        entry.setSize(file.length());

        taos.putArchiveEntry(entry);

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(
                file));
        int count;
        byte data[] = new byte[BUFFER];
        while ((count = bis.read(data, 0, BUFFER)) != -1) {
            taos.write(data, 0, count);
        }

        bis.close();

        taos.closeArchiveEntry();
    }

    /**
     * 解归档
     *
     * @param srcFile
     * @throws Exception
     */
    public static void dearchive(File srcFile) throws Exception {
        String basePath = srcFile.getParent();
        dearchive(srcFile, basePath);
    }

    /**
     * 解归档
     *
     * @param srcFile
     * @param destFile
     * @throws Exception
     */
    public static void dearchive(File srcFile, File destFile) throws Exception {

        TarArchiveInputStream tais = new TarArchiveInputStream(
                new FileInputStream(srcFile));
        dearchive(destFile, tais);

        tais.close();

    }

    /**
     * 解归档
     *
     * @param srcFile
     * @param destPath
     * @throws Exception
     */
    public static void dearchive(File srcFile, String destPath)
            throws Exception {
        dearchive(srcFile, new File(destPath));

    }

    /**
     * 文件 解归档
     *
     * @param destFile
     *            目标文件
     * @param tais
     *            ZipInputStream
     * @throws Exception
     */
    private static void dearchive(File destFile, TarArchiveInputStream tais)
            throws Exception {

        TarArchiveEntry entry = null;
        while ((entry = tais.getNextTarEntry()) != null) {

            // 文件
            String dir = destFile.getPath() + File.separator + entry.getName();

            File dirFile = new File(dir);

            // 文件检查
            fileProber(dirFile);

            if (entry.isDirectory()) {
                dirFile.mkdirs();
            } else {
                dearchiveFile(dirFile, tais);
            }

        }
    }

    /**
     * 文件 解归档
     *
     * @param srcPath
     *            源文件路径
     *
     * @throws Exception
     */
    public static void dearchive(String srcPath) throws Exception {
        File srcFile = new File(srcPath);

        dearchive(srcFile);
    }

    /**
     * 文件 解归档
     *
     * @param srcPath
     *            源文件路径
     * @param destPath
     *            目标文件路径
     * @throws Exception
     */
    public static void dearchive(String srcPath, String destPath)
            throws Exception {

        File srcFile = new File(srcPath);
        dearchive(srcFile, destPath);
    }

    /**
     * 文件解归档
     *
     * @param destFile
     *            目标文件
     * @param tais
     *            TarArchiveInputStream
     * @throws Exception
     */
    private static void dearchiveFile(File destFile, TarArchiveInputStream tais)
            throws Exception {

        BufferedOutputStream bos = new BufferedOutputStream(
                new FileOutputStream(destFile));

        int count;
        byte data[] = new byte[BUFFER];
        while ((count = tais.read(data, 0, BUFFER)) != -1) {
            bos.write(data, 0, count);
        }

        bos.close();
    }

    /**
     * 文件探针
     *
     * <pre>
     * 当父目录不存在时，创建目录！
     * </pre>
     *
     * @param dirFile
     */
    private static void fileProber(File dirFile) {

        File parentFile = dirFile.getParentFile();
        if (!parentFile.exists()) {

            // 递归寻找上级目录
            fileProber(parentFile);

            parentFile.mkdir();
        }

    }
}
