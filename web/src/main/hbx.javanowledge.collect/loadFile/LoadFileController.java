package loadFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Created by huangbaoxian on 2018/3/6.
 */
public class LoadFileController {

    /**
     **
     * 1 下载excel文件处理方
     *
     *  1 数据量大的要求 ，应该存储第三， 因为后端处理数据耗时， 前端迟迟没有反应，
     *    解决方案就是： 1 写个死循环， 不停的对前端做出数据会有，保持连接
     *                2 生成文件，存在本地或者三方盘，生成链接下载
     *
     *
    * */

    void downloadAction() {

        //下载代码
        HSSFWorkbook * wb ;
        String agent = request.getHeader("User-Agent");
        outputStream = response.getOutputStream();
        response.reset();
        //设置文件名
        String fileName = new SimpleDateFormat("yyyyMMdd").format(new Date())  +".xls";
        response.setHeader("Content-disposition", "attachment; filename="+ EcoinV2Controller.encodeFileName(request,fileName));
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        wb.write(outputStream);
        outputStream.flush();

    }

    /**
     * 把生成的excel转化为文件存在本地
     *
     *
    * */

    void  convert(){

        HSSFWorkbook * book ;
        long time = System.currentTimeMillis();
        //文件存储路径
        String systemPath = System.out.println(System.getProperty("user.dir")) + time + ".xls";
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(systemPath);
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
        // 流写完之后就存储在系统下
    }

    /**
    *
     * 使用 又拍云存储文件
     *
     * 1 又拍云账号
     * 2 又拍云存储空间
     * 3 又拍云密码
     *
     * 使用依赖
     *  <dependency>
             <groupId>com.upyun</groupId>
             <artifactId>java-sdk</artifactId>
             <version>3.18</version>
         </dependency>

     *
     * * */

    void uploadToUnpan(){

        /** 账号*/
        String account;
        /** 工作空间*/
        String workSpace;
        /** 密码*/
        String password;




        UpYun upYun = new UpYun(workSpace,account,password);
        upYun.setTimeout(60);
        upYun.setApiDomain(UpYun.ED_AUTO);
        /** systemPath 文件存储当前系统的路径*/
        /** path 文件存储又拍云的路径*/
        File file = new File(systemPath);
        boolean isSuccess =  upYun.writeFile(path,file);

        /** 又拍云下载http生成方式
         *
         *  1 开账号的时候绑定的域名
         *  2 路径为存储的路径
         *  3 前端再次请求服务器，服务器使用重定向功能，下载又拍云
         *
         * */

        /** 重定向方式
         *
         *
         * 1 修改状态码302， response对象sendRedirect
         *
         * 备注：可以使用springmvc 直接调用sendRedirect 就可以了
         * */




    }




    /**
     *
     * 生成excel文件方式
     * */
    void creatExcel() {
        /*
        HSSFSheet  使用框架
            <dependency>
			    <groupId>org.apache.poi</groupId>
			    <artifactId>poi</artifactId>
			    <version>3.10-FINAL</version>
		    </dependency>

		    也可以使用原生框架

		    1 每次可以生成一个 HSSFWorkbook（excel）
            2 每个HSSFWorkbook 可以拥有多个 HSSFSheet 每次HSSFSheet 默认最大行数 63450
            3 HSSFRow 是  HSSFSheet 生成的行数
            4 每行可以拥有多列  HSSFCell

            通过以上4个对象，就可以拥有一个完整的excel

        */


        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet("index");

        // 创建row，添加第0行
        HSSFRow row = sheet.createRow(0);
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        //添加第0行第一列
        HSSFCell cell = row.createCell(0);
        cell.setCellValue("日期");
        cell.setCellStyle(style);


    }



}
