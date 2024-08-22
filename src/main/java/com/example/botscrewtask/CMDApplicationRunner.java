package com.example.botscrewtask;

import com.example.botscrewtask.model.Degree;
import com.example.botscrewtask.model.Department;
import com.example.botscrewtask.model.Lector;
import com.example.botscrewtask.repository.DegreeRepository;
import com.example.botscrewtask.repository.DepartmentRepository;
import com.example.botscrewtask.repository.LectorRepository;
import com.example.botscrewtask.service.DepartmentService;
import com.example.botscrewtask.service.LectorService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Scanner;

@Component
@RequiredArgsConstructor
public class CMDApplicationRunner implements CommandLineRunner {
    private final DepartmentRepository departmentRepository;
    private final LectorRepository lectorRepository;
    private final DegreeRepository degreeRepository;
    private final DepartmentService departmentService;
    private final LectorService lectorService;


    @Override
    public void run(String... args) {
        initializeData();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter command:");
            String command = scanner.nextLine().trim();

            if (command.startsWith("Who is head of department ")) {
                String departmentName = command.substring("Who is head of department ".length());
                System.out.println(departmentService.getHeadOfDepartment(departmentName));
            } else if (command.startsWith("Show ")){
                if (command.contains(" statistics")){
                    String departmentName = command.substring("Show ".length(), command.indexOf(" statistics"));
                    System.out.println(departmentService.getDepartmentStatistics(departmentName));
                } else if (command.contains(" the average salary for the department ")) {
                String departmentName = command.substring("Show the average salary for the department ".length());
                System.out.println(departmentService.getAverageSalary(departmentName));
                } else if (command.contains(" count of employee for ")) {
                String departmentName = command.substring("Show count of employee for ".length());
                System.out.println(departmentService.getCountOfEmployee(departmentName));
                }
            }
              else if (command.startsWith("Global search by ")) {
                String template = command.substring("Global search by ".length());
                System.out.println(lectorService.globalSearch(template));
            }
            else if(command.equals("quit")) {
                break;
            }
            else {
                System.out.println("Unknown command");
            }
        }
    }


    private void initializeData() {
        try {
            Degree assistant = new Degree(null, "Assistant");
            Degree associateProfessor = new Degree(null, "Associate Professor");
            Degree professor = new Degree(null, "Professor");
            degreeRepository.save(assistant);
            degreeRepository.save(associateProfessor);
            degreeRepository.save(professor);

            Department computerScience = new Department(null, "Computer Science", null, new HashSet<>());
            Department design = new Department(null, "Design", null, new HashSet<>());
            Department peopleOperations = new Department(null, "People Operations", null, new HashSet<>());
            Department itDepartment = new Department(null, "IT Department", null, new HashSet<>());
            Department criminal = new Department(null, "Criminal", null, new HashSet<>());
            departmentRepository.save(computerScience);
            departmentRepository.save(design);
            departmentRepository.save(peopleOperations);
            departmentRepository.save(itDepartment);
            departmentRepository.save(criminal);

            Lector lector1 = new Lector(null, "Dima Radionov", associateProfessor, 1000, new HashSet<>());
            Lector lector2 = new Lector(null, "Elmira Radionova", professor, 4000, new HashSet<>());
            Lector lector3 = new Lector(null, "Michael Jackson", assistant, 200, new HashSet<>());
            Lector lector4 = new Lector(null, "Mike Bell", professor, 3500, new HashSet<>());
            Lector lector5 = new Lector(null, "Franklin Clinton", assistant, 400, new HashSet<>());
            lectorRepository.save(lector1);
            lectorRepository.save(lector2);
            lectorRepository.save(lector3);
            lectorRepository.save(lector4);
            lectorRepository.save(lector5);

            lector1.getDepartments().add(computerScience);
            lector1.getDepartments().add(design);
            lector1.getDepartments().add(peopleOperations);
            lector2.getDepartments().add(design);
            lector2.getDepartments().add(itDepartment);
            lector3.getDepartments().add(computerScience);
            lector3.getDepartments().add(design);
            lector4.getDepartments().add(computerScience);
            lector4.getDepartments().add(peopleOperations);
            lector4.getDepartments().add(itDepartment);
            lector5.getDepartments().add(criminal);
            lectorRepository.save(lector1);
            lectorRepository.save(lector2);
            lectorRepository.save(lector3);
            lectorRepository.save(lector4);
            lectorRepository.save(lector5);

            computerScience.setHeadOfDepartment(lector1);
            peopleOperations.setHeadOfDepartment(lector4);
            design.setHeadOfDepartment(lector2);
            design.setHeadOfDepartment(lector5);
            departmentRepository.save(computerScience);
            departmentRepository.save(design);
            departmentRepository.save(peopleOperations);
            departmentRepository.save(criminal);
        }
        catch (Exception e) {
            System.out.println("Data already initialized");
        }
    }
}
