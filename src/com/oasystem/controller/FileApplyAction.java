package com.oasystem.controller;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Controller
public class FileApplyAction {

	@RequestMapping("fileUpload")
	public String  fileUpload(@RequestParam("file") CommonsMultipartFile file) throws IOException {
        
        
        //��������������ʱ��
        long  startTime=System.currentTimeMillis();
        System.out.println("fileName��"+file.getOriginalFilename());
         
        try {
            //��ȡ�����
            OutputStream os=new FileOutputStream("E:/"+new Date().getTime()+file.getOriginalFilename());
            //��ȡ������ CommonsMultipartFile �п���ֱ�ӵõ��ļ�����
            InputStream is=file.getInputStream();
            int temp;
            //һ��һ���ֽڵĶ�ȡ��д��
            while((temp=is.read())!=(-1))
            {
                os.write(temp);
            }
           os.flush();
           os.close();
           is.close();
         
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        long  endTime=System.currentTimeMillis();
        System.out.println("����һ������ʱ�䣺"+String.valueOf(endTime-startTime)+"ms");
        return "/success"; 
    }
}
