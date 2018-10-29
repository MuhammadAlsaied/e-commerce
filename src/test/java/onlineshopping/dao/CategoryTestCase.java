package onlineshopping.dao;

import onlineshopping.dao.CategoryDAO;
import onlineshopping.dto.Category;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by @author Muhammed Alsaied On Jul 27, 2018
 * muhammadalsaied96@gmail.com
 */
public class CategoryTestCase {

    private static AnnotationConfigApplicationContext context;
    private static CategoryDAO categoryDAO;
    private Category category;

    @BeforeClass
    public static void ini() {
        context = new AnnotationConfigApplicationContext();
        context.scan("onlineshopping");
        context.refresh();
        categoryDAO = context.getBean("categoryDAO", CategoryDAO.class);
    }

    @Test
    public void testCRUDOperationst() {
        long intialCount = categoryDAO.count();
        category = new Category();
        category.setName("Mobile");
        category.setDescription("Sony - Samsung - Apple - etc...");
        assertEquals("Adding category to database...", true, categoryDAO.insert(category));

        assertEquals("checking number of categories in database", intialCount + 1, (long) categoryDAO.count());

        category.setName("Android");
        assertEquals("updating category...", true, categoryDAO.update(category));
        assertEquals("checking updated category", "Android", categoryDAO.get(category.getId()).getName());

        assertEquals("deleting category ...", true, categoryDAO.delete(category));

        assertEquals("checking number of categories in database", intialCount, (long) categoryDAO.count());

    }

}
