package com.codegym.controllers;

import com.codegym.models.ImageComment;
import com.codegym.repositories.ImageCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private ImageCommentRepository imageCommentRepository;

    @GetMapping("/")
    public String getIndexPage() {
        return "index";
    }

    @ModelAttribute("imgList")
    public List<ImageComment> getImageComments() {
        return imageCommentRepository.findAll();
    }

    @GetMapping("/img-of-the-day")
    public String getImgPage() {
        return "img-of-the-day";
    }

    @PostMapping("/img-of-the-day")
    public String createImgComment(@ModelAttribute ImageComment imageComment) {
        imageCommentRepository.save(imageComment);
        return "redirect:/img-of-the-day";
    }

    @GetMapping("/img-of-the-day/{id}/like")
    public String createImgComment(@PathVariable Long id) {
        ImageComment imageComment = imageCommentRepository.findById(id);
        imageComment.setLikes( imageComment.getLikes() + 1 );
        imageCommentRepository.save(imageComment);
        return "redirect:/img-of-the-day";
    }
}
