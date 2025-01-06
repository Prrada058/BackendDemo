package org.example.backenddemo.service;

import org.example.backenddemo.entity.Files;
import org.example.backenddemo.mapper.FilesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {
    @Autowired
    private FilesMapper filesMapper;

    @Override
    public String uploadFile(MultipartFile file, String path) throws IOException {
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getContentType());
        String absolutePath = System.getProperty("user.dir") + "/data/upload/" + path + "/";
        System.out.println(absolutePath);
        return saveFile(file, absolutePath);
    }

    public String saveFile(MultipartFile inputFile, String path) throws IOException {
        // 确保目录存在
        File dir = new File(path);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        // 获取文件扩展名
        String fileExtension = getFileExtension(inputFile.getOriginalFilename());

        // 生成唯一文件名
        String newFileName = UUID.randomUUID() + "." + fileExtension;

        // 保存文件到目标路径
        File file = new File(path + newFileName);
        inputFile.transferTo(file);

        // 将文件信息保存到数据库
        Files fileRecord = new Files(newFileName, path + newFileName);
        filesMapper.insert(fileRecord);

        return newFileName;
    }

    // 获取文件扩展名的辅助方法
    private String getFileExtension(String originalFilename) {
        if (originalFilename == null || !originalFilename.contains(".")) {
            return "";
        }
        return originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
    }
}
