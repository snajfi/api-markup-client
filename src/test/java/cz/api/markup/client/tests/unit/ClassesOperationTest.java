package cz.api.markup.client.tests.unit;

import cz.api.markup.client.reflection.ClassesOperation;
import cz.api.markup.client.tests.data.TestClass;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 *  Tests for {@link ClassesOperation} class.
 *  @author Filip Snajdr, fsnajdr86(at)gmail.com
 */
public class ClassesOperationTests {

    private ClassesOperation classesOperation = new ClassesOperation();

    @Test
    public void getClassesTestOfValidCall() {
        try {
            List<Class> classes = new ArrayList<>();
            classesOperation.getClasses(TestClass.class.getPackage().getName()).forEach(classes::add);

            assertTrue(classes.size()==1);
        } catch (ClassNotFoundException | IOException | URISyntaxException e) {
            fail();
        }
    }

}
