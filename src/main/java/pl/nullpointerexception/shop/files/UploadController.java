package pl.nullpointerexception.shop.files;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RestController("/api")
class UploadController {
    @Autowired
    private FileContentStore contentStore;
    @Autowired
    private FileRepository filesRepo;

    @GetMapping("/list")
    List<String> getFiles() {
        return null;
//        return filesRepo.findAll().stream().map(file -> file.getId() + " : " + file.getName()).toList();
    }

    @PostMapping("/uploadMultipart")
    Long uploadMultipart(@RequestParam("file") MultipartFile input) throws IOException {
        File file = new File();
        file.setContentMimeType(input.getContentType());

        InputStream inputStream = input.getInputStream();
        file.setName(input.getOriginalFilename());
        file.setSummary("adopfiasopdfiaospdifasopd");
        contentStore.setContent(file, inputStream);
        filesRepo.save(file);
        return file.getId();
    }
}
