package com.nixsolutions;

import com.nixsolutions.apiTests.createCompany.CreateNewCompany;
import com.nixsolutions.apiTests.createNewUsers.CreateNewUserWithTask;
import com.nixsolutions.apiTests.createNewUsers.CreateNewUsersWithoutTasks;
import com.nixsolutions.dataProvider.DataProviderClass;
import org.testng.annotations.Test;

public class FinalAPI {

    CreateNewUsersWithoutTasks createNewUsersWithoutTasks = new CreateNewUsersWithoutTasks();
    CreateNewUserWithTask createNewUserWithTask = new CreateNewUserWithTask();
    CreateNewCompany createNewCompany = new CreateNewCompany();

    //API
    //create new user

    @Test(dataProvider = "data-provider-new-user", dataProviderClass = DataProviderClass.class, groups = "api_user")
    public void verificationRegisterNewUser(String email, String name, String password) {
        createNewUsersWithoutTasks.registerNewUser(email, name, password);
    }

    @Test(dataProvider = "data-provider-exist-user-name", dataProviderClass = DataProviderClass.class, groups = "api_user")
    public void verificationUserNameExist(String email, String name, String password) {
        createNewUsersWithoutTasks.UserNameExist(email, name, password);
    }

    @Test(dataProvider = "data-provider-exist-user-email", dataProviderClass = DataProviderClass.class, groups = "api_user")
    public void verificationUserEmailExist(String email, String name, String password) {
        createNewUsersWithoutTasks.UserEmailExist(email, name, password);
    }

    @Test(dataProvider = "data-provider-login-user", dataProviderClass = DataProviderClass.class, groups = "api_user")
    public void verificationUserLogIn(String email, String password) {
        createNewUsersWithoutTasks.UserLogIn(email, password);
    }

    @Test(dataProvider = "data-provider-incorrect-login-user", dataProviderClass = DataProviderClass.class, groups = "api_user")
    public void verificationUserIncorrectLogIn(String email, String password) {
        createNewUsersWithoutTasks.UserIncorrectLogIn(email, password);
    }

    //create createuserwithtasks

    @Test(dataProvider = "data-provider-user-with-task", dataProviderClass = DataProviderClass.class, groups = "api_user_with_task")
    public void verificationCreateUserWithTask(String email, String name, String title1, String desc1, String title2, String desc2,
                                               String comp1, String comp2, String hobby, String address, String name1, String surname1,
                                               String fathername1, String cat, String dog, String parrot, String cavy,
                                               String hamster, String squirrel, String phone, String inn, String gender,
                                               String birthday, String dateStart) {
        createNewUserWithTask.createUserWithTask(email, name, title1, desc1, title2, desc2, comp1, comp2, hobby, address, name1,
                surname1, fathername1, cat, dog, parrot, cavy, hamster, squirrel, phone, inn, gender, birthday, dateStart);
    }

    //create Company

    @Test(dataProvider = "data-provider-creation-company", dataProviderClass = DataProviderClass.class, groups = "api_company")
    public void verificationCreateCompany(String companyName, String companyType, String companyUser1,
                                          String companyUser2, String emailOwner) {
        createNewCompany.createNewOrganization(companyName, companyType, companyUser1, companyUser2, emailOwner);
    }

    @Test(dataProvider = "data-provider-creation-company-wrong-owner", dataProviderClass = DataProviderClass.class, groups = "api_company")
    public void verificationCreateCompanyWithWrongOwner(String companyName, String companyType, String companyUser1,
                                                        String companyUser2, String emailOwner) {
        createNewCompany.createOrganizationWithWrongOwner(companyName, companyType, companyUser1, companyUser2, emailOwner);
    }

    @Test(dataProvider = "data-provider-creation-company-without-users", dataProviderClass = DataProviderClass.class, groups = "api_company")
    public void verificationCreateCompanyWithoutUsers(String companyName, String companyType, String companyUser1,
                                                      String companyUser2, String emailOwner) {
        createNewCompany.createOrganizationWithoutUsers(companyName, companyType, companyUser1, companyUser2, emailOwner);
    }

    @Test(dataProvider = "data-provider-creation-company-with-wrong-type", dataProviderClass = DataProviderClass.class, groups = "api_company")
    public void verificationCreateCompanyWithWrongType(String companyName, String companyType, String companyUser1,
                                                       String companyUser2, String emailOwner) {
        createNewCompany.createOrganizationWithWrongType(companyName, companyType, companyUser1, companyUser2, emailOwner);
    }

}
