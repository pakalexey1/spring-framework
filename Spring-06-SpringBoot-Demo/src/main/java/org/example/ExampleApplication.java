package org.example;

import org.example.model.Comment;
import org.example.service.CommentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ExampleApplication {

    public static void main(String[] args) {

        Comment comment = new Comment();
        comment.setAuthor("Johnson");
        comment.setText("Spring Framework");

        ApplicationContext context = SpringApplication.run(ExampleApplication.class, args);

        CommentService cs = context.getBean(CommentService.class);
        cs.publishComment(comment);


    }

}
