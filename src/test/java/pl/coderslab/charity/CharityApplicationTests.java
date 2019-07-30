package pl.coderslab.charity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.coderslab.charity.entity.Category;
import pl.coderslab.charity.repository.CategoryRepository;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CharityApplication.class)
public class CharityApplicationTests {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void shouldGetCategories() {
        //given
        int expectedCategoriesCount = 3;

        //when
        List<Category> categoryList = categoryRepository.findAll();

        //then
        assertEquals(expectedCategoriesCount, categoryList.size());

    }
}

