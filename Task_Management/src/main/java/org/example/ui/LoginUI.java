package org.example.ui;

import org.example.model.user.User;
import org.example.service.user.UserServiceImpl;
import org.example.ui.userUI.*;
import org.example.util.ScannerUtil;

public class LoginUI implements ScannerUtil {
    static UserServiceImpl userService = new UserServiceImpl();
    public static void login(){
        System.out.print("Enter your email: ");
        String email = scannerStr.nextLine();
        System.out.print("Enter your password: ");
        String password = scannerStr.nextLine();
        System.out.println(userService.login(email, password).getMessage());
        User currentUser = userService.login(email, password).currentUser;
        if (currentUser == null){
            return;
        }
        switch (currentUser.getRole()) {
            case MANAGER -> ManagerUI.managerWindow(currentUser);
            case USER -> UserUI.userWindow(currentUser);
            case BACKEND_DEV -> BackendUI.backendWindow(currentUser);
            case FRONTEND_DEV -> FrontendUI.frontendWindow(currentUser);
            case BE_LEAD ->  BE_LeadUI.be_leadWindow(currentUser);
            case FE_LEAD ->  FE_LeadUI.fe_leadWindow(currentUser);
            case SCRUM_MASTER -> ScrumMasterUI.scrumMasterWindow(currentUser);
            case BUSINESS_ANALYST -> Business_AnalystUI.b_analystWindow(currentUser);
            case QUALITY_ASSURANCE_EN -> QAassurance_UI.qaWindow(currentUser);
            case TESTER -> TesterUI.testerWindow(currentUser);
        }
    }
}
