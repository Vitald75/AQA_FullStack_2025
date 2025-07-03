package eu.senla.core;


public final class ConstantsClass {

    public static final String MAIN_URL = ReadPropertiesFile.getProperty("MAIN_URL");
    public static final String DASHBOARD_URL = "/dashboard/index";
    public static final String WEB_EP = "/web/index.php";
    public static final String AUTH_LOGIN_URL = "/auth/login";
    public static final String AUTH_VALIDATE_URL = "/auth/validate";
    public static final String PIM_URL = "/pim/viewEmployeeList";
    public static final String PIM_DETAILS_URL = "/pim/viewPersonalDetails/empNumber";
    public static final String RECRUITMENT_VIEW_URL = "/recruitment/viewCandidates";
    public static final String RECRUITMENT_ADD_URL = "/recruitment/addCandidate";
    public static final String ASSIGN_LEAVE_URL = "/leave/assignLeave";

    public static final String API_EP = "/web/index.php/api/v2";
    public static final String LEAVE_API_URL = "/leave/leave-entitlements";
    public static final String PIM_EMPLOYEE_API_URL = "/pim/employees/";

    private  ConstantsClass() {
        // Предотвращение создания экземпляра
    }
}
