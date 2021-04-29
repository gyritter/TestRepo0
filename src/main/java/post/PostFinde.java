package post;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PostFinde {

    private List<Post> posts;

    public PostFinde(List<Post> posts) {
        this.posts = posts;
    }

    public List<Post> findPostsFor(String user) {

        List<Post> result = new ArrayList<>();

        for (Post p : posts) {
            if (p.getOwner()!=null && p.getOwner().equals(user) &&
                    p.getPublishedAt().isBefore(LocalDate.now())
                    && !p.getContent().isEmpty() && !p.getTitle().isEmpty()) {
                result.add(p);
            }
        }
        return result;
    }
}

