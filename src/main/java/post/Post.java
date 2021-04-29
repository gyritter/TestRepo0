package post;

import java.time.LocalDate;

public class Post {

    private String title;
    private LocalDate publishedAt;
    private String content;
    private String owner;

    public String getTitle() {
        return title;
    }

    public LocalDate getPublishedAt() {
        return publishedAt;
    }

    public String getContent() {
        return content;
    }

    public String getOwner() {
        return owner;
    }

    public Post(String title, LocalDate publishedAt, String content, String owner) {
        this.title = title;
        this.publishedAt = publishedAt;
        this.content = content;
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Post{" +
                "title='" + title + '\'' +
                ", publishedAt=" + publishedAt +
                ", content='" + content + '\'' +
                ", owner='" + owner + '\'' +
                '}';
    }
}
