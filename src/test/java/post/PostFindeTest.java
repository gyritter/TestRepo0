package post;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PostFindeTest {

    @Test
    public void postFinderTest() {
        List<Post> posts = new ArrayList<>();
        posts.add(new Post("Felszólítás", LocalDate.of(2020, 12, 01),
                "Fizess!", null));
        posts.add(new Post("Felszólítás2", LocalDate.of(2020, 12, 31),
                "Fizess!", "John Doe"));
        posts.add(new Post("Üzenet", LocalDate.of(2021, 12, 31),
                "Fizess!", "John Doe"));
        posts.add(new Post("NAV", LocalDate.of(2019, 12, 03),
                "Fizess!", "John Doe"));
        posts.add(new Post("Hivatal", LocalDate.of(2021, 01, 31),
                "Kártya!", "Jane"));
        posts.add(new Post("Felszólítás3", LocalDate.of(2020, 12, 31),
                "Fizess!", "Jack"));
        PostFinde postFinder = new PostFinde(posts);

        assertEquals(2, postFinder.findPostsFor("John Doe").size());
        System.out.println(postFinder.findPostsFor("John Doe").get(0).toString());
    }


}