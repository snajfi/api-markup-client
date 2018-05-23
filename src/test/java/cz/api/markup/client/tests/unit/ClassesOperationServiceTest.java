package cz.api.markup.client.tests.unit;

import cz.api.markup.client.exceptions.CanNotGetClassesException;
import cz.api.markup.client.services.ClassesOperationService;
import cz.api.markup.client.tests.data.TestClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 *  Tests for {@link ClassesOperationService} class.
 *  @author Filip Snajdr, fsnajdr86(at)gmail.com
 */
public class ClassesOperationServiceTest {

    private ClassesOperationService classesOperation = new ClassesOperationService();

    @Test
    public void getClassesTestOfValidCall() {
        try {

            List<Class> classes = new ArrayList<>(classesOperation.getClasses(TestClass.class.getPackage().getName()));
            assertTrue(classes.size()==1);

            classes.clear();
            classes.addAll(classesOperation.getClasses("somethingWhatDoNotExist"));
            assertTrue(classes.isEmpty());

        } catch (CanNotGetClassesException e) {
            fail();
        }
    }

}
