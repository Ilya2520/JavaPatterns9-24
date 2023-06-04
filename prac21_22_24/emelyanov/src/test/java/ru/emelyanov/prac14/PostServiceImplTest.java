package ru.emelyanov.prac14;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.emelyanov.prac14.models.Post;
import ru.emelyanov.prac14.repositories.PostRepository;
import ru.emelyanov.prac14.service.PostService;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class PostServiceImplTest {

    @Mock
    private PostRepository postRepository;

    @Captor
    ArgumentCaptor<Post> captor;

    @Test
    void getpost() {

        Post post = new Post();
        post.setName("POST1");

        Post post2 = new Post();
        post2.setName("POST2");

        Mockito.when(postRepository.findAll()).thenReturn(List.of(post, post2));

        PostService postService = new PostService(postRepository);
        Assertions.assertEquals(2, postService.findAll().size());
        Assertions.assertEquals("POST1", postService.findAll().get(0).getName());

    }


    @Test
    void create() {

        Post post = new Post();
        post.setName("POST1");

        PostService postService = new PostService(postRepository);

        postService.create(post);

        Mockito.verify(postRepository).save(captor.capture());
        Post captured = captor.getValue();

        Assertions.assertEquals("POST1", captured.getName());
    }
}