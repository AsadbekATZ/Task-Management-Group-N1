package org.example.ui.workWithUsers;

import org.example.model.user.User;
import org.example.model.user.UserRole;
import org.example.service.user.UserServiceImpl;
import org.example.util.ScannerUtil;

import java.util.ArrayList;
import java.util.InputMismatchException;

public class WorkWithUsersUI implements ScannerUtil {

    static UserServiceImpl userService = new UserServiceImpl();
    public static void workWithUsers() {
        String stepCode;
        while (true) {
            System.out.println("""
                    1. User list
                    0. Back""");
            stepCode = scannerStr.nextLine();
            if (stepCode.equals("1")) {
                UserOperationsUI.userOperations(userSelector());
            }else if(stepCode.equals("0")){
                return;
            }
        }
    }
    public static User userSelector() {
        System.out.println("""
                Choose user type: 
                1. Business analyst
                2. Scrum master
                3. Frontend lead
                4. Backend lead
                5. Quality assurance
                6. Tester
                7. Frontend developer
                8. Backend developer
                9. User
                """);
        UserRole userType = null;
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
            default -> userSelector();
        }
        int cnt = 0;
        if (listByRole(userType).isEmpty()){
            System.out.println("There is no any users in this role!");
            System.out.print("Press any key to go back: ");
            scannerStr.nextLine();
            userSelector();
        }
        for (User user : listByRole(userType)) {
            System.out.println("********" + ++cnt + "********");
            System.out.println(user);
            System.out.println("*************************");
        }
        System.out.print("Choose user you want to operate: ");
        int choose1 = 0;
        try {
            choose1 = scannerInt.nextInt();
        }catch (InputMismatchException e){
            System.out.println("Wrong input please try again!");
            scannerInt.nextLine();
        }
        if (choose1 < 1 && choose1 >= listByRole(userType).size()){
            userSelector();
        }
        System.out.println(listByRole(userType).get(choose1-1));
        return listByRole(userType).get(choose1-1);
    }
    public static ArrayList<User> listByRole(UserRole role){
        ArrayList<User> temp = new ArrayList<>();
        for (User user : userService.getUserList()) {
            if (user.getRole().equals(role)){
                temp.add(user);
            }
        }
        return temp;
    }
}
