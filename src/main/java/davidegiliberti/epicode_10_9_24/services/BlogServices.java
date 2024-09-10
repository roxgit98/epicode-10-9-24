package davidegiliberti.epicode_10_9_24.services;

import davidegiliberti.epicode_10_9_24.entities.Blog;
import davidegiliberti.epicode_10_9_24.exceptions.NotFoundExceptions;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class BlogServices {
    private List<Blog> blogList = new ArrayList<>();

    public List<Blog> findAll() {
        return this.blogList;
    }

    public Blog saveBlog(Blog body) {
        Random random = new Random();
        body.setId(random.nextInt(1, 900));
        this.blogList.add(body);
        return body;
    }

    public Blog findById(int blogId) {
        Blog found = null;
        for (Blog blog : this.blogList) {
            if (blog.getId() == blogId) found = blog;
        }
        if (found == null) throw new NotFoundExceptions(blogId);
        return found;
    }

    public void delete(int blogId) {
        Blog found = null;
        for (Blog blog : this.blogList) {
            if (blog.getId() == blogId) found = blog;
        }
        if (found == null) throw new NotFoundExceptions(blogId);
        this.blogList.remove(found);
    }

    public Blog findAndUpdate(int blogId, Blog updatedBlog) {
        Blog found = null;
        for (Blog blog : this.blogList) {
            if (blog.getId() == blogId) {
                found = blog;
                found.setCategoria(updatedBlog.getCategoria());
                found.setContenuto(updatedBlog.getContenuto());
                found.setCover(updatedBlog.getCover());
                found.setTitolo(updatedBlog.getTitolo());
                found.setTempoLetturaMinuti(updatedBlog.getTempoLetturaMinuti());

            }

        }
        if (found == null) throw new NotFoundExceptions(blogId);
        return found;
    }
}
