package by.overone.it.validation;

public class RegexValidation {

    public static boolean checkEmailFormat(String email) {
        if (email != null) {
            String emailRegex = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{1,5}|[0-9]{1,3})(\\]?)$";
            return email.trim().matches(emailRegex);
        } else {
            return false;
        }
    }

    public static boolean checkTelephoneFormat(String telephone) {
        if (telephone != null) {
            String telephoneRegex = "^(\\+375|80)(29|25|44|33)(\\d{3})(\\d{2})(\\d{2})$";
            return telephone.matches(telephoneRegex);
        } else {
            return true;
        }
    }

    public static boolean checkPasswordFormat(String password) {
        if (password != null) {
            String passwordRegex = "(?=.*[0-9])(?=.*[a-z])[0-9a-zA-Z!@#$%^&*]{6,30}";
            return password.matches(passwordRegex);
        } else {
            return false;
        }
    }
}
