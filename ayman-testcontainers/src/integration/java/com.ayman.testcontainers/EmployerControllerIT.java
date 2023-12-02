package com.ayman.testcontainers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.ayman.testcontainers.employee.model.Employee;
import com.ayman.testcontainers.employee.model.Employees;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@SpringBootTest(classes = TestcontainersApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
//@RunWith(SpringRunner.class) // Junit 4
@ExtendWith(SpringExtension.class) // Junit 5
@ContextConfiguration(initializers = ConfigFileApplicationContextInitializer.class)
//@ActiveProfiles("test")
@TestPropertySource("classpath:h2-database.properties")
public class EmployerControllerIT
{
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Sql({"../../../h2-data-schema.sql"})
    @Test
    public void testAllEmployees()
    {
        assertTrue(
                this.restTemplate
                        .getForObject("http://localhost:" + port + "/employees", Employees.class)
                        .getEmployeeList().size() == 3);
    }

    @Test
    public void testAddEmployee() {
        Employee employee = new Employee("Lokesh", "Gupta", "howtodoinjava@gmail.com");
        ResponseEntity<String> responseEntity = this.restTemplate
                .postForEntity("http://localhost:" + port + "/employees", employee, String.class);
        assertEquals(201, responseEntity.getStatusCodeValue());
    }
}