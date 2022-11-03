package miu.hw1.myhw.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Post {
    long id;
    String title;
    String content;
    String author;
}
