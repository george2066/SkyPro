private static void validLogin(String login) {
    Pattern pattern = Pattern.compile("\\W");
    Matcher matcher = pattern.matcher(login);
    if (matcher.find()) {
        throw new WrongLoginException("Логин может содержать только латинские буквы, цифры и знак подчёркивания.");
    }
}

private static void validPassword(String password, String confirmPassword) {
    Pattern pattern = Pattern.compile("\\W");
    Matcher matcher = pattern.matcher(password);

    if (matcher.find() || !confirmPassword.equals(password) || password.length() > 20) {
        throw new WrongPasswordException("Пароль может содержать только латинские буквы, цифры, знак подчёркивания, должен быть меньше или равно 20ти символам и полностью совпадать с confirmPassword.");
    }
}

private void authentication(String login, String password, String confirmPassword) {
    try {
        validLogin(login);
        validPassword(password, confirmPassword);
    } catch (WrongLoginException e) {
        e.printStackTrace();
    } catch (WrongPasswordException e) {
        e.printStackTrace();
    }
}

void main() {
    String login = "george2066";
    String password = "12345678qwerty";
    String confirmPassword = "12345678qwerty";
    authentication(login, password, confirmPassword);
}