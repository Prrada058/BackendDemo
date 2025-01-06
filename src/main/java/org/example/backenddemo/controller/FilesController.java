package org.example.backenddemo.controller;

import org.example.backenddemo.entity.Files;
import org.example.backenddemo.mapper.FilesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import static com.google.common.io.Files.getFileExtension;

@RestController
public class FilesController {

    @Autowired
    private FilesMapper filesMapper;


    public String up(MultipartFile file) throws IOException {
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getContentType());
        String path = System.getProperty("user.dir") + "/data/upload/";
        System.out.println(path);
        return saveFile(file, path);

    }

    public String saveFile(MultipartFile input_file, String path) throws IOException {
        File dir = new File(path);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        String fileExtension = getFileExtension(input_file.getOriginalFilename());

        String newFileName = UUID.randomUUID() + "." + fileExtension;

        File file = new File(path + newFileName);
        input_file.transferTo(file);

        Files file1 = new Files(newFileName, path + newFileName);
        filesMapper.insert(file1);

        return newFileName;
    }


}