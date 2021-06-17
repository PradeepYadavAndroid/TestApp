package com.example.pacewisdom.ServerApis;

public class ServerApiPatient {



    public static String MAIN_IP="http://appointoservices.bsninfotech.org";
    public static String MAIN_IPLINK="";

    public static String FONT="OpenSans-Semibold.ttf";

    public static String FONT_DASHBOARD="futuramediumbt.ttf";


    public static String PAITENT_SIGNUP= MAIN_IP+"/Common.svc/mobile/InsertUpdateDeleteAccount";
    public static String PAITENT_SIGNUP_SECOND= MAIN_IP+"/Common.svc/mobile/SendCode";
    public static String CODEVERIFY= MAIN_IP+"/Common.svc/mobile/AccessAccount";
    public static String SPECIALIZATION= MAIN_IP+"/Common.svc/mobile/universal";
    public static String PATIENTPRO_FILE_API= MAIN_IP+"/Patient.svc/mobile/InsertUpdateDeletePatientProfile";
    public static String PAITENT_GET_DATA_API= MAIN_IP+"/Patient.svc/mobile/PatientProfile";
    public static String DOCTOR_LIST_API= MAIN_IP+"/Search.svc/mobile/SearchProfile";
    public static String DOCTOR_DETAILS_API= MAIN_IP+"/DoctorClinic.svc/mobile/ClinicProfile";
    public static String BOOKAPPOINTMENT_API= MAIN_IP+"/Appointment.svc/mobile/InsertUpdateDeleteAppointment";
    public static String BOOKAPPOINTMENTDETAILS_API= MAIN_IP+"/Appointment.svc/mobile/Appointments";
    public static String MEMBERDELETE_API= MAIN_IP+"/Patient.svc/mobile/InsertUpdateDeletePatientProfile";
    public static String CLINIC_SERVICES= MAIN_IP+"/Common.svc/mobile/NotificationList";
    public static String COMPLETEDAPPOINTMENT_API= MAIN_IP+"/Appointment.svc/mobile/InsertUpdateDeleteAppointment";
    public static String NOTIFICATION_UPDATE_API= MAIN_IP+"/Common.svc/mobile/InsertUpdateNotification";
    public static String CHECKURL_API= MAIN_IP+"/Common.svc/mobile/GenerateCheckSum";
    public static String PAYMEMENTUPDATE_API= MAIN_IP+"/Common.svc/mobile/UpdateTransactions";
    public static String NOTIFICATIONUPDATE_API= MAIN_IP+"/Common.svc/mobile/InsertUpdateNotification";
    public static String CONTACTUS_API= MAIN_IP+"/Common.svc/mobile/InsertQuery";
    public static String CLINICALL_API= MAIN_IP+"/DoctorClinic.svc/mobile/ClinicProfile";

}
