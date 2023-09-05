package com.project;

import java.io.IOException;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.project.dao.UserDAO;
import com.project.model.MyClass;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/ms1")
public class Controller_ms1
{
    @Autowired
    UserDAO user;
    
    //OBJECT TRANSFER FROM 8080 TO OTHER SERVICE HOSTED ON 8082
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/pass-object")
    public ResponseEntity<Object> passObjectToMs2() {
        MyClass myObject = new MyClass();
        myObject.setId(1);
        myObject.setName("OBJECT FROM CONTROLLER MS1");
        
        try {
			Socket s =new Socket("localhost", 4059);
		

        // SEND THE OBJECT TO CONTROLLER_MS2
        ResponseEntity<Object> response = restTemplate.postForEntity(
            "http://localhost:8082/ms2/receive-object",
            s,
            Object.class
        );

        return ResponseEntity.ok(response.getBody());
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
    }
    
    //MICROSERVICES IMPLEMENTATION
    @GetMapping("/empidpass/{empid}")
    public String getforms1(@PathVariable int empid)
    {
		return user.getdetailms1(empid);
    }
    
    //Dynamic Column Name and empid
    @GetMapping("column/{coloumnName}/empid/{empid}")
    public List<Map<String, Object>> getEmployeeById(@PathVariable String coloumnName ,@PathVariable int empid) 
    {
    	//Here employee is table name and for given id
    	return user.getDetails(coloumnName, empid);
    }
    //Login Logout Merge
    
    @PostMapping("/insertidpass")
    public String addLoginCred(@RequestBody Map<String, Object> loginCred, HttpServletRequest request) 
    {
    	// validate is the table name
    	String tableName = "validate"; 
    	
    	// Saving entry time
        LocalDateTime entryTime = LocalDateTime.now();
        
        // Saving IP 
        String reqIp = request.getRemoteAddr();
        
        //IP Whitelisting for one IP
        if(reqIp == "0:0:0:0:0:0:0:1")
        {
        	String[] columns = {"userid", "password","data","loginTime","reqIp"};
        	Object[] values = { loginCred.get("userid"), loginCred.get("password"),loginCred.get("data"),
        			entryTime,reqIp };
        	
        	return user.insertLoginCred(tableName, columns, values);
        }
        else
        {
        	return "You cannot access the API";
        }
    }
    @GetMapping("getdata/id/{userid}/pass/{password}")
	public List<Map<String, Object>> getDataAfterLogin(@PathVariable String userid, @PathVariable String password)
	{
		return user.getDetailsByIdPass(userid,password);
	}
    //Login Logout Merge Completed
    
    
    //Dynamic ORDER BY 
    @GetMapping("employee/{orderByColumn}")
    public List<Map<String, Object>> getEmployeesOrderedBy(@PathVariable String orderByColumn) 
    {
        return user.getDetailsOrderedBy(orderByColumn);
    }
    //Dynamic HAVING with GROUP BY 
    @GetMapping("/employee/age/{empAge}/id/{empId}")
    public List<Map<String, Object>> getEmployeesByAgeAndId(@PathVariable int empAge, @PathVariable int empId) 
    {
        return user.getEmployeesByAgeAndId(empAge, empId);
    }
    
    //GROUP BY Dynamic Selection of 2 coloumns and give coloumn names in Postman 
    @GetMapping("employee/groupBy/{column1}/{column2}")
    public List<Map<String, Object>> getEmployeesGroupedBy(@PathVariable String column1, @PathVariable String column2) 
    {
        return user.getDetailsGroupedBy(column1, column2);
    }
    //Dynamic DISTINCT Selection for 2 columns
    @GetMapping("employee/distinct/column1/{coloumnName1}/column2/{coloumnName2}")
    public List<Map<String, Object>> getEmployeeById(@PathVariable String coloumnName1 ,@PathVariable String coloumnName2) 
    {
       //Here employee is table name and for given id
        return user.getDetailsDistinct(coloumnName1, coloumnName2);
    }
    //Dynamic LIMIT set with one condition and Limit as input
    @GetMapping("/employee/column1/{columnName}/columnvalue/{columnNameValue}/limit/{lit}")
    public List<Map<String, Object>> getEmployeesByLimit(@PathVariable String columnName, 
    		@PathVariable int columnNameValue, @PathVariable int lit) 
    {
        return user.getDetailsLimit(columnName, columnNameValue, lit);
    }
    // New Employee Addition
    @PostMapping("addEmployee")
    public String addNewEmployee(@RequestBody Map<String, Object> employeeData) 
    {
        
    	// Assuming "employee" is the default table name
    	String tableName = "employee"; 

        String[] columns = { "empid", "emp_name", "emp_salary", "emp_age", "emp_city" };
        Object[] values = { employeeData.get("empid"), employeeData.get("emp_name"),
                            employeeData.get("emp_salary"), employeeData.get("emp_age"),
                            employeeData.get("emp_city") };

        return user.insertEmployeeData(tableName, columns, values);
    }
    
    @PutMapping("employee/{empid}/{empName}")
    public ResponseEntity<String> updateEmployee(@PathVariable int empid, @PathVariable String empName) 
    {
        if (empName == null || empName.isEmpty()) {
            return ResponseEntity.badRequest().body("Employee name must be provided for updating.");
        }

        String result = user.updateEmployeeData(empid, empName);
        
        if (result.startsWith("Failed")) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
        }

        return ResponseEntity.ok(result);
    }
    @DeleteMapping("employee/{empid}")
    public ResponseEntity<String> deleteEmployee(@PathVariable int empid) 
    {
        String result = user.deleteEmployeeData(empid);
        
        if (result.startsWith("Failed")) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
        }

        return ResponseEntity.ok(result);
    }
}
