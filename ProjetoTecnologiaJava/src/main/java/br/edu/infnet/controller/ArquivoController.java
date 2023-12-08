package br.edu.infnet.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import br.edu.infnet.domain.Arquivo;

import org.springframework.ui.Model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Controller
public class ArquivoController {

    @GetMapping("/upload")
    public String showUploadForm() {
        return "upload";
    }

    @PostMapping("/upload")
    public String handleFileUpload(@RequestParam("file") MultipartFile file, Model model) {
        if (!file.isEmpty()) {
            try {
                InputStreamReader reader = new InputStreamReader(file.getInputStream());
                BufferedReader br = new BufferedReader(reader);
                StringBuilder content = new StringBuilder();
                String line;
                while ((line = br.readLine()) != null) {
                    content.append(line).append("\n");
                }
                br.close();
                reader.close();

                Arquivo fileContent = new Arquivo();
                fileContent.setConteudo(content.toString());

                model.addAttribute("fileContent", fileContent);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "uploadResult";
    }
}
