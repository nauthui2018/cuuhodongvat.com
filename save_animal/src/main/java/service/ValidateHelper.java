package service;

import model.Employee;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateHelper {

    public ValidateHelper() {
    }

    public boolean validateFirstName(String name) {
        boolean isValid = true;
        int minLength = 1;
        int maxLengthName = 45;
        String trimmedFirstName = trimmedString(name);
        int lengthFirstName = trimmedFirstName.length();
        Pattern pattern = Pattern.compile("^(?![\\s.]+$)[a-zA-Z\\s.]*$");
        Matcher matcherFirstName = pattern.matcher(trimmedFirstName);
        if (!matcherFirstName.matches()
                || lengthFirstName < minLength
                || lengthFirstName > maxLengthName) {
            isValid = false;
        }
        return isValid;
    }

    public boolean validateLastName(String name) {
        boolean isValid = true;
        int minLength = 1;
        int maxLengthName = 45;
        String trimmedFirstName = trimmedString(name);
        int lengthFirstName = trimmedFirstName.length();
        Pattern pattern = Pattern.compile("[A-Z][a-z]*");
        Matcher matcherFirstName = pattern.matcher(trimmedFirstName);
        if (!matcherFirstName.matches()
                || lengthFirstName < minLength
                || lengthFirstName > maxLengthName) {
            isValid = false;
        }
        return isValid;
    }

    public boolean validateShortText(String text) {
        boolean isValid = true;
        int minLength = 1;
        int maxLength = 200;
        String trimmedAddress = trimmedString(text);
        int length = trimmedAddress.length();
        if (length < minLength || length > maxLength) {
            isValid = false;
        }
        return isValid;
    }

    public boolean validateLongText(String text) {
        boolean isValid = true;
        int minLength = 1;
        int maxLength = 20000;
        String trimmedAddress = trimmedString(text);
        int length = trimmedAddress.length();
        if (length < minLength || length > maxLength) {
            isValid = false;
        }
        return isValid;
    }

    public boolean validateEmail(String email) {
        boolean isValid = true;
        String trimmedEmail = trimmedString(email);
        int length = trimmedEmail.length();
        String regex = "^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9]" +
                "(?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(trimmedEmail);
        int maxLengthEmail = 100;
        if (length > maxLengthEmail || !matcher.matches()) {
            isValid = false;
        }
        return isValid;
    }

    public boolean validateDate(String date) {
        String trimmedDate = trimmedString(date);
        String regex = "^(?:\\d{4}-(?:(?:0[13578]|1[02])-(?:0[1-9]|[1-2][0-9]|3[01])|(?:0[469]|11)-" +
                "(?:0[1-9]|[1-2][0-9]|30)|02-(?:0[1-9]|1[0-9]|2[0-8]))|\\d{2}(?:[02468][048]|[13579][26])-02-29)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(trimmedDate);
        return matcher.matches();
    }

    public boolean validateMobile(String mobile) {
        boolean isValid = true;
        String trimmedMobile = trimmedString(mobile);
        int length = trimmedMobile.length();
        String regex = "^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?" +
                "(\\d{3})(\\s|\\.)?(\\d{3})$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(trimmedMobile);
        int maxLength = 45;
        if (!matcher.matches() || length > maxLength) {
            isValid = false;
        }
        return isValid;
    }

    public boolean validateIntegerNumber(String str) {
        boolean isValid = false;
        String trimmedStr = trimmedString(str);
        try {
            int number = Integer.parseInt(trimmedStr);
            if (number >= 0) {
                isValid = true;
            }
        } catch (NumberFormatException ex) {
            System.out.println(ex.getLocalizedMessage());
        }
        return isValid;
    }

    public boolean validateDoubleNumber(String str) {
        boolean isValid = false;
        String trimmedStr = trimmedString(str);
        try {
            double number = Double.parseDouble(trimmedStr);
            if (number >= 0) {
                isValid = true;
            }
        } catch (NumberFormatException ex) {
            System.out.println(ex.getLocalizedMessage());
        }
        return isValid;
    }

    public String trimmedString(String str) {
        String trimmedStr = str.trim().replaceAll("\\s+", " ");
        return trimmedStr;
    }

    public boolean validateGender(String str) {
        boolean isValid = false;
        String trimmedStr = trimmedString(str);
        try {
            int number = Integer.parseInt(trimmedStr);
            if (number >= 0 && number <=2) {
                isValid = true;
            }
        } catch (NumberFormatException ex) {
            System.out.println(ex.getLocalizedMessage());
        }
        return isValid;
    }

// -----------------------------------------------------------------------------------------
// -------------------------------------  Long   -------------------------------------------
// -----------------------------------------------------------------------------------------

public boolean validateName(String name) {
    boolean isValid = true;
    int minLength = 2;
    int maxLengthName = 50;
    String trimmedName = trimmedString(name);
    int lengthName = trimmedName.length();
    Pattern pattern = Pattern.compile("^[a-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂẾưăạảấầẩẫậắằẳẵặẹẻẽềềểếỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s\\W|_]+$");
    Matcher matcherFirstName = pattern.matcher(trimmedName);
    if (!matcherFirstName.matches()
            || lengthName < minLength
            || lengthName > maxLengthName) {
        isValid = false;
    }
    return isValid;
}


    public boolean validateAddress(String address) {
        boolean isValid = true;
        int minLength = 2;
        int maxLength = 225;
        String trimmedAddress = trimmedString(address);
        int length = trimmedAddress.length();
        if (length < minLength || length > maxLength) {
            isValid = false;
        }
        return isValid;
    }

    public boolean validateEmailLong(String email) {
        boolean isValid = true;
        String trimmedEmail = trimmedString(email);
        int length = trimmedEmail.length();
        String regex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(trimmedEmail);
        int maxLengthEmail = 50;
        if (length > maxLengthEmail || !matcher.matches()) {
            isValid = false;
        }
        return isValid;
    }

    public boolean validatePhone(String mobile) {
        boolean isValid = true;
        String trimmedMobile = trimmedString(mobile);
        int length = trimmedMobile.length();
        String regex = "(09|01[2|6|8|9])+([0-9]{8})\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(trimmedMobile);
        int minlength=10;
        int maxLength = 11;
        if (!matcher.matches() || length > maxLength || length< minlength) {
            isValid = false;
        }
        return isValid;
    }

    public boolean validateImageDescription(String imageOrDescription) {
        String trimmedDate = trimmedString(imageOrDescription);
        boolean isValid = true;
        int length=trimmedDate.length();
        int maxLength=500;
        if (length > maxLength || length<0 ) {
            return false;
        }
        return isValid;
    }

    private Employee employee=new Employee();

    public boolean validateGenderLong(String gender) {
        boolean isValid = false;
        String trimmedGender = trimmedString(gender);
        int length = trimmedGender.length();
        int maxLengthGender = 10;
        for (String item:employee.getGenderList()) {
            if (item.equals(trimmedGender)){
                isValid=true;
                break;
            }
        }
        if(length>maxLengthGender || !isValid){
            return false;
        }
        return true;
    }

    public boolean validateDegree(String degree) {
        boolean isValid = false;
        String trimmedDegree = trimmedString(degree);
        int length = trimmedDegree.length();
        int maxLengthDegree = 30;
        for (String item:employee.getDegreeList()) {
            if (item.equals(trimmedDegree)){
                isValid=true;
                break;
            }
        }
        if(length>maxLengthDegree || !isValid){
            return false;
        }

        return true;
    }

    public boolean validatePosition(String position) {
        boolean isValid = false;
        String trimmedPosition = trimmedString(position);
        int length = trimmedPosition.length();
        int maxLengthDegree = 30;
        for (String item:employee.getPositionList()) {
            if (item.equals(trimmedPosition)){
                isValid=true;
                break;
            }
        }
        if(length>maxLengthDegree || !isValid){
            return false;
        }
        return true;
    }


    //    Validate Report
    public HashMap<String, String> validationReport(String name, String address, String email, String phone, String description) {
        HashMap<String, String> validationResult = new HashMap<>();
        if (!validateName(name)) {
            validationResult.put("Name", "'" + name + "' - Invalid name");
        }
        if (!validateAddress(address)) {
            validationResult.put("Address", "'" + address + "' - Invalid address");
        }
        if (!validateEmailLong(email)) {
            validationResult.put("Email", "'" + email + "' - Invalid email");
        }
        if (!validatePhone(phone)) {
            validationResult.put("Phone", "'" + phone + "' - Invalid phone number");
        }
        if (!validateImageDescription(description)) {
            validationResult.put("Description", "'" + description + "' - Invalid description");
        }
        return validationResult;
    }


    //   Validate Employee
    public HashMap<String, String> validationEmployee(String name, String gender, String dob, String phone,String address,String email,
                                                      String idProvince,String description,String image, String joinDate,String degree,String position) {
        HashMap<String, String> validationResult = new HashMap<>();
        if (!validateName(name)) {
            validationResult.put("Name", "'" + name + "' - Invalid name");
        }
        if (!validateGenderLong(gender)) {
            validationResult.put("Gender", "'" + gender + "' - Invalid gender");
        }
        if (!validateDate(dob)) {
            validationResult.put("DOB", "'" + dob + "' - Invalid date");
        }
        if (!validatePhone(phone)) {
            validationResult.put("Phone", "'" + phone + "' - Invalid phone number");
        }
        if (!validateAddress(address)) {
            validationResult.put("Address", "'" + address + "' - Invalid address");
        }
        if (!validateEmailLong(email)) {
            validationResult.put("Email", "'" + email + "' - Invalid email");
        }
        if (!validateIntegerNumber(idProvince)) {
            validationResult.put("Province", "'" + idProvince + "' - Invalid province");
        }
        if (!validateImageDescription(description)) {
            validationResult.put("Description", "'" + description + "' - Invalid description");
        }
        if (!validateImageDescription(image)) {
            validationResult.put("Image", "'" + image + "' - Invalid link image");
        }
        if (!validateDate(joinDate)) {
            validationResult.put("JoinDate", "'" + joinDate + "' - Invalid date");
        }
        if (!validateDegree(degree)) {
            validationResult.put("Degree", "'" + degree + "' - Invalid degree");
        }
        if (!validatePosition(position)) {
            validationResult.put("Position", "'" + position + "' - Invalid position");
        }
        return validationResult;
    }
    // validate donor
    public HashMap<String, String> validationDonor(String name,String surrogate, String address, String email, String phone,String image,String money) {
        HashMap<String, String> validationResult = new HashMap<>();
        if (!validateName(name)) {
            validationResult.put("Name", "'" + name + "' - Invalid name");
        }
        if (!validateName(surrogate)) {
            validationResult.put("Surrogate", "'" + surrogate + "' - Invalid surrogate");
        }
        if (!validateAddress(address)) {
            validationResult.put("Address", "'" + address + "' - Invalid address");
        }
        if (!validateEmailLong(email)) {
            validationResult.put("Email", "'" + email + "' - Invalid email");
        }
        if (!validatePhone(phone)) {
            validationResult.put("Phone", "'" + phone + "' - Invalid phone number");
        }
        if (!validateImageDescription(image)) {
            validationResult.put("Image", "'" + image + "' - Invalid description");
        }
        if (!validateDoubleNumber(money)) {
            validationResult.put("Money", "'" + money + "' - Invalid number");
        }
        return validationResult;
    }

}
