package org.example;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import util.Util;

@NoArgsConstructor
@Getter
@Setter

public class Department {

    private String departmentId;
    private String departmentName;
    private static int nextId = 1;

    public Department(String departmentName) {
        if (validateDepartmentName(departmentName)) {
            this.departmentId = "D" + String.format("%02d", nextId++);
            this.departmentName = departmentName;
        } else {
            this.departmentId = null;
            this.departmentName = null;
        }
    }

    /**
     * Checks if a department name is valid.
     * @param departmentName the name of the department to be checked
     * @return true if department name is valid, false if invalid
     */
        public static boolean validateDepartmentName(String departmentName) {
            if (departmentName == null || departmentName.isEmpty()) {
                return false;
            }

            for (int i = 0; i < departmentName.length(); i++) {
                char c = departmentName.charAt(i);
                if (!(c == ' ' || (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))) {
                    return false;
                }
            }

            return true;
        }
    @Override
    public String toString() {
        return "Department{" +
                "departmentId='" + departmentId + '\'' +
                ", departmentName='" + Util.toTitleCase(departmentName) + '\'' +
                '}';
    }
}



