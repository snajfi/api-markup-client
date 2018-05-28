package cz.api.markup.client.tests.integrations;

import cz.api.markup.client.exceptions.CanNotGetClassesException;
import cz.api.markup.client.exceptions.NoClassesFoundInGivenPackageException;
import cz.api.markup.client.pojos.api.ApiPojo;
import cz.api.markup.client.services.ApiService;
import cz.api.markup.client.services.ClassesOperationService;
import cz.api.markup.client.services.UtilsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertFalse;

/**
 *  Tests for {@link ApiService} class.
 *  @author Filip Snajdr, fsnajdr86(at)gmail.com
 */
@RunWith(MockitoJUnitRunner.class)
public class ApiServiceIT {

    @Spy
    private UtilsService utilsService = new UtilsService();

    @Spy
    private ClassesOperationService classesOperationService = new ClassesOperationService();

    @InjectMocks
    private ApiService apiService = new ApiService();

    @Test
    public void apiServiceTest() throws NoClassesFoundInGivenPackageException, CanNotGetClassesException {

        ApiPojo apiPojo = apiService.getApiPojo();

        assertFalse(apiPojo.getEndPoints().isEmpty());


    }

}
