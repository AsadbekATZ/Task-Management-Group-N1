package org.example.ui.workWithUsers;

import org.example.model.user.User;
import org.example.model.user.UserRole;
import org.example.service.user.ManagerService;
import org.example.util.ScannerUtil;

public class UserOperationsUI implements ScannerUtil {
    static ManagerService managerService = new ManagerService();
    public static void userOperations(User user){
        String stepCode;
        while (true) {
            System.out.println("""
                    1. Remove user
                    2. Change role of user
                    0. Back""");
            stepCode = scannerStr.nextLine();
            switch (stepCode) {
                case "1" -> System.out.println(managerService.removeUser(user).getMessage());
                case "2" -> {
                    System.out.println("""
                        Choose user type: 1. Business analyst
                        2. Scrum master
                        3. Frontend lead
                        4. Backend lead
                        5. Quality assurance
                        6. Tester
                        7. Frontend developer
                        8. Backend developer
                        9. User
                        """);
                    UserRole userType;
                    String choose = scannerStr.nextLine();
                    switch (choose){
                        case "1" -> userType = UserRole.BUSINESS_ANALYST;
                        case "2" -> userType = UserRole.SCRUM_MASTER;
                        case "3" -> userType = UserRole.FE_LEAD;
                        case "4" -> userType = UserRole.BE_LEAD;
                        case "5" -> userType = UserRole.QUALITY_ASSURANCE_EN;
                        case "6" -> userType = UserRole.TESTER;
                        case "7" -> userType = UserRole.FRONTEND_DEV;
                        case "8" -> userType = UserRole.BACKEND_DEV;
                        case "9" -> userType = UserRole.USER;
                        default -> {
                            return;
                        }
                    }
                    System.out.println(managerService.assignRole(user, userType).getMessage());
                }
                case "0" -> {
                    return;
                }
            }
        }
    }
}
